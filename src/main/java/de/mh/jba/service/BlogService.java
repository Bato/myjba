package de.mh.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import de.mh.jba.entity.Blog;
import de.mh.jba.entity.User;
import de.mh.jba.repository.BlogRepository;
import de.mh.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}


	public void delete(int id) {
		blogRepository.delete(id);
	}


	public Blog findOne(int id) {
		
		return blogRepository.findOne(id);
	}


	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		
		blogRepository.delete(blog);
		
	}

}
