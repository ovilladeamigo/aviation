package com.ovm.uy.aviation.service.clients;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ovm.uy.aviation.model.clients.ClientLigthDto;

@Stateless
@Local
public class ClientBean {
	@Inject
	private EntityManager em;

	public List<ClientLigthDto> findAll() {
		return em.createNamedQuery("selectClientLigthNotRemoved").getResultList();
	}
}
