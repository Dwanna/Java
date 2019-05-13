import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	Database db = new Database();

	@Test
	/*
	 * Test Number 1 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:-1, 1, 1 Expected Output = "false"
	 */
	void testValidcreateOrder01() {
		db.initDBConnection();
		Order test = new Order();
		assertEquals(false, test.createOrder(-1, 1, 1, db));
	}

	@Test
	/*
	 * Test Number 2 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1001, 1, 1 Expected Output = "false"
	 */
	void testValidcreateOrder02() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1001, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 3 Test Objective:Test valid create Order publication ID and
	 * SubscriptionID Input:1, 1, 1 Expected Output = "true"
	 */
	void testValidcreateOrder03() {
		// db.initDBConnection();
		Order test = new Order();

		assertEquals(true, test.createOrder(1, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 4 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1, -1, 1 Expected Output = "false"
	 */
	void testValidcreateOrder04() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1, -1, 1, db));

	}

	@Test
	/*
	 * Test Number 5 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1, -1, 1 Expected Output = "false"
	 */
	void testValidcreateOrder05() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1, 1001, 1, db));

	}

	@Test
	/*
	 * Test Number 6 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1, 1001, 1 Expected Output = "false"
	 */
	void testValidcreateOrder06() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1, 1001, 1, db));

	}

	@Test
	/*
	 * Test Number 7 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1, 1, -1 Expected Output = "false"
	 */
	void testValidcreateOrder07() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1, 1, -1, db));

	}

	@Test
	/*
	 * Test Number 8 Test Objective: Test valid create Order publication ID and
	 * SubscriptionID Input:1, 1, 1001 Expected Output = "false"
	 */
	void testValidcreateOrder08() {
		db.initDBConnection();
		Order test = new Order();

		assertEquals(false, test.createOrder(1, 1, 1001, db));

	}

	@Test
	/*
	 * Test Number 9 Test Objective: Test valid get Order Input:-1 Expected Output =
	 * "Invalid Order ID"
	 */
	void testValidgetOrder01() {
		db.initDBConnection();
		Order test = new Order();
		String res = "Invalid Order ID";

		assertEquals(res, test.getOrder(-1, db));

	}

	@Test
	/*
	 * Test Number 10 Test Objective: Test valid get Order Input:1001 Expected
	 * Output = "Invalid Order ID"
	 */
	void testValidgetOrder02() {
		db.initDBConnection();
		Order test = new Order();
		String res = "Invalid Order ID";

		assertEquals(res, test.getOrder(1001, db));

	}

	@Test
	/*
	 * Test Number 11 Test Objective: Test valid get Order Input:1 Expected Output =
	 * "Invalid Order ID"
	 */
	void testValidgetOrder03() {
		db.initDBConnection();
		Order test = new Order();

		String res = db.getOrder(1);

		assertEquals(res, test.getOrder(1, db));

	}

	@Test
	/*
	 * Test Number 1 Test Objective: Test Valid Delete Order Input: 1 Expected
	 * Output = true, valid
	 */
	void testDeleteOrder01() {
		// db.initDBConnection();
		Order test = new Order();
		String res = "";
		assertEquals(true, test.deleteOrders(1, db));
	}

	@Test
	/*
	 * Test Number 2 Test Objective: Test Invalid Delete Order Input: 0 Expected
	 * Output = false, invalid
	 */
	void testDeleteOrder02() {
		// db.initDBConnection();
		Order test = new Order();
		String res = "";

		assertEquals(false, test.deleteOrders(0, db));

	}

	@Test
	/*
	 * Test Number 3 Test Objective: Test Invalid Delete Order Input: 101 Expected
	 * Output = false, invalid
	 */
	void testDeleteOrder03() {
		// db.initDBConnection();
		Order test = new Order();
		String res = "";

		assertEquals(false, test.deleteOrders(101, db));

	}

	@Test
	/*
	 * Test Number 4 Test Objective: Test Valid Delete Order Input: 50 Expected
	 * Output = true, valid
	 */
	void testDeleteOrder04() {
		// db.initDBConnection();
		Order test = new Order();
		String res = "";

		assertEquals(true, test.deleteOrders(50, db));

	}

	@Test
	/*
	 * Test Number 16 Test Objective: Test valid Customer ID for generate Invoice
	 * Input: -1 Expected Output = "Invalid customer ID"
	 */
	void testGenerateInvoice01() {
		// db.initDBConnection();
		Order test = new Order();

		assertEquals("Invalid customer ID", test.generateInvoice(-1, db));

	}

	@Test
	/*
	 * Test Number 17 Test Objective: Test valid Customer ID for generate Invoice
	 * Input: 1001 Expected Output = "Invalid customer ID"
	 */
	void testGenerateInvoice02() {
		// db.initDBConnection();
		Order test = new Order();

		assertEquals("Invalid customer ID", test.generateInvoice(1001, db));

	}

	@Test
	/*
	 * Test Number 18 Test Objective: Test valid Customer ID for generate Invoice
	 * Input: 1 Expected Output = db.generateInvoice(1)
	 */
	void testGenerateInvoice03() {
		// db.initDBConnection();
		Order test = new Order();

		assertEquals(db.generateInvoice(1), test.generateInvoice(1, db));

	}

}
