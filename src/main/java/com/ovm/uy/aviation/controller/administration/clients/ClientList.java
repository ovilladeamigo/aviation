package com.ovm.uy.aviation.controller.administration.clients;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ovm.uy.aviation.model.clients.ClientLigthDto;
import com.ovm.uy.aviation.service.clients.ClientBean;

@Named
@ViewScoped
public class ClientList implements Serializable {
	private static final long serialVersionUID = 5252481557506002442L;
	@EJB
	private ClientBean clientBean;

	List<ClientLigthDto> values;

	// Filter<ClientLigthDto> filter = new Filter<>(new ClientLigthDto());

	List<ClientLigthDto> selectedValues; // cars selected in checkbox column

	List<ClientLigthDto> filteredValues;

	@PostConstruct
	private void init() {
		values = clientBean.findAll();

	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	public List<ClientLigthDto> getValues() {
		return values;
	}

	public void setValues(List<ClientLigthDto> values) {
		this.values = values;
	}

	public List<ClientLigthDto> getSelectedValues() {
		return selectedValues;
	}

	public void setSelectedValues(List<ClientLigthDto> selectedValues) {
		this.selectedValues = selectedValues;
	}

	public List<ClientLigthDto> getFilteredValues() {
		return filteredValues;
	}

	public void setFilteredValues(List<ClientLigthDto> filteredValues) {
		this.filteredValues = filteredValues;
	}

}
