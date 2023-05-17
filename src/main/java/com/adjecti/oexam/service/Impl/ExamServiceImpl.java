package com.adjecti.oexam.service.Impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.entity.Exam;
import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.ExamDTO;
import com.adjecti.oexam.modal.OptionDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.repository.ExamRepository;
import com.adjecti.oexam.service.ExamService;
import com.adjecti.oexam.service.OptionService;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private OptionService  optionService;
	@Override
	public Exam addExam(ExamDTO examDTO) {
		Exam exam=modelMapper.map(examDTO, Exam.class);
		return this.examRepository.save(exam);
	}

	@Override
	public Exam updateExam(ExamDTO examDTO) {
		Exam exam = modelMapper.map(examDTO, Exam.class);
		return this.examRepository.save(exam);
	}

	
	 @Override
		public  List<ExamDTO> getExam() {
		 List<Exam>questionList=examRepository.findAll();
		 Type listType = new TypeToken<List<ExamDTO>>() {}.getType();
		 List<ExamDTO>questiondtoList=modelMapper.map(questionList, listType);
		 return questiondtoList;
			 
		 
	 }
	@Override
	public ExamDTO getExam(Long examId) {
	Exam exam=examRepository.findByEid(examId);
	ExamDTO examDTO=modelMapper.map(exam, ExamDTO.class);
	return examDTO;
	}

	@Override
	public void deleteExam(Long examId) {
		this.examRepository.deleteById(examId);
	}

	@Override
	public ExamDTO saveExam(ExamDTO examDTO, String[] QuestionArr, Long[] questionId) {
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		for (int i = 0; i < QuestionArr.length; i++) {
			QuestionDTO quest = new QuestionDTO();
			quest.setQuesid(questionId[i]);
			quest.setQuestion(QuestionArr[i]);
			List<OptionDTO> ch = optionService.optionListByQuestionId(questionId[i]);

			quest.setAnswer(ch);
			questionList.add(quest);
		}
		examDTO.setQuestion(questionList);
		addExam(examDTO);
		
		return examDTO;
	}

	

	
	
}
