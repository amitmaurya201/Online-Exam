
package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.entity.UserExamDetail;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.UserExamDetailDTO;

public interface UserExamDetailService {
	public UserExamDetail addExamDetail(UserExamDetailDTO userExamDetailDTO);

	public List<UserExamDetailDTO> userExamDetail();
	  public List<Long> getExamIds();
		public  List<Long> getUserIds();
		 public List<UserExamDetail> getUserExamDetailsList(String uid, long eid);
		 public List<UserExamDetailDTO> getUserExamDetailsList(String uid);
         public List<QuestionDTO> getDetails(String id);
}
