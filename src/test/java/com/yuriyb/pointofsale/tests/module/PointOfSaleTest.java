package com.yuriyb.pointofsale.tests.module;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.handlers.ExitHandler;
import com.yuriyb.pointofsale.handlers.Handler;
import com.yuriyb.pointofsale.handlers.ScanBarCodeHandler;

public class PointOfSaleTest {
	
	private PointOfSale pos;
	
	@Before
	public void setUp(){
		pos = PointOfSale.getInstance();
	}
	
	@Test
	public void testInputProcessingByFirstHandlerInTheChain() throws ProductNotFoundException{
		Handler exitHandlerMock = Mockito.mock(ExitHandler.class);
		Handler scanBarCodeHandlerMock = Mockito.mock(ScanBarCodeHandler.class);
		
		List<Handler> handlersCollection = new ArrayList<Handler>();
		
		handlersCollection.add(exitHandlerMock);
		handlersCollection.add(scanBarCodeHandlerMock);
		pos.setHandlersChain(handlersCollection);
		pos.processInput("Test Input");
		
		verify(exitHandlerMock, times(1)).process(anyString());
		verify(scanBarCodeHandlerMock, times(0)).process(anyString());
	}
}
