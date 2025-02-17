package Activities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Activity1 {
	// Test fixtures
	ArrayList<String> list;

	// Initialize test fixtures before each test method
	//Commanding Before Test
	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<String>();
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
	}

	// Test method to test the insert operation

	@Test
	public void insertTest() {
		
		List<String> expectedList= Arrays.asList("alpha", "beta", "gamma");

		// Assertion for size
		assertEquals(2, list.size());

		// Add new element

		list.add(2, "gamma");

		// Assert with new elements

		assertEquals(3, list.size());

		// Assert individual elements

		assertIterableEquals(expectedList, list);
		

	}

	// Test method to test the replace operation

	@Test
	public void replaceTest() {
		List<String> expectedList= Arrays.asList("alpha", "beta", "Charlie");

		// Assertion for size
		assertEquals(2, list.size());

		// Add new element

		list.add(2, "gamma");
		list.set(2, "Charlie");

		// Assert with new elements

		assertEquals(3, list.size());

		// Assert individual elements

		assertIterableEquals(expectedList, list);
		

	}

}