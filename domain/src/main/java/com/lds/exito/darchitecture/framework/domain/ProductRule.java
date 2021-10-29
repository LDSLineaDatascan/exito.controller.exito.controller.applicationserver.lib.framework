package com.lds.exito.darchitecture.framework.domain;

public class ProductRule {

	private Long id;

	private Product product;

	private ParametersConfig operationType;

	private ParametersConfig validationType;

	private ParametersConfig ruleType;

	private String ruleValue;

	public ProductRule() {

	}

	public ProductRule(Product product, ParametersConfig operationType, ParametersConfig validationType,
			ParametersConfig ruleType, String ruleValue) {
		this.product = product;
		this.operationType = operationType;
		this.validationType = validationType;
		this.ruleType = ruleType;
		this.ruleValue = ruleValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ParametersConfig getOperationType() {
		return operationType;
	}

	public void setOperationType(ParametersConfig operationType) {
		this.operationType = operationType;
	}

	public ParametersConfig getValidationType() {
		return validationType;
	}

	public void setValidationType(ParametersConfig validationType) {
		this.validationType = validationType;
	}

	public ParametersConfig getRuleType() {
		return ruleType;
	}

	public void setRuleType(ParametersConfig ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

}
