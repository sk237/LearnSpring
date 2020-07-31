package com.sk237.joong233.Repository;

import com.sk237.joong233.Model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAllByUserIdOrderByCreatedTime(String userId);
}
