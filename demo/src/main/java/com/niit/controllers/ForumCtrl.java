package com.niit.controllers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.niit.model.Dao;
import com.niit.pojo.Blog;
import com.niit.pojo.Comment;
import com.niit.pojo.Forum;

@RestController
public class ForumCtrl {
	@Autowired
	private Dao forumDao;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/addForum", method = RequestMethod.POST)
	public ResponseEntity<Forum> addPost(@RequestBody Forum blog) {
		System.out.println();

		boolean status = forumDao.save(blog);
		if (status) {
			return new ResponseEntity<Forum>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<Forum>(blog, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/getAllForum")
	public ResponseEntity<List<?>> getAllBlogs() {

		List<?> forums = forumDao.getList();

		return new ResponseEntity<List<?>>(forums, HttpStatus.OK);
	}

	@RequestMapping("/forum/comment/{id}")
	public ResponseEntity<Comment> postComment(@RequestBody Comment comment, @PathVariable int id) {

		Forum forum = (Forum) forumDao.getById(id);
		List<Comment> comments = forum.getComments();
		comments.add(comment);
		forum.setComments(comments);
		forumDao.update(forum);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
}
