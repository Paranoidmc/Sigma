package it.contrader.service;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.contrader.converter.LogConverter;
import it.contrader.dao.LogRepository;
import it.contrader.dto.LogDTO;
import it.contrader.model.Log;

@Service
public class LogService extends AbstractService<Log, LogDTO> {
	
	@Autowired
	LogRepository repository;
	@Autowired
	LogConverter conv;
	@Autowired
	RestTemplate rest;
		public LogDTO findById(long id) {
			return conv.toDTO(repository.findByid(id));
		}
		
		public List<LogDTO> getLog() {
			List<LogDTO> listDTO = new ArrayList<LogDTO>();
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			 
			LogDTO logDTO= null;
			 ResponseEntity<String> response = rest.exchange("http://localhost:8081/process",HttpMethod.GET,null,String.class);
			 System.out.println(response);
			 JSONObject obj = new JSONObject(response.getBody());
			 JSONArray Obj2 =obj.getJSONArray("result");
			 final int n = Obj2.length();
			 JSONObject log;
			 
			 for(int i=0 ; i<n; i++)
			 {
				 logDTO= new LogDTO();
				 log = Obj2.getJSONObject(i);
				 
			
				 logDTO.setName(log.getString("name"));
				 logDTO.setStatus(log.getString("status"));
				 logDTO.setType(log.getString("type"));
				 logDTO.setData(timeStamp);
				 listDTO.add(logDTO);
				 
			 }
			 
			 repository.saveAll(converter.toEntityList(listDTO));
			 return listDTO;
			 
		}
		
	
}