/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for ProductComparator
 */
@DisplayName("Test product comparisons")
@SpringBootTest
public class ProductComparatorTest {

//	static Stream<Arguments> testMatchingProducts() {
//
//		Product sweetApple1 = new Product("Granny Smith Apple", 1.5);
//		Product sweetApple2 = new Product("Granny Smith Apple", 1.5);
//		Product iPhone1 = new Product("iPhone 15", 1200.00);
//		Product iPhone2 = new Product("iPhone 15", 1200.00);
//		Product pineapple1 = new Product("Sweet Pineapple", 2.75);
//		Product pineapple2 = new Product("Sweet Pineapple", 2.75);
//
//		return Stream.of(Arguments.of(sweetApple1, sweetApple2), Arguments.of(iPhone1, iPhone2),
//				Arguments.of(pineapple1, pineapple2));
//	}
//
//	static Stream<Arguments> testNonMatchingProducts() {
//
//		Product sweetApple1 = new Product("Granny Smith Apple", 1.5);
//		Product sweetApple2 = new Product("Sour Apple", 1.5);
//		Product iPhone1 = new Product("iPhone 15", 1200.00);
//		Product iPhone2 = new Product("iPhone 12", 999.99);
//		Product pineapple1 = new Product("Sweet Pineapple", 2.75);
//		Product pineapple2 = new Product("Sour Pineapple", 1.55);
//
//		return Stream.of(Arguments.of(sweetApple1, sweetApple2), Arguments.of(iPhone1, iPhone2),
//				Arguments.of(pineapple1, pineapple2));
//	}

	// Compare results are -1 the object is less than, 0 both are equals, 1 is
	// greater than the other.

//	@DisplayName("Should return true on all comparisons")
//	@ParameterizedTest(name = "{0}")
//	@MethodSource("testMatchingProducts")
	@Test
	public void compare2SameProductsEqualSuccessTest() {
		Product sweetApple1 = new Product("Granny Smith Apple", 1.5);
		Product sweetApple2 = new Product("Granny Smith Apple", 1.5);
		ProductComparator pc = new ProductComparator();
		System.out.println(pc.compare(sweetApple1, sweetApple2));
		assertEquals(0, pc.compare(sweetApple1, sweetApple2));
	}

//	@DisplayName("Should return false on all comparisons")
//	@ParameterizedTest(name = "{0}")
//	@MethodSource("testNonMatchingProducts")
	@Test
	public void compare2DifferentProductsNotEqualSuccessTest() {
		Product sweetApple1 = new Product("Granny Smith Apple", 1.5);
		Product sweetApple2 = new Product("Sour Apple", 1.5);

		ProductComparator pc = new ProductComparator();
		assertNotEquals(1, pc.compare(sweetApple1, sweetApple2));
	}

}
