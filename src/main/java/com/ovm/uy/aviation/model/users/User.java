package com.ovm.uy.aviation.model.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.jboss.security.auth.spi.Util;

@Entity
@Table(name = "com_user")
@NamedQueries({ @NamedQuery(name = User.ALL_NOT_REMOVED, query = "SELECT U FROM User U WHERE U.removed = false") })
public class User implements Serializable {
	private static final long serialVersionUID = -1123751732684125403L;
	public static final String ALL_NOT_REMOVED = "User.ALL_NOT_REMOVED";

	@Id
	@Column(length = 50)
	@Size(min = 5, max = 50)
	private String email;
	@Column(length = 50)
	@Size(min = 2, max = 50)
	private String name;
	@Column(length = 30, nullable = false)
	@Size(min = 5, max = 50)
	private String password;
	private boolean removed;
	private String layout;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "com_user_rol", joinColumns = @JoinColumn(name = "user_uuid"))
	@Enumerated(EnumType.STRING)
	private List<Rol> rols;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String passwordHash = Util.createPasswordHash("MD5", "base64", null, null, password);
		this.password = passwordHash;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
