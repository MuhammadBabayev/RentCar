package org.example.rentcar.dto.comment;

//import com.example.CreativeCar.dto.comment.CreateCommentDTO;
import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Comment;
import org.example.rentcar.entity.Users;

public class CommentCreateMapper {

    public static Comment dtoToEntity(CreateCommentDTO createCommentDTO, Users user, Car car) {
        return Comment.builder()
                .comment(createCommentDTO.getComment())
                .user(user)
                .car(car)
                .build();
    }
}
