package com.yuriyb.pointofsale.devices;

import java.math.BigDecimal;
import java.util.Map;

import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;

/**
 * IScanner interface. It contains methods of scanner for implementation
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public interface IScanner {
	public void scan(String productCode) throws ProductNotFoundException, InvalidBarCodeException;
	public void setProductsPrices(IProductsInfoDB productsInfoDB);
	public void clearScanned();
	public Map<String, String> getReceipt();
	public BigDecimal calculateTotalPrice();
}
