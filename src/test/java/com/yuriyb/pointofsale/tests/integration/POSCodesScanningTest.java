package com.yuriyb.pointofsale.tests.integration;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.PointOfSaleBuilder;
import com.yuriyb.pointofsale.PointOfSaleBuildingDirector;
import com.yuriyb.pointofsale.StandartPointOfSaleBuilder;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * PointOfSaleTerminalTest class. It has several test methods.
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
@RunWith(Parameterized.class)
public class POSCodesScanningTest {
	private String[] codesForScanning;
	private BigDecimal expectedResult;
	
	/**
	 * Constructor of PointOfSaleTerminalTest class. Creates the instance of this class. 
	 */
	public POSCodesScanningTest(String[] toScan, BigDecimal expectedResult){
		this.codesForScanning = toScan;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp(){
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	    director.getPointOfSale().getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
	}
	
	@After
	public void clearShopingCart(){
		PointOfSale.getInstance().getScaner().clearScanned();
	}
	
	/**
	 * Test method. Verifies the correctness of calculations of total sum
	 * @throws ProductNotFoundException 
	 */
	@Test
	public void successfulGetTotal() throws ProductNotFoundException {
		for (String code : codesForScanning) {
			PointOfSale.getInstance().processInput(code);
		}
		assertEquals(expectedResult, PointOfSale.getInstance().getScaner().calculateTotalPrice());
	}
	
	/**
	 * Returns the parameters which will be used by constructor of PointOfSaleTerminalTest class
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return DataForTestUtility.getData();
	}
}
