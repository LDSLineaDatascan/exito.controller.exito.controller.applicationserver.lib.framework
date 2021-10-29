package com.lds.exito.darchitecture.framework.service;

import java.util.Optional;
import java.util.Set;

import com.lds.exito.darchitecture.framework.domain.Product;

public interface ProductService {

	public Optional<Product> save(Product domain);

	public Set<Product> saveList(Set<Product> productList);

}
