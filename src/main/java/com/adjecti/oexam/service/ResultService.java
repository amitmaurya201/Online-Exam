package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.entity.Result;
import com.adjecti.oexam.modal.ResultDTO;

public interface ResultService {
	
	public Result addResult(ResultDTO resultDTO);
	
	public List<Result> getResults();
	
	public List<ResultDTO> getResult();

	public ResultDTO getResult(Long id);
	
	List<Result> findByName(String name);
}
