package com.yuriyb.pointofsale.productprices;

import com.yuriyb.pointofsale.exceptions.UndefinedProductException;

public interface IProductsInfoDB {

	/**
     * Adds the product into ProductsWithPricesStorage in field productsWithCodesMap
     */
	public void addProduct(Product product);

	/**
     * Deletes the product from ProductsWithPricesStorage by product code
     */
	public void deleteProduct(String productCode);

	/**
     * Gets the product price from ProductsWithPricesStorage by product code
	 * @throws UndefinedProductException 
     */
	public Price getPrice(String productCode);

	/**
     * Checks the product presence in the ProductsWithPricesStorage by product code
     */
	public boolean isPresentInStorage(String productCode);
}