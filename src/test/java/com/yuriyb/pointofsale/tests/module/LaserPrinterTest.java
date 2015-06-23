package com.yuriyb.pointofsale.tests.module;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.LaserPrinter;

public class LaserPrinterTest {
	
	private IPrinter printer;
	private IPrinter printerSpy;
	
	@Before
	public void setUp(){
		printer = new LaserPrinter();
		printerSpy = Mockito.spy(printer);
	}
	
	@Test
	public void checkMessageShowingByDisplay(){
		printerSpy.printMessage("Test");
		verify(printerSpy).printMessage("Test");
	}
}
