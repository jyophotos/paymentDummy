package com.dummy.paymentdummy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dummy.paymentdummy.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	/*
	 * @Query("select u from UserDetails where :key = :value") public
	 * List<UserDetails> getUser(@Param("key") String key, @Param("value") String
	 * value);
	 */
	
	@Query("select u from UserDetails u where username = :username")
	public List<UserDetails> getUserByUsername( @Param("username") String value);
}
