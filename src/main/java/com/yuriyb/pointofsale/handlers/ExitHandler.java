package com.yuriyb.pointofsale.handlers;

import java.util.Map;

import com.yuriyb.pointofsale.PointOfSale;

/**
 * ExitHandler class
 * @version 1.80 22 June 2015
 * @author  Yuriy B.
 */
public class ExitHandler implements Handler {
	
	private Handler nextInChainHandler;

	@Override
	public void setNext(Handler nextInChain) {
		this.nextInChainHandler = nextInChain;
	}

	@Override
	public void process(String input) {
		if ((null!=input)&&(input=="exit")){
			Map<String,String> receipt = PointOfSale.getInstance().getScaner().getReceipt();
			String boughtProducts =	receipt.get("boughtProducts");
			String totalPriceInReceipt = receipt.get("totalPrice");
			PointOfSale.getInstance().getDisplay().showMessage(boughtProducts+totalPriceInReceipt);
			PointOfSale.getInstance().getPrinter().printMessage(totalPriceInReceipt);
		} else {
			nextInChainHandler.process(input);
		}
	}
}
