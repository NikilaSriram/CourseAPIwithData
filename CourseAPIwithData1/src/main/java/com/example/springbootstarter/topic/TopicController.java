package com.example.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController //to send the response in form of json
public class TopicController {

	@Autowired //to inject topic service that is created
	private TopicService topicService;
	
	@RequestMapping("/topics")// to map the request and send the response by executing the method to spring mvc
	public List<Topic> getAllTopics()
	{
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")// id changes everytime and so written in {}
	public Optional<Topic> getTopic(@PathVariable String id) // to tell that id is coming from path of url
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/topics")
	public void addTopic(@RequestBody Topic topic)// takes the JSON representation of request payload and change the json instance to topic instance 
	{
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)// takes the JSON representation of request payload and change the json instance to topic instance 
	{
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/topics/{id}")// id changes everytime and so written in {}
	public void deleteTopic(@PathVariable String id) // to tell that id is coming from path of url
	{
		topicService.deleteTopic(id);
	}
	
}
