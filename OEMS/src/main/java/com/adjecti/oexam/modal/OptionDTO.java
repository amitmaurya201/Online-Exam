package com.adjecti.oexam.modal;

import lombok.Data;


@Data
public class OptionDTO {

	private Long aid;
	private String option;
	private boolean iscorrect;
	private QuestionDTO question;
	private int counter;
	  private boolean optcheck;
	

	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	
	
	public boolean isIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
	}
	
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public boolean isOptcheck() {
		return optcheck;
	}
	public void setOptcheck(boolean optcheck) {
		this.optcheck = optcheck;
	}

	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	public OptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
