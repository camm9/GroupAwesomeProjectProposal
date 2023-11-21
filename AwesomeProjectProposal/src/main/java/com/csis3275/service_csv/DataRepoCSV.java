/**
 * 
 */
package com.csis3275.service_csv;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model_db.UserDataset;

/**
 * 
 */
public interface DataRepoCSV extends JpaRepository < UserDataset, Long > {

}
