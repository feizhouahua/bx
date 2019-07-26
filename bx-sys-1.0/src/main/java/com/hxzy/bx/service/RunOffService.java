package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.RunOff;

public interface RunOffService {
	public void addrunOff(RunOff runOff);
	
	//查询runoff分页
	public List<RunOff> queryRunOff(Integer start, Integer count);
	
	//查询数量
	public int runNum();
}
