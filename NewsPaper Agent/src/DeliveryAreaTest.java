import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeliveryAreaTest {

	Database db = new Database();

	@Test

	/*
	 * Test Number 1 
	 * Test Objective: Test valid address in create Delivery Area
	 * Input:"er",-1,-1, 
	 * Expected Output = false
	 */
	void testValidcreateDeliveryArea01() {
		DeliveryArea test = new DeliveryArea();
		// db.initDBConnection();
		assertEquals(false, test.createDeliveryArea("er", -1, -1, db));

	}

	@Test

	/*
	 * Test Number 2 
	 * Test Objective: Test valid address in create Delivery Area
	 * Input:"er",-1,-1,
	 *  Expected Output = false
	 */
	void testValidcreateDeliveryArea02() {
		DeliveryArea test = new DeliveryArea();
		// db.initDBConnection();
		assertEquals(false, test.createDeliveryArea("", -1, -1, db));

	}

	@Test

	/*
	 * Test Number 3 Test Objective: Test valid address in create Delivery Area
	 * Input:"theskyiscryingandiamnotfellinggood",-1,-1 Expected Output = false
	 */
	void testValidcreateDeliveryArea03() {
		DeliveryArea test = new DeliveryArea();
		assertEquals(false, test.createDeliveryArea("theskyiscryingandiamnotfellinggood", -1, -1, db));

	}

	@Test

	/*
	 * Test Number 4 Test Objective: Test valid Driver ID in create Delivery Area
	 * Input:"Athlone",-1,-1 Expected Output = false
	 */
	void testValidcreateDeliveryArea04() {
		DeliveryArea test = new DeliveryArea();
		assertEquals(false, test.createDeliveryArea("Athlone", -1, 1, db));

	}

	@Test

	/*
	 * Test Number 5 Test Objective: Test valid Driver ID in create Delivery Area
	 * Input:"Athlone",1,1 Expected Output = true
	 */
	void testValidcreateDeliveryArea05() {
		DeliveryArea test = new DeliveryArea();
		assertEquals(true, test.createDeliveryArea("Athlone", 1, 1, db));

	}

	@Test

	/*
	 * Test Number 6 Test Objective: Test valid Driver ID in create Delivery Area
	 * Input:"Athlone",1001,1 Expected Output = false
	 */
	void testValidcreateDeliveryArea06() {
		DeliveryArea test = new DeliveryArea();
		// db.initDBConnection();
		assertEquals(false, test.createDeliveryArea("Athlone", 1001, -1, db));

	}

	@Test

	/*
	 * Test Number 7 Test Objective: Test valid Driver ID in create Delivery Area
	 * Input:"Athlone",1,1 Expected Output = true
	 */
	void testValidcreateDeliveryArea07() {
		DeliveryArea test = new DeliveryArea();

		assertEquals(true, test.createDeliveryArea("Athlone", 1, 1, db));

	}
	@Test
	/*
	 * Test Number 8 Test Objective: Test valid Customer ID in create Delivery Area
	 * Input:"Athlone",1,-1 Expected Output = false
	 */
	void testValidcreateDeliveryArea08() {
		DeliveryArea test = new DeliveryArea();

		assertEquals(false, test.createDeliveryArea("Athlone", 1, -1, db));
		// Invalid Customer ID", e.getMessage();

	}
	@Test
	/*
	 * Test Number 9 Test Objective: Test valid Customer ID in create Delivery Area
	 * Input:"Athlone",1,1001 Expected Output = false
	 */
	void testValidcreateDeliveryArea09() {
		DeliveryArea test = new DeliveryArea();
		// db.initDBConnection();
		assertEquals(false, test.createDeliveryArea("Daniel", 16, 1001, db));

	}

	// /*
	// * Test Number 10
	// * Test Objective: Test valid Customer ID in create Delivery Area
	// * Input:"Athlone",1,1
	// * Expected Output = true
	// */
	// void testValidcreateDeliveryArea10() {
	// DeliveryArea test = new DeliveryArea();
	// //db.initDBConnection();
	// assertEquals(true, test.createDeliveryArea("Athlone",1,1,db));
	//
	// }
	/*
	 * Test Number 10 Test Objective: Test valid Delivery area ID in print Delivery
	 * summary Input:-1 Expected Output = false
	 */

	@Test
	void testDailySummary01() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals("Invalid Delivery Id", dTest.printSummary(-1, db));
	}
	/*
	 * Test Number 11 Test Objective: Test valid Delivery area ID in print Delivery
	 * summary Input:1 Expected Output = db.printDailySummary(1)
	 */

	@Test
	void testDailySummary02() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals(db.printDailySummary(1), dTest.printSummary(1, db));
	}
	/*
	 * Test Number 12
	 *  Test Objective: Test valid Delivery area ID in print Delivery
	 * summary Input:1001
	 * Expected Output = "Invalid Delivery Id"
	 */

	@Test
	void testDailySummary03() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals("Invalid Delivery Id", dTest.printSummary(1001, db));
	}
	

	/*
	 * Test Number 13 
	 * Test Objective: Test valid Delivery area ID in get Delivery
	 * Area Input:1
	 *  Expected Output = db.getDeliveryArea(1)
	 */

	@Test
	void testgetDeliveryArea01() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals(db.getDeliveryArea(1), dTest.getDeliveryArea(1, db));
	}

	/*
	 * Test Number 14 
	 * Test Objective: Test valid Delivery area ID in get Delivery
	 * Area Input:-1
	 *  Expected Output = "Invalid Delivery Id"
	 */

	@Test
	void testgetDeliveryArea02() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals("Invalid Delivery Id", dTest.getDeliveryArea(-1, db));
	}

	/*
	 * Test Number 15 
	 * Test Objective: Test valid Delivery area ID in get Delivery
	 * Area Input:1001 
	 * Expected Output = "Invalid Delivery Id"
	 */

	@Test
	void testgetDeliveryArea03() {
		db.initDBConnection();
		DeliveryArea dTest = new DeliveryArea();
		assertEquals("Invalid Delivery Id", dTest.getDeliveryArea(1001, db));
	}

}
