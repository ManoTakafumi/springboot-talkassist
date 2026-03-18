package com.example.talkassist.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.talkassist.entity.Topic;
import com.example.talkassist.repository.TopicRepository;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final Random random = new Random();

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic getRandomTopicByKeyword(String keyword) {
        List<Topic> topics = topicRepository.findByKeyword(keyword);

        if (topics.isEmpty()) {
            return getRandom(topics);
        }

        List<Topic> fallbackTopics = topicRepository.findFallbackTopics();

        if (fallbackTopics.isEmpty()) {
            return null;
        }

        return getRandom(fallbackTopics);

//        Random random = new Random();
//        return topics.get(random.nextInt(topics.size()));
    }

    private Topic getRandom(List<Topic> topics) {
        Random random = new Random();
        return topics.get(random.nextInt(topics.size()));
    }
}
