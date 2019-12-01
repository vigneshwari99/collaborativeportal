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

@RestController
public class BlogCtrl {

	@Autowired
	private Dao blogDao;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public ResponseEntity<Blog> addPost(@RequestBody Blog blog) {
		System.out.println();

		boolean status = blogDao.save(blog);
		if (status) {
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<Blog>(blog, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/getAllPosts")
	public ResponseEntity<List<?>> getAllBlogs() {

		List<?> blogs = blogDao.getList();

		return new ResponseEntity<List<?>>(blogs, HttpStatus.OK);
	}

	@RequestMapping(value = "image/upload/{imgName}", method = RequestMethod.POST)
	public ResponseEntity<?> imageUpload(HttpServletRequest req, @PathVariable("imgName") String imgName) {
		/*
		 * Image Upload functionality.
		 */
		System.out.println("Image name -> " + imgName);
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		try {

			MultipartFile test = mr.getFile(imgName);
			System.out.println("File recieved ->" + test.getOriginalFilename());

		} catch (Exception e) {
			System.out.println("file not found");
		}
		Iterator<String> itr = mr.getFileNames();
		while (itr.hasNext()) {
			// org.springframework.web.multipart.MultipartFile
			MultipartFile fd = mr.getFile(itr.next());
			String fileName = fd.getOriginalFilename();
			System.out.println("*****" + fileName);

			try {
				/*
				 * Creating the directory in the server context to store.
				 */
				String imagePath = request.getSession().getServletContext().getRealPath("/resources/images/posts");
				System.out.println("------- Context Path set -------");
				File dir = new File(imagePath + File.separator);
				System.out.println("------- Directory set to" + dir + "-------");
				if (!dir.exists())
					dir.mkdirs();

				String filePath = imagePath + File.separator + imgName + ".jpg";
				File dest = new File(filePath);
				System.out.println("------- Image uploaded to " + dest + "-------");
				fd.transferTo(dest);

			} catch (Exception e) {
				System.out.println("You failed to upload " + " => " + e.getMessage());

				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping("/post/comment/{id}")
	public ResponseEntity<Comment> postComment(@RequestBody Comment comment, @PathVariable int id) {

		Blog blog = (Blog) blogDao.getById(id);
		List<Comment> comments = blog.getComments();
		comments.add(comment);
		blog.setComments(comments);
		blogDao.update(blog);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

}
