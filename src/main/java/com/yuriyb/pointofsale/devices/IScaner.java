package com.yuriyb.pointofsale.devices;

import java.math.BigDecimal;
import java.util.Map;

import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;

public interface IScaner {
	public void scan(String productCode) throws UndefinedProductException, InvalidBarCodeException;
	public void setProductsPrices(IProductsInfoDB productsInfoDB);
	public void clearScanned();
	public Map<String, String> getReceipt() throws UndefinedProductException;
	public BigDecimal calculateTotalPrice() throws UndefinedProductException;
}
