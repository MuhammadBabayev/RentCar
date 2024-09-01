package org.example.rentcar.repository;

import org.example.rentcar.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("SELECT r FROM Reply r WHERE r.user.id = :userId and r.status='A'")
    List<Reply> findRepliesByUserId(@Param("userId") Long userId);

    @Query("SELECT r FROM Reply r WHERE r.comment.id = :commentId and r.status='A'")
    List<Reply> findRepliesByCommentId(@Param("commentId") Long commentId);
}
