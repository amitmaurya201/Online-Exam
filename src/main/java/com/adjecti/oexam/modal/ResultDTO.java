package com.adjecti.oexam.modal;

import java.util.Date;

import lombok.Data;
@Data
public class ResultDTO {
	private long rid;
	private String userName;
	private String examname;
	private Long maxMarks;
	private Long examid;
	private Long score;
	private Date createon;
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
	public Date getCreateon() {
		return createon;
	}
	public void setCreateon(Date createon) {
		this.createon = createon;
	}
	public ResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
