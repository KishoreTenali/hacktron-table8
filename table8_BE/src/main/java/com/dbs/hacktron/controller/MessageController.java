package com.dbs.hacktron.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {


	@GetMapping("/queue/{id}/message")
	public void getAllMessages(@PathVariable(value = "id") String queueId) {
		}

	@PostMapping("/queue/{id}/message/{messageId}")
	public void createMessage(@PathVariable(value = "id") String queueId ,@PathVariable(value = "messageId") String messageId ) {
		
	}

	@DeleteMapping("/queue/{id}/message/{messageId}")
	public void deleteMessageByQueueId(@PathVariable(value = "id") String queueId ,@PathVariable(value = "id") String messageId ) {
		
	}
}
