package com.yuriyb.pointofsale.devices;

/**
 * LaserPrinter class
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public class LaserPrinter implements IPrinter {
	public void printMessage(String message){
		System.out.println("LaserPrinter :"+message);
	}
}
