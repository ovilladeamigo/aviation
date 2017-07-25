package com.ovm.uy.aviation.service.users;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ovm.uy.aviation.model.users.User;

@Stateless
@Local
public class UserBean {
	@Inject
	private EntityManager em;

	public void save(User oUser) {
		em.persist(oUser);
	}

	public User get(String sEmail) {
		return em.find(User.class, sEmail);

	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createNamedQuery(User.ALL_NOT_REMOVED).getResultList();
	}
}
