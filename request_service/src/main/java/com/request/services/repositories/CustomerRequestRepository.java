package com.request.services.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.request.services.entities.CustomerRequest;

public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Integer> {

	List<CustomerRequest> findByStatus(String status);
	
	List<CustomerRequest> findByTitleLike(String status);
	//.findByTitleLike("%in%");
	//findByAppleNameNotLike("%a%");

	//Optional<CustomerRequest> findByStatus(String status);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE customer_request SET comments = :comments , status = :status WHERE id = :id",nativeQuery = true)
	String updateCommentsByPendingStatus(String comments, String status, Integer id);
	
	@Query("UPDATE CustomerRequest SET comments = :comments , status = :status WHERE id = :id")
	Integer updateCommentsByClosedStatus(String comments, String status, Integer id);

}