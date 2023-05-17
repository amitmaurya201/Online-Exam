package com.adjecti.oexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adjecti.oexam.entity.*;


@Repository
public interface UserExamDetailRepository extends JpaRepository<UserExamDetail, Long> {

	
	  @Query(value="SELECT distinct(exam_id) as eid FROM public.user_exam_detail", nativeQuery = true)
	  List<Long> getExamIds();
	  
	  @Query(value="SELECT distinct(user_id) as uid FROM public.user_exam_detail", nativeQuery = true)
	  List<Long> getUserIds();
	  
	  @Query(value="SELECT * from user_exam_detail ued where ued.user_id = ?1 and ued.exam_id = ?2", nativeQuery = true)
	  List<UserExamDetail> getUserExamDetailsList(String uid, long eid);
	  
	  @Query(value="SELECT * from user_exam_detail ued where ued.user_id = ?1", nativeQuery = true)
	  List<UserExamDetail> getUserExamDetailsList(String uid);
  }

