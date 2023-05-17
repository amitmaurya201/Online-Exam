package com.adjecti.oexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.oexam.entity.Exam;



@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

	public Exam findByEid(long eid);
}
