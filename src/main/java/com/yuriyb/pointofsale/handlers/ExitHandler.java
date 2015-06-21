package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;

public class ExitHandler implements Handler {
	
	private Handler nextInChainHandler;

	@Override
	public void setNext(Handler nextInChain) {
		this.nextInChainHandler = nextInChain;
	}

	@Override
	public void process(String input) throws UndefinedProductException {
		if (input == "exit"){
			LCDDisplay.getInstance().showMessage(" "+BarCodesScaner.getInstance().calculateTotalPrice());
			LaserPrinter.getInstance().printMessage(""+BarCodesScaner.getInstance().calculateTotalPrice());
		} else {
			nextInChainHandler.process(input);
		}
	}
}