package com.example.talkassist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.talkassist.entity.Topic;
import com.example.talkassist.service.TopicService;

@Controller
public class SuggestController {

    private final TopicService topicService;

    public SuggestController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/suggest")
    public String suggest(
            @RequestParam String keyword,
            Model model) {

        Topic topic = topicService.getRandomTopicByKeyword(keyword);

        if (topic == null) {
            model.addAttribute("message", "該当する話題が見つかりませんでした。");
        } else {
            model.addAttribute("topic", topic);
        }

        return "result";
    }
}
