###############################################################################|####################
 Spring web application tutorial (java blogs aggregator)
                                                                             http://www.javavids.com
         http://www.javavids.com/tutorial/spring-web-application-tutorial-java-blogs-aggregator.html

How to create a web application (Java Blogs Aggregator) from scratch. 
From nothing to an application up and running on a custom domain. 
###############################################################################|####################

http://api.jquery.com/
http://getbootstrap.com/
http://getbootstrap.com/getting-started/
http://getbootstrap.com/javascript/#modals

Importing a GitHub project into Eclipse
Importing a Git Project into Eclipse

Start Eclipse and go to the File menu and choose Import. 
WS ist D:\tools\Spring\code\ws_JBA

Copy the URL from Github and select in Eclipse from the menu the 
	File > Import > Git > Projects from Git

URI: https://github.com/jirkapinkas/java-blog-aggregator.git
Host: github.com
Repository Path: /jirkapinkas/java-blog-aggregator.git

Local Destination
	Directory: D:\tools\Spring\code\JBA\
	Initial Branch: master
Configuration
	remote name: origin
Optional: Enter username and pwd

Elipse Java setting
	C:\Program Files\Java\jdk1.7.0_25	
Elipse Maven setting
	D:\tools\maven\eclipse\conf
	D:\tools\maven\repository
	
mvn -P dev jetty:run -Dspring.profiles.active="dev"

###############################################################################
Spring web app tutorial 1: Hello World Maven Java EE 6
###############################################################################

How to create a Hello World Maven Java EE 6 web application in Eclipse and 
how to use Jetty plugin (Jetty is a web container like Apache Tomcat).
 
Download result: http://www.javavids.com/spring-web-app-tutorial/java-blog-aggregator-step-1.zip

D:\eclipse\eclipse-jee-kepler\eclipse.exe -clean -nosplash -showLocation -data D:\tools\Spring\code\ws_JBA

Test:
http://localhost:8080/
Directory: /


###############################################################################
Spring web app tutorial 2: Setting GitHub & Eclipse
###############################################################################

Create a new repository on the command line

touch README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/Bato/myjba.git
git push -u origin master
Push an existing repository from the command line

git remote add origin https://github.com/Bato/myjba.git


###############################################################################
Spring web app tutorial 3: Spring Web MVC hello world
###############################################################################

Spring Web MVC basics explained, using Dispatcher Servlet and web.xml, 
how to scan Spring annotations and basic example of @Controller and @RequestMapping annotations.

Download result: http://www.javavids.com/spring-web-app-tutorial/java-blog-aggregator-step-3.zip

pom.xml 

web.xml
~~~~~~~~

spring bean configuratioen file: dispatcher-servlet.xml
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

	<mvc:annotation-driven />

	<context:component-scan base-package="cz.jiripinkas.jba.controller" />
</beans>



Test
http://localhost:8080/index.html




###############################################################################
Spring web app tutorial 4: Apache Tiles
      http://www.javavids.com/video/spring-web-app-tutorial-4-apache-tiles.html
###############################################################################
Apache Tiles & Framework Spring integration, Apache Tiles basics, 
how to use template, tiles definitions and attributes.


Download result: http://www.javavids.com/spring-web-app-tutorial/java-blog-aggregator-step-4.zip

dispatcher-servlet.xml tiles


###############################################################################
Spring web app tutorial 5: Twitter Bootstrap
 http://www.javavids.com/video/spring-web-app-tutorial-5-twitter-bootstrap.html
###############################################################################
How to use Twitter Bootstrap to make our application pretty :-) 
I will use Twitter Bootstrap and JQuery from CDN (Content Delivery Network). 
Our web application will have responsive layout (useful for mobile devices).

http://getbootstrap.com/
http://getbootstrap.com/getting-started/

Bootstrap CDN
The folks over at MaxCDN graciously provide CDN support for Bootstrap's CSS and JavaScript. 
Just use these Bootstrap CDN links.

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

http://jquery.com/download/
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

classic.jsp

###############################################################################
Spring web app tutorial 6: Servlet and JSP API
http://www.javavids.com/video/spring-web-app-tutorial-6-servlet-and-jsp-api.html
###############################################################################
How to resolve error: The superclass "javax.servlet.http.HttpServlet" was not 
found on the Java Build Path? If you use Maven, add to pom.xml Servlet and JSP API 
with scope provided.

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.0.1</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.2.1</version>
			<scope>provided</scope>
		</dependency>
		
###############################################################################
Spring web app tutorial 7: Spring root context
###############################################################################

How to use Spring root context using ContextLoaderListener and configuration 
file applicationContext.xml. How to effectively use context:component-scan 
with context:exclude-filter.

Crete anothe spring context
Multiple servlet but one application contex single service, ...
scan all application without controllers


###############################################################################
Spring web app tutorial 8: persistence
       http://www.javavids.com/video/spring-web-app-tutorial-8-persistence.html
###############################################################################
How to integrate Hibernate with Spring and Spring Data JPA using 
LocalContainerEntityManagerFactoryBean? I will use test HSQL test database 
(later will be used PostgreSQL).

In configuration I won't use  persistence.xml. The Hibernate will print SQL 
commands to standard output (using hibernate.show_sql) and the database will 
be created automatically from entities (using hibernate.hbm2ddl.auto). 
Plus hello world entity.

add dependency
applicationContext.xml



txmanager

Hibernate: drop table User if exists
Hibernate: create table User (id integer generated by default as identity 
(start with 1), primary key (id))

###############################################################################
Spring web app tutorial 9: JPA entities
http://www.javavids.com/video/spring-web-app-tutorial-9-jpa-entities.html
###############################################################################
Eclipse JPA Diagram Editor installieren
Since Eclipse Kepler goto 
Help -> Install New Software -> Work with: Kepler, type "JPA", 
search for Dali Java Persistence Tools - JPA Diagram Editor and install this plugin.

Add JPA Project Facets 


Hibernate: alter table Blog drop constraint FK_thdkoy0q7vcgc5hay9wb99vnh
Hibernate: alter table Item drop constraint FK_il3204s0mf6d1m8am8f5768ah
Hibernate: alter table Role_User drop constraint FK_iha4m965rutefhrl4f2pvko39
Hibernate: alter table Role_User drop constraint FK_1rtsbyk364hixsho0345aj4sd
Hibernate: alter table User_Role drop constraint FK_tc5k40i3kit8944syrd366vy1
Hibernate: alter table User_Role drop constraint FK_dv4w2xni693cg4ibi3fo1fkk6
Hibernate: drop table Blog if exists
Hibernate: drop table Item if exists
Hibernate: drop table Role if exists
Hibernate: drop table Role_User if exists
Hibernate: drop table User if exists
Hibernate: drop table User_Role if exists
Hibernate: create table Blog (id integer generated by default as identity (start with 1), name varchar(255), url varchar(255), user_id integer, primary key (id))
Hibernate: create table Item (id integer generated by default as identity (start with 1), description varchar(255), link varchar(255), published_date timestamp, title varchar(255), blog_id integer, primary key (id))
Hibernate: create table Role (id integer generated by default as identity (start with 1), name varchar(255), primary key (id))
Hibernate: create table Role_User (Role_id integer not null, users_id integer not null)
Hibernate: create table User (id integer generated by default as identity (start with 1), email varchar(255), name varchar(255), password varchar(255), primary key (id))
Hibernate: create table User_Role (User_id integer not null, roles_id integer not null)
Hibernate: alter table Blog add constraint FK_thdkoy0q7vcgc5hay9wb99vnh foreign key (user_id) references User
Hibernate: alter table Item add constraint FK_il3204s0mf6d1m8am8f5768ah foreign key (blog_id) references Blog
Hibernate: alter table Role_User add constraint FK_iha4m965rutefhrl4f2pvko39 foreign key (users_id) references User
Hibernate: alter table Role_User add constraint FK_1rtsbyk364hixsho0345aj4sd foreign key (Role_id) references Role
Hibernate: alter table User_Role add constraint FK_tc5k40i3kit8944syrd366vy1 foreign key (roles_id) references Role
Hibernate: alter table User_Role add constraint FK_dv4w2xni693cg4ibi3fo1fkk6 foreign key (User_id) references User
2014-05-28 10:01:54.151:INFO:/:main: Initializing Spring FrameworkServlet 'dispatcher'

###############################################################################
Spring web app tutorial 10: Spring Data JPA basics
http://www.javavids.com/video/spring-web-app-tutorial-10-spring-data-jpa-basics.html
###############################################################################

Hibernate: insert into Role (id, name) values (default, ?)
Hibernate: insert into Role (id, name) values (default, ?)
Hibernate: insert into User (id, email, name, password) values (default, ?, ?, ?)
Hibernate: insert into User_Role (User_id, roles_id) values (?, ?)
Hibernate: insert into User_Role (User_id, roles_id) values (?, ?)
Hibernate: insert into Blog (id, name, url, user_id) values (default, ?, ?, ?)
Hibernate: insert into Item (id, blog_id, description, link, published_date, title) values (default, ?, ?, ?, ?, ?)
Hibernate: insert into Item (id, blog_id, description, link, published_date, title) values (default, ?, ?, ?, ?, ?)

###############################################################################
Spring web app tutorial 11: MVC (Model View Controller)
             http://www.javavids.com/video/spring-web-app-tutorial-11-mvc-model-view-controller.html
###############################################################################
How to use Spring Web MVC (Model View Controller) with Apache Tiles. 
How to use  JSTL (Java Standard Tag Library) - c:forEach. 
Styling table using Twitter Bootstrap.


###############################################################################
Spring web app tutorial 12: Apache Tiles dynamic menu
            http://www.javavids.com/video/spring-web-app-tutorial-12-apache-tiles-dynamic-menu.html
###############################################################################
How to create a dynamic menu using Apache Tiles and Twitter Bootstrap, 
how to use tilesx:useAttribute and 
how to use Expression Language ternary operator.

###############################################################################
Spring web app tutorial 13: Path Variable
                         http://www.javavids.com/video/spring-web-app-tutorial-13-path-variable.html
###############################################################################
How to use path variable in Spring Web MVC

###############################################################################
Spring web app tutorial 14: JSP Include Directive
                 http://www.javavids.com/video/spring-web-app-tutorial-14-jsp-include-directive.html
###############################################################################
How to use JSP Include Directive to load JSP taglibs using single line of code.

###############################################################################
Spring web app tutorial 15: Hibernate Lazy Initialization Exception
http://www.javavids.com/video/spring-web-app-tutorial-15-hibernate-lazy-initialization-exception.html
###############################################################################
How to resolve LazyInitializationException using OpenEntityManagerInViewFilter/ 
OpenSessionInViewFilter?
You get Lazy Initialization Exception when you access LAZY relationship outside 
transaction in Hibernate (JPA) - also known as Hibernate Lazy Loading.

###############################################################################
Spring web app tutorial 16: Hibernate Transaction
                 http://www.javavids.com/video/spring-web-app-tutorial-16-hibernate-transaction.html
###############################################################################
How to use Spring Transactional annotation to load entities in service layer 
instead of using Open Entity Manager In View Filter.

###############################################################################
Spring web app tutorial 17: Spring Data JPA Paging and sorting
    http://www.javavids.com/video/spring-web-app-tutorial-17-spring-data-jpa-paging-and-sorting.html
###############################################################################
How to use Spring Data JPA for paging, sorting and top-n processing? 
This will generate SQL "SELECT ... ORDER BY ... LIMIT ...".

How to limit the number of Items in ItemRepository 


###############################################################################
Spring web app tutorial 18: JSP Form binding using Model Attribute
http://www.javavids.com/video/spring-web-app-tutorial-18-jsp-form-binding-using-model-attribute.html
###############################################################################
How to bind JSP form to Java object using ModelAttribute annotation. 
The form will have responsive layout using Twitter Bootstrap. 
Receiving HTTP POST in Spring Web MVC.

###############################################################################
Spring web app tutorial 19: Spring Security basics
                http://www.javavids.com/video/spring-web-app-tutorial-19-spring-security-basics.html
###############################################################################
Spring Security basics, how to secure Spring web application URLs using Spring Security Filter. Spring Security XML configuration file.

Spring Security Reference
http://docs.spring.io/spring-security/site/docs/3.2.4.RELEASE/reference/htmlsingle/


###############################################################################
Spring web app tutorial 20: Spring Security login page
            http://www.javavids.com/video/spring-web-app-tutorial-20-spring-security-login-page.html
###############################################################################
How to change default login page in Spring security. 
Creating JSP file with Twitter Bootstrap.

http://getbootstrap.com/getting-started/
Sign-in page
Custom form layout and design for a simple sign in form.

	1. create LoginContoller.java
	2. general.xml
	3. edit template: classic.jsp
	4. login.jsp
	5. security.xml
	
###############################################################################
Spring web app tutorial 21: Spring Security Logout
                http://www.javavids.com/video/spring-web-app-tutorial-21-spring-security-logout.html
###############################################################################
How to set custom logout URL in a Spring Security application.
	1. edit template: classic.jsp
	   <a href='<spring:url value="/logout"></spring:url>'>Logout</a>
	2. security.xml
		<logout logout-url="/logout" />
		
###############################################################################
Spring web app tutorial 22: Spring Security Expressions
           http://www.javavids.com/video/spring-web-app-tutorial-22-spring-security-expressions.html
###############################################################################
How to use Expression-Based Access Control in Spring Security. 
Example of hasRole expression.

	1. security.xml
		<http use-expressions="true">
		
		
###############################################################################
Spring web app tutorial 23: Spring Security and JSP
               http://www.javavids.com/video/spring-web-app-tutorial-23-spring-security-and-jsp.html
###############################################################################
How to use Spring Security JSP taglib and tag security:authorize with 
isAuthenticated and hasRole expressions.
	1. pom.xml
		add spring-security-taglibs
	2. edit template: classic.jsp

###############################################################################
Spring web app tutorial 24: Spring Security and database
          http://www.javavids.com/video/spring-web-app-tutorial-24-spring-security-and-database.html
###############################################################################
How to read roles and users using JDBC User Service 
from relational database - HSQL, PostgreSQL, MySQL, Oracle, ...)? 
Authorities by username query and users by username query.

	0. Fix the Problem in Role.java
			@ManyToMany(mappedBy="roles")
			private List<User> users;
	1. security.xml
		<jdbc-user-service data-source-ref="dataSource" ...
		
		
###############################################################################
Spring web app tutorial 25: Spring Security BCrypt
###############################################################################
How to encode password using BCrypt 
(best practice, contains salt and is best protection against brute-force attacks).

	1. security.xml
		<password-encoder hash="bcrypt" />
	2. InitDbService.java
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		
###############################################################################
Spring web app tutorial 26: registration form complete
            http://www.javavids.com/video/spring-web-app-tutorial-26-registration-form-complete.html
###############################################################################
Complete registration form. 
Now we will be able to create a user with encrypted password (using bcrypt) 
and role ROLE_USER, which will be able to login using Spring Security.


###############################################################################
Spring web app tutorial 27: Spring Web MVC redirect
               http://www.javavids.com/video/spring-web-app-tutorial-27-spring-web-mvc-redirect.html
###############################################################################
How to implement Post/Redirect/Get design pattern using Spring Web MVC. 
Best practice for form submit.

	1. UserController.java
		return "redirect:/register.html?success=true";
	2. user-register.jsp
		<c:if test="${param.success eq true }" >
			<div class="alert alert-success">Registration successful !</div>
		</c:if>		
		
		
###############################################################################
Spring web app tutorial 28: User account
                          http://www.javavids.com/video/spring-web-app-tutorial-28-user-account.html
###############################################################################
How to create a page with user account. 
How to retrieve currently logged in user name (using Principal object) in Spring Web MVC. 
Security is done using Spring security.


###############################################################################
Spring web app tutorial 29: Twitter Bootstrap modal
               http://www.javavids.com/video/spring-web-app-tutorial-29-twitter-bootstrap-modal.html
###############################################################################
How to use Twitter Bootstrap modal dialog? Example of a modal dialog with form, 
which will create a new blog.

http://getbootstrap.com/javascript/#modals
Launch demo modal

Responsive jQuery UI Dialog 
Responsive designed that the modal window will auto resize to fit within the container.

###############################################################################
Spring web app tutorial 30: Twitter Bootstrap tabs
                http://www.javavids.com/video/spring-web-app-tutorial-30-twitter-bootstrap-tabs.html
###############################################################################
Using Twitter Bootstrap tabs with JQuery.
http://api.jquery.com/

http://getbootstrap.com/javascript/#tabs
Togglable tabs tab.js
	1. user-detail.jsp
	
	
###############################################################################
Spring web app tutorial 31: JPA / Hibernate cascade
                 http://www.javavids.com/video/spring-web-app-tutorial-31-jpa-hibernate-cascade.html
###############################################################################
How to cascade operations in JPA / Hibernate? 
Presented on cascade type remove. This will solve ConstraintViolationException, 
which we'll get, when we try to remove some entity without removing all entities, 
which use it, first


solve the problem:
	org.hibernate.exception.ConstraintViolationException
	
Remove the blog
	1. Blog.java
		@OneToMany(mappedBy="blog", cascade=CascadeType.REMOVE)
	2. user-detail.jsp
			<a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a>

remove the user
	1. Blog.java
		@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
		private List<Blog> blogs;
	2. user.jsp
			

	
###############################################################################
Spring web app tutorial 32: Twitter Bootstrap dynamic modal
       http://www.javavids.com/video/spring-web-app-tutorial-32-twitter-bootstrap-dynamic-modal.html
###############################################################################
How to create a dynamic modal dialog using Twitter Bootstrap, 
which will be used in a list. 

http://getbootstrap.com/javascript/#modals
	<div class="modal fade" 
		id="modalRemove" tabindex="-1" role="dialog" 
		aria-labelledby="myModalLabel" 
		aria-hidden="true">
I will use JQuery to dynamically set link value inside modal window.
	$(document).ready(function() {
		$(".triggerRemove").click(function(e) {
			e.preventDefault();
			$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();
		});
	});

Prevent to remove something by accident
	1. user-detail.jsp	
	2. user.jsp

	
###############################################################################
Spring web app tutorial 33: Spring Security PreAuthorize
          http://www.javavids.com/video/spring-web-app-tutorial-33-spring-security-preauthorize.html
###############################################################################
How to enable and use expressions with annotations in Spring Security. 
Specifically I will show you how to use PreAuthorize annotation.

Problem: User can delet a blog from another user
User test can delete blog from user admin 
http://localhost:8080/blog/remove/1.html	

Two approachs
a - check blog user name with current user

b- activate the annotation	(out of the box they are disabled

	1. security.xml
	<global-method-security pre-post-annotations="enabled" />
	
	2. Usercontroller.java
		@RequestMapping("/blog/remove/{id}")
		public String removeBlog(@PathVariable int id) {
			Blog blog = blogService.findOne(id);
			blogService.delete(blog);
			return "redirect:/account.html";
		}
	
	3. BlogService.java
		import org.springframework.security.access.method.P;
		import org.springframework.security.access.prepost.PreAuthorize
		@Service
		public class BlogService {
			@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
			public void delete(@P("blog") Blog blog) {
		

		
###############################################################################
Spring web app tutorial 34: utf-8
                                 http://www.javavids.com/video/spring-web-app-tutorial-34-utf-8.html
###############################################################################
How to force UTF-8 so that forms work on Apache Tomcat. 
Using CharacterEncodingFilter from Spring framework.

Žaba Čolić 
Серге́й Алекса́ндрович Есе́нин

http://localhost:8080/my-jba
	
###############################################################################
Spring web app tutorial 35: Cross Site Scripting - XSS
              http://www.javavids.com/video/spring-web-app-tutorial-35-cross-site-scripting-xss.html
###############################################################################
Example of Cross Site Scripting (XSS) and how to solve this problem using c out tag from JSTL.

<script>$(document).ready(function() {	$('body').hide();});</script>
	
How do I prevent people from doing XSS in Java?

Option I
~~~~~~~~~
In Spring you can escape the html from JSP pages generated by <form> tags. 
This closes off a lot avenues for XSS attacks, and can be done automatically in three ways:

	For the entire application in the web.xml file:
		<context-param>
			<param-name>defaultHtmlEscape</param-name>
			<param-value>true</param-value>
		</context-param>

	For all forms on a given page in the file itself:
		<spring:htmlEscape defaultHtmlEscape="true" /> 

	For each form:
		<form:input path="someFormField" htmlEscape="true" /> 

OPTION II
~~~~~~~~~	
	exchange all
		<a href="<spring:url value="/users/${user.id}.html" />">${user.name}</a>	
	with
		<a href="<spring:url value="/users/${user.id}.html" />">
			<c:out value="${user.name}" /> 
		</a>  
		
		
###############################################################################
Spring web app tutorial 36: Hibernate Validator
                   http://www.javavids.com/video/spring-web-app-tutorial-36-hibernate-validator.html
###############################################################################
How to validate input using Hibernate Validator (Bean Validation)? 
How to validate email, URL etc.

    dispatcher-servlet.xml
		<mvc:annotation-driven />

	pom.xml
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.1.0.Final</version>
		</dependency>		
		
	Blog.java
	User.java
			@Size(min = 1, message = "Name must be at least 1 character!")
			@URL(message = "Invalid URL!")
			@Email(message = "Invalid email address!")
	
	
	UserController.java
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
			if (result.hasErrors()) {
				return "user-register";
			}
			userService.save(user);
			return "redirect:/register.html?success=true";
		}
		@RequestMapping(value="/account", method=RequestMethod.POST)
		public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog,
				BindingResult result, Principal principal) {			
			if (result.hasErrors()) {
			  return account(model, principal);	
			}			
			String name = principal.getName();
			blogService.save(blog, name);
			return "redirect:/account.html";
		}			

		user-detail.jsp
		user-register.jsp
		      <form:input path="name" class="form-control" />
		      <form:errors path="name" />		      
		      <form:errors path="*" />		      

			  
###############################################################################
###############################################################################

	
###############################################################################
###############################################################################

	
###############################################################################
###############################################################################


###############################################################################
Spring web app tutorial 51: Spring Profiles and PostgreSQL DB
###############################################################################
How to use Spring Profiles to distinguish between development and production environment. How to use Heroku PostgreSQL database. This is the last video in "Java blog aggregator" series.

