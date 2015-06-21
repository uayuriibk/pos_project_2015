package com.yuriyb.pointofsale.devices;

public class LCDDisplay implements IDisplay {
	
	private static IDisplay instance = new LCDDisplay();
	
	private LCDDisplay(){
	}
	
	public static synchronized IDisplay getInstance(){
		return instance;
	}
	
	public void showMessage(String message){
		System.out.println("LCDDisplay: "+message);
	}
}
