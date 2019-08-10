package com.dbs.hacktron.controller;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.utils.Queue;

@RestController
@RequestMapping("/api/v1")
public class HacktronController {
	
	
	public static Map<String,Queue> queues = new TreeMap<String,Queue>();
	   
    public static int queueCount = 0;
	    
	
	
	@GetMapping("/queue/create/{queueName}")
	public void addQueue(@PathVariable(value = "queueName") String queueName) {
		String queueId = UUID.randomUUID().toString();
		Queue queue = new Queue(queueId , queueName , new LinkedList<String>());
		queues.put(queueId, queue);
		
	}
	
	@GetMapping("/queue")
	public @ResponseBody Map<String,Queue> getQueueList() {
		
		return queues;
	}
	
	@DeleteMapping("/queue/{queueId}")
	public String deleteQueue(@PathVariable("queueId") String queueId) {
		queues.remove(queueId);
		
		return "Queue " + queueId + " Removed Successfully";
	}
}
