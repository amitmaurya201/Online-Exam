package com.adjecti.oexam.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.adjecti.oexam.modal.ResultDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class AdminPDFExporter {

	private List<ResultDTO> listResults;

	public AdminPDFExporter(List<ResultDTO> listResults2) {
		this.listResults = listResults2;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Result ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Attempted by", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Exam Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Max Marks", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Score", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (ResultDTO result : listResults) {
			table.addCell(String.valueOf(result.getRid()));
			table.addCell(result.getUserName());
			table.addCell(result.getExamname());
			table.addCell(String.valueOf(result.getMaxMarks()));
			table.addCell(String.valueOf(result.getScore()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Results", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
