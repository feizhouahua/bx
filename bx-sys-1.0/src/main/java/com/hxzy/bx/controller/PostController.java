package com.hxzy.bx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.bx.entity.Department;
import com.hxzy.bx.entity.Post;
import com.hxzy.bx.service.PostService;

@Controller
public class PostController {
	
	@Resource(name="postServiceImpl")
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
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
	
//	@ResponseBody
//	@RequestMapping(method=RequestMethod.GET, value="get/users")
//	public String list(ModelMap map) throws UnsupportedEncodingException {
//		List<User> list=us.getUsers();
//		JSONArray array=JSONArray.fromObject(list);
//		return new String(array.toString().getBytes("UTF-8"),"ISO-8859-1");
//	}
}
