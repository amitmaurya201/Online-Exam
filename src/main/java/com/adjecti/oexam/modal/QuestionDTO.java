package com.adjecti.oexam.modal;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
@Data
public class QuestionDTO{	
	private Long quesid;
	
	private String question;
	private Date createon;
	private Date updateon;
	private String createdby;
	private String updatedby;
	private List<OptionDTO>answer;
    private String imageid;
	private CategoryDTO category;
	private String []question1; 
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
	public Date getCreateon() {
		return createon;
	}
	public void setCreateon(Date createon) {
		this.createon = createon;
	}
	public Date getUpdateon() {
		return updateon;
	}
	public void setUpdateon(Date updateon) {
		this.updateon = updateon;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	
	
	
	public List<OptionDTO> getAnswer() {
		return answer;
	}
	public void setAnswer(List<OptionDTO> answer) {
		this.answer = answer;
	}
	public String getImageid() {
		return imageid;
	}
	public void setImageid(String imageid) {
		this.imageid = imageid;
	}
	
	
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public QuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
}

/*
 * package com.adjecti.oexam.modal;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * import javax.validation.constraints.Size;
 * 
 * import org.bson.types.Binary;
 * 
 * import com.adjecti.oexam.entity.Category; import
 * com.adjecti.oexam.entity.Option;
 * 
 * import lombok.Data;
 * 
 * @Data public class QuestionDTO {
 * 
 * private Long quesid; private Long cid; private String question; private
 * Category category; private Date createon; private String imageid; private
 * List<OptionDTO> answerDTO; private List<Option> answer; public Long
 * getQuesid() { return quesid; } public void setQuesid(Long quesid) {
 * this.quesid = quesid; } public Long getCid() { return cid; } public void
 * setCid(Long cid) { this.cid = cid; } public String getQuestion() { return
 * question; } public void setQuestion(String question) { this.question =
 * question; }
 * 
 * public Category getCategory() { return category; } public void
 * setCategory(Category category) { this.category = category; }
 * 
 * public Date getCreateon() { return createon; } public void setCreateon(Date
 * createon) { this.createon = createon; }
 * 
 * public List<Option> getAnswer() { return answer; } public void
 * setAnswer(List<Option> answer) { this.answer = answer; }
 * 
 * 
 * 
 * public List<OptionDTO> getAnswerDTO() { return answerDTO; } public void
 * setAnswerDTO(List<OptionDTO> answerDTO) { this.answerDTO = answerDTO; }
 * public String getImageid() { return imageid; } public void setImageid(String
 * imageid) { this.imageid = imageid; } public QuestionDTO(Long quesid, Long
 * cid, String question, Category category) { super(); this.quesid = quesid;
 * this.cid = cid; this.question = question; this.category = category; }
 * 
 * 
 * public QuestionDTO(Long quesid, Long cid, String question, Category category,
 * Date createon, String imageid, List<Option> answer) { super(); this.quesid =
 * quesid; this.cid = cid; this.question = question; this.category = category;
 * this.createon = createon; this.imageid = imageid; this.answer = answer; }
 * public QuestionDTO() { super(); // TODO Auto-generated constructor stub }
 * 
 * @Override public String toString() { return "QuestionDTO [quesid=" + quesid +
 * ", cid=" + cid + ", question=" + question + ", category=" + category +
 * ", createon=" + createon + ", imageid=" + imageid + ", answer=" + answer +
 * "]"; }
 * 
 * 
 * 
 * }
 */