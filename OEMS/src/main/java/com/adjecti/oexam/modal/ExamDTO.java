package com.adjecti.oexam.modal;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ExamDTO {
	private Long eid;
	private String examName;
	private String description;
	
	private int maxMarks;
	private int noOfQuestion;
	private boolean enabled=true;
	private List<QuestionDTO> question;
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public int getNoOfQuestion() {
		return noOfQuestion;
	}
	public void setNoOfQuestion(int noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<QuestionDTO> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionDTO> question) {
		this.question = question;
	}
	public ExamDTO(Long eid, String examName, String description, int maxMarks, int noOfQuestion, boolean enabled,
			List<QuestionDTO> question) {
		super();
		this.eid = eid;
		this.examName = examName;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQuestion = noOfQuestion;
		this.enabled = enabled;
		this.question = question;
	}
	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
