package com.yuriyb.pointofsale.productprices;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ProductsInfoDB class. It describes storage where products with prices are.
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
public class ProductsInfoDB implements IProductsInfoDB {
	
	private Map<String, Product> productsCodesMap = new HashMap<String, Product>();
	
	/**
	 * Constructor of ProductsInfoDB class.
	 * Creates an instance of ProductsInfoDB class.
	 */
	public ProductsInfoDB() {}
	
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
     * Adds the product into ProductsInfoDB in field productsWithCodesMap
     */
	public void addProduct(Product product){
		productsCodesMap.put(product.getCode(), product);
	}
	
	/**
     * Deletes the product from ProductsInfoDB by product code
     */
	public void deleteProduct(String productCode){
		productsCodesMap.remove(productCode);
	}
	
	/**
     * Gets the product price from ProductsInfoDB by product code
     */
	public Price getPrice(String productCode) {
		return productsCodesMap.get(productCode).getPrice();
	}
	
	/**
     * Gets the product title from ProductsInfoDB by product code
     */
	public String getProductTitle(String productCode) {
		return productsCodesMap.get(productCode).getTitle();
	}
	
	public Map<String, Product> getProductsCodesMap() {
		return productsCodesMap;
	}

	public void setProductsCodesMap(Map<String, Product> productsCodesMap) {
		this.productsCodesMap = productsCodesMap;
	}
	
	/**
     * Checks the product presence in the ProductsInfoDB by product code
     */
	public boolean isPresentInStorage(String productCode){
		Product product = productsCodesMap.get(productCode);
		if (product == null) {
			return false;
		}
		return true;
	}
}
