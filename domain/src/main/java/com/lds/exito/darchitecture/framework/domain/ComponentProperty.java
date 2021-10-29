package com.lds.exito.darchitecture.framework.domain;

public class ComponentProperty {

	private Integer id;

	private String propertyName;

	private String propertyValue;

	private boolean isEncrypt;

	private boolean isActive;

	private boolean isAllowQuery;

	private boolean isAllowUpdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public boolean isEncrypt() {
		return isEncrypt;
	}

	public void setEncrypt(boolean isEncrypt) {
		this.isEncrypt = isEncrypt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAllowQuery() {
		return isAllowQuery;
	}

	public void setAllowQuery(boolean isAllowQuery) {
		this.isAllowQuery = isAllowQuery;
	}

	public boolean isAllowUpdate() {
		return isAllowUpdate;
	}

	public void setAllowUpdate(boolean isAllowUpdate) {
		this.isAllowUpdate = isAllowUpdate;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof ComponentProperty))
			return false;
		ComponentProperty cp = (ComponentProperty) obj;
		return this.id == cp.id;
	}

	public int hashCode() {
		return id.hashCode();
	}

}
