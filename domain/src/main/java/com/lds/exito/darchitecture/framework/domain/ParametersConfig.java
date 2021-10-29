package com.lds.exito.darchitecture.framework.domain;

public class ParametersConfig {

	private Long id;

	private String descripcionGroup;

	private String groupId;

	private String parameterName;

	private String parameterValue;

	private String descripcionParameter;

	public ParametersConfig() {

	}

	public ParametersConfig(String parameterName) {
		this.parameterName = parameterName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionGroup() {
		return descripcionGroup;
	}

	public void setDescripcionGroup(String descripcionGroup) {
		this.descripcionGroup = descripcionGroup;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getDescripcionParameter() {
		return descripcionParameter;
	}

	public void setDescripcionParameter(String descripcionParameter) {
		this.descripcionParameter = descripcionParameter;
	}

}
