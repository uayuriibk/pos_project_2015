package com.yuriyb.pos.test.helpingclasses;

import java.math.BigDecimal;

import com.yuriyb.pointofsale.PointOfSale;
import com.yuriyb.pointofsale.PointOfSaleBuilder;
import com.yuriyb.pointofsale.PointOfSaleBuildingDirector;
import com.yuriyb.pointofsale.StandartPointOfSaleBuilder;
import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;
import com.yuriyb.pointofsale.productprices.Price;
import com.yuriyb.pointofsale.productprices.Product;
import com.yuriyb.pointofsale.productprices.ProductsInfoDB;

// this class in fact is not needed. It was using in the beginning for previous testing of code
public class Main {

	public static void main(String[] args) throws ProductNotFoundException {
		IProductsInfoDB pidb = new ProductsInfoDB();
		Product product1 = new Product("A", "A product", new Price(new BigDecimal(13.25)));
		Product product2 = new Product("B", "B product", new Price(new BigDecimal(13.25)));
		pidb.addProduct(product1);
		pidb.addProduct(product2);
		
		PointOfSaleBuildingDirector director = new PointOfSaleBuildingDirector();
		PointOfSaleBuilder standartPointOfSale = new StandartPointOfSaleBuilder();
		director.setPointOfSaleBuilder(standartPointOfSale);
		director.constructPointOfSale();
	    director.getPointOfSale().getScaner().setProductsPrices(pidb);
	    
		PointOfSale.getInstance().processInput("A");
		PointOfSale.getInstance().processInput("B");
		PointOfSale.getInstance().processInput("");
		PointOfSale.getInstance().processInput("C");
		PointOfSale.getInstance().processInput(null);
		
		System.out.println(PointOfSale.getInstance().getScaner().calculateTotalPrice());
	}

}
