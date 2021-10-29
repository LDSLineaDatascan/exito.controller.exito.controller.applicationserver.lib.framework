package com.lds.exito.darchitecture.framework.repository;

import java.util.List;
import java.util.Optional;

import com.lds.exito.darchitecture.framework.domain.Component;

public interface ComponentRepository extends CrudRepository<Component> {

	public List<Component> findComponentByPropertiesName(String propertiesName);

	public Optional<Component> findComponentAndAuthorizerByName(String alias);

}
