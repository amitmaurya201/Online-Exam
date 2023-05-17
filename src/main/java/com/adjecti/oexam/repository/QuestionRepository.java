package com.adjecti.oexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.oexam.entity.Category;
import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.QuestionDTO;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	public Question findByQuesid(long quesid);

	public List<Question> findQuestionByCategory(Category category);

	

	

    
	
	
}
