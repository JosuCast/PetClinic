package com.tecsup.petclinic.services;





import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

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
	public void testUpdateOwner() {

		String OWNER_FIRST = "Josue";
		String OWNER_LAST = "Castillo";
		long create_id=5;

		String UP_OWNER_NAME = "Pedro";
		String UP_OWNER_LAST = "Salas";

		Owner owner = new Owner(OWNER_FIRST, OWNER_LAST, null, null,null);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);

		create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirst_name(UP_OWNER_NAME);
		ownerCreated.setLast_name(UP_OWNER_LAST);


		// Execute update
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);
		
		
		assertThat(create_id ,notNullValue());
		assertThat(upgradeOwner.getId(), is(create_id));
		assertThat(upgradeOwner.getFirst_name(), is(UP_OWNER_NAME));
		assertThat(upgradeOwner.getLast_name(), is(UP_OWNER_LAST));


	}
	
}
