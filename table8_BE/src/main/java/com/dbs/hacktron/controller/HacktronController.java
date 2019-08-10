package com.dbs.hacktron.controller;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.utils.Queue;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HacktronController {
	
	
	public static Map<String,Queue> queues = new TreeMap<String,Queue>();
	   
    public static int queueCount = 0;
    
	@PostMapping("/queue/create/{queueName}")
	public String addQueue(@PathVariable(value = "queueName") String queueName) {
		String message = "";
		if (queues.size() != 100) {
			String queueId = UUID.randomUUID().toString();
			Queue queue = new Queue(queueId , queueName , new LinkedList<String>());
			queues.put(queueId, queue);	
			message = "Queue " + queueName + " Added successfully";
		} else {
			message = "Queue count is reached maximum limit";
		}
		
		return  message;
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
		Queue que = queues.get(queueId);
		return que.getData();
		
	}

	@PostMapping("/queue/{id}/message/{messageData}")
	public String createMessage(@PathVariable(value = "id") String queueId ,@PathVariable(value = "messageData") String message ) {
		String successMsg = "";
		Queue queVar = queues.get(queueId);
		if(queVar != null) {
			LinkedList<String> data = new LinkedList<String>();
			data.add(message);
			queVar.setData(data);
			queues.put(queueId, queVar);
			successMsg = "Message added succesfully";
		}else {
			successMsg = "Invalid queueID "+ queueId+".";
		}
		return successMsg;
	}

}
