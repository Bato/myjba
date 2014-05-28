package de.mh.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mh.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
