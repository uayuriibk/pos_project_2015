package com.yuriyb.pointofsale;

import java.util.ArrayList;
import java.util.List;

import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.handlers.ExitHandler;
import com.yuriyb.pointofsale.handlers.Handler;
import com.yuriyb.pointofsale.handlers.ScanBarCodeHandler;

/**
 * StandartPointOfSaleBuilder class. It is used for PointOfSale construction according to
 * the patter Builder. It is the custom version of the object construction in ordinary cases
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
public class StandartPointOfSaleBuilder extends PointOfSaleBuilder {

	@Override
	public void buildDisplay() {
		pos.setDisplay(new LCDDisplay());
	}

	@Override
	public void buildPrinter() {
		pos.setPrinter(new LaserPrinter());
	}

	@Override
	public void buildScaner() {
		pos.setScaner(new BarCodesScaner());	
	}

	@Override
	public void buildHandlersChain() {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(new ExitHandler());
		handlers.add(new ScanBarCodeHandler());
		pos.setHandlersChain(handlers);
	}
}
