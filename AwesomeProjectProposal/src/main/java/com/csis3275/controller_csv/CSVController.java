package com.csis3275.controller_csv;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.service_csv.CsvFileGenerator;
import com.csis3275.service_csv.DataCSVService;

@Controller
public class CSVController {

	@Autowired
	private DataCSVService DataService;

	@Autowired
	private CsvFileGenerator csvGenerator;

	@GetMapping("/member/export-to-csv")
	public String exportIntoCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"DataSet.csv\"");
		csvGenerator.writeDataSetToCsv(DataService.getUserDataList(), response.getWriter());
		return "member/index";
	}
}
