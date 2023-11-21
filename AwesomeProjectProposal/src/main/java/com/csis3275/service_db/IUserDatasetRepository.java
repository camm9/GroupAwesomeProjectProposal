package com.csis3275.service_db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csis3275.model_db.UserDataset;

@Repository
public interface IUserDatasetRepository extends CrudRepository<UserDataset, Long>{
	
	
	@Query(value = "from UserDataset t WHERE t.tokeni = :token")
	List<UserDataset> findBytoken(Long token);

}
