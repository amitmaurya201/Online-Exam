package com.adjecti.oexam.modal;

import lombok.Data;

@Data
public class UserExamDetailDTO {
	private long userExamId;
	private long questionId;
	private long answerId;
	private long examId;
	private String attempted;
	private String userId;
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}
	
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	
	public String getAttempted() {
		return attempted;
	}
	public void setAttempted(String attempted) {
		this.attempted = attempted;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public long getUserExamId() {
		return userExamId;
	}

	public void setUserExamId(long userExamId) {
		this.userExamId = userExamId;
	}

	public UserExamDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
