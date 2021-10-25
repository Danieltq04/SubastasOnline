package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.CommentRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Comment;
import com.ajsw.microdb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public Comment save(CommentRequest commentRequest){
        Comment comment = new Comment();
        comment.setApplicantId(commentRequest.getApplicantId());
        comment.setBidderId(commentRequest.getBidderId());
        comment.setCommentDescription(commentRequest.getCommentDescription());
        comment.setScore(commentRequest.getScore());
        comment.setDate(commentRequest.getDate());
        return commentRepository.save(comment);
    }
    public Comment delete(String id){
        Comment comment = commentRepository.getCommentById(id);
        if(comment == null){
            throw new SystemLoginException("");
        }
        return commentRepository.deleteCommentById(id);
    }
    public Comment update(Comment comment){
        Comment commentUpdate = commentRepository.getCommentById(comment.getId());
        commentUpdate.setApplicantId(comment.getApplicantId());
        commentUpdate.setBidderId(comment.getBidderId());
        commentUpdate.setCommentDescription(comment.getCommentDescription());
        commentUpdate.setScore(comment.getScore());
        commentUpdate.setDate(comment.getDate());
        commentRepository.save(commentUpdate);
        return commentUpdate;
    }
    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
    public Comment getById(String id){
        return commentRepository.getCommentById(id);
    }
}
