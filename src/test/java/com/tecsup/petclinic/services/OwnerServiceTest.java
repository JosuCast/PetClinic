package com.tecsup.petclinic.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnertNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(NAME, owner.getName());

	}
	
	@Test
	public void testCreatePet() {

		String PET_NAME = "Ponky";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Pet pet = new Pet(PET_NAME, 1, 1, null);
		
		Pet petCreated = petService.create(pet);
		
		logger.info("PET CREATED :" + petCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(petCreated.getId()      , notNullValue());
		assertThat(petCreated.getName()    , is(PET_NAME));
		assertThat(petCreated.getOwnerId() , is(OWNER_ID));
		assertThat(petCreated.getTypeId()  , is(TYPE_ID));

	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdatePet() {

		String PET_NAME = "Bear";
		int OWNER_ID = 1;
		int TYPE_ID = 1;
		long create_id = -1;

		String UP_PET_NAME = "Bear2";
		int UP_OWNER_ID = 2;
		int UP_TYPE_ID = 2;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID, null);

		// Create record
		logger.info(">" + pet);
		Pet petCreated = petService.create(pet);
		logger.info(">>" + petCreated);

		create_id = petCreated.getId();

		// Prepare data for update
		petCreated.setName(UP_PET_NAME);
		petCreated.setOwnerId(UP_OWNER_ID);
		petCreated.setTypeId(UP_TYPE_ID);

		// Execute update
		Pet upgradePet = petService.update(petCreated);
		logger.info(">>>>" + upgradePet);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradePet.getId(), is(create_id));
		assertThat(upgradePet.getName(), is(UP_PET_NAME));
		assertThat(upgradePet.getTypeId(), is(UP_OWNER_ID));
		assertThat(upgradePet.getOwnerId(), is(UP_TYPE_ID));
	}
	
}
