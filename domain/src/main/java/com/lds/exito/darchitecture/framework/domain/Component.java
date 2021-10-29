package com.lds.exito.darchitecture.framework.domain;

public class Component {

	private Integer id;

	private String componentName;

	private String alias;

	private CommunicationProperty communicationProperty;

	public Component() {

	}

	public Component(Integer id, String componentName, String alias) {
		this.id = id;
		this.componentName = componentName;
		this.alias = alias;
	}

	public Component(Integer id, String componentName, String alias, CommunicationProperty communicationProperty) {
		this.id = id;
		this.componentName = componentName;
		this.alias = alias;
		this.communicationProperty = communicationProperty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public CommunicationProperty getCommunicationProperty() {
		return communicationProperty;
	}

	public void setCommunicationProperty(CommunicationProperty communicationProperty) {
		this.communicationProperty = communicationProperty;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Component)
			return false;
		Component c = (Component) obj;
		return c != null && this.getAlias().equals(c.getAlias());
	}

	public int hashCode() {
		return id.hashCode();
	}

	public String toString() {
		return "Component[componentName=" + componentName + ",alias=" + alias + "]";
	}

}
