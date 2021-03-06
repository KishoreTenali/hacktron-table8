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

import com.dbs.hacktron.exception.ResourceNotFoundException;
import com.dbs.hacktron.utils.Queue;




@RestController
@RequestMapping("/api/v1")
public class HacktronController {
	
	
	public static Map<String,Queue> queues = new TreeMap<String,Queue>();
	   
    public static int queueCount = 0;
    
	@PostMapping("/queue/create/{queueName}")
	public String addQueue(@PathVariable(value = "queueName") String queueName) {
		String message = "";
		if (queues.size() != 5) {
		String queueId = UUID.randomUUID().toString();
		Queue queue = new Queue(queueId , queueName , new LinkedList<String>());
		queues.put(queueId, queue);
		message = "Queue " + queueName + " Added successfully";
		} else {
			message = "Queue reaches maximum limit";
		}
		
		return message;
	}
	
	@GetMapping("/queue")
	public @ResponseBody Map<String,Queue> getQueueList() throws ResourceNotFoundException {
		
		if(queues.isEmpty())
		{
			throw new ResourceNotFoundException("No QUEUES Found");
		}
		return queues;
	}
	
	@DeleteMapping("/queue/{queueId}")
	public String deleteQueue(@PathVariable("queueId") String queueId) throws ResourceNotFoundException {
		if(!queues.containsKey(queueId) || queues.get(queueId).equals(null)){
			throw new ResourceNotFoundException("invalid QueueId");
		}
		queues.remove(queueId);
		return "Queue " + queueId + " Removed Successfully";
	}
	
	@GetMapping("/queue/{id}/message")
	public LinkedList<String> getAllMessages(@PathVariable(value = "id") String queueId) throws ResourceNotFoundException {
		if(!queues.containsKey(queueId) || queues.get(queueId).equals(null)){
			throw new ResourceNotFoundException("invalid QueueId");
		}
		Queue queue = queues.get(queueId);
		return queue.getData();
		
	}

	@PostMapping("/queue/{id}/message/{messageData}")
	public String createMessage(@PathVariable(value = "id") String queueId ,@PathVariable(value = "messageData") String message ) {
		String successMsg = "";
		Queue queVar = queues.get(queueId);
		if(queVar != null) {
			LinkedList<String> data = queVar.getData();
			data.add(message);
			queVar.setData(data);
			queues.put(queueId, queVar);
			successMsg = "Message added succesfully";
		}else {
			successMsg = "Invalid queueID "+ queueId+".";
		}
		return successMsg;
	}

	@DeleteMapping("/queue/{id}/message")
	public String deleteMessageByQueueId(@PathVariable(value = "id") String queueId,
			@PathVariable(value = "id") String messageId) throws ResourceNotFoundException {
		if(!queues.containsKey(queueId) || queues.get(queueId).equals(null)){
			throw new ResourceNotFoundException("invalid QueueId");
		}
		queues.get(queueId).getData().poll();
		return  "Message is removed ";
	}
	
	@GetMapping("/queue/queuecheck/{queueId}")
	public String checkQueue(@PathVariable("queueId") String queueId) {
	String message = ""; 
	
	Queue queue = queues.get(queueId);
	if ( queue.getData().size() == 0 ) {
	message = "Queue is empty";
	} else {
	message = "Queue containes"+queue.getData().size()+" messages";
	}

	return message;
	}
}
