package org.example.rentcar.controller;

import org.example.rentcar.dto.reply.CreateReplyDTO;
import org.example.rentcar.entity.Reply;
import org.example.rentcar.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping
    public ResponseEntity<List<Reply>> getAllReplies() {
        List<Reply> replies = replyService.getAllReplies();
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reply> getReplyById(@PathVariable Long id) {
        Optional<Reply> reply = replyService.getReplyById(id);
        return reply.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/{commentId}/{userId}")
    public ResponseEntity<Reply> createReply(@RequestBody CreateReplyDTO createReplyDTO,
                                             @PathVariable Long commentId, @PathVariable Long userId
                                             ) {
        Reply reply = replyService.saveReply(createReplyDTO, commentId, userId);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<Reply>> getRepliesByCommentId(@PathVariable Long commentId) {
        List<Reply> replies = replyService.getRepliesByCommentId(commentId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reply>> getRepliesByUserId(@PathVariable Long userId) {
        List<Reply> replies = replyService.getRepliesByUserId(userId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }
}
