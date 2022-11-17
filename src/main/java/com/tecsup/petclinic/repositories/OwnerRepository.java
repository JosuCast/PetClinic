package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	// Fetch pets by name
		List<Owner> findByFirstName(String name);

		// Fetch pets by typeId
		List<Owner> findByLastName(String last_name);

		// Fetch pets by ownerId
		List<Owner> findByTelephone(String telephone);

}
