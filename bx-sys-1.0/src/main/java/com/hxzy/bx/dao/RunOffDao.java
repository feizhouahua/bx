package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.RunOff;

public interface RunOffDao {
	//添加runoff
	public void addrunOff(RunOff runOff);
	
	//查询runoff分页
	public List<RunOff> queryRunOff(@Param(value="start")Integer start,@Param(value="count") Integer count);

	//查询数量
	public int runNum();
}
