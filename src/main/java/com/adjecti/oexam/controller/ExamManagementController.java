package com.adjecti.oexam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.modal.ExamDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.ResultDTO;
import com.adjecti.oexam.modal.UserExamDetailDTO;
import com.adjecti.oexam.service.CategoryService;
import com.adjecti.oexam.service.ExamService;
import com.adjecti.oexam.service.QuestionService;
import com.adjecti.oexam.service.ResultService;
import com.adjecti.oexam.service.UserExamDetailService;

@Controller
@RequestMapping("/admin")
public class ExamManagementController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ExamService examService;



	@Autowired
	private UserExamDetailService userExamDetailService;

	@Autowired
	private ResultService resultService;

	// ------------exam create operations--------------------------

	// ---------------------add exam view-------------------------------
	@RequestMapping(value = "/create-exam")
	public ModelAndView viewExamCreate(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> categoryList = categoryService.getCategories();
		modelAndView.addObject(categoryList);
		modelAndView.addObject("examModel", new ExamDTO());
		modelAndView.setViewName("add_exam");
		return modelAndView;
	}

	// -----------------------add exam ---------------------------------------
	@RequestMapping(value = "/add_question_create_exam", method = RequestMethod.POST)
	public ModelAndView savequestionOnExam(@RequestParam("category") Long categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		List<QuestionDTO> questionList = questionService.findByCategoryId(categoryId);
		modelAndView.addObject("questionList", questionList);
		modelAndView.setViewName("exam_add_question");
		return modelAndView;
	}

	@RequestMapping("/exam_add_question")
	public ModelAndView viewAddExamQuestion() {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> categoryList = categoryService.getCategories();
		modelAndView.addObject("categoryList", categoryList);
		modelAndView.setViewName("exam_add_question");
		return modelAndView;
	}

	@RequestMapping(value = "/exam_add_question", method = RequestMethod.POST)
	public ModelAndView addExamQuestion(@RequestParam("isCheck") Boolean[] isCheck,
			@RequestParam("question") String[] question, @RequestParam("questionId") Long[] questionId) {
		ModelAndView modelAndView = new ModelAndView();
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		for (int i = 0; i < isCheck.length; i++) {
			if (isCheck[i] == true) {
				QuestionDTO quest = new QuestionDTO();
				quest.setQuesid(questionId[i]);
				quest.setQuestion(question[i]);
				questionList.add(quest);
			}
		}

		modelAndView.addObject("questionList", questionList);
		modelAndView.setViewName("add_exam");
		return modelAndView;
	}

	@RequestMapping(value = "/save_exam", method = RequestMethod.POST)
	public ModelAndView saveExam(HttpServletRequest request, @RequestParam("question") String[] question,
			@RequestParam("questionId") Long[] questionId, @ModelAttribute("examModel") ExamDTO examDTO) {
		ModelAndView modelAndView = new ModelAndView();
		ExamDTO exam = examService.saveExam(examDTO, question, questionId);
		/*
		 * String examName = request.getParameter("examName"); String examDesc =
		 * request.getParameter("description"); int maxMarks =
		 * Integer.parseInt(request.getParameter("maxMarks"));
		 * 
		 * List<QuestionDTO> questionList = new ArrayList<QuestionDTO>(); ExamDTO exam =
		 * new ExamDTO(); exam.setDescription(examDesc); exam.setExamName(examName);
		 * exam.setMaxMarks(maxMarks); for (int i = 0; i < question.length; i++) {
		 * QuestionDTO quest = new QuestionDTO(); quest.setQuesid(questionId[i]);
		 * quest.setQuestion(question[i]); List<OptionDTO> ch =
		 * optionService.optionListByQuestionId(questionId[i]);
		 * 
		 * quest.setAnswer(ch); questionList.add(quest); }
		 * exam.setQuestion(questionList); examService.addExam(exam);
		 */		modelAndView.addObject("exam", exam);
		modelAndView.setViewName("view_exam_page");
		return modelAndView;
	}

	// ----------------------view exam page ------------------------------------
	@RequestMapping(value = "/view_exam", method = RequestMethod.GET)
	public ModelAndView viewExam() {
		ModelAndView modelAndView = new ModelAndView();
		List<ExamDTO> examList = examService.getExam();
		modelAndView.addObject("examList", examList);
		modelAndView.setViewName("view_exam");
		return modelAndView;
	}

	// ---------------delete exam--------------------------------------------
	@RequestMapping(value = "/delete-exam", method = RequestMethod.POST)
	public ModelAndView deleteExam(@RequestParam("id") long id) {
		ModelAndView modelAndView = new ModelAndView();
		examService.deleteExam(id);
		modelAndView.setViewName("redirect:/admin/view_exam");
		return modelAndView;
	}

	// ---------------view question who are in exam-------------------------------
	@RequestMapping(value = "/view-exam-questions", method = RequestMethod.GET)
	public ModelAndView viewExamQuestions(@RequestParam("empId") long id) {
		ModelAndView modelAndView = new ModelAndView();
		ExamDTO question = examService.getExam(id);
		List<QuestionDTO> list1 = question.getQuestion();
		modelAndView.addObject("questionList", list1);
		modelAndView.setViewName("exam_questions");
		return modelAndView;
	}

	// ------------------ to edit the exam details---------------------
	@RequestMapping(value = "/edit_exam", method = RequestMethod.GET)
	public ModelAndView updateExamView(@RequestParam("examId") Long id, Model modal) {
		ModelAndView modelAndView = new ModelAndView("ExamUpdate");
		ExamDTO examDTO = examService.getExam(id);
		modelAndView.addObject("ExamUpdate", examDTO);
		modelAndView.setViewName("update_exam");
		return modelAndView;
	}

	// ----------------------edit exam-----------------------------------------
	@RequestMapping(value = "/update_exam", method = RequestMethod.POST)
	public ModelAndView updateExam(@ModelAttribute ExamDTO examDTO) {
		ModelAndView modelAndView = new ModelAndView();
		examService.updateExam(examDTO);
		modelAndView.setViewName("redirect:/admin/view_exam");
		return modelAndView;
	}

	@RequestMapping(value = "/view-exam-result", method = RequestMethod.GET)
	public ModelAndView viewResults() {
		ModelAndView modelAndView = new ModelAndView();
		List<ResultDTO> resultList = resultService.getResult();
		modelAndView.addObject("resultList", resultList);
		modelAndView.setViewName("view_results");
		return modelAndView;
	}

	@RequestMapping(value = "/getUserExamDetail", method = RequestMethod.GET)
	public ModelAndView viewUserExamDetail(Model modal, @RequestParam("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView();
		List<QuestionDTO> questionList = userExamDetailService.getDetails(userId);
		modelAndView.addObject("questionList", questionList);
		modelAndView.setViewName("user_exam_detail");
		return modelAndView;
	}

	// -----------------to display the id of user who give exam----------------
	@RequestMapping("/view_users_exam")
	public ModelAndView viewUserId() {
		ModelAndView modelAndView = new ModelAndView();
		List<Long> examIdList = userExamDetailService.getExamIds();
		List<Long> userIdList = userExamDetailService.getUserIds();
		List<UserExamDetailDTO> examList = userExamDetailService.userExamDetail();
		modelAndView.addObject("examList", examList);
		modelAndView.addObject("examIdList", examIdList);
		modelAndView.addObject("userIdList", userIdList);
		modelAndView.setViewName("view_users_exam");
		return modelAndView;
	}
}
