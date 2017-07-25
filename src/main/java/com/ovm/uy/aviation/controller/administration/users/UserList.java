package com.ovm.uy.aviation.controller.administration.users;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.ovm.uy.aviation.model.users.User;
import com.ovm.uy.aviation.service.users.UserBean;

@Named
@ViewScoped
public class UserList implements Serializable {
	private static final long serialVersionUID = 5252481557506002442L;
	@EJB
	private UserBean userBean;

	List<User> values;
	List<User> selectedValues;  
	List<User> filteredValues;

	@PostConstruct
	private void init() {
		values = userBean.findAll();
	}

	public List<User> getValues() {
		return values;
	}

	public void setValues(List<User> values) {
		this.values = values;
	}

	public List<User> getSelectedValues() {
		return selectedValues;
	}

	public void setSelectedValues(List<User> selectedValues) {
		this.selectedValues = selectedValues;
	}

	public List<User> getFilteredValues() {
		return filteredValues;
	}

	public void setFilteredValues(List<User> filteredValues) {
		this.filteredValues = filteredValues;
	}

}
