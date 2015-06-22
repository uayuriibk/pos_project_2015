package com.yuriyb.pointofsale.devices;

public class LCDDisplay implements IDisplay {
	
	public void showMessage(String message){
		System.out.println("LCDDisplay: "+message);
	}
}
