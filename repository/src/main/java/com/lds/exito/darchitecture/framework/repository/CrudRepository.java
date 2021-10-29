package com.lds.exito.darchitecture.framework.repository;

interface CrudRepository<T> {

	T findById(Integer id);
	
	T save(T domain);

}
