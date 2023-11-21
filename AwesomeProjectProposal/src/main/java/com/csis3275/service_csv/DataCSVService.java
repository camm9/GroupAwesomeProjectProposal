package com.csis3275.service_csv;
import java.util.List;

import com.csis3275.model_db.UserDataset;

public interface DataCSVService {
	  void addUserDataset(UserDataset UserDataset);
	  List < UserDataset > getUserDataList();
}
