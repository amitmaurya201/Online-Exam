package com.adjecti.oexam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserExamDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long userExamId;
	private long questionId;
	private long answerId;
	private String attempted;
	private long examId;
	private String userId;
	public long getUserExamId() {
		return userExamId;
	}
	public void setUserExamId(long userExamId) {
		this.userExamId = userExamId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}
	public String getAttempted() {
		return attempted;
	}
	public void setAttempted(String attempted) {
		this.attempted = attempted;
	}
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserExamDetail(long userExamId, long questionId, long answerId, String attempted, long examId,
			String userId) {
		super();
		this.userExamId = userExamId;
		this.questionId = questionId;
		this.answerId = answerId;
		this.attempted = attempted;
		this.examId = examId;
		this.userId = userId;
	}
	public UserExamDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
