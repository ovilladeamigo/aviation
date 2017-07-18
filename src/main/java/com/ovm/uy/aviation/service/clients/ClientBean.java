package com.ovm.uy.aviation.service.clients;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.ovm.uy.aviation.model.clients.Client;
import com.ovm.uy.aviation.model.clients.ClientLigthDto;
import com.ovm.uy.aviation.model.clients.Client_;
import com.ovm.uy.aviation.util.pagination.PaginatorFilter;
import com.ovm.uy.aviation.util.pagination.PaginatorReturn;

@Stateless
@Local
public class ClientBean {
	@Inject
	private EntityManager em;

	public void save(Client oClient) {
		if (oClient.getId() != null) {
			em.merge(oClient);
		} else {
			em.persist(oClient);
		}
	}

	public void removed(Long nClientId) {
		Client oClient = em.find(Client.class, nClientId);

		oClient.setRemoved(true);

		em.flush();
	}

	public Client get(Long nClientId) {
		Client oClient = em.find(Client.class, nClientId);

		return oClient;
	}

	public List<ClientLigthDto> findAll( ) {
		PaginatorReturn<ClientLigthDto> oReturn = null;
		// return
		return em.createNamedQuery("selectClientLigthNotRemoved", ClientLigthDto.class).getResultList();
		// CriteriaBuilder builder = em.getCriteriaBuilder();

		// CriteriaQuery<Tuple> cq = builder.createTupleQuery();
		// Root<Client> root = cq.from(Client.class);
		// Client_.addres.get;
		//
		//// cq.multiselect(oFilter.get);
		//// em.createQuery(cq).getr
		//
		// em.createQuery(cq,"")
		//
		// CriteriaBuilder cb = em.getCriteriaBuilder();
		// CriteriaQuery<ClientLigthDto> query =
		// cb.createQuery(ClientLigthDto.class);
		// Root<Client> teacher = query.from(Client.class);
		//
		// List
		// List<Selection<X>>

		// query.multiselect(teacher.get("firstName"), teacher.get("lastName"));
		//
		// List<ClientLigthDto> results = em.createQuery(query).getResultList();
		//
		// for (ClientLigthDto info : results) {
		// System.out.println("First name = " + info.getCode() + " " + "Last
		// Name = " + info.getName());
		// }
		//
		// return oReturn;
	}
}
