package com.lds.exito.darchitecture.framework.service;

import java.util.Optional;

import com.lds.exito.darchitecture.framework.domain.ComponentProperty;

public interface ComponentPropertyService {

	Optional<ComponentProperty> getPropertyByPropertyName(String propertyName);

}
