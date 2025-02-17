package Activities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	Calculator calc = new Calculator();

	
	@Test
	public void addTest() {
		// Perform, the add function to get the actual result
		int result1 = calc.add(10, 20);
		int result2 = calc.add(15, 15);
		int result3 = calc.add(25, 5);
		// Add a assertion statement to verify against expected result
		assertAll(
			() ->	assertEquals(30, result1),
			() ->	assertEquals(30, result2),
			() ->	assertEquals(30, result3)
			);
		
	}

	@Test
	public void multiplyTest() {
		//Perform Multiply
		int result4 = calc.multiply(5, 5);
		//Expected Result
		
		assertEquals(25, result4);

	}

	@Test
	public void squareTest() {
		//Perform Square
		int result3 = calc.square(6);
		//Expected Result
		assertEquals(36, result3);

	}
	
	@ParameterizedTest
	@ValueSource(ints= {1, 2, 3})
	public void paramSqrtTest(int num1) {
		int result =calc.square(num1);
		assertEquals(num1 *num1, result);
		
	}
	
	@ParameterizedTest
	@CsvSource({
	    "10,90", 
	    "20, 80",
	    "50, 50"
	})
	public void paramAddTest(int num1 , int num2) {
		int result4= calc.add(num1, num2);
		assertEquals(100, result4);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(files= "src/test/resources/input.csv", nullValues = {"N/A", "N/A", "-"})
	public void AggregateTest(ArgumentsAccessor args) {
		System.out.println(args.getString(0) + "has only" + (args.getInteger(3)+3) + "sick days remaining");
	}
	
}