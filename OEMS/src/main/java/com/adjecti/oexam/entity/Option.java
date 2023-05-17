package com.adjecti.oexam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="answer")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aId;
	private String option;
	private boolean iscorrect;	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createOn;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateOn;	
	private String createdby;	
	private String updatedBy;
	private boolean optcheck;

	@ManyToOne()
	private Question question;
	
	@PrePersist
    protected void prePersist() {
        if (this. createOn == null)  createOn = new Date();
      
    }
	@PreUpdate
	protected void preUpdate() {
		this.updateOn = new Date();
	}
	public Long getaId() {
		return aId;
	}
	public void setaId(Long aId) {
		this.aId = aId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	public boolean isIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
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
	public boolean isOptcheck() {
		return optcheck;
	}
	public void setOptcheck(boolean optcheck) {
		this.optcheck = optcheck;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Option(Long aId, String option, boolean iscorrect, Date createOn, Date updateOn, String createdby,
			String updatedBy, boolean optcheck, Question question) {
		super();
		this.aId = aId;
		this.option = option;
		this.iscorrect = iscorrect;
		this.createOn = createOn;
		this.updateOn = updateOn;
		this.createdby = createdby;
		this.updatedBy = updatedBy;
		this.optcheck = optcheck;
		this.question = question;
	}
	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
