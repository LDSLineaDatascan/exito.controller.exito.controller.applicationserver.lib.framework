package com.lds.exito.darchitecture.framework.repository;

import java.util.Optional;

import com.lds.exito.darchitecture.framework.domain.ComponentProperty;

public interface ComponentPropertyRepository extends CrudRepository<ComponentProperty> {

	public Optional<ComponentProperty> getPropertyByPropertyName(String propertyName);

}
