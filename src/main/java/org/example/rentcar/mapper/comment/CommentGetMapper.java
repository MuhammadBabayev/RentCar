package org.example.rentcar.mapper.comment;

import org.example.rentcar.dto.comment.GetCommentDTO;
import org.example.rentcar.entity.Comment;

public class CommentGetMapper {
    public static GetCommentDTO entityToDto(Comment comment) {
        return GetCommentDTO.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .userId(comment.getUser().getId())
                .carId(comment.getCar().getId())
                .build();
    }
}
