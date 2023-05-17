package com.adjecti.oexam.service.Impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adjecti.oexam.entity.Category;
import com.adjecti.oexam.entity.Option;
import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.repository.CategoryRepository;
import com.adjecti.oexam.repository.QuestionRepository;
import com.adjecti.oexam.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Question addQuestion(QuestionDTO questionDto) {
   Question  question=modelMapper.map(questionDto, Question.class);   
   return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(QuestionDTO questionDto) {
		Question question=modelMapper.map(questionDto, Question.class);
		return this.questionRepository.save(question);
	}

	 @Override
		public List<QuestionDTO> getQuestionDTO() {
		 List<Question>questionList=questionRepository.findAll();
		 Type listType = new TypeToken<List<QuestionDTO>>() {}.getType();
		 List<QuestionDTO>questiondtoList=modelMapper.map(questionList, listType);
		 return questiondtoList;
			 
		 
	 }
	@Override
	public QuestionDTO getQuestionDTO(Long questionId) {
		Question question=questionRepository.findByQuesid(questionId);
		QuestionDTO questionDTO=modelMapper.map(question, QuestionDTO.class);
		return questionDTO;
		
	}
	@Override
	public boolean deleteQuestion(long id) {
		questionRepository.deleteById(id);
		return true;		
	}

	@Override
	public Long findAnswerIdCorrect(Long questionId) {
	  
		Question question = questionRepository.findByQuesid(questionId);
		for(Option option:question.getAnswer()) {
			if(option.isIscorrect()) {
				return option.getaId();
			}
		}
		return (long) -1;
	}

	@Override
	public List<QuestionDTO> findByCategoryId(long id) {
			Category category = categoryRepository.findById(id).get();
			List<Question> questionList= questionRepository.findQuestionByCategory(category);
			List<QuestionDTO> questionDTO=modelMapper.map(questionList,
					((TypeToken<List<QuestionDTO>>) new TypeToken<List<QuestionDTO>>() {
					}).getType());
			return questionDTO;
		}
	
	@Override
	public void saveQuestionList(List<QuestionDTO>questionList) {
		List<Question> question=modelMapper.map(questionList,
				((TypeToken<List<Question>>) new TypeToken<List<Question>>() {
				}).getType());
		questionRepository.saveAll(question);
		
	}
 
	@Override
	public List<QuestionDTO> getQuestionByCategory(CategoryDTO category) {
		Category category1=modelMapper.map(category, Category.class);
		List<Question> question=questionRepository.findQuestionByCategory(category1);
		Type listType = new TypeToken<List<QuestionDTO>>() {}.getType();
		System.out.println(question);
		List<QuestionDTO> questionDTO=modelMapper.map(question, listType);
				return questionDTO;
	}


		
	

	
}
