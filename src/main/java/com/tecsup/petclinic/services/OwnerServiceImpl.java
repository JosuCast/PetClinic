package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

public class OwnerServiceImpl implements OwnerService{
	
	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
	
	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);
	}

	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	@Override
	public List<Owner> findByName(String name) {
		List<Owner> owners = ownerRepository.findByName(name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	@Override
	public List<Owner> findByTypeId(int typeId) {
		List<Owner> owners = ownerRepository.findByTypeId(typeId);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}

	@Override
	public List<Owner> findByOwnerId(int ownerId) {
		List<Owner> owners = ownerRepository.findByOwnerId(ownerId);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	@Override
	public Iterable<Owner> findAll() {
		// TODO Auto-generated 
				return ownerRepository.findAll();
	}

}
