package com.yuriyb.pointofsale.tests.module;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.IScanner;
import com.yuriyb.pointofsale.handlers.Handler;

public class PointOfSaleTest {
	
	PointOfSale pos;
	IDisplay displayMock;
	IPrinter printerMock;
	IScanner scanerMock;
	private List<Handler> handlers;
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testSOMETHIN(){
		//when()
	}
	
}
