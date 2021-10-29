package com.lds.exito.darchitecture.framework.domain;

public class ProductOperations {

	private Long id;

	private Boolean enableCashout;

	private Boolean enableCashin;

	private Boolean enablePayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEnableCashout() {
		return enableCashout;
	}

	public void setEnableCashout(Boolean enableCashout) {
		this.enableCashout = enableCashout;
	}

	public Boolean getEnableCashin() {
		return enableCashin;
	}

	public void setEnableCashin(Boolean enableCashin) {
		this.enableCashin = enableCashin;
	}

	public Boolean getEnablePayment() {
		return enablePayment;
	}

	public void setEnablePayment(Boolean enablePayment) {
		this.enablePayment = enablePayment;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ProductOperations))
			return false;
		ProductOperations pO = (ProductOperations) obj;
		return this.id.equals(pO.getId());
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

}
