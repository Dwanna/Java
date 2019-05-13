
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class CustomerTest extends TestCase {

	Database db = new Database();

	/*
	 * Test Number : 1 Test Objective: Valid Create customer Inputs "TestName",
	 * "TestAddress", "9999999999", 21, db Expected Output : True e
	 */
	@Test
	void testValidCustomerName() {
		// db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(true, cTest.createCust("TestName", "TestAddress", "9999999999", 21, db));

	}

	/*
	 * Test Number : 02 Test Objective : Invalid Customer Name Inputs
	 * "TestInvalidName 01", "Test Address Address Address", "Test Contact", 21, db
	 * Expected Output : Console - Invalid Customer Name
	 */
	@Test
	void testInvalidCustomerName() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.createCust("TestInvalidName 01", "Test Address Address Address", "Test Contact", 21, db));
	}

	/*
	 * Test Number : 03 Test Objective : Test Cusomer Name is too long Inputs
	 * "Test Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
	 * , "Test Address1 Address2", "Test Contact", 20, db Expected Output : Invalid
	 * Customer Name b
	 */
	@Test
	void testCustomerNameTooLong() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.createCust(
						"Test Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
						"Test Address1 Address2", "Test Contact", 20, db));
	}

	/*
	 * Test Number : 04 Test Objective : Test Customer age above 100 Inputs
	 * "TestName", "TestAddress", "1234567897", 101, db Expected Output : Console -
	 * Invalid Customer Age b
	 */
	@Test
	void testInvalidCustomerAge01() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("TestName", "TestAddress", "1234567897", 101, db));
	}

	/*
	 * Test Number : 05 Test Objective : Test Customer age below 18 "TestName",
	 * "TestAddressAddresAddress", "Test Contact", 18, db Expected Output : Console
	 * - Invalid Age b
	 */
	@Test
	void testInvalidCustomerAge002() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("TestName", "TestAddressAddresAddress", "Test Contact", 18, db));
	}

	/*
	 * Test Number : 06 Test Objective : Customer Address is too short Inputs
	 * "TestName", "TestAddress", "Test Contact", 20, db Expected Output : Invalid
	 * Customer Address
	 */
	@Test
	void testCustomerAddress001() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("TestName", "TestAddress", "Test Contact", 20, db));
	}

	/*
	 * Test Number : 07 Test Objective : Customer Address is too long Inputs
	 * "Test Name",
	 * "Test Addresssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
	 * , "Test Contact", 20, db Expected Output : Invalid Customer Address
	 */
	@Test
	void testCustomerAddress002() {
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.createCust("Test Name",
						"Test Addresssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
						"Test Contact", 20, db));
	}

	/*
	 * Test Number : 08 Test Objective : Test Customer contact should not contacin
	 * any string Inputs "Test Name", "Test Address Address", "12Hello345", 20, db
	 * Expected Output : Console - Invalid Contact Details
	 */
	@Test
	void testCustomerContact001() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("Test Name", "Test Address Address", "12Hello345", 20, db));
	}

	/*
	 * Test Number : 09 Test Objective : Test Customer contact details should not be
	 * long. Inputs "Test Name", "Test Address Address", "9090909090909", 20, db
	 * Test Output: Console - Invalid Contact Details
	 */
	@Test
	void testCustomerContact002() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("Test Name", "Test Address Address", "9090909090909", 20, db));
	}

	/*
	 * Test Number : 10 Test Objective : Test Customer contact details should not be
	 * too small Inputs "TestName", "TestAddressAddress", "9876543", 20, db Test
	 * Output : Console - Invalid Contact Details
	 */
	@Test
	void testCustomerContact003() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.createCust("TestName", "TestAddressAddress", "9876543", 20, db));
	}

	/* 
	 * 
	 */
	/*
	 * @Test void testLookForCustomer001() { Customer cTest = new Customer();
	 * db.initDBConnection(); String res = "CustomerNotFound"; assertEquals(res,
	 * cTest.findCustomer("TestNameFail", db)); }
	 */

	/*
	 * Test Number : 11 Test Objective : To look for customer by name Inputs
	 * "Ayodej", db Test Output : Printing details of customer
	 */

	@Test
	void testLookForCustomer002() {
		db.initDBConnection();
		Customer cTest = new Customer();
		String res = db.lookForCustomerName("Ayodej");
		assertEquals(res, cTest.findCustomerByName("Ayodej", db));
	}

	/*
	 * Test Number : 12 Test Objective : Look for customer by name Test Input :
	 * Entered numeric value with name Inputs "TestName12", db Test Output : Invalid
	 * name entered
	 */
	@Test
	void testLookForCustomer003() {
		Customer cTest = new Customer();
		db.initDBConnection();
		assertEquals("Invalid Name Entered", cTest.findCustomerByName("TestName12", db));
	}

	/*
	 * Test Number : 13 Test Objective : To successfully update customer details
	 * Test Input : All the valid details 2,"Steve", "Limerick", "9911223344",29, db
	 * Test Output : Successful
	 */

	@Test
	public void testValidModifyCustomer001() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(true, cTest.modifyCust(2, "Steve", "Limerick", "9911223344", 29, db));
	}

	/*
	 * Test Number : 14 Test Objective : If user enter negative number to search
	 * modify customer details Test Input : Negative value -1,"Steve", "Limerick",
	 * "9911223344",29, db Test Output : Invalid customer id
	 */
	@Test
	public void testInValidModifyCustomer002() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(-1, "Steve", "Limerick", "9911223344", 29, db));
	}

	/*
	 * Test Number : 15 Test Objective : If user enter more than 1000 Inputs
	 * 1001,"TestName", "TestAddress", "9911223344",30, db Test Output false
	 */
	@Test
	public void testInvalidModifyCustomer003() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1001, "TestName", "TestAddress", "9911223344", 30, db));
	}
	/*
	 * Test Number : 16 Test Objective : Inputs 1001,"TestName", "TestAddress",
	 * "9911223344",30, db Test Output false
	 */

	@Test
	public void testArchiveCustomer001() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(true, cTest.archiveCustomer(1, db));
	}

	/*
	 * Test Number : 17
	 * Test Objective : To check if we put negative integer, should not accept
	 * Test Input : -1
	 * Test Output : False - not archive successfully
	 */
	@Test
	public void testArchiveCustomer002() {
		// db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.archiveCustomer(-1, db));
	}

	/*
	 * Test Number : 18
	 * Test Objective : To check if we 0, should not accept
	 * Test Input : 0
	 * Test Output : False - not archive successfully
	 */
	@Test
	public void testArchiveCustNotFound() {
		// db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.archiveCustomer(0, db));
	}

	/*
	 * Test Number : 19
	 * Test Objective : Invalid customer name
	 * Test Input : Test Invalid Name 01
	 * Test Output : False - Invalid name entered
	 */
	@Test
	void testModifyInvalidCustomerName() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.modifyCust(1, "Test Invalid Name 01", "Test Address Address Address", "Test Contact", 21, db));
	}

	/*
	 * Test Number : 20
	 * Test Objective : Invalid customer name, name is too long (condition won't match)
	 * Test Input : Test Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	 * Test Output : False - Invalid name entered
	 */
	@Test
	void testModifyCustomerNameTooLong() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.modifyCust(1,
						"Test Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
						"Test Address1 Address2", "Test Contact", 20, db));
	}
	
	/*
	 * Test Number : 21
	 * Test Objective : Invalid customer age
	 * Test Input : 109
	 * Test Output : False - Invalid Customer Age
	 */

	@Test
	void testModifyInvalidCustomerAge01() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "TestName", "TestAddress", "9876543212", 109, db));
	}

	/*
	 * Test Number : 22
	 * Test Objective : Invalid customer age
	 * Test Input : 18
	 * Test Output : False - Invalid customer age
	 */
	@Test
	void testModifyInvalidCustomerAge002() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "Test Name", "Test Address Address Address", "Test Contact", 18, db));
	}

	/*
	 * Test Number : 23
	 * Test Objective : To update details of customer address
	 * Test Input : Test Address
	 * Test Output : Updated successfully
	 */
	@Test
	void testModifyCustomerAddress001() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "Test Name", "Test Address", "Test Contact", 20, db));
	}

	/*
	 * Test Number : 24
	 * Test Objective : Customer address too long, when try to update detail
	 * Test Input : Test Addressssssssssssssssssssssssssssss
	 * Test Output : False - Invalid Customer Address
	 */
	@Test
	void testModifyCustomerAddress002() {
		Customer cTest = new Customer();
		assertEquals(false,
				cTest.modifyCust(1, "Test Name",
						"Test Addresssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
						"Test Contact", 20, db));
	}
	
	/*
	 * Test Number : 25
	 * Test Objective : Entering string with contact number, should not accept
	 * Test Input : 12Hello345
	 * Test Output : False - Invalid Contact Number
	 */

	@Test
	void testModifyCustomerContact001() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "Test Name", "Test Address Address", "12Hello345", 20, db));
	}

	/*
	 * Test Number : 26
	 * Test Objective : Entering too long contact number, should not accept
	 * Test Input : 9090909090909
	 * Test Output : False - Invalid Contact Number
	 */
	@Test
	void testModifyCustomerContact002() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "Test Name", "Test Address Address", "9090909090909", 20, db));
	}
	
	/*
	 * Test Number : 27
	 * Test Objective : Update contact details, entering too short contact number, should not accept
	 * Test Input : 9876543
	 * Test Output : False - Invalid Contact Number
	 */

	@Test
	void testModifyCustomerContact003() {
		Customer cTest = new Customer();
		assertEquals(false, cTest.modifyCust(1, "Test Name", "Test Address Address", "9876543", 20, db));
	}

	/*
	 * Test Number : 28
	 * Test Objective : Look customer by customer id
	 * Test Input : 1
	 * Test Output : Print customer details
	 */
	@Test
	void testLookForCustomerById() {
		db.initDBConnection();
		Customer cTest = new Customer();
		String res = db.lookForCustomerId(1);
		assertEquals(res, cTest.findCustomerById(1, db));
	}

	/*
	 * Test Number : 29
	 * Test Objective : Look customer by id
	 * Test Input : 1001
	 * Test Output : False - Invalid Customer id
	 */
	@Test
	void testLookForCustomerById02() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals("Invalid Customer ID", cTest.findCustomerById(1001, db));
	}

	/*
	 * Test Number : 30
	 * Test Objective : Look customer by id
	 * Test Input : 10
	 * Test Output : False - Customer Not Found
	 */
	@Test
	void testLookForCustomerById03() {
		db.initDBConnection();
		Customer cTest = new Customer();
		String res = db.lookForCustomerId(10);
		assertEquals(res, cTest.findCustomerById(10, db));
	}

	/*
	 * Test Number : 31
	 * Test Objective : Look customer by id
	 * Test Input : -1
	 * Test Output : False - Invalid customer id
	 */
	@Test
	void testLookForCustomerById04() {
		db.initDBConnection();
		Customer cTest = new Customer();
		// String res = db.lookForCustomerId(1001);
		assertEquals("Invalid Customer ID", cTest.findCustomerById(-8, db));

	}
	

	/*
	 * Test Number : 32
	 * Test Objective : Test Customer's ID
	 * Test Input : Input:1
	 * Test Output : True
	 */
	@Test
	public void testUnArchiveCustomer001() {
		db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(true, cTest.unArchiveCustomer(1, db));
	}
	/*
	 * Test Number : 33
	 * Test Objective : Test Customer's ID
	 * Test Input : -1
	 * Test Output : False
	 */

	@Test
	public void testUnArchiveCustomer002() {
		// db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.unArchiveCustomer(-1, db));
	}
	// /*
	// * Test Number 3 Test Objective: Test Customer not found
	// * Input:1001
	// * Expected Output =false
	// *
	// */
	//
	// @Test
	// public void testUnArchiveCustNotFound() {
	// // db.initDBConnection();
	// Customer cTest = new Customer();
	// assertEquals("Customer Not Found", cTest.unArchiveCustomer(-1, db));
	// }

	/*

	 * Test Number 3 Test Objective: Test Customer's ID Input:1001 Expected Output
	 * Test Number : 34
	 * Test Objective : Test Customer's ID
	 * Test Input : 1001
	 * Test Output : False

	 */
	@Test
	public void testUnArchiveCustomer003() {
		// db.initDBConnection();
		Customer cTest = new Customer();
		assertEquals(false, cTest.unArchiveCustomer(1001, db));
	}

}
