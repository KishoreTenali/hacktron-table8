package com.dbs.hacktron.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HacktronController {
	
	@PostMapping("/queue/create")
	public void addQueue(@PathParam(value = "queName") String queName) {
		
	}
	
	@GetMapping("/queue/")
	public void getQueue() {
		
	}
	
	@DeleteMapping("/queue/")
	public void deleteQueue(@PathParam(value = "queueId") int queueId) {
		
	}
}
