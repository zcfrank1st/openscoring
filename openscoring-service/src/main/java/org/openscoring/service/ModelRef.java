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
package org.openscoring.service;

import java.security.Principal;
import java.util.Objects;

public class ModelRef {

	private Principal owner = null;

	private String id = null;


	public ModelRef(){
	}

	@Override
	public int hashCode(){
		int result = 1;

		result = (31 * result) + Objects.hashCode(getOwner());
		result = (31 * result) + Objects.hash(getId());

		return result;
	}

	@Override
	public boolean equals(Object object){

		if(object instanceof ModelRef){
			ModelRef that = (ModelRef)object;

			return Objects.equals(this.getOwner(), that.getOwner()) && Objects.equals(this.getId(), that.getId());
		}

		return false;
	}

	public Principal getOwner(){
		return this.owner;
	}

	public ModelRef setOwner(Principal owner){
		this.owner = owner;

		return this;
	}

	public String getId(){
		return this.id;
	}

	public ModelRef setId(String id){
		this.id = Objects.requireNonNull(id);

		return this;
	}

	static
	public boolean validateId(String id){
		return (id != null) && (id).matches(REGEX_ID);
	}

	public static final String PATH_VALUE_ID = "{id:" + ModelRef.REGEX_ID + "}";

	private static final String REGEX_ID = "[a-zA-Z0-9][a-zA-Z0-9\\_\\-]*";
}