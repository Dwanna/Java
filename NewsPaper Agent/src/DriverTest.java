import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriverTest {
	Database db = new Database();

	@Test

	/*
	 * Test Number 1 Test Objective: Test Driver Username Input:"ee12e","eee"
	 * Expected Output = false
	 */
	void testValidCreateDriver001() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals(false, test.createDriver("ee12e", "ee", db));

	}

	@Test

	/*
	 * Test Number 2 Test Objective: Test Driver Password Input:"ee12e","eeeeeeee"
	 * Expected Output = false
	 */
	void testValidCreateDriver002() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals(false, test.createDriver("ee12e", "eeeeeeee", db));

	}

	@Test

	/*
	 * Test Number 3 Test Objective: Test Username
	 * Input:"Ayodejidaniel","Agilemethods" Expected Output = true
	 */
	void testValidCreateDriver003() {
		// db.initDBConnection();
		Driver test = new Driver();
		assertEquals(true, test.createDriver("Ayodejidaniel", "Agilemethods", db));

	}

	@Test

	/*
	 * Test Number 4 Test Objective: Test Driver Username
	 * Input:"Ayodejidanielddddddd"","Agilem1ethods" Expected Output = false
	 */
	void testValidCreateDriver004() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("Ayodejidanielddddddd", "Agilem1ethods", db));

	}

	@Test

	/*
	 * Test Number 5 Test Objective: Test Driver Password
	 * Input:"Ayodejidanielddddddd"","AgileTeam11" Expected Output = false
	 */
	void testValidCreateDriver005() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("Ayodeji", "AgileTeam11", db));

	}

	@Test

	/*
	 * Test Number 6 Test Objective: Test Driver Password Input:
	 * "Ayodejiioushfijsehfewhoufehwwihwifhuwhfiuwehwfuhhwi"","AgileTeamjhbfjhbwehfbwefbewbfkwbejjkwjbfwjwbfbw"
	 * Expected Output = false
	 */
	void testValidCreateDriver006() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("Ayodejiioushfijsehfewhoufehwwihwifhuwhfiuwehwfuhhwi",
				"AgileTeamjhbfjhbwehfbwefbewbfkwbejjkwjbfwjwbfbw", db));

	}

	@Test

	/*
	 * Test Number 7 Test Objective: Test Driver Password Input:""","rach" Expected
	 * Output = false
	 */
	void testValidCreateDriver007() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("", "racheal", db));

	}

	@Test

	/*
	 * Test Number 8 Test Objective: Test Driver Password
	 * Input:"Ayodejiojeaburu"","" Expected Output = false
	 */
	void testValidCreateDriver008() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("Ayodeji", "", db));

	}

	@Test

	/*
	 * Test Number 8 Test Objective: Test valid Driver Input:"Ayodeji" Expected
	 * Output = true
	 */
	void testValidLookUpDriver001() {
		db.initDBConnection();
		Driver test = new Driver();
		String driverLookUp = db.getDriverName("Ayodeji");
		assertEquals(driverLookUp, test.lookUpDriver("Ayodeji", db));

	}

	@Test

	/*
	 * Test Number 9 Test Objective: Test valid Driver Input:"abcdefghijklmnopq"
	 * Expected Output = "Invalid Driver Name"
	 */
	void testValidLookUpDriver002() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals("Invalid Driver Name", test.lookUpDriver("abcdefghijklmnopq", db));

	}

	/*
	 * Test Number 10 Test Objective: Test valid Driver username
	 * Input:"abcdefghijklmnopq" Expected Output = "Invalid Driver Name"
	 */
	@Test
	void archieveDriver001() {
		// db.initDBConnection();
		Driver Test = new Driver();
		// //String res = "Driver name: Edward\n" +
		// "Password: Edward \n" +
		// "Driver ID: 1" ;
		assertEquals(false, Test.archiveDriver("abcdefghijklmnopq", db));
	}

	/*
	 * Test Number 11 Test Objective: Test valid Driver Username Input:"Edward"
	 * Expected Output = true
	 */
	@Test
	void archieveDriver002() {
		// db.initDBConnection();
		Driver Test = new Driver();
		// //String res = "Driver name: Edward\n" +
		// "Password: Edward \n" +
		// "Driver ID: 1" ;
		assertEquals(true, Test.archiveDriver("Edward", db));
	}

	/*
	 * Test Number 12 Test Objective: Test valid Docket id to change delivery status
	 * Input:1001 Expected Output = false
	 */
	@Test
	void deliveryStatus01() {
		// db.initDBConnection();
		Driver Test = new Driver();
		// //String res = "Driver name: Edward\n" +
		// "Password: Edward \n" +
		// "Driver ID: 1" ;
		assertEquals(false, Test.deliveryStatus(1001, false, db));
	}

	/*
	 * Test Number 13 Test Objective: Test valid Docket id to change delivery status
	 * Input:-1 Expected Output = false
	 */
	@Test
	void deliveryStatus02() {
		// db.initDBConnection();
		Driver Test = new Driver();
		// //String res = "Driver name: Edward\n" +
		// "Password: Edward \n" +
		// "Driver ID: 1" ;
		assertEquals(false, Test.deliveryStatus(-1, false, db));
	}

	/*
	 * Test Number 13 Test Objective: Test valid Docket id to change delivery status
	 * Input:1001 Expected Output = false
	 */
	@Test
	void deliveryStatus03() {
		// db.initDBConnection();
		Driver Test = new Driver();
		// //String res = "Driver name: Edward\n" +
		// "Password: Edward \n" +
		// "Driver ID: 1" ;
		assertEquals(true, Test.deliveryStatus(1, false, db));
	}

	@Test

	/*
	 * Test Number 14 Test Objective: Test Driver ID in modify Driver
	 * Input:-1,"Edward","Password" Expected Output = false
	 */
	void testmodifyDriver01() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(-1, "Edward", "Password", db));

	}

	@Test

	/*
	 * Test Number 15 Test Objective: Test Driver Password
	 * Input:1001"Edward","Password" Expected Output = false
	 */
	void testmodifyDriver02() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1001, "Edward", "Password", db));

	}

	@Test

	/*
	 * Test Number 16 Test Objective: Test modify Driver details
	 * Input:1,"Ayodeji","Agilemethods" Expected Output = true
	 */
	void testmodifyDriver03() {
		db.initDBConnection();
		Driver test = new Driver();
		assertEquals(true, test.modifyDriver(1000, "Ayodeji", "Agilemethods", db));

	}

	@Test

	/*
	 * Test Number 17 Test Objective: Test Driver Username in Modify Driver
	 * Input:1,"Edwarddddddddddddddddddddd","Password" Expected Output = false
	 */
	void testmodifyDriver04() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "Edwarddddddddddddddddddddd", "Password", db));

	}

	@Test

	/*
	 * Test Number 18 Test Objective: Test Driver Username in modify Driver
	 * Input:1,"Edward12","Password" Expected Output = false
	 */
	void testmodifyDriver05() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "Edward12", "Password", db));

	}

	@Test

	/*
	 * Test Number 19 Test Objective: Test Driver Password in modify Driver
	 * Input:1,"Edward","Password123" Expected Output = false
	 */
	void testmodifyDriver06() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "Edward", "Password123", db));

	}

	@Test

	/*
	 * Test Number 20 Test Objective: Test Driver Ussrname Input:1,""","Password"
	 * Expected Output = false
	 */
	void testmodifyDriver07() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "", "Password", db));

	}

	@Test

	/*
	 * Test Number 21 Test Objective: Test Driver Password Input:1,"Ayodeji,""
	 * Expected Output = false
	 */
	void testmodifyDriver08() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "Ayodeji", "", db));

	}

	@Test

	/*
	 * Test Number 22 Test Objective: Test Driver Password
	 * Input:"Ayodejiojeaburu"","" Expected Output = false
	 */
	void testmodifyDriver09() {

		Driver test = new Driver();
		assertEquals(false, test.createDriver("Ayodeji", "", db));

	}

	@Test

	/*
	 * Test Number 23 Test Objective: Test Driver Password in modifyPassword
	 * Input:1,"Ayodeji","Passwordddddddddddddddddddd" Expected Output = false
	 */
	void testmodifyDriver10() {

		Driver test = new Driver();
		assertEquals(false, test.modifyDriver(1, "Ayodeji", "Passwordddddddddddddddddddd", db));

	}
	/*
	 * Test Number 24 Test Objective: Test Driver Username
	 * Input:"abcdefghijklmnopq", Expected Output = false
	 */

	@Test
	void unArchieveDriver001() {
		// db.initDBConnection();
		Driver Test = new Driver();

		assertEquals(false, Test.unArchiveDriver("abcdefghijklmnopq", db));
	}

	/*
	 * Test Number 25 Test Objective: Test valid Driver Username Input:"Edward"
	 * Expected Output = true
	 */
	@Test
	void unArchieveDriver002() {
		// db.initDBConnection();
		Driver Test = new Driver();

		assertEquals(true, Test.unArchiveDriver("Edward", db));
	}

	/*
	 * Test Number 26 Test Objective: Test valid Driver Username Input:"Edward12"
	 * Expected Output = true
	 */
	@Test
	void unArchieveDriver003() {
		// db.initDBConnection();
		Driver Test = new Driver();

		assertEquals(false, Test.unArchiveDriver("Edward12", db));
	}

}
