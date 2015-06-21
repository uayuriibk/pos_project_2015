package com.yuriyb.pointofsale;

public class PointOfSaleBuildingDirector {
		private PointOfSaleBuilder pointOfSaleBuilder;
		
		public void setPointOfSaleBuilder(PointOfSaleBuilder pointOfSaleBuilder){
			this.pointOfSaleBuilder = pointOfSaleBuilder;
		}
		
		public PointOfSale getPointOfSale(){
			return pointOfSaleBuilder.getPointOfSale();
		}
		
		public void constructConstructPointOfSale(){
			pointOfSaleBuilder.createNewPointOfSale();
			pointOfSaleBuilder.buildScaner();
			pointOfSaleBuilder.buildDisplay();
			pointOfSaleBuilder.buildPrinter();
			pointOfSaleBuilder.buildHandlersChain();
		}
}
