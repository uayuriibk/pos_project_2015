package com.yuriyb.pointofsale.tests.module;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.LCDDisplay;

public class LCDDisplayTest {
	
	IDisplay display;
	IDisplay displaySpy;
	
	@Before
	public void setUp(){
		display = new LCDDisplay();
		displaySpy = Mockito.spy(display);
	}
	
	@Test
	public void checkMessageShowingByDisplay(){
		displaySpy.showMessage("Test");
		verify(displaySpy).showMessage("Test");
	}
}
