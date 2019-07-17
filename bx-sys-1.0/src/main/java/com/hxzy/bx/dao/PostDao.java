package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Post;

public interface PostDao {

	//查询职务列表(start 表示从第几条记录开始 count表示每页显示几条记录)
	public List<Post> getPosts(@Param(value = "start") int start,@Param(value = "count")int count);
	
	//添加职务
	public void addPost(Post post);
	
	//编辑职务
	public void updatePost(Post post);
	
	//查询有多少条记录
	public int getCounts();
		
	//根据id查找对象
	public Post getPostById(int id);
	
	//根据depart_name查找该部门的职务
	public List<Post> getPost_names(String depart_name);
}
