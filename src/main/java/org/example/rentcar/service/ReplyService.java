package org.example.rentcar.service;

import org.example.rentcar.dto.reply.CreateReplyDTO;
import org.example.rentcar.dto.reply.ReplyCreateMapper;
import org.example.rentcar.entity.Comment;
import org.example.rentcar.entity.Reply;
import org.example.rentcar.entity.Users;
import org.example.rentcar.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final UserService userService;

    private final CommentService commentService;

    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    public Optional<Reply> getReplyById(Long id) {
        return replyRepository.findById(id);
    }

    public Reply saveReply(CreateReplyDTO createReplyDTO,Long commentId,Long userId) {
        Comment comment=commentService.getCommentById(commentId);
        Users user = userService.getUserById(userId);
        Reply reply= ReplyCreateMapper.dtoToEntity(createReplyDTO,comment,user);
    return replyRepository.save(reply);
    }

    public void deleteReply(Long id) {
        Optional<Reply> replyOptional = replyRepository.findById(id);
        if (replyOptional.isPresent()) {
            Reply reply = replyOptional.get();
            reply.setStatus("D");
            replyRepository.save(reply);
        } else {

            throw new RuntimeException("Reply not found with id: " + id);
        }
    }

    public List<Reply> getRepliesByCommentId(Long commentId) {
        return replyRepository.findRepliesByCommentId(commentId);
    }

    public List<Reply> getRepliesByUserId(Long userId) {
        return replyRepository.findRepliesByUserId(userId);
    }

}
