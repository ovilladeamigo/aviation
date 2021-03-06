package com.ovm.uy.aviation.model.clients;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(indexes = { @Index(name = "code", columnList = "code", unique = false) })

@SqlResultSetMapping(name = "ClientLigthDtoMapping", classes = {
		@ConstructorResult(targetClass = com.ovm.uy.aviation.model.clients.ClientLigthDto.class, columns = {
				@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "code"),
				@ColumnResult(name = "name"), @ColumnResult(name = "telephone1") }) })

@NamedNativeQueries({
		@NamedNativeQuery(name = "selectClientLigthNotRemoved", query = "SELECT C.id, C.code, C.name, C.telephone1 FROM Client C "
				+ "WHERE C.removed <> true", resultSetMapping = "ClientLigthDtoMapping") })
public class Client implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String code;
	@NotEmpty
	private String name;
	private String rut;
	private String telephone1;
	private String telephone2;
	private String celphone1;
	private String celphone2;
	private String email1;
	private String email2;
	private String addres;
	private boolean removed;
	@Version
	private Long version;

	public Client() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getCelphone1() {
		return celphone1;
	}

	public void setCelphone1(String celphone1) {
		this.celphone1 = celphone1;
	}

	public String getCelphone2() {
		return celphone2;
	}

	public void setCelphone2(String celphone2) {
		this.celphone2 = celphone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
