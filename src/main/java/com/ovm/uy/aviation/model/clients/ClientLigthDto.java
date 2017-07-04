package com.ovm.uy.aviation.model.clients;

import java.io.Serializable;

public class ClientLigthDto implements Serializable {
	private static final long serialVersionUID = -1723149319733537715L;
	private Long id;
	private String code;
	private String name;
	private String telephone1;

	public ClientLigthDto() {

	}

	public ClientLigthDto(Long id, String code, String name, String telephone1) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.telephone1 = telephone1;
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

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
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
		ClientLigthDto other = (ClientLigthDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
