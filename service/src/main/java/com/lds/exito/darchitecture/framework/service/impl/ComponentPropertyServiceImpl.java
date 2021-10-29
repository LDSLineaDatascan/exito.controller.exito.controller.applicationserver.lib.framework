package com.lds.exito.darchitecture.framework.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lds.exito.darchitecture.framework.domain.ComponentProperty;
import com.lds.exito.darchitecture.framework.repository.ComponentPropertyRepository;
import com.lds.exito.darchitecture.framework.service.ComponentPropertyService;

@Service
public class ComponentPropertyServiceImpl implements ComponentPropertyService {

	private final ComponentPropertyRepository componentPropertyRepository;
	
	public ComponentPropertyServiceImpl(ComponentPropertyRepository componentPropertyRepository) {
		this.componentPropertyRepository = componentPropertyRepository;
	}
	
	@Override
	public Optional<ComponentProperty> getPropertyByPropertyName(String propertyName) {
		return componentPropertyRepository.getPropertyByPropertyName(propertyName);
	}

}
