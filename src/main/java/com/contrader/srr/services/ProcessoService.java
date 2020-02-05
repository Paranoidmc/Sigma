package com.contrader.srr.services;

import com.contrader.srr.domain.Processo;

import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessoService {

     
   
    public String transform(List<Processo> list) {
    	String json = new Gson().toJson(list );
    	json="{result: "+json+"}";
    	return json;

    }
    

    public String getById(Integer id, List<Processo> db) {
    	Processo p=db.stream()
        .filter(b -> b.getId().equals(id))
        .findFirst().orElse(null);
    	
    	String json = new Gson().toJson(p );
    	json="{result: "+json+"}";
    	return json;
    }

  
}
