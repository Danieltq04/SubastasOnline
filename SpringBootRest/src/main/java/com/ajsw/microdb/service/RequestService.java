package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.RequestDtoRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Request;
import com.ajsw.microdb.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }
    public Request save(RequestDtoRequest requestDtoRequest){
        Request request = new Request();
        request.setApplicantId(requestDtoRequest.getApplicantId());
        request.setTypeJob(requestDtoRequest.getTypeJob());
        request.setDate(requestDtoRequest.getDate());
        request.setZone(requestDtoRequest.getZone());
        request.setDescription(requestDtoRequest.getDescription());
        request.setState(requestDtoRequest.getState());
        return requestRepository.save(request);
    }
    public Request delete(String id){
        Request request = requestRepository.getRequestById(id);
        if(request == null){
            throw new SystemLoginException("");
        }
        return requestRepository.deleteRequestById(id);
    }
    public Request update(Request request){
        Request requestUpdate = requestRepository.getRequestById(request.getId());
        requestUpdate.setApplicantId(request.getApplicantId());
        requestUpdate.setTypeJob(request.getTypeJob());
        requestUpdate.setDate(request.getDate());
        requestUpdate.setZone(request.getZone());
        requestUpdate.setDescription(request.getDescription());
        requestUpdate.setState(request.getState());
        requestRepository.save(requestUpdate);
        return requestUpdate;
    }
    public List<Request> getAll(){
        return requestRepository.findAll();
    }
    public Request getById(String id){
        return requestRepository.getRequestById(id);
    }
}
