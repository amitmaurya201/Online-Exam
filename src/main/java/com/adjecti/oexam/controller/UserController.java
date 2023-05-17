
package com.adjecti.oexam.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.modal.ExamDTO;
import com.adjecti.oexam.modal.OptionDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.ResultDTO;
import com.adjecti.oexam.modal.UserDTO;
import com.adjecti.oexam.modal.UserExamDetailDTO;
import com.adjecti.oexam.service.ExamService;
import com.adjecti.oexam.service.QuestionService;
import com.adjecti.oexam.service.ResultService;
import com.adjecti.oexam.service.UserExamDetailService;
import com.adjecti.oexam.service.UserService;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.SysoCounter;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ExamService examService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ResultService resultService;


	@Autowired
	private UserService userService;

	@Autowired
	private UserExamDetailService userExamDetailService;



	//----------------------to display the user dashboard page------------------------
	@RequestMapping("/")
	public ModelAndView userDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		List<ExamDTO> examList = examService.getExam();
		modelAndView.addObject("examList", examList);
		modelAndView.setViewName("user_dashboard");
		return modelAndView;

	}
    //-----------------to display home page of user------------------
	@RequestMapping("/home")
	public ModelAndView userInstruction() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "user_dashboard");
		return modelAndView;
	}
    // ---------------to display the exam page to user----------------
	@RequestMapping("/startexam")
	public ModelAndView userExam() {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("user_exam");
		return modelAndView;
	}
    // ----------------do logout from user----------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
    // ----------------display question which are in exam---------------
	@RequestMapping(value = "/startexam", method = RequestMethod.GET)
	public ModelAndView viewQuestionPage(@RequestParam("examId") Long id) {
		ModelAndView modelAndView = new  ModelAndView();
		ExamDTO examDTO = examService.getExam(id);
		modelAndView.addObject("examid", examDTO);
		List<QuestionDTO> list1 = examDTO.getQuestion();	
		modelAndView.addObject("questionList", list1);
		for (QuestionDTO question : list1) {
			QuestionDTO ques = questionService.getQuestionDTO(question.getQuesid());
			List<OptionDTO> optionList = ques.getAnswer();		
			modelAndView.addObject("answerList", optionList);
		}
        modelAndView.setViewName("user_exam");
		return modelAndView;
	}
	  //------------------submit the result of the

	  
	  @RequestMapping(value = "/submit", method = RequestMethod.POST) public
	  ModelAndView submitExam(HttpServletRequest request, Principal principal,
	  
	  @RequestParam("questionId") Long[] questionId) { 
		  List<Long> listId = new ArrayList<>(); 
		  ModelAndView modelAndView = new ModelAndView();
		  String examname = request.getParameter("examId");
		  String examid =request.getParameter("Id");
		  long eid = Long.parseLong(examid);
		  String marks = request.getParameter("marks");
		  long maxmarks = Long.parseLong(marks); Long
	      score = (long) 0;
         UserExamDetailDTO userExamDetailDTO = new UserExamDetailDTO();
         UserDTO user =userService.findByUserId(principal.getName());
         String Id = user.getUserId();
	  for (int i = 0; i < questionId.length; i++) { 
		  userExamDetailDTO. setQuestionId(questionId[i]); 
		  Long answerIdCorrect = questionService.findAnswerIdCorrect((questionId[i]));
	  userExamDetailDTO.setUserId(Id); 
	  String name = "answer_" + questionId[i];
	  
	  long id = Long.parseLong(request.getParameter(name));
	  
	  if (id == 0) { userExamDetailDTO.setAttempted("NOT ATTEMPTED"); } else {
	  userExamDetailDTO.setAttempted("ATTEMPTED"); } listId.add(id);
	  userExamDetailDTO.setAnswerId(id);
	  userExamDetailDTO.setExamId(Long.parseLong(examid));
	  userExamDetailService.addExamDetail(userExamDetailDTO);
	  
	  if (answerIdCorrect == id) { score++; request.setAttribute("score", score); }
	  
	  }
	  
	  ResultDTO result = new ResultDTO(); 
	  result.setScore(score++);
	  result.setExamname(examname); 
	  result.setMaxMarks(maxmarks);
	  result.setExamid(eid);
	  result.setUserName(user.getUserName());
	  resultService.addResult(result); 
	  List<ResultDTO> resultDTO = resultService.getResult();
	  for (ResultDTO resultDTO2 : resultDTO) {
		modelAndView.addObject("idlist", resultDTO2.getRid());
	}
	  modelAndView.setViewName("result"); 
	  return modelAndView; 
	  }
	  @RequestMapping(value = "/download-result/{id}", method = RequestMethod.GET)
		public void exportToPDFResultByUser(HttpServletResponse response, HttpServletRequest request, @PathVariable Long id)
				throws DocumentException, IOException {
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=results_" + currentDateTime + ".pdf";
			response.setHeader(headerKey, headerValue);
			ResultDTO result = resultService.getResult(id);
			if (result.getRid() == id) {
				UserPDFExporter exporter = new UserPDFExporter(result);
				exporter.export(response);
			}

		}
	 
}
