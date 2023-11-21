package com.csis3275.service_db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import jakarta.persistence.Entity;

import com.csis3275.model_db.UserDataset;

@Service
public class UserDatasetService implements IUserDatasetRepository{
	
	@Autowired
	private IUserDatasetRepository userDatasetRepo;

	
	
	//Find user by ID
		public UserDataset findUserDataset(Long userDatasetId) {
			Optional<UserDataset> userDataset = userDatasetRepo.findById(userDatasetId);
			UserDataset foundUserDataset;
			
			if(userDataset != null) {
				foundUserDataset = (UserDataset) userDataset.get();
				return foundUserDataset;
			}
			else {
				return foundUserDataset = new UserDataset();
			}		
		}
		
		
		//Find datasetSaved by Token
		public ArrayList<UserDataset> findDataSetbyToken(Long token) {
			return (ArrayList<UserDataset>) userDatasetRepo.findBytoken(token);
		}
		
			
			//Create user
			public UserDataset saveUserDataset(UserDataset newUserDataset) {
			
				return userDatasetRepo.save(newUserDataset);
			}
			
			//Read user
			public ArrayList<UserDataset> readUserDataset()	{
				return (ArrayList<UserDataset>)userDatasetRepo.findAll();
			}
			
			
			//Update user
			public void updateStudent(UserDataset selectedUserDataset) {
				userDatasetRepo.save(selectedUserDataset);
			}
			
			//Delete user
			public void deleteUser(Long idToDelete)	{
				userDatasetRepo.deleteById(idToDelete);
			}

			@Override
			public <S extends UserDataset> S save(S entity) {
				// TODO Auto-generated method stub
				return null;
			}

			

			@Override
			public Optional<UserDataset> findById(Long id) {
				// TODO Auto-generated method stub
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long id) {
				// TODO Auto-generated method stub
				return false;
			}

			

			@Override
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void deleteById(Long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(UserDataset entity) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAllById(Iterable<? extends Long> ids) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAll(Iterable<? extends UserDataset> entities) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public <S extends UserDataset> Iterable<S> saveAll(Iterable<S> entities) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterable<UserDataset> findAll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterable<UserDataset> findAllById(Iterable<Long> ids) {
				// TODO Auto-generated method stub
				return null;
			}





			@Override
			public List<UserDataset> findBytoken(Long token) {
				// TODO Auto-generated method stub
				return null;
			}


			

}
