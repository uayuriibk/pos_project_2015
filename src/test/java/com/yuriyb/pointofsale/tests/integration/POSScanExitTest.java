package com.yuriyb.pointofsale.tests.integration;

import org.junit.Before;
import org.junit.Test;

import com.yuriyb.pointofsale.PointOfSaleBuilder;
import com.yuriyb.pointofsale.PointOfSaleBuildingDirector;
import com.yuriyb.pointofsale.StandartPointOfSaleBuilder;

public class POSScanExitTest {
	
	@Before
	public void setUp(){
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructConstructPointOfSale();
	    //pos = director.getPointOfSale();
	    //pos.getScaner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
	}
	
	@Test
	public void dsfds(){
		
	}
}
