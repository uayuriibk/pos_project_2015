package com.yuriyb.pointofsale.productprices;


/**
 * Product class. It describes product.
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
public class Product {
	
	private String code;
	
	private String title;
	
	private Price price;
	
	/**
     * Creates the Product and fills fields.
     *
     * @param code  product's code
     * @param title product title
     */
	public Product (String code, String title, Price price) {
		this.code = code;
		this.title = title;
		this.price = price;
	}
	
	/**
     * Gets the code of the product
     */
	public String getCode() {
		return code;
	}
	
	/**
     * Sets the code of the product
     */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
     * Gets the title of the product
     */
	public String getTitle() {
		return title;
	}
	
	/**
     * Sets the title of the product
     */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
     * Gets the price of the product
     */
	public Price getPrice() {
		return price;
	}
	
	/**
     * Sets the price of the product
     */
	public void setPrice(Price price){
		this.price = price;
	}
}
