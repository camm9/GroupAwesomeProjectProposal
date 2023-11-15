package com.csis3275.service_db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.csis3275.model_db.User;

@Service
public class UserService implements IUserRepository {
	
	@Autowired 
	private IUserRepository userRepo;
		//Find user by ID
	public User findUser(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		User foundUser;
		
		if(user != null) {
			foundUser = (User) user.get();
			return foundUser;
		}
		else {
			return foundUser = new User();
		}		
	}
		
		//Create user
		public User saveUser(User newUser) {
			return userRepo.save(newUser);
		}
		
		//Read user
		public ArrayList<User> readUsers()	{
			return (ArrayList<User>)userRepo.findAll();
		}
		
		
		//Update user
		public void updateStudent(User selectedUser) {
			userRepo.save(selectedUser);
		}
		
		//Delete user
		public void deleteUser(Long idToDelete)	{
			userRepo.deleteById(idToDelete);
		}

		@Override
		public <S extends User> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		
		@Override
		public Optional<User> findById(Long id) {
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
		public void delete(User entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends User> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<User> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<User> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		
}
