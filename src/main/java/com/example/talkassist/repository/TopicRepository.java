package com.example.talkassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.talkassist.entity.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t FROM Topic t WHERE t.keywords LIKE %:keyword%")
    List<Topic> findByKeyword(@Param("keyword") String keyword);

    @Query("SELECT t FROM Topic t WHERE t.keywords LIKE '%雑談%'")
    List<Topic> findFallbackTopics();
//    List<Topic> findByKeywordsContaining(String keyword);
}
