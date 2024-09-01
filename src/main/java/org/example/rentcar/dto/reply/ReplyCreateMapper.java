package org.example.rentcar.dto.reply;

import org.example.rentcar.entity.Comment;
import org.example.rentcar.entity.Reply;
import org.example.rentcar.entity.Users;

public class ReplyCreateMapper {
    public static Reply dtoToEntity(CreateReplyDTO createReplyDTO, Comment comment, Users user) {
        return Reply.builder().reply(
                createReplyDTO.getReply()).
                comment(comment).
                user(user)
                .build();
    }
}
