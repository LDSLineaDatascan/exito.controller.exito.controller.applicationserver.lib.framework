package com.lds.exito.darchitecture.framework.domain.helper;

import java.util.List;

import com.lds.exito.darchitecture.framework.domain.Component;
import com.lds.exito.darchitecture.framework.domain.ComponentProperty;

public class ComponentHelper extends Component implements Comparable<ComponentHelper> {

	private ComponentProperty componentProperty;

	public ComponentProperty getComponentProperty() {
		return componentProperty;
	}

	public void setComponentProperty(ComponentProperty componentProperty) {
		this.componentProperty = componentProperty;
	}

	public Component getComponent(List<ComponentProperty> propertyList) {
		super.getCommunicationProperty().setComponentPropertyList(propertyList);
		return new Component(super.getId(), super.getComponentName(), super.getAlias(),
				super.getCommunicationProperty());
	}

	@Override
	public int compareTo(ComponentHelper o) {
		return super.getId() - o.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ComponentHelper))
			return false;
		ComponentHelper cp = (ComponentHelper) obj;
		return super.getId().equals(cp.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}
