package com.csis3275.service_csv;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csis3275.model_db.User;
import com.csis3275.model_db.UserDataset;
import com.csis3275.service_db.UserDatasetService;


@Service
public class DataCSVServiceImpl implements DataCSVService {

	@Autowired
	DataRepoCSV DataRepo;

	@Override
	public void addUserDataset(UserDataset UserDataset) {
		DataRepo.save(UserDataset);
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDataset> getUserDataList() {
		// TODO Auto-generated method stub
		//List<UserDataset> NewDataset = 	UserDatasetService.readUserDataset();
		PopulateDataSet();
		//Return Deummy value	
		return DataRepo.findAll();
	}
	
	public void PopulateDataSet() {
	    for (int i = 0; i <= 10; i++) {
	    	UserDataset UserData = new UserDataset();
	    	UserData.setUser(new User ("NewUserToken" + i));
	    	UserData.setMatchId(""+i);
	    	UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	    	addUserDataset(UserData);
	      }
	}
}
