package com.csis3275.controller_csv;

import java.io.IOException;

import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.service_csv.CsvFileGenerator;
import com.csis3275.service_csv.DataCSVService;
import com.csis3275.service_csv.DataCSVServiceImpl;
import com.csis3275.service_db.UserDatasetService;
@Controller
public class CSVController {

	@Autowired
	private DataCSVService DataCSVService;
	
	@Autowired
	private UserDatasetService UserDatasetService;

	@Autowired
	private CsvFileGenerator csvGenerator;

	@GetMapping("/member/export-to-csv")
	public String exportIntoCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"DataSet.csv\"");
		if (UserDatasetService.readUserDataset().size() > 0) {
			//Write User Data service from data read
			csvGenerator.writeDataSetToCsv(UserDatasetService.readUserDataset(), response.getWriter());
		}
		else {
			//No saved data found, creating dummy data for fake values
			csvGenerator.writeDemoMessage(response.getWriter());
			csvGenerator.writeDataSetToCsv(DataCSVService.getUserDataList(), response.getWriter());
		}
		return "member/index";
	}
}
