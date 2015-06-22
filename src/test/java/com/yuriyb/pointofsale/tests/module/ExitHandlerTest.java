package com.yuriyb.pointofsale.tests.module;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.handlers.ExitHandler;
import com.yuriyb.pointofsale.handlers.Handler;

public class ExitHandlerTest {
	
	Handler exitHandler;
	Handler nextHandler;
	
	@Before
	public void setUp(){
		exitHandler = new ExitHandler();
	}
	
	@Test
	public void testExitHandlerSkipsProcessing() throws ProductNotFoundException{
		nextHandler = Mockito.mock(Handler.class); 
		exitHandler.setNext(nextHandler);
		exitHandler.process("Test");
		verify(nextHandler).process("Test");
	}
}
