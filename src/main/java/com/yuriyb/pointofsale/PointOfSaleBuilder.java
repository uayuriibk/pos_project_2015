package com.yuriyb.pointofsale;

public abstract class PointOfSaleBuilder {
	
	protected PointOfSale pos;
	
	public PointOfSale getPointOfSale(){
		return pos;
	}
	
	public void createNewPointOfSale(){
		pos = PointOfSale.getInstance();
	}
	
	public abstract void buildDisplay();
	public abstract void buildPrinter();
	public abstract void buildScaner();
	public abstract void buildHandlersChain();
}
