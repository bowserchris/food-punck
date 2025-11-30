/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import static com.smash.food_punk.utils.FoodPunkConstantsTest.APPLE_NAME_1;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.APPLE_NAME_3;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.DISPLAY_NAME_CLASS_TEST;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.DISPLAY_NAME_COMPARE_2_FAIL;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.DISPLAY_NAME_COMPARE_2_SUCCESS;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.DISPLAY_NAME_LOWEST_PRODUCT_SUCCESS;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.DISPLAY_PARAM_NAME_TEST;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.PHONE_NAME_1;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.PHONE_NAME_2;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.PINEAPPLE_NAME_1;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.PINEAPPLE_NAME_3;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.TEST_MATCH_PRODUCTS;
import static com.smash.food_punk.utils.FoodPunkConstantsTest.TEST_NON_MATCH_PRODUCTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for ProductComparator
 */
@DisplayName(DISPLAY_NAME_CLASS_TEST)
@SpringBootTest
public class ProductComparatorTest {

	private static ProductComparator productComparator;

	@BeforeAll // TODO check to run individual tests and not full class
	static void setup() {
		productComparator = new ProductComparator();
	}

	static Stream<Arguments> testMatchingProducts() {

		Product sweetApple1 = new Product(APPLE_NAME_1, 1.5);
		Product iPhone1 = new Product(PHONE_NAME_1, 1200.00);
		Product pineapple1 = new Product(PINEAPPLE_NAME_1, 2.75);

		return Stream.of(Arguments.of(sweetApple1, sweetApple1), Arguments.of(iPhone1, iPhone1),
				Arguments.of(pineapple1, pineapple1));
	}

	static Stream<Arguments> testNonMatchingProducts() {

		Product sweetApple1 = new Product(APPLE_NAME_1, 1.5);
		Product sweetApple2 = new Product(APPLE_NAME_3, 1.55);
		Product iPhone1 = new Product(PHONE_NAME_1, 1200.00);
		Product iPhone2 = new Product(PHONE_NAME_2, 999.99);
		Product pineapple1 = new Product(PINEAPPLE_NAME_1, 2.75);
		Product pineapple2 = new Product(PINEAPPLE_NAME_3, 1.55);

		return Stream.of(Arguments.of(sweetApple1, sweetApple2), Arguments.of(iPhone1, iPhone2),
				Arguments.of(pineapple1, pineapple2));
	}

	// Compare results are -1 the object is less than, 0 both are equals, 1 is
	// greater than the other.

	@DisplayName(DISPLAY_NAME_COMPARE_2_SUCCESS)
	@ParameterizedTest(name = DISPLAY_PARAM_NAME_TEST)
	@MethodSource(TEST_MATCH_PRODUCTS)
	public void compare2SameProductsEqualSuccessTest(Product product1, Product product2) {
		assertEquals(0, productComparator.compare(product1, product2));
	}

	@DisplayName(DISPLAY_NAME_COMPARE_2_FAIL)
	@ParameterizedTest(name = DISPLAY_PARAM_NAME_TEST)
	@MethodSource(TEST_NON_MATCH_PRODUCTS)
	public void compare2DifferentProductsNotEqualSuccessTest(Product product1, Product product2) {
		assertNotEquals(0, productComparator.compare(product1, product2));
	}

	// TODO improve to make it a parameterized test here
	@DisplayName(DISPLAY_NAME_LOWEST_PRODUCT_SUCCESS)
	@Test
	public void returnSortedLowestPriceSuccessTest() {

		Product sweetApple1 = new Product(APPLE_NAME_1, 1.5);
		Product sweetApple2 = new Product(APPLE_NAME_3, 1.55);
		Product iPhone1 = new Product(PHONE_NAME_1, 1200.00);
		Product iPhone2 = new Product(PHONE_NAME_2, 999.99);
		Product pineapple1 = new Product(PINEAPPLE_NAME_1, 2.75);
		Product pineapple2 = new Product(PINEAPPLE_NAME_3, 1.55);

		List<Product> apples = Arrays.asList(sweetApple1, sweetApple2);
		List<Product> phones = Arrays.asList(iPhone1, iPhone2);
		List<Product> pineapples = Arrays.asList(pineapple1, pineapple2);

		assertEquals(sweetApple1, productComparator.returnSortedLowestPrice(apples));
		assertEquals(iPhone2, productComparator.returnSortedLowestPrice(phones));
		assertEquals(pineapple2, productComparator.returnSortedLowestPrice(pineapples));
	}

}
