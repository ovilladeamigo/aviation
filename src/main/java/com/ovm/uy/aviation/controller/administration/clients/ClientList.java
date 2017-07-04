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

	LazyDataModel<ClientLigthDto> values;

	// Filter<ClientLigthDto> filter = new Filter<>(new ClientLigthDto());

	List<ClientLigthDto> selectedValues; // cars selected in checkbox column

	List<ClientLigthDto> filteredValues;

	@PostConstruct
	private void init() {
		values = new LazyDataModel<ClientLigthDto>() {
			@Override
			public List<ClientLigthDto> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				return clientBean.findAll();
			}

			@Override
			public int getRowCount() {
				return super.getRowCount();
			}

		};
	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	public LazyDataModel<ClientLigthDto> getValues() {
		return values;
	}

	public void setValues(LazyDataModel<ClientLigthDto> values) {
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
