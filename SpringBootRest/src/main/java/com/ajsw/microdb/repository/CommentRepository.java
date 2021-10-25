package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    Comment getCommentById(String id);
    Comment deleteCommentById(String id);
}
