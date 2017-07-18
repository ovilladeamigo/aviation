package com.ovm.uy.aviation.controller.administration.clients;

import static com.github.adminfaces.template.util.Assert.has;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.ovm.uy.aviation.model.clients.Client;
import com.ovm.uy.aviation.service.clients.ClientBean;

@Named
@ViewScoped
public class ClientForm implements Serializable {
	private static final long serialVersionUID = 5252481557506002442L;
	@EJB
	private ClientBean clientBean;

	private Client clientSelect;

	private Long id;

	public void onInit() {
		if (Faces.isAjaxRequest()) {
			return;
		}
		if (has(id)) {
			clientSelect = clientBean.get(id);
		} else {
			clientSelect = new Client();
		}
	}

	public void onSave() {
		String msg;
		if (clientSelect.getId() == null) {
			clientBean.save(clientSelect);
			msg = "Cliente " + clientSelect.getCode() + " creado con exito";
		} else {
			clientBean.save(clientSelect);
			msg = "Cliente " + clientSelect.getCode() + " editado con exito";
		}
		addDetailMessage(msg);
	}

	public void onClear() {
		clientSelect = new Client();
		id = null;
	}

	public void onRemove() {

	}

	public static void addDetailMessage(String message) {
		addDetailMessage(message, null);
	}

	public static void addDetailMessage(String message, FacesMessage.Severity severity) {

		FacesMessage facesMessage = Messages.create("").detail(message).get();
		if (severity != null && severity != FacesMessage.SEVERITY_INFO) {
			facesMessage.setSeverity(severity);
		} else {
			Messages.add(null, facesMessage);
		}
	}

	/*
	 * Getters and Setters
	 */

	public Client getClientSelect() {
		return clientSelect;
	}

	public void setClientSelect(Client clientSelect) {
		this.clientSelect = clientSelect;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNew() {
		return clientSelect == null || clientSelect.getId() == null;
	}

}
