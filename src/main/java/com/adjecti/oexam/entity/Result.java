package com.adjecti.oexam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rid;
	private String userName;
	private String examname;
	private Long maxMarks;
	private Long examid;
	private Long score;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createOn;
	@PrePersist
    protected void prePersist() {
        if (this. createOn == null)  createOn = new Date();
      
    }
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public Long getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(Long maxMarks) {
		this.maxMarks = maxMarks;
	}
	public Long getExamid() {
		return examid;
	}
	public void setExamid(Long examid) {
		this.examid = examid;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public Result(long rid, String userName, String examname, Long maxMarks, Long examid, Long score, Date createOn) {
		super();
		this.rid = rid;
		this.userName = userName;
		this.examname = examname;
		this.maxMarks = maxMarks;
		this.examid = examid;
		this.score = score;
		this.createOn = createOn;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
