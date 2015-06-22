package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
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
			String boughtProducts = PointOfSale.getInstance().getScaner().getReceipt().get("boughtProducts");
			String totalPriceInReceipt = PointOfSale.getInstance().getScaner().getReceipt().get("totalPrice");
			PointOfSale.getInstance().getDisplay().showMessage(boughtProducts+totalPriceInReceipt);
			PointOfSale.getInstance().getPrinter().printMessage(totalPriceInReceipt);
		} else {
			nextInChainHandler.process(input);
		}
	}
}
