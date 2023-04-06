package com.mertkagan.hobbyto.dataAccess.abstracts;

import com.mertkagan.hobbyto.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
}
