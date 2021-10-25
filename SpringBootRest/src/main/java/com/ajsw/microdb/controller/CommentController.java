package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.CommentRequest;
import com.ajsw.microdb.model.Comment;
import com.ajsw.microdb.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/CommentController")
@CrossOrigin("*")
@Api(tags = "Comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/")
    public List<Comment> getAll(){
        return commentService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Comment get(@PathVariable String id){
        return commentService.getById(id);
    }
    @PostMapping(value = "/")
    public Comment save(@RequestBody CommentRequest commentRequest){
        return commentService.save(commentRequest);
    }
    @DeleteMapping(value = "/{id}")
    public Comment delete(@PathVariable String id){
        return commentService.delete(id);
    }
    @PutMapping(value = "/")
    public Comment update(@RequestBody Comment offer){
        return commentService.update(offer);
    }

}
