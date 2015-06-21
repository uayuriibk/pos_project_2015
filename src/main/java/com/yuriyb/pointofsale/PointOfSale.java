package com.yuriyb.pointofsale;

import java.util.List;

import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.IScaner;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
import com.yuriyb.pointofsale.handlers.Handler;

public class PointOfSale {

	private static PointOfSale instance = new PointOfSale();
	private IDisplay display;
	private IPrinter printer;
	private IScaner  scaner;
	private List<Handler> handlers; 
	
	public PointOfSale(){
	}
	
	public IDisplay getDisplay() {
		return display;
	}
	
	public void setDisplay(IDisplay display) {
		this.display = display;
	}
	
	public IPrinter getPrinter() {
		return printer;
	}
	
	public void setPrinter(IPrinter printer) {
		this.printer = printer;
	}
	
	public IScaner getScaner() {
		return scaner;
	}
	
	public void setScaner(IScaner scaner) {
		this.scaner = scaner;
	}
	
	public static synchronized PointOfSale getInstance(){
		return instance;	
	}
	
	/**
     * Setting of handlers
     *
     */
	public void setHandlersChain(List<Handler> handlers){
		this.handlers = handlers;
		for(int i=0; i<handlers.size()-1; i++){
			handlers.get(i).setNext(handlers.get(i+1));
		}
	}
	
	/**
     * Process input
     *
     * @param input  input signal 
     */
	public void processInput(String input) {
		try {
			handlers.get(0).process(input);
		} catch (UndefinedProductException e) {
			e.printStackTrace();
		}
	}
}
