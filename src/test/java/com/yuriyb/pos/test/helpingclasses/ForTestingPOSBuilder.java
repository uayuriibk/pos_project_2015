package com.yuriyb.pos.test.helpingclasses;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import com.yuriyb.pointofsale.PointOfSaleBuilder;
import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.IScanner;
import com.yuriyb.pointofsale.handlers.Handler;

//this class in fact is not needed. It was using for experiments only
public class ForTestingPOSBuilder extends PointOfSaleBuilder {

	@Override
	public void buildDisplay() {
		pos.setDisplay(Mockito.mock(IDisplay.class));
	}

	@Override
	public void buildPrinter() {
		pos.setPrinter(Mockito.mock(IPrinter.class));
	}

	@Override
	public void buildScaner() {
		pos.setScaner(Mockito.mock(IScanner.class));	
	}

	@Override
	public void buildHandlersChain() {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(Mockito.mock(Handler.class));
		handlers.add(Mockito.mock(Handler.class));
		pos.setHandlersChain(handlers);
	}
}