import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class ManagerTest extends TestCase {
	@Test
	/*
	 * Test Number 1 Test Objective: Valid Manager Login Input Admin, Pass Expected
	 * Output : true, valid
	 */
	public void testManagerLogin01() {
		Manager test = new Manager();
		assertEquals(true, test.validateLogin("Admin", "Pass"));
	}

	@Test
	/*
	 * Test Number 2 Test Objective: Invalid Manager login Input Adminn, Pass
	 * Expected Output : false, invalid
	 */
	public void testManagerLogin02() {
		Manager test = new Manager();
		assertEquals(false, test.validateLogin("Adminn", "Pass"));
	}

	@Test
	/*
	 * Test Number 3 Test Objective: Invalid Manager Login Input "", "" Expected
	 * Output : false, invalid
	 */
	public void testManagerLogin03() {
		Manager test = new Manager();
		assertEquals(false, test.validateLogin("", ""));
	}

}