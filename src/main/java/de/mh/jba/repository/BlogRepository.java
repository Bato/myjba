package de.mh.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mh.jba.entity.Blog;
import de.mh.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
