package com.yuriyb.pointofsale.tests.integration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.devices.IScaner;
import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
import com.yuriyb.pointofsale.handlers.ExitHandler;
import com.yuriyb.pointofsale.handlers.Handler;
import com.yuriyb.pointofsale.handlers.ScanBarCodeHandler;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * PointOfSaleTerminalTest class. It has several test methods.
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
@RunWith(Parameterized.class)
public class POSCodesScanningTest {
	private String[] codesForScanning;
	private BigDecimal expectedResult;
	private PointOfSale pos;
	
	/**
	 * Constructor of PointOfSaleTerminalTest class. Creates the instance of this class. 
	 */
	public POSCodesScanningTest(String[] toScan, BigDecimal expectedResult){
		this.codesForScanning = toScan;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp(){
/*		pos = new PointOfSale();
		pos.setScaner(Scaner.getInstance());
		pos.getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
		pos.setDisplay(LCDDisplay.getInstance());
		pos.setPrinter(LaserPrinter.getInstance());*/
	}
	
	@After
	public void clearShopingCart(){
		pos.getScaner().clearScanned();
	}
	
	/**
	 * Test method. Verifies the correctness of calculations of total sum
	 * @throws UndefinedProductException 
	 */
	@Test
	public void successfulGetTotal() throws UndefinedProductException {
		for (String code : codesForScanning) {
			pos.processInput(code);
		}
		assertEquals(expectedResult, BarCodesScaner.getInstance().calculateTotalPrice());
	}
	
	/**
	 * Returns the parameters which will be used by constructor of PointOfSaleTerminalTest class
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return DataForTestUtility.getData();
	}
}
