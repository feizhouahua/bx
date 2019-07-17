package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Department;
import com.hxzy.bx.entity.Post;

public interface PostService {
		
		//查询职务列表(start 表示从第几条记录开始 count表示每页显示几条记录)
		public List<Post> getPosts(int start,int count);
		
		//添加职务
		public void addPost(Post post);
		
		//编辑职务
		public void updatePost(Post post);
		
		//查询有多少条记录
		public int getCounts();
		
		//根据每页显示记录数获得页数
		public int getPages(int pagecount);
				
		//根据id查找对象
		public Post getPostById(int id);	
		
		//根据depart_name 查找该部门的职务
		public List<Post> getPost_names(String depart_name);
}
