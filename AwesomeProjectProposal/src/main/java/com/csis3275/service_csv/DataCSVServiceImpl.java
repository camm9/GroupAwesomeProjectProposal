package com.csis3275.service_csv;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csis3275.model_db.UserDataset;

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
		return DataRepo.findAll();
	}

}
