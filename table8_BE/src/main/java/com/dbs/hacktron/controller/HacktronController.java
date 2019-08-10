package com.dbs.hacktron.controller;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.utils.Queue;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class HacktronController {
	
	
	public static Map<String,Queue> queues = new TreeMap<String,Queue>();
	   
    public static int queueCount = 0;
	    
	
	
	@PostMapping("/queue/create/{queueName}")
	public String addQueue(@PathVariable(value = "queueName") String queueName) {
		String queueId = UUID.randomUUID().toString();
		Queue queue = new Queue(queueId , queueName , new LinkedList<String>());
		queues.put(queueId, queue);
		
		return "Queue " + queueName + " Added successfully";
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
	
	@GetMapping("/queue/{id}/message")
	public LinkedList<String> getAllMessages(@PathVariable(value = "id") String queueId) {
		
		Queue queue = queues.get(queueId);
		
		return queue.getData();
		
	}
	


	@DeleteMapping("/queue/{id}/message/")
	public String deleteMessageByQueueId(@PathVariable(value = "id") String queueId,
			@PathVariable(value = "id") String messageId) {
		queues.get(queueId).getData().poll();
		
		return queues.get(queueId).getData().getFirst() + " is removed ";
	}
}
