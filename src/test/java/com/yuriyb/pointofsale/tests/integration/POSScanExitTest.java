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
import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;

public class POSScanExitTest {
	
	IPrinter printerMock;
	IDisplay displayMock;
	
	@Before
	public void setUp(){
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	    director.getPointOfSale().getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
	    
	    printerMock = Mockito.mock(IPrinter.class);
		displayMock = Mockito.mock(IDisplay.class);
		
	    PointOfSale.getInstance().setPrinter(printerMock);
	    PointOfSale.getInstance().setDisplay(displayMock);
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
}
