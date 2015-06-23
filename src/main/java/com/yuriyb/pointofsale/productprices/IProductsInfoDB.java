package com.yuriyb.pointofsale.productprices;

import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;

/**
 * IProductsInfoDB interface
 * @version 1.80 22 June 2015
 * @author  Yuriy B.
 */
public interface IProductsInfoDB {

	/**
     * Adds the product into IProductsInfoDB in field productsWithCodesMap
     */
	public void addProduct(Product product);

	/**
     * Deletes the product from IProductsInfoDB by product code
     */
	public void deleteProduct(String productCode);

	/**
     * Gets the product price from IProductsInfoDB by product code
	 * @throws ProductNotFoundException 
     */
	public Price getPrice(String productCode);
	
	/**
     * Gets the product title from IProductsInfoDB by product code
	 * @throws ProductNotFoundException 
     */
	public String getProductTitle(String productCode);

	/**
     * Checks the product presence in the IProductsInfoDB by product code
     */
	public boolean isPresentInStorage(String productCode);
}
