package com.lds.exito.darchitecture.framework.repository;

import java.util.Optional;
import java.util.Set;

import com.lds.exito.darchitecture.framework.domain.Product;

public interface ProductRepository extends CrudRepository<Product> {

	Set<Product> findAll();

	Optional<Product> findProductByProductCodeAndInternalIdentification(String productCode,
			String internalIdentification);

	Optional<Product> findProductByNameAndTypeAndVariety(String productName, String productCode, String variety);
	
	Optional<Product> findByProductCode(String productCode, String productType);

}
