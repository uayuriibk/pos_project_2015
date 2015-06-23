package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.exceptions.InvalidBarCodeException;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;

/**
 * ScanBarCodeHandler class
 * @version 1.80 22 June 2015
 * @author  Yuriy B.
 */
public class ScanBarCodeHandler implements Handler {

	@Override
	public void setNext(Handler nextInChain) {
	}

	@Override
	public void process(String input) {
		try {
			PointOfSale.getInstance().getScaner().scan(input);
		} catch (ProductNotFoundException upe) {
			PointOfSale.getInstance().getDisplay().showMessage(upe.getMessage());
		} catch (InvalidBarCodeException ibce) {
			PointOfSale.getInstance().getDisplay().showMessage(ibce.getMessage());
		}
	}
}