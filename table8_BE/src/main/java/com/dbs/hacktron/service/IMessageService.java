package com.dbs.hackathon.service;

public interface MessageService {

	public String getAllMessages();
	
	public String createMessage(String id, String messageId);
	
	public String deleteMessageByQueueId(String id, String messageId);
}
