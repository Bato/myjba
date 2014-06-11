package de.mh.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import de.mh.jba.entity.Blog;
import de.mh.jba.entity.Item;
import de.mh.jba.entity.User;
import de.mh.jba.exception.RssException;
import de.mh.jba.repository.BlogRepository;
import de.mh.jba.repository.ItemRepository;
import de.mh.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RssService rssService;
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
	}


	public void saveItems(Blog blog) {
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {			
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if (savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}				
			}			
		} catch (RssException e) {
			e.printStackTrace();
		}
		
	}


	// 1 hour = 60 seconds X 60 minutes X 1000
	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs() {
		List<Blog> blogs = blogRepository.findAll();
		for (Blog blog : blogs) {
			saveItems(blog);
		}
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
