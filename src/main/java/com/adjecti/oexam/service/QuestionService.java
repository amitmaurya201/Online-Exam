package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.modal.QuestionDTO;

public interface QuestionService {

	public Question addQuestion(QuestionDTO questionDto);

	public Question updateQuestion(QuestionDTO questionDto);

	public List<QuestionDTO> getQuestionDTO();
   
	public QuestionDTO getQuestionDTO(Long questionId);
	public boolean deleteQuestion(long id);
	
	public Long findAnswerIdCorrect(Long questionId);

	public List<QuestionDTO> findByCategoryId(long id);
	public void saveQuestionList(List<QuestionDTO>questionList);
	public List<QuestionDTO> getQuestionByCategory(CategoryDTO category);
	
	

}
