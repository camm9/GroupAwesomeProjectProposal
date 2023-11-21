package com.csis3275.service_csv;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.csis3275.model_db.UserDataset;

@Component
public class CsvFileGenerator {
	public void writeDataSetToCsv(List<UserDataset> UserDatasets, Writer writer) {
		try {

			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
			for (UserDataset UserDataset : UserDatasets) {
				printer.printRecord(UserDataset.getUser(), UserDataset.getMatchId(), UserDataset.getDos());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}