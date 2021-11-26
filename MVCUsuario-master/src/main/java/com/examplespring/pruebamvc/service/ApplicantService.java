package com.examplespring.pruebamvc.service;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {
    private final String URL = "http://localhost:8088/api";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private HttpClient httpClient = HttpClients.createDefault();

    public ArrayList<ApplicantDTO> findAll() throws IOException {
        HttpGet request = new HttpGet(URL+"/ApplicantController/");
        HttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());


        Type listType = new TypeToken<ArrayList<ApplicantDTO>>() {}.getType(); //TypeToken se utiliza para indicarle a Gson el tipo especifico al cual lo tiene que convertir
        ArrayList<ApplicantDTO> applicants = new Gson().fromJson(result, listType);

        return applicants;
    }
}
