package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.PostDao;
import com.hxzy.bx.entity.Post;
import com.hxzy.bx.service.PostService;

@Component("postServiceImpl")
public class PostServiceImpl implements PostService {

	@Resource
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Override
	public List<Post> getPosts(int start, int count) {
		// TODO Auto-generated method stub
		return postDao.getPosts(start, count);
	}
	@Override
	public void addPost(Post post) {
		postDao.addPost(post);
		
	}
	@Override
	public void updatePost(Post post) {
		postDao.updatePost(post);
		
	}
	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return postDao.getCounts();
	}
	@Override
	public int getPages(int pagecount) {
		int counts=getCounts();
		if(counts%pagecount==0) {
			return counts/pagecount;
		}else {			
			return counts/pagecount+1;
		}

	}
	@Override
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		return postDao.getPostById(id);
	}
	@Override
	public List<Post> getPost_names(String depart_name) {
		// TODO Auto-generated method stub
		return postDao.getPost_names(depart_name);
	}
	@Override
	public Post getPostByName(String post_name) {
		// TODO Auto-generated method stub
		return postDao.getPostByName(post_name);
	}
}
