package com.lds.exito.darchitecture.framework.domain;

import java.util.List;

public class CommunicationProperty {

	private Integer idCommunicationProperty;

	private String propertyName;

	private String protocol;

	private String hostname;

	private int timeOut;

	private String method;

	private Integer port;

	private String uri;

	private boolean isActive;

	private int numberMaxRetry;

	private List<ComponentProperty> componentPropertyList;

	public Integer getIdCommunicationProperty() {
		return idCommunicationProperty;
	}

	public void setIdCommunicationProperty(Integer idCommunicationProperty) {
		this.idCommunicationProperty = idCommunicationProperty;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getNumberMaxRetry() {
		return numberMaxRetry;
	}

	public void setNumberMaxRetry(int numberMaxRetry) {
		this.numberMaxRetry = numberMaxRetry;
	}
	
	public List<ComponentProperty> getComponentPropertyList() {
		return componentPropertyList;
	}

	public void setComponentPropertyList(List<ComponentProperty> componentPropertyList) {
		this.componentPropertyList = componentPropertyList;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof CommunicationProperty))
			return false;
		CommunicationProperty cp = (CommunicationProperty) obj;
		return idCommunicationProperty != null && this.idCommunicationProperty == cp.getIdCommunicationProperty();
	}

	@Override
	public int hashCode() {
		return idCommunicationProperty.hashCode();
	}

}
