package com.adjecti.oexam.modal;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategoryDTO {	

	private Long cid;
    
    @NotBlank(message = "Please enter category")
	private String title;
	
	private Date createOn;
    private String createdby;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public CategoryDTO(Long cid, @NotBlank(message = "Please enter category") String title, Date createOn,
			String createdby) {
		super();
		this.cid = cid;
		this.title = title;
		this.createOn = createOn;
		this.createdby = createdby;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
