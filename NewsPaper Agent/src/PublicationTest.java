import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class PublicationTest extends TestCase {

	Database db = new Database();

	/*
	 * Test Number 1 Test Objective: Create Publication of Magazine Input Magazine,
	 * 2.30, db Expected Output : True - Valid
	 */
	@Test
	void testCreatePublication01() {
		db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(true, stockTest.createPublication("Magazine", 2.30, db));

	}

	/*
	 * Test Number 2 Test Objective: Create Publication of Newspaper Input
	 * Newspaper, 3.50, db Expected Output : True - Valid
	 */
	@Test
	void testCreatePublication02() {
		db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(true, stockTest.createPublication("Newspaper", 3.50, db));

	}

	/*
	 * Test Number 3 Test Objective: Create Publication of newspaper input
	 * newspaper, 3.50. db Expected Output : false - invalid
	 */
	@Test
	void testCreatePublication03() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("newspaper", 3.50, db));

	}

	/*
	 * Test Number 4 Test Objective: create publication magazine input magazine,
	 * 2.30, db Expected Output : false - invalid
	 */
	@Test
	void testCreatePublication04() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("magazine", 2.30, db));
	}

	/*
	 * Test Number 5 Test Objective: Create Publication magazine input magazine,
	 * 0.0, db Expected Output : false invalid
	 */
	@Test
	void testCreatePublication05() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("magazine", 0.0, db));
	}

	/*
	 * Test Number 6 Test Objective: Create publication newspaper Inputs newspaper,
	 * 0.0, db Expected Output : false invalid
	 */
	@Test
	void testCreatePublication06() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("newspaper", 0.0, db));

	}

	/*
	 * Test Number 7 Test Objective: Create publication magazine Inputs Magazine,
	 * 0.0, null Expected Output : false invalid
	 */
	@Test
	void testCreatePublication07() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("Magazine", 0.0, db));
	}

	/*
	 * Test Number 8 Test Objective: Create publication newspaper Inputs Newspaper,
	 * 0.0, null Expected Output : false invalid
	 */
	@Test
	void testCreatePublication08() {
		// db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals(false, stockTest.createPublication("Newspaper", 0.0, db));

	}

	/*
	 * Test Number 1 Test Objective: Get publication by id -1 Inputs -1, db Expected
	 * Output : false invalid
	 */
	@Test
	void testGetPublication01() {
		db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals("Invalid Publication ID", stockTest.getPublication(-1, db));
	}

	/*
	 * Test Number 2 Test Objective: Get publication by id 1001 Inputs 1001, db
	 * Expected Output : false invalid
	 */
	@Test
	void testGetPublication02() {
		db.initDBConnection();
		Publication stockTest = new Publication();
		assertEquals("Invalid Publication ID", stockTest.getPublication(1001, db));
	}

	/*
	 * Test Number 3 Test Objective: Get publication by id 1 Inputs 1, db Expected
	 * Output : true valid
	 */
	@Test
	void testGetPublication03() {
		db.initDBConnection();
		Publication stockTest = new Publication();
		String res = db.getPublication(100);
		assertEquals(res, stockTest.getPublication(100, db));
	}

	@Test
	/*
	 * Test Number 01 Test Objective: Update Publication to Newspaper Update
	 * Publication Name and Price Inputs 1, Newspaper, 3.50, db Expected Output :
	 * true valid
	 */

	void testUpdatePublication01() {
		db.initDBConnection();
		Publication test = new Publication();
		assertEquals(true, test.updatePublication(1, "Newspaper", 3.50, db));
	}

	@Test
	/*
	 * Test Number 02 Test Objective: Update Publication to Magazine Update
	 * Publication Name and Price Inputs 1,Magazine, 2.30, db Expected Output : true
	 * valid
	 */

	void testUpdatePublication001() {

		db.initDBConnection();
		Publication test = new Publication();
		assertEquals(true, test.updatePublication(1000, "Magazine", 2.30, db));
	}

	@Test
	/*
	 * Test Number 02 Test Objective: Update Publication Update Publication Name
	 * Newspaper, 3.50, db Expected Output : true valid
	 */
	void testUpdatePublication002() {
		db.initDBConnection();
		Publication test = new Publication();
		assertEquals(true, test.updatePublication(1000, "Newspaper", 3.50, db));
	}

	@Test
	/*
	 * Test Number 03 Test Objective: Update Publication to newspaper Update
	 * Publication Name and Price Inputs -1, newspaper, 3.50, db Expected Output :
	 * false invalid
	 */
	void testUpdatePublication03() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(-1, "newspaper", 3.50, db));
	}

	@Test
	/*
	 * Test Number 04 Test Objective: Update Publication to magazine Update
	 * Publication Name and Price Inputs 1001, magazine, 2.30, db Expected Output :
	 * false invalid
	 */
	void testUpdatePublication04() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(1001, "magazine", 2.30, db));
	}

	@Test
	/*
	 * Test Number 05 Test Objective: Update Publication to Magazine Update
	 * Publication Name and Price Inputs 56,Magazine, 0.0, db Expected Output :
	 * false invalid
	 */
	void testUpdatePublication05() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(56, "Magazine", 0.0, db));
	}

	@Test
	/*
	 * Test Number 06 Test Objective: Update Publication to Newspaper Update
	 * Publication Name and Price Inputs 34,Newspaper, 0.0, db Expected Output :
	 * false invalid
	 */
	void testUpdatePublication06() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(34, "Newspaper", 0.0, db));
	}

	@Test
	/*
	 * Test Number 07 Test Objective: Update Publication to Magazine Update
	 * Publication Name and Price Inputs 0,"Magazine",0.0,db Expected Output : false
	 * invalid
	 */
	void testUpdatePublication07() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(0, "Magazine", 0.0, db));
	}

	@Test
	/*
	 * Test Number 08 Test Objective: Update Publication to Newspaper Update
	 * Publication Name and Price Inputs 0,"Newspaper",0.0,null,db Expected Output :
	 * false invalid
	 */
	void testUpdatePublication08() {
		Publication test = new Publication();
		assertEquals(false, test.updatePublication(0, "Newspaper", 0.0, db));
	}
}
