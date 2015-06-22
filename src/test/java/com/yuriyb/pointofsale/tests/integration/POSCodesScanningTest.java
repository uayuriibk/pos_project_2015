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
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
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
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	    director.getPointOfSale().getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
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
