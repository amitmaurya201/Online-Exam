
package com.adjecti.oexam.service.Impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.Option;
import com.adjecti.oexam.entity.Question;
import com.adjecti.oexam.modal.OptionDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.repository.OptionRepository;
import com.adjecti.oexam.service.OptionService;
import com.adjecti.oexam.service.QuestionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepository optionRepository;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Option addOption(OptionDTO optionDTO) {
		Option option = modelMapper.map(optionDTO, Option.class);
		return this.optionRepository.save(option);
	}

	@Override public Option updateOption(Option option) {
    return this.optionRepository.save(option); }

	@Override public Option getOption(Long optionId) { 
   return this.optionRepository.getOne(optionId); }

	@Override public void deleteOption(Long optionId) { // TODO Auto-generated
    this.optionRepository.deleteById(optionId); }

	@Override
	public List<Option> saveList() { 
		return null ;
	}

	@Override
	public List<Option> saveAllOption(List<OptionDTO> optionDTOList) {

		List<Option> optionList = modelMapper.map(optionDTOList,
				((TypeToken<List<Option>>) new TypeToken<List<Option>>() {
				}).getType());
		return (List<Option>) optionRepository.saveAll(optionList);

	}

	@Override
	public List<OptionDTO> optionListByQuestionId(long id) {
		QuestionDTO QuestionDTO = questionService.getQuestionDTO(id);
		Question question = modelMapper.map(QuestionDTO, Question.class);
		List<Option> optionList = optionRepository.findChoiceByQuestion(question);
		List<OptionDTO> optionDTO = modelMapper.map(optionList,
				((TypeToken<List<OptionDTO>>) new TypeToken<List<OptionDTO>>() {
				}).getType());
		return optionDTO;
	}

	/*
	 * private OptionDTO convertDataIntoDTO(Option option) { OptionDTO dto = new
	 * OptionDTO(); dto.setQuesId(option.getQuestion().getQuesid());
	 * dto.setAid(option.getAid()); dto.setOption(option.getOption());
	 * dto.setQuestion(option.getQuestion());
	 * dto.setIscorrect(option.isIscorrect());;
	 * 
	 * return dto; }
	 * 
	 * @Override public List<OptionDTO> getOptionsDTO() { return ((List<Option>)
	 * optionRepository.findAll()).stream().map(this::convertDataIntoDTO)
	 * .collect(Collectors.toList()); }
	 */
	 @Override
		public List<OptionDTO> getOptionsDTO() {
		 List<Option>optionList=optionRepository.findAll();
		 Type listType = new TypeToken<List<OptionDTO>>() {}.getType();
		 List<OptionDTO>optiondtoList=modelMapper.map(optionList, listType);
		 return optiondtoList;
			 
		 
	 }
	@Override
	public List<Option> optionLiByQuestionId(long id) {
			QuestionDTO QuestionDTO = questionService.getQuestionDTO(id);
			Question question = modelMapper.map(QuestionDTO, Question.class);
			List<Option> optionList = optionRepository.findChoiceByQuestion(question);		
			return optionList;
	}

	@Override
	public OptionDTO getOptiondto(Long optionId) {
		Option option=optionRepository.findById(optionId).get();
		OptionDTO optionDTO=modelMapper.map(option,OptionDTO.class);	
		return optionDTO;
	}

	@Override
	public List<Option> findChoiceByQuestion(Question question) {
		List<Option> optionList=optionRepository.findChoiceByQuestion(question);
		return optionList;
	}
	@Override
	public List<Option> getOptions() {
		return optionRepository.findAll();
	}
}
