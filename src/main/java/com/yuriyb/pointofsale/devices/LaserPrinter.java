package com.yuriyb.pointofsale.devices;

public class LaserPrinter implements IPrinter {
	public void printMessage(String message){
		System.out.println("LaserPrinter :"+message);
	}
}
