/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing a product or item
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	private String name;
	private double price;

}
