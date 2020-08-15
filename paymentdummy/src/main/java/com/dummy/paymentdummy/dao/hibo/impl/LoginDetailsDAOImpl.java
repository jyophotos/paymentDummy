package com.dummy.paymentdummy.dao.hibo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dummy.paymentdummy.dao.hibo.LoginDetailsDAO;
import com.dummy.paymentdummy.entity.LoginDetails;

@Repository
public class LoginDetailsDAOImpl implements LoginDetailsDAO {

	EntityManager entityManager;
	
	@Autowired
	public LoginDetailsDAOImpl(EntityManager theEntityManger) {
		this.entityManager=theEntityManger;
	}
	
	@Override
	@Transactional
	public List<LoginDetails> getAllDetails() {
		Session session = entityManager.unwrap(Session.class);
		//Query<LoginDetails> theQuery = session.createQuery("from LOGIN_DETAILS", LoginDetails.class);
		//List<LoginDetails> loginDetails = theQuery.getResultList();
		List<LoginDetails> loginDetails = session.createQuery("from LoginDetails", LoginDetails.class).getResultList();
		return loginDetails;
	}

}
