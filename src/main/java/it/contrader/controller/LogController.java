package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LogDTO;
import it.contrader.service.LogService;

@RestController
@RequestMapping("/log")
@CrossOrigin(origins = "http://localhost:4200")
public class LogController extends AbstractController<LogDTO>{
	@Autowired
	LogService service;
	
	@Scheduled(fixedRateString ="${time}")
	@GetMapping
	public void getList() {
		service.getLog();
	}
	@GetMapping("/rate")
	public void setRate(@RequestParam int x) {
		Properties properties = new Properties();
		properties.replace("time", x);
		
	}
}