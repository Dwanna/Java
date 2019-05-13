import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DocketTest {
	Database db = new Database();

	@Test

	/*
	 * Test Number 1 Test Objective: Test valid Driver ID Input:-1 Expected Output =
	 * false
	 */
	void testValidDriverID001() {
		Docket test = new Docket();
		db.initDBConnection();
		assertEquals(false, test.createDocket(-1, db));

	}

	@Test
	/*
	 * Test Number 2 Test Objective: Test valid Driver ID Input:1 Expected Output =
	 * true
	 */
	void testValidDriverID002() {
		Docket test = new Docket();
		// db.initDBConnection();
		assertEquals(true, test.createDocket(1, db));

	}

	@Test
	/*
	 * Test Number 3 Test Objective: Test valid Driver ID Input:1001 Expected Output
	 * = false
	 */
	void testValidDriverID003() {
		Docket test = new Docket();
		db.initDBConnection();
		assertEquals(false, test.createDocket(1001, db));

	}

	@Test
	/*
	 * Test Number 4 Test Objective: Test valid Driver ID Input:1000 Expected Output
	 * = true
	 */

	void testValidDriverID004() {
		Docket test = new Docket();
		// db.initDBConnection();
		assertEquals(true, test.createDocket(1000, db));

	}

	@Test
	/*
	 * Test Number 5 Test Objective: Test valid Driver ID Input:1 Expected Output =
	 * Docket ID
	 */

	void getDocketID001() {
		Docket test = new Docket();
		db.initDBConnection();
		String res = db.getDocket_id(1);
		assertEquals(res, test.getDocket(1, db));

	}

	@Test
	/*
	 * Test Number 6 Test Objective: Test valid Driver ID Input:1001 Expected Output
	 * = "Invalid DocketID"
	 */

	void getDocketID002() {
		db.initDBConnection();
		Docket test = new Docket();
		assertEquals("Invalid DocketID", test.getDocket(1001, db));

	}

	@Test
	/*
	 * Test Number 7 Test Objective: Test valid Driver ID Input:-1 Expected Output =
	 * "Invalid DocketID"
	 */

	void getDocketID003() {
		db.initDBConnection();
		Docket test = new Docket();
		assertEquals("Invalid DocketID", test.getDocket(-1, db));

	}

	@Test
	/*
	 * Test Number 8 Test Objective: Test valid Docket ID(add Order to Docket)
	 * Input:-1,1 Expected Output = false
	 */

	void addOrderToDocket01() {
		// db.initDBConnection();
		Docket test = new Docket();
		assertEquals(false, test.addOrderToDocket(-1, 1, db));

	}

	@Test
	/*
	 * Test Number 9 Test Objective: Test valid Docket ID(add Order to Docket)
	 * Input:1001,1 Expected Output = false
	 */

	void addOrderToDocket02() {
		// db.initDBConnection();
		Docket test = new Docket();
		assertEquals(false, test.addOrderToDocket(1001, 1, db));

	}

	@Test
	/*
	 * Test Number 10 Test Objective: Test valid Order ID(add Order to Docket)
	 * Input:1,-1 Expected Output = false
	 */

	void addOrderToDocket03() {
		// db.initDBConnection();
		Docket test = new Docket();
		assertEquals(false, test.addOrderToDocket(1, -1, db));

	}

	@Test
	/*
	 * Test Number 11 Test Objective: Test valid Order ID(add Order to Docket)
	 * Input:1,1001 Expected Output = false
	 */

	void addOrderToDocket04() {
		// db.initDBConnection();
		Docket test = new Docket();
		assertEquals(false, test.addOrderToDocket(1, 1001, db));

	}

	@Test
	/*
	 * Test Number 12 Test Objective: Test valid Order ID(add Order to Docket)
	 * Input:1,1 Expected Output = true
	 */

	void addOrderToDocket05() {
		// db.initDBConnection();
		Docket test = new Docket();
		assertEquals(true, test.addOrderToDocket(1, 1, db));

	}

	@Test

	/*
	 * Test Number 13 Test Objective: Test valid DeliveryStatus Input:-1 Expected
	 * Output = false
	 */
	void testValiDeliveryStatus01() {
		Docket test = new Docket();
		db.initDBConnection();
		assertEquals(false, test.deliveryStatus(-1, db));

	}

	@Test
	/*
	 * Test Number 14 Test Objective: Test valid DeliveryStatus Input:1 Expected
	 * Output = true
	 */
	void testValidDeliveryStatus02() {
		Docket test = new Docket();
		// db.initDBConnection();
		assertEquals(true, test.deliveryStatus(1, db));

	}

	@Test
	/*
	 * Test Number 15 Test Objective: Test valid DeliveryStatus Input:1001 Expected
	 * Output = false
	 */
	void testValidDeliveryStatus03() {
		Docket test = new Docket();
		db.initDBConnection();
		assertEquals(false, test.deliveryStatus(1001, db));

	}

	@Test
	/*
	 * Test Number 16 Test Objective: Test valid Docket ID Input:-1 Expected Output
	 * = Invalid Docket Id
	 */
	void testDocketId01() {
		db.initDBConnection();
		Docket dTest = new Docket();
		assertEquals("Invalid Docket Id", dTest.lookDocket(-1, db));
	}

	@Test
	/*
	 * Test Number 17 Test Objective: Test valid LookDocket Input:1 Expected Output
	 * = printDocket
	 */
	void testDocketId02() {
		db.initDBConnection();
		Docket dTest = new Docket();
		assertEquals(db.printDocket(1), dTest.lookDocket(1, db));
	}

	@Test
	/*
	 * Test Number 18 Test Objective: Test DocketID for modify Docket Input:0,1,1
	 * Expected Output = false
	 */
	void testModifyDocket01() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(0, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 19 Test Objective: Test DocketID for modify Docket Input:1001,1,1
	 * Expected Output = false
	 */
	void testModifyDocket02() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(1001, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 20 Test Objective: Test DocketID for modify Docket Input:1,0,1
	 * Expected Output = false
	 */
	void testModifyDocket03() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(1, 0, 1, db));

	}

	@Test
	/*
	 * Test Number 21 Test Objective: Test DocketID for modify Docket Input:1,1001,1
	 * Expected Output = false
	 */
	void testModifyDocket04() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(1, 1001, 1, db));

	}

	@Test
	/*
	 * Test Number 22 Test Objective: Test DocketID for modify Docket Input:1,1,0
	 * Expected Output = false
	 */
	void testModifyDocket05() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(1, 1, 0, db));

	}

	@Test
	/*
	 * Test Number 23 Test Objective: Test DocketID for modify Docket Input:1,1,1001
	 * Expected Output = false
	 */
	void testModifyDocket06() {
		// db.initDBConnection();
		Docket test = new Docket();

		assertEquals(false, test.modifyDocket(1, 1, 1001, db));

	}

	@Test
	/*
	 * Test Number 24 Test Objective: Test DocketID for modify Docket Input:1000,1,1
	 * Expected Output = true
	 */
	void testModifyDocket07() {
		db.initDBConnection();
		Docket test = new Docket();

		assertEquals(true, test.modifyDocket(1000, 1, 1, db));

	}

}
