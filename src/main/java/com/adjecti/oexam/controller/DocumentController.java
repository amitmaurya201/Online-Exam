package com.adjecti.oexam.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.modal.QuestionDTO;
import com.adjecti.oexam.modal.ResultDTO;
import com.adjecti.oexam.service.QuestionService;
import com.adjecti.oexam.service.ResultService;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/admin")
public class DocumentController {

	@Autowired
	private ResultService resultService;

	@Autowired
	private QuestionService questionService;

	// -----------------to download user exam result in pdf format----------------------
	@RequestMapping(value = "/download-result", method = RequestMethod.GET)
	public void exportToPDFResults(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=results_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		List<ResultDTO> listResults = resultService.getResult();
		AdminPDFExporter exporter = new AdminPDFExporter(listResults);
		exporter.export(response);
	}

	// ----------------to upload question in excel format----------------------
	@RequestMapping(value = "/upload-questions", method = RequestMethod.GET)
	public void exportToExcelQuestions(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=question_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		List<QuestionDTO> questionList = questionService.getQuestionDTO();
		AdminExcelExporter excelExporter = new AdminExcelExporter(questionList);
		excelExporter.export(response);
	}

	
	@RequestMapping(value = "/upload-excel", method = RequestMethod.POST)
	public ModelAndView importExcelFileQuestions(@RequestParam("file") MultipartFile files)
			throws IOException, InvalidFormatException {
		ModelAndView modelAndView = new ModelAndView();
		String fileName = files.getOriginalFilename();
		File convfile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		files.transferTo(convfile);
		XSSFWorkbook workbook = new XSSFWorkbook(convfile);
		int num = workbook.getNumberOfSheets();
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rows = sheet.getLastRowNum();
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		for (int r = 1; r <= rows; r++) {
			QuestionDTO question = new QuestionDTO();
			CategoryDTO category = new CategoryDTO();
			XSSFRow row = sheet.getRow(r);
			String quest = row.getCell(0).getStringCellValue();
			long categorycid = (long) row.getCell(1).getNumericCellValue();
			category.setCid(categorycid);
			question.setQuestion(quest);
			questionList.add(question);
			question.setCategory(category);
		}
		convfile.delete();
		questionService.saveQuestionList(questionList);
		modelAndView.setViewName("adminpage");
		return modelAndView;

	}
}
