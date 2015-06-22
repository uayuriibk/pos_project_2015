package com.yuriyb.pointofsale.tests.module;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;

import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;
import com.yuriyb.pointofsale.productprices.Price;

public class BarCodeScannerTest {
	
	private BarCodesScaner scanner;
	private IProductsInfoDB productsInfoMock;
	
	@Before
	public void setUp(){
		scanner = new BarCodesScaner();
	}
	
	@After
	public void setDown(){
		scanner = null;
	}
	
	@Test
	public void checkTotalPriceCalculationWillReturn2(){
		productsInfoMock = Mockito.mock(IProductsInfoDB.class);
		scanner.setProductsPrices(productsInfoMock);
		when(productsInfoMock.getPrice(anyString())).thenReturn(new Price(new BigDecimal(1.00)));
		
		List<String> testShopCart = new ArrayList<String>();
		testShopCart.add("testCode");
		testShopCart.add("testCode2");
		
		scanner.setShoppingCart(testShopCart);
		
		BigDecimal expected = new BigDecimal(2.00);
		BigDecimal actual = scanner.calculateTotalPrice();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void checkReceipt(){
		productsInfoMock = Mockito.mock(IProductsInfoDB.class);
		scanner.setProductsPrices(productsInfoMock);
		when(productsInfoMock.getProductTitle(anyString())).thenReturn("TestProduct");
		when(productsInfoMock.getPrice(anyString())).thenReturn(new Price(new BigDecimal(1.00)));
		
		List<String> testShopCart = new ArrayList<String>();
		testShopCart.add("testCode");
		testShopCart.add("testCode2");
		scanner.setShoppingCart(testShopCart);
			
		Map<String,String> expectedReceipt = new HashMap<String,String>();
		expectedReceipt.put("boughtProducts", "1,TestProduct,price:1;2,TestProduct,price:1;");
		expectedReceipt.put("totalPrice", "Total Price:2;");
		Map<String,String> actualReceipt = scanner.getReceipt();
		
		Assert.assertEquals(expectedReceipt, actualReceipt);
	}
	
	@Test(expected=InvalidBarCodeException.class)
	public void checkInvalidBarCodeExceptionThrowing() throws InvalidBarCodeException, ProductNotFoundException{
		scanner.scan("");
	}
	
	@Test(expected=ProductNotFoundException.class)
	public void checkProductNotFoundExceptionThrowing() throws InvalidBarCodeException, ProductNotFoundException{
		productsInfoMock = Mockito.mock(IProductsInfoDB.class);
		scanner.setProductsPrices(productsInfoMock);
		when(productsInfoMock.isPresentInStorage(anyString())).thenReturn(false);
		scanner.scan("X");
	}
	
	@Test
	public void checkScanAndCodeAddingIntoCart() throws InvalidBarCodeException, ProductNotFoundException {
		productsInfoMock = Mockito.mock(IProductsInfoDB.class);
		scanner.setProductsPrices(productsInfoMock);
		when(productsInfoMock.isPresentInStorage(anyString())).thenReturn(true);
		
		List<String> testShopCart = new ArrayList<String>();
		scanner.setShoppingCart(testShopCart);
		scanner.scan("testProduct1");
		scanner.scan("testProduct2");
		
		int expectedShoppingCartSize = 2;
		int actualShoppingCartSize = scanner.getShoppingCart().size();
		
		Assert.assertEquals(expectedShoppingCartSize, actualShoppingCartSize);
	}
	
	
	@Test
	public void checkShopCartClearing() throws InvalidBarCodeException, ProductNotFoundException {
		productsInfoMock = Mockito.mock(IProductsInfoDB.class);
		scanner.setProductsPrices(productsInfoMock);
		when(productsInfoMock.isPresentInStorage(anyString())).thenReturn(true);
		
		List<String> testShopCart = new ArrayList<String>();
		scanner.setShoppingCart(testShopCart);
		scanner.scan("testProduct1");
		scanner.clearScanned();
		
		int expectedShoppingCartSize = 0;
		int actualShoppingCartSize = scanner.getShoppingCart().size();
		
		Assert.assertEquals(expectedShoppingCartSize, actualShoppingCartSize);
	}
}
