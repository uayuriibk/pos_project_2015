package com.yuriyb.pointofsale.tests.integration;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

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
import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;

public class POSScanExitTest {
	
	@Before
	public void setUp(){
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	    director.getPointOfSale().getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
	}
	
	@Test
	public void checkSize(){
		List<String> inputData = new ArrayList<String>();
		for(String input:inputData){
			PointOfSale.getInstance().processInput(input);
		}
	}
	
	@Test
	public void scanCodes1(){
		IPrinter printerSpy = Mockito.spy(LaserPrinter.getInstance());
		IDisplay displaySpy = Mockito.spy(LCDDisplay.getInstance());
		List<String> inputData = new ArrayList<String>();
		inputData.add("A");
		inputData.add("B");
		inputData.add("exit");
		for(String input:inputData){
			PointOfSale.getInstance().processInput(input);
		}
		
		verify(printerSpy).printMessage("");//доробити
		verify(displaySpy).showMessage("");
	}
	
	@Test
	public void scanCodes(){
		List<String> inputData = new ArrayList<String>();
		for(String input:inputData){
			PointOfSale.getInstance().processInput(input);
		}
	}
	
}
