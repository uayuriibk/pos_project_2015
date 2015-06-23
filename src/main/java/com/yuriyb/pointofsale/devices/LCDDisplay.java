package com.yuriyb.pointofsale.devices;

/**
 * LCDDisplay class which implements IDisplay interface
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public class LCDDisplay implements IDisplay {
	public void showMessage(String message){
		System.out.println("LCDDisplay: "+message);
	}
}
