package com.tecsup.petclinic.services;





import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;


@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	
	
	
	@Test
	public void testCreateOwner() {

		String OWNER_FIRST_NAME = "Josue";
		String OWNER_LAST_NAME = "Castillo";


		Owner owner = new Owner(OWNER_FIRST_NAME, OWNER_LAST_NAME, null,null, null);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		
		


	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdatePet() {

		String OWNER_FIRST = "Josue";
		String OWNER_LAST = "Castillo";
		long create_id=5;

		String UP_OWNER_NAME = "Pedro";
		String UP_OWNER_LAST = "Salas";

		Owner pet = new Owner(OWNER_FIRST, OWNER_LAST, null, null,null);

		// Create record
		logger.info(">" + pet);
		Owner ownerCreated = ownerService.create(pet);
		logger.info(">>" + ownerCreated);

		create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirst_name(UP_OWNER_NAME);
		ownerCreated.setLast_name(UP_OWNER_LAST);


		// Execute update
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);
		
		

	}
	
}
