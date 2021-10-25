package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.RequestDtoRequest;
import com.ajsw.microdb.model.Request;
import com.ajsw.microdb.service.RequestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/RequestController")
@CrossOrigin("*")
@Api(tags = "Request")
public class RequestController {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping(value = "/")
    public List<Request> getAll(){
        return requestService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Request get(@PathVariable String id){
        return requestService.getById(id);
    }
    @PostMapping(value = "/")
    public Request save(@RequestBody RequestDtoRequest request){
        return requestService.save(request);
    }
    @DeleteMapping(value = "/{id}")
    public Request delete(@PathVariable String id){
        return requestService.delete(id);
    }
    @PutMapping(value = "/")
    public Request update(@RequestBody Request request){
        return requestService.update(request);
    }

}
