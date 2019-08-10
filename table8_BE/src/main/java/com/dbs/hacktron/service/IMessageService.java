package com.dbs.hacktron.service;

public interface IMessageService {

	public String getAllMessages();
	
	public String createMessage(String id, String messageId);
	
	public String deleteMessageByQueueId(String id, String messageId);
}
