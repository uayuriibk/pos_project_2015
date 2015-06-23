package com.yuriyb.pointofsale;

/**
 * PointOfSaleBuildingDirector class. It is used for PointOfSale construction according to
 * the patter Builder
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
public class PointOfSaleBuildingDirector {
		private PointOfSaleBuilder pointOfSaleBuilder;
		
		public void setPointOfSaleBuilder(PointOfSaleBuilder pointOfSaleBuilder){
			this.pointOfSaleBuilder = pointOfSaleBuilder;
		}
		
		public PointOfSale getPointOfSale(){
			return pointOfSaleBuilder.getPointOfSale();
		}
		
		public void constructPointOfSale(){
			pointOfSaleBuilder.createNewPointOfSale();
			pointOfSaleBuilder.buildScaner();
			pointOfSaleBuilder.buildDisplay();
			pointOfSaleBuilder.buildPrinter();
			pointOfSaleBuilder.buildHandlersChain();
		}
}
