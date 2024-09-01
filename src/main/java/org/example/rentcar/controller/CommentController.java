package org.example.rentcar.controller;

import org.example.rentcar.dto.comment.CreateCommentDTO;
import org.example.rentcar.entity.Comment;
import org.example.rentcar.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{userId}/{carId}")
    public ResponseEntity<Comment> saveComment(@RequestBody CreateCommentDTO createCommentDTO,
                                               @PathVariable Long userId,
                                               @PathVariable Long carId) {

       return ResponseEntity.ok(commentService.saveComment(createCommentDTO, userId, carId));
    }


    @GetMapping("/car/{carId}")  // statusu A olani verir
    public List<Comment> getCommentsByCarId(@PathVariable Long carId) {
        return commentService.getCommentsByCarId(carId);
    }

    @PostMapping("/update/{carid}/{userid}")
    public ResponseEntity<Void> updateComment(@PathVariable Long carid, @PathVariable Long userid, @RequestBody String newComment) {
        commentService.updateCommentByCarAndUser(carid, userid, newComment);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {

            commentService.deleteComment(id);
            return ResponseEntity.noContent().build();

    }


    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.getCommentsByUserId(userId);
    }
}
