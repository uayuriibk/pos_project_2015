package com.yuriyb.pointofsale.productprices;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.yuriyb.pointofsale.exceptions.UndefinedProductException;

/**
 * ProductsWithPricesStorage class. It describes storage where products with prices are.
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public class ProductsInfoDB implements IProductsInfoDB {
	
	private Map<String, Product> productsCodesMap = new HashMap<String, Product>();
	
	/**
	 * Constructor of ProductsInfoDB class.
	 * Creates an instance of ProductsInfoDB class.
	 */
	public ProductsInfoDB() {
	}
	
	/**
	 * Constructor of ProductsInfoDB class. 
	 * Creates an instance of ProductsInfoDB class.
	 * Contains parameter <tt>products</tt>
	 * 
	 * @param products   collection of products
	 */
	public ProductsInfoDB(Collection<Product> products) {
		for (Product product : products) {
			productsCodesMap.put(product.getCode(), product);
		}
	}
	
	/**
     * Adds the product into ProductsWithPricesStorage in field productsWithCodesMap
     */
	public void addProduct(Product product){
		productsCodesMap.put(product.getCode(), product);
	}
	
	/**
     * Deletes the product from ProductsWithPricesStorage by product code
     */
	public void deleteProduct(String productCode){
		productsCodesMap.remove(productCode);
	}
	
	/**
     * Gets the product price from ProductsWithPricesStorage by product code
     */
	public Price getPrice(String productCode) {
		return productsCodesMap.get(productCode).getPrice();
	}
	
	/**
     * Checks the product presence in the ProductsWithPricesStorage by product code
     */
	public boolean isPresentInStorage(String productCode){
		Product product = productsCodesMap.get(productCode);
		if (product == null) {
			return false;
		}
		return true;
	}
}
