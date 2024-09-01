package org.example.rentcar.service;

//import com.example.CreativeCar.dto.comment.CreateCommentDTO;

import org.example.rentcar.dto.comment.CommentCreateMapper;
import org.example.rentcar.dto.comment.CreateCommentDTO;
import org.example.rentcar.dto.comment.GetCommentDTO;
import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Comment;
import org.example.rentcar.entity.Users;
import org.example.rentcar.exception.NotFoundException;
import org.example.rentcar.mapper.comment.CommentGetMapper;
import org.example.rentcar.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.example.rentcar.enums.ExceptionMessage.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;


    private final CarService carService;


    private final UserService userService;



    public Comment getCommentById(Long id) {
        return commentRepository.findByIdAndStatus(id).stream()
                .findFirst().orElseThrow(() ->new NotFoundException(
                        format(
                                NOT_FOUND.getMessage(),
                                id
                        )));
    }

    public Optional<List<GetCommentDTO>> getComments(Long userId, Long carId) {
        Optional<List<Comment>> comments = commentRepository.findAllByCarAndUser(carId, userId);
        return comments.map(list ->
                list.stream()
                        .map(CommentGetMapper::entityToDto)
                        .collect(Collectors.toList())
        );
    }

    public Comment saveComment(CreateCommentDTO createCommentDTO, Long userId, Long carId) {
        Users user = userService.getUserById(userId);
        Car car = carService.getCarById(carId);
        Comment comment = CommentCreateMapper.dtoToEntity(createCommentDTO, user, car);
        return commentRepository.save(comment);
    }




    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).get();
        comment.setStatus("D");
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByCarId(Long carId) {
        return commentRepository.findActiveCommentsByCarId(carId);
    }

    public void updateCommentByCarAndUser(Long carId, Long userId, String newComment) {
        commentRepository.updateCommentByCarAndUser(carId, userId, newComment);
    }

    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findCommentsByUserId(userId);
    }
}
