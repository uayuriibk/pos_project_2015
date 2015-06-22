package com.yuriyb.pointofsale.tests.integration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.PointOfSaleBuilder;
import com.yuriyb.pointofsale.PointOfSaleBuildingDirector;
import com.yuriyb.pointofsale.StandartPointOfSaleBuilder;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.IScaner;
import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;
import com.yuriyb.pointofsale.productprices.ProductsInfoDB;

public class POSMessagesOutputingInteractionChekingTest {
	
	IPrinter printerMock;
	IDisplay displayMock;
	IScaner scanerMock;
	IProductsInfoDB productInfoDBMock;
	
	@Before
	public void setUp(){
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	   
	    printerMock = Mockito.spy(new LaserPrinter());
		displayMock = Mockito.spy(new LCDDisplay());
		scanerMock = Mockito.spy(new BarCodesScaner());
		scanerMock = Mockito.spy(new BarCodesScaner());
		
	    PointOfSale.getInstance().setPrinter(printerMock);
	    PointOfSale.getInstance().setDisplay(displayMock);
	    PointOfSale.getInstance().setScaner(scanerMock);
	    director.getPointOfSale().getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
	}
	
	@Test
	public void checkMessagesDisplayingAfterProductNotFoundException(){
		PointOfSale.getInstance().processInput("X");
		verify(displayMock).showMessage("Product not found");
	}
	
	@Test
	public void checkMessagesDisplayingAfterInvalidBarCodeException(){
		PointOfSale.getInstance().processInput("");
		verify(displayMock).showMessage("Invalid bar-code");
	}
	
	@Test
	public void checkMessagesPrintingAndDisplayingAfterExitInput(){
		
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		
		for(String input:inputData){
			PointOfSale.getInstance().processInput(input);
		}
		
		verify(printerMock).printMessage("Total Price:3;");
		verify(displayMock).showMessage("1,Apple,price:1;2,Banan,price:2;Total Price:3;");
	}
	
	@Test
	public void checkSettingOfProductsInfoIntoScaner(){
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		verify(scanerMock, timeout(100).times(1)).setProductsPrices(notNull(ProductsInfoDB.class));
	}
	
	@Test
	public void checkScaningByScanerTwoTimes() throws ProductNotFoundException, InvalidBarCodeException{
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		
		for(String input:inputData){
			PointOfSale.getInstance().processInput(input);
		}
		
		verify(scanerMock, timeout(100).times(2)).scan(anyString());
	}
	
	@Test
	public void checkProvidingOfReceiptByScanerOneTime(){
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		
		for(String input: inputData){
			PointOfSale.getInstance().processInput(input);
		}
		
		verify(scanerMock, timeout(100).times(1)).getReceipt();
	}
	
	@Test
	public void checkCallingByScannerCalculateTotalPriceOneTime(){
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		
		for(String input: inputData){
			PointOfSale.getInstance().processInput(input);
		}
		
		verify(scanerMock, timeout(100).times(1)).calculateTotalPrice();
	}
}
