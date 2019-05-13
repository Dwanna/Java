import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubscptionTest {

	Database db = new Database();

	@Test

	/*
	 * Test Number 1 Test Objective: Test valid Subscription Frequency Input:"eee"
	 * Expected Output = false
	 */
	void testValidcreateSubscription001() {

		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("eee", db));

	}

	@Test
	/*
	 * Test Number 2 Test Objective: Test valid Subscription Frequency Input:"Daily"
	 * Expected Output = true
	 */
	void testValidcreateSubscription002() {

		Subscrption test = new Subscrption();
		assertEquals(true, test.createSubscription("Daily", db));

	}

	@Test
	/*
	 * Test Number 3 Test Objective: Test valid Subscription Frequency
	 * Input:"Weekly" Expected Output = true
	 */
	void testValidcreateSubscription003() {

		Subscrption test = new Subscrption();
		assertEquals(true, test.createSubscription("Weekly", db));

	}

	@Test
	/*
	 * Test Number 4 Test Objective: Test valid Subscription Frequency
	 * Input:"Monthly" Expected Output = true
	 */
	void testValidcreateSubscription004() {

		Subscrption test = new Subscrption();
		assertEquals(true, test.createSubscription("Monthly", db));

	}

	@Test
	/*
	 * Test Number 5 Test Objective: Test valid Subscription Frequency Input:"Dail"
	 * Expected Output = false
	 */
	void testValidcreateSubscription005() {

		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("Dail", db));

	}

	@Test
	/*
	 * Test Number 6 Test Objective: Test valid Subscription Frequency
	 * Input:"Dailyyyy" Expected Output = false
	 */
	void testValidcreateSubscription006() {

		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("Dailyyyy", db));

	}

	@Test
	/*
	 * Test Number 7 Test Objective: Test valid Subscription Frequency Input:""
	 * Expected Output = false
	 */
	void testValidcreateSubscription007() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("", db));

	}

	@Test
	/*
	 * Test Number 8 Test Objective: Test valid Subscription Frequency Input:"daily"
	 * Expected Output = false
	 */
	void testValidcreateSubscription008() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("daily", db));

	}

	@Test
	/*
	 * Test Number 9 Test Objective: Test valid Subscription Frequency
	 * Input:"weekly" Expected Output = false
	 */
	void testValidcreateSubscription009() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("weekly", db));

	}

	@Test
	/*
	 * Test Number 10 Test Objective: Test valid Subscription Frequency
	 * Input:"monthly" Expected Output = false
	 */
	void testValidcreateSubscription010() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		assertEquals(false, test.createSubscription("monthly", db));

	}

	@Test
	/*
	 * Test Number 11 Test Objective: Test valid Subscrption ID Input:-1 Expected
	 * Output = "Invalid Subscrption ID"
	 */
	void testValidSubID001() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		assertEquals("Invalid Subscrption ID", test.getSubscription(-1, db));

	}

	@Test
	/*
	 * Test Number 12 Test Objective: Test valid Subscrption ID Input:1 Expected
	 * Output = "ID = 1,Frequency = Weekly, Status = true"
	 */
	void testValidSubID002() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		String res = db.getSubscription(1);
		assertEquals(res, test.getSubscription(1, db));

	}

	@Test
	/*
	 * Test Number 13 Test Objective: Test valid Subscrption ID Input:1001 Expected
	 * Output = "Invalid Subscrption ID"
	 */
	void testValidSubID003() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		String res = "Invalid Subscrption ID";
		assertEquals(res, test.getSubscription(1001, db));

	}

	// /**
	// * Test1 CustomerInactivity
	// */
	// @Test
	// void testCustomerInactivity001() {
	// db.initDBConnection();
	// Subscrption Test = new Subscrption();
	// String res = "Subscrption Id: null\n" +
	// "Frequence: null\n" +
	// "Subscrption status: null" ;
	// assertEquals(res, Test.CustomerInactivity(1, db));
	// }
	//
	//
	// /**
	// * Test2 CustomerInactivity
	// */
	// @Test
	// void testCustomerInactivity002() {
	// db.initDBConnection();
	// Subscrption Test = new Subscrption();
	// String res = "Subscrption Id: null\n" +
	// "Frequence: null\n" +
	// "Subscrption status: null" ;
	// assertEquals(res, Test.CustomerInactivity(1, db));
	// }
	//
	//
	// /**
	// * Test3 CustomerInactivity
	// */
	// @Test
	// void testCustomerInactivity003(){
	// Subscrption Test = new Subscrption();
	// db.initDBConnection();
	// assertEquals("Invalid sub ID", Test.CustomerInactivity(-1, db));
	// }
	@Test
	/*
	 * Test Number 14 Test Objective: Test valid Add publication ID and
	 * SubscriptionID Input:-1, 1, 1
	 *  Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomerID01() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(-1, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 15 Test Objective: Test valid Add publication ID and
	 * SubscriptionID Input:1001, 1, 1 
	 * Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer02() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1001, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 16 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(CustomerID) 
	 * Input:1, 1, 1 
	 * Expected Output = "true"
	 */
	void testValidAddPublicationAndCustomer03() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(true, test.addPubicationAndCustomerID(1, 1, 1, db));

	}

	@Test
	/*
	 * Test Number 17 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(customerID) Input:1, -1, 1 Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer04() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1, -1, 1, db));

	}

	@Test
	/*
	 * Test Number 18 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(customerID) 
	 * Input:1, 1001, 1
	 *  Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer05() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1, 1001, 1, db));

	}

	@Test
	/*
	 * Test Number 19 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(customerID) 
	 * Input:1, 1001, 1 
	 * Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer06() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1, 1001, 1, db));

	}

	@Test
	/*
	 * Test Number 20 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(customerID) 
	 * Input:1, 1, -1 
	 * Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer07() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1, 1, -1, db));

	}

	@Test
	/*
	 * Test Number 21 Test Objective: Test valid Add publication ID and
	 * SubscriptionID(customerID) Input:1, 1, 1001 Expected Output = "false"
	 */
	void testValidAddPublicationAndCustomer08() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.addPubicationAndCustomerID(1, 1, 1001, db));

	}

	@Test

	/*
	 * Test Number 22 Test Objective: Test Customer ID Input:-1
	 * 
	 *Expected Output="Invalid Customer ID"
	 */
	void testCustomerInactivity001() {

		Subscrption test = new Subscrption();
		assertEquals("Invalid Customer ID", test.CustomerInactivity(-1, db));

	}

	@Test

	/*
	 * Test Number 23 Test Objective: Test Customer ID Input:1001 
	 * Expected Output ="Invalid Customer ID"
	 */
	void testCustomerInactivity002() {

		Subscrption test = new Subscrption();
		assertEquals("Invalid Customer ID", test.CustomerInactivity(1001, db));

	}

	@Test
	/*
	 * Test Number 24 Test Objective: Test Customer ID Input:999 Expected Output =
	 * db.customerInactivity(999)
	 */
	void testCustomerInactivity003() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		String res = db.customerInactivity(999);
		assertEquals(res, test.CustomerInactivity(999, db));

	}

	@Test
	/*
	 * Test Number 25
	 * 
	 * Test Objective: Test CustomerInactivity
	 * 
	 * Test Objective: Test Customer ID
	 * 
	 * Input:999 Expected Output = Invalid Customer ID
	 */
	void testCustomerInactivity004() {
		db.initDBConnection();
		Subscrption test = new Subscrption();
		// String res=db.customerInactivity(999);
		assertEquals("Invalid Customer ID", test.CustomerInactivity(-3, db));

	}

	@Test

	/*
	 * Test Number 26 Test Objective: Test customer ID for changeActive Input:-1,
	 * true Expected Output =false
	 */
	void testchangeActive001() {

		Subscrption test = new Subscrption();
		assertEquals(false, test.changeActive(-1, true, db));

	}

	@Test
	/*
	 * Test Number 27 Test Objective: Test Customer ID for changeActive Input:-3,
	 * true Expected Output = false
	 */
	void testchangeActive002() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.changeActive(-3, true, db));

	}

	@Test

	/*
	 * Test Number 28 Test Objective: Test customer ID for changeActive Input:1001,
	 * false Expected Output = false
	 */
	void testchangeActive003() {

		Subscrption test = new Subscrption();
		assertEquals(false, test.changeActive(1001, false, db));

	}

	@Test

	/*
	 * Test Number 29 Test Objective: Test customer ID for changeActive Input:1,
	 * true Expected Output = true
	 */
	void testchangeActive004() {

		Subscrption test = new Subscrption();
		// boolean v= false;
		assertEquals(true, test.changeActive(1, false, db));

	}

	@Test
	/*
	 * Test Number 30 Test Objective: Test customer ID for changeActive Input:99,
	 * true Expected Output = true
	 */
	void testchangeActive005() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(true, test.changeActive(99, true, db));

	}

	@Test
	/*
	 * Test Number 31 Test Objective: Test subscription Id for modify subscription
	 * Input:-1, 1, "Daily", true, 1 Expected Output = false
	 */
	void testModifySubscription01() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(-1, 1, "Daily", true, 1, db));

	}

	@Test
	/*
	 * Test Number 32 Test Objective: Test subscription Id for modify subscription
	 * Input:1001, 1, "Daily", true, 1 Expected Output = false
	 */
	void testModifySubscription02() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1001, 1, "Daily", true, 1, db));

	}

	@Test
	/*
	 * Test Number 33 Test Objective: Test customer Id for modify subscription
	 * Input:1,-1, "Daily", true, 1 Expected Output = false
	 */
	void testModifySubscription03() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1, -1, "Daily", true, 1, db));

	}

	@Test
	/*
	 * Test Number 34 Test Objective: Test customer Id for modify subscription
	 * Input:1, 1001, "Daily", true, 1 Expected Output = false
	 */
	void testModifySubscription04() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1, 1001, "Daily", true, 1, db));

	}

	@Test
	/*
	 * Test Number 35 Test Objective: Test frequency for modify subscription
	 * Input:-1, 1, "Dail", true, 1 Expected Output = false
	 */
	void testModifySubscription05() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1, 1, "Dail", true, 1, db));

	}

	@Test
	/*
	 * Test Number 36 Test Objective: Test frequency for modify subscription
	 * Input:1, 1, "daily", true, 1 Expected Output = false
	 */
	void testModifySubscription06() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1, 1, "daily", true, 1, db));

	}

	@Test
	/*
	 * Test Number 37 Test Objective: Test publication Id for modify subscription
	 * Input:1, 1, "Daily", true, -1 Expected Output = false
	 */
	void testModifySubscription07() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();
		// boolean v=true;
		assertEquals(false, test.modifySubscription(1, 1, "Daily", true, -1, db));

	}

	@Test
	/*
	 * Test Number 38 Test Objective: Test publication Id for modify subscription
	 * Input:1, 1, "Daily", true, 1001 Expected Output = false
	 */
	void testModifySubscription08() {
		// db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(false, test.modifySubscription(1, 1, "Daily", true, 1001, db));

	}

	@Test
	/*
	 * Test Number 39 Test Objective: Test publication Id for modify subscription
	 * Input:1, 1, "Daily", true, 1 Expected Output = true
	 */
	void testModifySubscription09() {
		db.initDBConnection();
		Subscrption test = new Subscrption();

		assertEquals(true, test.modifySubscription(1000, 1, "Monthly", true, 1, db));

	}

}
