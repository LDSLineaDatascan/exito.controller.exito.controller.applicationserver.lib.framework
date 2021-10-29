package com.lds.exito.darchitecture.framework.domain;

public class ProductFlow {

	private Long id;

	private String flowIdentifier;

	private String flowConnector;

	private Product product;

	public ProductFlow(String flowIdentifier, String flowConnector, Product product) {
		this.flowIdentifier = flowIdentifier;
		this.flowConnector = flowConnector;
		this.product = product;
	}

	public ProductFlow() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlowIdentifier() {
		return flowIdentifier;
	}

	public void setFlowIdentifier(String flowIdentifier) {
		this.flowIdentifier = flowIdentifier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getFlowConnector() {
		return flowConnector;
	}

	public void setFlowConnector(String flowConnector) {
		this.flowConnector = flowConnector;
	}

}
