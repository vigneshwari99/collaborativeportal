package com.niit.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.pojo.Message;
import com.niit.pojo.OutMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutMessage sendMessage(Message message){
		
		System.out.println("Message recieved: "+message.getMessage());
		return new  OutMessage(message, new Date());
	}
}