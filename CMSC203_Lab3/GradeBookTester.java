import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook gradebook1;
	GradeBook gradebook2;

	@BeforeEach
	void setUp() throws Exception {
		gradebook1 = new GradeBook(5);
		gradebook2 = new GradeBook(5);
		//Add scores to gradebook 1
		gradebook1.addScore(67);
		gradebook1.addScore(83);
		gradebook1.addScore(88.5);
		//Add scores to gradebook 2
		gradebook2.addScore(90);
		gradebook2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() {
		//Compare what is in scores array to what should be in array
		String gradebook1scores = "67.0 83.0 88.5";
		String gradebook2scores = "90.0 100.0";
		assertTrue(gradebook1scores.equals(gradebook1.toString()));
		assertTrue(gradebook2scores.equals(gradebook2.toString()));
		//Compare score size
		assertEquals(gradebook1.getScoreSize(), 3);
		assertEquals(gradebook2.getScoreSize(), 2);
	}

	@Test
	void testSum() {
		//Compare expected sum to returned sum gradebook 1
		double gradebook1sum = 238.5;
		assertEquals(gradebook1sum, gradebook1.sum());
		//Compare expected sum to returned sum gradebook 2
		double gradebook2sum = 190.0;
		assertEquals(gradebook2sum, gradebook2.sum());
	}

	@Test
	void testMinimum() {
		//Compare expected minimum to returned minimum gradebook 1
		assertEquals(67.0, gradebook1.minimum());
		//Compare expected minimum to returned minimum gradebook 2
		assertEquals(90.0, gradebook2.minimum());
	}

	@Test
	void testFinalScore() {
		//Compare what is returned by finalScore to the expected finalScore
		//IF scoreSize >= 2, finalScore = sum of the scores with lowest score dropped
		//Else finalScore = 0
		assertEquals(85.75, gradebook1.finalScore());
		assertEquals(100.0, gradebook2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		//Compare score size
		assertEquals(gradebook1.getScoreSize(), 3);
		assertEquals(gradebook2.getScoreSize(), 2);
	}

	@Test
	void testToString() {
		//Compare what is in scores array to what should be in array
		String gradebook1scores = "67.0 83.0 88.5";
		String gradebook2scores = "90.0 100.0";
		assertTrue(gradebook1scores.equals(gradebook1.toString()));
		assertTrue(gradebook2scores.equals(gradebook2.toString()));
	}

}
