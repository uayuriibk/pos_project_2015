package com.yuriyb.pointofsale;

/**
 * PointOfSaleBuilder class. It is used for PointOfSale construction according to
 * the patter Builder
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
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
