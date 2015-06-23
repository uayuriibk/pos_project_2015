package com.yuriyb.pointofsale.tests.integration;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;
import com.yuriyb.pointofsale.productprices.Price;
import com.yuriyb.pointofsale.productprices.Product;
import com.yuriyb.pointofsale.productprices.ProductsInfoDB;

/**
 * DataForTestUtil class. Utility class which provides data for testing
 * @version 1.80 22 June 2015
 * @author  Yuriy B.
 */
public class DataForTestUtility {
	
	 /**
     * Gets product codes to scan and data for tests
     */
	public static Collection<Object[]> getData() {
		Collection<Object[]> inputData = new LinkedList<Object[]>();
		inputData.add(new Object[] { splitToTheLetters("ABCDAB"), new BigDecimal(13.00)});
		inputData.add(new Object[] { splitToTheLetters("CCCCC"), new BigDecimal(15.0)});
		inputData.add(new Object[] { splitToTheLetters("ABCD"), new BigDecimal(10.00)});
		return inputData;
	}
	
	/**
     * Gets the storage of products with prices
     */
	public static IProductsInfoDB getProductsInfoDB() {
		return new ProductsInfoDB(getProducts());
	}
	
	/**
     * Get the collection of products
     */
	public static Collection<Product> getProducts() {
		Collection<Product> products = new LinkedList<Product>();
		products.add(getProductA());
		products.add(getProductB());
		products.add(getProductC());
		products.add(getProductD());
		return products;
	}
	
	/**
     * Gets the product A
     */
	public static Product getProductA() {
		Price price = new Price(new BigDecimal(1.00));
		Product product = new Product ("A", "Apple", price);
		return product;
	}
	
	/**
     * Gets the product B
     */
	public static Product getProductB() {
		Price price = new Price(new BigDecimal(2.00));
		Product product = new Product ("B", "Banan", price);
		return product;
	}
	
	/**
     * Gets the product C
     */
	public static Product getProductC() {
		Price price = new Price(new BigDecimal(3.00));
		Product product = new Product ("C", "Cucumber", price);
		return product;
	}
	
	/**
     * Gets the product D
     */
	public static Product getProductD() {
		Price price = new Price(new BigDecimal(4.00));
		Product product = new Product ("D", "Dirol", price);
		return product;
	}
	
	/**
     * Gets the array of letters for scanning
     */
	public static String[] splitToTheLetters(String source) {
		String splittedLetters[] = new String[source.length()];
		char[] chars = source.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			splittedLetters[i] = Character.toString(chars[i]);
		}
		return splittedLetters;
	}
}