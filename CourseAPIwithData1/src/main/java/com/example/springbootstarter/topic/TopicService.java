package com.example.springbootstarter.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // to create a singleton object to this class as soon as the application is launched
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics :: add);
		return topics;
	}

	public Optional<Topic> getTopic(String id)
	{
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
	
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
