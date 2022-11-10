package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	// Fetch pets by name
	List<Owner> findByName(String name);

	// Fetch pets by typeId
	List<Owner> findByTypeId(int typeId);

	// Fetch pets by ownerId
	List<Owner> findByOwnerId(int ownerId);
}
