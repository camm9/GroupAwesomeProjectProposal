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

	public void writeDemoMessage(Writer writer) {
		try {
			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
			printer.printRecord("No user data set found, creating dummy data");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDataSetToCsv(List<UserDataset> UserDatasets, Writer writer) {
		try {

			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
			printer.printRecord("UserID", "MatchID", "Date");
			for (UserDataset UserDataset : UserDatasets) {
				if (UserDataset.getUser()!= null) {
					//printer.printRecord(UserDataset.getUser(), UserDataset.getMatchId(), UserDataset.getDos());
					printer.printRecord( "UserOf" + UserDataset.getDos(), UserDataset.getMatchId(), UserDataset.getDos());
				}
				else {
					printer.printRecord( "UserOf" + UserDataset.getDos(), UserDataset.getMatchId(), UserDataset.getDos());
				}
			}
			printer.printRecord("End of File");
			printer.close();
		} catch (IOException e) {
			//Disabled Print Stack 
			e.printStackTrace();
		}
	}
}