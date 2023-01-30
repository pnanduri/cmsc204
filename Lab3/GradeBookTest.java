import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook g1, g2;

	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(30);
		g1.addScore(20);
		g1.addScore(50);
		
		g2.addScore(40);
		g2.addScore(25);
		g2.addScore(35);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}


	@Test
	void testSum() {
		assertTrue(100.0==g1.sum());
		assertTrue(100.0==g2.sum());
	}

	@Test
	void testMinimum() {
		assertTrue(20.0==g1.minimum());
		assertTrue(25.0==g2.minimum());
	}

	@Test
	void testFinalScore() {
		
		assertTrue(80.0==g1.finalScore());
		assertTrue(75.0==g2.finalScore());
		
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3, g1.getScoreSize());
		assertEquals(3, g2.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue("30.0 20.0 50.0".equals(g1.toString()));
		assertTrue("40.0 25.0 35.0".equals(g2.toString()));
	}

}
