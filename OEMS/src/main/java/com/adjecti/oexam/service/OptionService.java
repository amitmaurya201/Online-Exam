package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.entity.Option;
import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.OptionDTO;


public interface OptionService {

	public Option addOption(OptionDTO optionDTO);
	public Option updateOption(Option option); 
	public List<Option> saveList();
	public Option getOption(Long optionId);
	public void deleteOption(Long optionId);
	public List<Option> saveAllOption(List<OptionDTO> optionDTOList);
	public List<OptionDTO> optionListByQuestionId(long id);
	public List<OptionDTO> getOptionsDTO();
	public List<Option> optionLiByQuestionId(long id);
	 public OptionDTO getOptiondto(Long optionId);
	 public List<Option> findChoiceByQuestion(Question question); 
	 public List<Option> getOptions() ;

	
	
}
