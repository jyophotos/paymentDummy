package com.dummy.paymentdummy.dao.hibo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dummy.paymentdummy.dao.hibo.UserDetailsDAO;
import com.dummy.paymentdummy.entity.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	EntityManager entityManger;
	
	@Autowired
	public UserDetailsDAOImpl(EntityManager thisEntityManager) {
		this.entityManger = thisEntityManager;
	}
	
	@Override
	public List<UserDetails> getAllUsers() {
		Session currentSession = entityManger.unwrap(Session.class);
		List<UserDetails> userDetails = currentSession.createQuery("from UserDetails", UserDetails.class).getResultList();
		return userDetails;
	}

	@Override
	public void addUser(UserDetails userDetails) {
		Session currentSession = entityManger.unwrap(Session.class);
		currentSession.save(userDetails);
	}

	@Override
	public List<UserDetails> getUser(String key, String value) {
		Session currentSession = entityManger.unwrap(Session.class);
		Query<UserDetails> theQuery = currentSession.createQuery("from UserDetails where "+key +"= :values");
		theQuery.setParameter("values", value);
		List<UserDetails> userDetails = theQuery.getResultList();
		return userDetails;
	}

	@Override
	public void updateUser(UserDetails userDetails) {
		Session currentSession = entityManger.unwrap(Session.class);
		currentSession.saveOrUpdate(userDetails);
	}

}
