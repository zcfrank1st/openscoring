/*
 * Copyright (c) 2019 Villu Ruusmann
 *
 * This file is part of Openscoring
 *
 * Openscoring is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Openscoring is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Openscoring.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openscoring.service.providers;

import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.ParamConverter;

import org.openscoring.service.ModelRef;

abstract
public class ModelRefConverter implements ParamConverter<ModelRef> {

	abstract
	public SecurityContext getSecurityContext();

	@Override
	public ModelRef fromString(String id){
		SecurityContext securityContext = getSecurityContext();

		ModelRef modelRef = new ModelRef()
			.setOwner(securityContext.getUserPrincipal())
			.setId(id);

		return modelRef;
	}

	@Override
	public String toString(ModelRef modelRef){
		return modelRef.getId();
	}
}