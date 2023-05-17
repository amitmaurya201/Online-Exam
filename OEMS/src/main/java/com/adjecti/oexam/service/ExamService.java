package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.entity.Exam;
import com.adjecti.oexam.modal.ExamDTO;
import com.adjecti.oexam.modal.QuestionDTO;



public interface ExamService {

	// to new Exam
	public Exam addExam(ExamDTO examDTO);
	
	

	// to update exam
	public Exam updateExam(ExamDTO examDTO);

	// to find all exam
	public List<ExamDTO> getExam();

	// to find by id exam
	public ExamDTO getExam(Long examId);
	
	
	// to delete exam
	public void deleteExam(Long examId);
	
	public ExamDTO saveExam(ExamDTO examDTO,String [] QuestionArr,Long [] questionId);


}
