package com.adjecti.oexam.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quesid;
	private String question;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createOn;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateOn;
	private String createdby;
	private String updatedBy;
	@ManyToOne()
	private Category category;
	@OneToMany(mappedBy = "question" ,cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Option> answer;
	@PrePersist
	protected void prePersist() {
		if (this.createOn == null)
			createOn = new Date();

	}

	@PreUpdate
	protected void preUpdate() {
		this.updateOn = new Date();
	}

	public Long getQuesid() {
		return quesid;
	}

	public void setQuesid(Long quesid) {
		this.quesid = quesid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Option> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Option> answer) {
		this.answer = answer;
	}

	public Question(Long quesid, String question, Date createOn, Date updateOn, String createdby, String updatedBy,
			Category category, List<Option> answer) {
		super();
		this.quesid = quesid;
		this.question = question;
		this.createOn = createOn;
		this.updateOn = updateOn;
		this.createdby = createdby;
		this.updatedBy = updatedBy;
		this.category = category;
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
