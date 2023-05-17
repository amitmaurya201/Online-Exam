package com.adjecti.oexam.service.Impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.Category;
import com.adjecti.oexam.entity.Result;
import com.adjecti.oexam.modal.ResultDTO;
import com.adjecti.oexam.repository.ResultRepository;
import com.adjecti.oexam.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Result addResult(ResultDTO resultDTO) {
		Result result = modelMapper.map(resultDTO, Result.class);
	
		return this.resultRepository.save(result);
	}
	
	public List<Result> getResults(){

		return this.resultRepository.findAll();
		
		
	}

	@Override
	public ResultDTO getResult(Long id) {
		Result result = resultRepository.getById(id);
		ResultDTO resultDTO = modelMapper.map(result, ResultDTO.class);
		
		return resultDTO;
	}

	@Override
	public List<ResultDTO> getResult() {
		 List<Result> resultList = resultRepository.findAll();
		 Type listType = new TypeToken<List<ResultDTO>>() {}.getType();
		 List<ResultDTO> resultdtoList=modelMapper.map(resultList, listType);
		
		  return resultdtoList;
	}

	@Override
	public List<Result> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
