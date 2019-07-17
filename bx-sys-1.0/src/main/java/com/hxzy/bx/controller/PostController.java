package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.bx.entity.Department;
import com.hxzy.bx.entity.Post;
import com.hxzy.bx.service.DepartmentService;
import com.hxzy.bx.service.PostService;

@Controller
public class PostController {
	
	@Resource(name="postServiceImpl")
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	@RequestMapping("resources/post/list")
	public String list(@RequestParam int page,Model model) {
		if(page==0) {
			page=1;
		}
		int pagecount=5;//每页显示5条记录
		int pages=postService.getPages(pagecount);//获得页数
		List<Post> posts=postService.getPosts((page-1)*pagecount, pagecount);
		model.addAttribute("posts", posts);
		model.addAttribute("page", page);
		model.addAttribute("pages", pages);
		return "list";
	}
	
	@RequestMapping("resources/post/add")
	public String add(@ModelAttribute Post post,Department department) throws UnsupportedEncodingException {
//		department.setDepart_name(new String(department.getDepart_name().getBytes("iso-8859-1"),"utf-8"));
//		post.setPost_name(new String(post.getPost_name().getBytes("iso-8859-1"),"utf-8"));
		Department d=departmentService.getDepartmentByName(department.getDepart_name());
		post.setDepartment(d);
		postService.addPost(post);
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("resources/post/updatea")
	public String updatea(@RequestParam int id,Model model) {
		Post post=postService.getPostById(id);
		model.addAttribute("post", post);
		System.out.println(post.getDepartment());
		return "update";
	}
	
	@RequestMapping("resources/post/updateb")
	public String updateb(@ModelAttribute Department department,Post post) throws UnsupportedEncodingException {
//		department.setDepart_name(new String(department.getDepart_name().getBytes("iso-8859-1"),"utf-8"));
//		post.setPost_name(new String(post.getPost_name().getBytes("iso-8859-1"),"utf-8"));
		Department d=departmentService.getDepartmentByName(department.getDepart_name());
		post.setDepartment(d);
		postService.updatePost(post);
		return "redirect:list.html?page=1";
	}
	
	
}
