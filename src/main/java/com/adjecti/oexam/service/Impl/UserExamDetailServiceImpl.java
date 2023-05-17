
package com.adjecti.oexam.service.Impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.UserExamDetail;
import com.adjecti.oexam.modal.OptionDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.UserExamDetailDTO;
import com.adjecti.oexam.repository.UserExamDetailRepository;
import com.adjecti.oexam.service.QuestionService;
import com.adjecti.oexam.service.UserExamDetailService;

@Service
public class UserExamDetailServiceImpl implements UserExamDetailService {

	@Autowired
	private UserExamDetailRepository userExamDetailRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private QuestionService questionService;

	@Override
	public UserExamDetail addExamDetail(UserExamDetailDTO userExamDetailDTO) {
		UserExamDetail userExamDetail = modelMapper.map(userExamDetailDTO, UserExamDetail.class);
		return userExamDetailRepository.save(userExamDetail);

	}

	@Override
	public List<UserExamDetailDTO> userExamDetail() {
		 List<UserExamDetail>userExamDetailList=userExamDetailRepository.findAll();
		 Type listType = new TypeToken<List<UserExamDetailDTO>>() {}.getType();
		 List<UserExamDetailDTO>userExamDetailDTOList=modelMapper.map(userExamDetailList, listType);
		return userExamDetailDTOList;
	}

	@Override
	public List<Long> getExamIds() {
		
		return userExamDetailRepository.getExamIds();
	}

	@Override
	public List<Long> getUserIds() {
		
		return userExamDetailRepository.getUserIds();
	}

	@Override
	public List<UserExamDetail> getUserExamDetailsList(String uid, long eid) {
	
		return userExamDetailRepository.getUserExamDetailsList(uid);
	}

	@Override
	public List<UserExamDetailDTO> getUserExamDetailsList(String uid) {	
		
		List<UserExamDetail>userExamDetailsList=userExamDetailRepository.getUserExamDetailsList(uid);
		Type typeList=new TypeToken<List<UserExamDetailDTO>>() {}.getType();
		 List<UserExamDetailDTO>userExamDetailDTOList=modelMapper.map(userExamDetailsList, typeList);
		return userExamDetailDTOList;
	}

	@Override
	public List<QuestionDTO> getDetails(String id) {
		List<UserExamDetailDTO> userExamDetail = getUserExamDetailsList(id);
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		List<Long> answerList = new ArrayList<Long>();
		for (UserExamDetailDTO userExam : userExamDetail) {
			Long questionId = userExam.getQuestionId();
			long userAnswer = userExam.getAnswerId();
			answerList.add(userAnswer);
			QuestionDTO questionDTO = questionService.getQuestionDTO(questionId);
			questionList.add(questionDTO);
		}
		List<QuestionDTO> qList = new ArrayList<QuestionDTO>();
		for (QuestionDTO question : questionList) {
			List<OptionDTO> opt = new ArrayList<OptionDTO>();
			for (OptionDTO option : question.getAnswer()) {
				option.setOptcheck(false);
				if (answerList.contains(option.getAid())) {
					option.setOptcheck(true);
				}
				opt.add(option);
			}
			question.setAnswer(opt);
			qList.add(question);
		}
		 return qList;	
	}
   
	

}
