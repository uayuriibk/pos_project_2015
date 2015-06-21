package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
import com.yuriyb.pointofsale.devices.BarCodesScaner;

public class ScanBarCodeHandler implements Handler {

	@Override
	public void setNext(Handler nextInChain) {	
	}

	@Override
	public void process(String input) {
		try {
			BarCodesScaner.getInstance().scan(input);
		} catch (UndefinedProductException upe) {
			LCDDisplay.getInstance().showMessage(upe.getMessage());
		} catch (InvalidBarCodeException ibce) {
			LCDDisplay.getInstance().showMessage(ibce.getMessage());
		}
	}
}