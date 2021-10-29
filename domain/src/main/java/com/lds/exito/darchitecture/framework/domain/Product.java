package com.lds.exito.darchitecture.framework.domain;

import java.util.Set;

public class Product {

	private Long id;

	private ProductFlow flow;

	private Set<ProductRule> rules;

	private String productCode;

	private String productName;

	private String productType;

	private String pluVariety;

	private Boolean enable;

	public Product() {
	}

	public Product(Set<ProductRule> rules, ProductFlow flow, String productCode, String productName, String productType,
			String pluVariety, Boolean enable) {
		this.rules = rules;
		this.flow = flow;
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.pluVariety = pluVariety;
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPluVariety() {
		return pluVariety;
	}

	public void setPluVariety(String pluVariety) {
		this.pluVariety = pluVariety;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public ProductFlow getFlow() {
		return flow;
	}

	public void setFlow(ProductFlow flow) {
		this.flow = flow;
	}

	public Set<ProductRule> getRules() {
		return rules;
	}

	public void setRules(Set<ProductRule> rules) {
		this.rules = rules;
	}

}
