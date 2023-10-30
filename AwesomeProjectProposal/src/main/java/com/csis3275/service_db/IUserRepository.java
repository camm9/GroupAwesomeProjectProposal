package com.csis3275.service_db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.csis3275.model_db.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>{

}
