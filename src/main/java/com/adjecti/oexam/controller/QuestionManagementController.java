package com.adjecti.oexam.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.modal.OptionDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.UserDTO;
import com.adjecti.oexam.service.CategoryService;
import com.adjecti.oexam.service.OptionService;
import com.adjecti.oexam.service.QuestionService;
import com.adjecti.oexam.service.UserService;

@Controller
@RequestMapping("/admin")
public class QuestionManagementController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private OptionService optionService;

	// ------------------------Category related
	// operations--------------------------------------------------------

	// ----------------------add category view---------------------
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView addCategoryView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("category", new CategoryDTO());
		modelAndView.setViewName("add_category");
		return modelAndView;
	}

	// ----------------------add category------------------------
	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO, Errors errors,
			Principal principal) {
		UserDTO user = userService.findByUserId(principal.getName());
		categoryDTO.setCreatedby(user.getUserName());
		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			modelAndView.setViewName("add_category");
		} else {
			categoryService.addCategory(categoryDTO);
			modelAndView.setViewName("redirect:/admin/view_category");
		}
		return modelAndView;
	}

	// -------------------view category page---------------------------------
	@RequestMapping("/view_category")
	public ModelAndView viewCategory(CategoryDTO categoryDto) {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> examList = categoryService.getCategories();
		modelAndView.addObject("list", examList);
		modelAndView.setViewName("view_category");
		return modelAndView;
	}

	// ----------------delete category-----------------------------
	@RequestMapping(value = "/deletecategory", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@RequestParam("categoryId") Long id) {
		CategoryDTO category = categoryService.getCategory(id);
		List<QuestionDTO> questionList = questionService.getQuestionByCategory(category);
		ModelAndView modelAndView = new ModelAndView();
		if (questionList != null) {
			for (QuestionDTO question : questionList) {
				if (question.getCategory().getCid() == id) {
					modelAndView.addObject("error", "cannot deleted");
					modelAndView.setViewName("message_error");
					return modelAndView;

				} else {
					categoryService.deleteCategory(id);
					modelAndView.setViewName("redirect:/admin/view_category");
				}
			}
		}

		categoryService.deleteCategory(id);
		modelAndView.setViewName("redirect:/admin/view_category");
		return modelAndView;
	}

	// ---------------------edit category page---------------------
	@RequestMapping(value = "/edit_category", method = RequestMethod.GET)
	public ModelAndView updateCategoryView(@RequestParam("categoryId") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		CategoryDTO categoryDto = categoryService.getCategory(id);
		modelAndView.addObject("category", categoryDto);
		modelAndView.setViewName("update_category");
		return modelAndView;
	}

	// ----------------edit category-------------------------------------
	@RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {
		ModelAndView modelAndView = new ModelAndView();
		categoryService.updateCategory(categoryDTO);
		modelAndView.setViewName("redirect:/admin/view_category");
		return modelAndView;
	}

	// ------------------add question--------------------------------------
	@RequestMapping("/add_question")
	public ModelAndView getAddQuestionView(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO>categoryDTOList= categoryService.getCategories();
		List<QuestionDTO> questionList = questionService.getQuestionDTO();
		
		model.addAttribute("questionList", questionList);
		 model.addAttribute("categoryDTOList", categoryDTOList);
		modelAndView.addObject("questionModel", new QuestionDTO());
		modelAndView.setViewName("add_question");
		return modelAndView;
	}

	// -----------------------add question-----------------------------
	@RequestMapping(value = "/save-question", method = RequestMethod.POST)
	public ModelAndView saveQuestion(@ModelAttribute("questionModel") QuestionDTO questionDto, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
			UserDTO user = userService.findByUserId(principal.getName());
			questionDto.setCreatedby(user.getUserName());
			questionService.addQuestion(questionDto);
			List<QuestionDTO> questionList = questionService.getQuestionDTO();
			modelAndView.addObject("questionList", questionList);
			modelAndView.setViewName("redirect:/admin/view_add_question");	
			
		
			return modelAndView;
	}

	@RequestMapping(value = "/view_add_question", method = RequestMethod.GET)
	public ModelAndView viewQuestion() {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> examList = categoryService.getCategories();
		modelAndView.addObject("categoryList", examList);
		List<QuestionDTO> questionList = questionService.getQuestionDTO();	
		modelAndView.addObject("questionList", questionList);
		modelAndView.setViewName("view_add_question");
		return modelAndView;
	}

	@RequestMapping("/edit_question")
	public ModelAndView editQuestionView(@RequestParam("questionId") Long questionId) {
		QuestionDTO questionDTO = questionService.getQuestionDTO(questionId);
		List<OptionDTO> optionList = optionService.optionListByQuestionId(questionId);
		//List<Option> option = new ArrayList<Option>();
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> categoryList = categoryService.getCategories();
		modelAndView.addObject("question", questionDTO);
		modelAndView.addObject("categoryList", categoryList);
		modelAndView.addObject("optionList", optionList);
		modelAndView.setViewName("edit_management");
		modelAndView.addObject("choice", new ArrayList<OptionDTO>() );
		modelAndView.addObject("choice", new QuestionDTO());
		return modelAndView;
	}

	// ---------------------add option view------------------------------------
	@RequestMapping(value = "/add_option", method = RequestMethod.GET)
	public ModelAndView addOptionView(@RequestParam("questionId") Long questionId) {
		ModelAndView modelAndView = new ModelAndView();
		QuestionDTO question = questionService.getQuestionDTO(questionId);
		modelAndView.addObject("question", question);
		modelAndView.setViewName("add_option");
		return modelAndView;
	}

	@RequestMapping(value = "/save_choices", method = RequestMethod.POST)
	public ModelAndView saveOptions(HttpServletRequest request) {
		long questionId = Long.parseLong(request.getParameter("question"));
		int counter = Integer.parseInt(request.getParameter("counter"));
		QuestionDTO questiondto = questionService.getQuestionDTO(questionId);
		questiondto.setQuesid(questionId);
		List<OptionDTO> optionList = new ArrayList<OptionDTO>();
		ModelAndView modelAndView = new ModelAndView(); 
		if (counter > 1) {
			for (int i = 1; i <= counter; i++) {
				OptionDTO choice = new OptionDTO();
				choice.setOption(request.getParameter("choice" + i));
				choice.setIscorrect(Boolean.parseBoolean(request.getParameter("ischeck" + i)));
				choice.setQuestion(questiondto);
				optionList.add(choice);

			}
			optionService.saveAllOption(optionList);
		} else if (counter == 1) {
			OptionDTO choice = new OptionDTO();
			choice.setOption(request.getParameter("choice1"));
			choice.setIscorrect(Boolean.parseBoolean(request.getParameter("ischeck1")));
			choice.setQuestion(questiondto);
			optionList.add(choice);
			optionService.saveAllOption(optionList);
		}
		modelAndView.setViewName("redirect:/admin/view_add_question");
		return modelAndView;
	}

	@RequestMapping(value = "/update_question", method = RequestMethod.POST)
	public ModelAndView updateQuestion(@RequestParam("questionId") Long questionId,
			@RequestParam("question") String quest, @RequestParam("option") String[] choice,
			@RequestParam("aid") Long[] choiceId) {
		QuestionDTO que = questionService.getQuestionDTO(questionId);
		que.setQuesid(questionId);
		que.setQuestion(quest);
		List<OptionDTO> optionListType = new ArrayList<OptionDTO>();
		for (int i = 0; i < choiceId.length; i++) {
			OptionDTO optionDTO = optionService.getOptiondto(choiceId[i]);
			optionDTO.setOption(choice[i]);
			optionListType.add(optionDTO);
		}
		que.setAnswer(optionListType);
		questionService.updateQuestion(que);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/view_add_question");
		return modelAndView;
	}
	
	
	// --------------delete question-------------------------------------------
	@RequestMapping(value = "/delete_question")
	public ModelAndView deleteQuestion(@RequestParam("questionId") Long questionId) {
		ModelAndView modelAndView = new ModelAndView();
		QuestionDTO question = questionService.getQuestionDTO(questionId);
	
		List<OptionDTO> optionList = question.getAnswer();
		
		if (optionList != null) {
			for (OptionDTO option : optionList) {
				if (option.getQuestion().getQuesid() == questionId) {
					modelAndView.addObject("error", "cannot deleted");
					modelAndView.setViewName("message_error2");
					return modelAndView;

				} else {
					questionService.deleteQuestion(questionId);
					modelAndView.setViewName("view_add_question");
				}

			}
		}
		questionService.deleteQuestion(questionId);
		modelAndView.setViewName("view_add_question");
		return modelAndView;
	}}
