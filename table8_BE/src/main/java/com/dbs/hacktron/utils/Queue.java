package com.dbs.hacktron.utils;

import java.util.LinkedList;

public class Queue {
	
	 private String  queueId;
	 
	 private String queueName;
	 
	 private LinkedList<String> data;
	 
	 
	 public Queue(String queueId, String queueName , LinkedList<String> data) {
		 this.queueId = queueId;
		 this.queueName = queueName;
		 this.data = data;
	 }
	 
	// Setters and Getters Methods

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public LinkedList<String> getData() {
		return data;
	}

	public void setData(LinkedList<String> data) {
		this.data = data;
	}
	
}
