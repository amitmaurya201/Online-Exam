package com.adjecti.oexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.oexam.entity.Option;
import com.adjecti.oexam.entity.Question;



@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {
	 public List<Option> findChoiceByQuestion(Question question); 
	
}
