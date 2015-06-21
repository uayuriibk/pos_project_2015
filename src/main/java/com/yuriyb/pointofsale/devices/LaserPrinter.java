package com.yuriyb.pointofsale.devices;

public class LaserPrinter implements IPrinter {
	
	private static IPrinter instance = new LaserPrinter();
	
	private LaserPrinter(){
	}
	
	public static synchronized IPrinter getInstance(){
		return instance;
	}
	public void printMessage(String message){
		System.out.println("LaserPrinter :"+message);
	}
}
