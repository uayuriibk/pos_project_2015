package com.yuriyb.pointofsale;

import java.math.BigDecimal;

import com.yuriyb.pointofsale.devices.IDisplay;
import com.yuriyb.pointofsale.devices.IPrinter;
import com.yuriyb.pointofsale.devices.IScaner;
import com.yuriyb.pointofsale.devices.LCDDisplay;
import com.yuriyb.pointofsale.devices.LaserPrinter;
import com.yuriyb.pointofsale.devices.BarCodesScaner;
import com.yuriyb.pointofsale.exceptions.UndefinedProductException;
import com.yuriyb.pointofsale.productprices.IProductsInfoDB;
import com.yuriyb.pointofsale.productprices.Price;
import com.yuriyb.pointofsale.productprices.Product;
import com.yuriyb.pointofsale.productprices.ProductsInfoDB;

public class Main {

	public static void main(String[] args) throws UndefinedProductException {
	
		PointOfSale pos = new PointOfSale();
		IProductsInfoDB pidb = new ProductsInfoDB();
		Product product1 = new Product("A", "A product", new Price(new BigDecimal(13.25)));
		Product product2 = new Product("B", "B product", new Price(new BigDecimal(13.25)));
		pidb.addProduct(product1);
		pidb.addProduct(product2);
		
		IDisplay display = LCDDisplay.getInstance();
		IPrinter printer = LaserPrinter.getInstance();
		BarCodesScaner.getInstance().setProductsPrices(pidb);
		
		pos.setDisplay(display);
		pos.setPrinter(printer);
		pos.setScaner(BarCodesScaner.getInstance());
		pos.processInput("A");
		pos.processInput("B");
		pos.processInput("");
		pos.processInput("C");
		pos.processInput(null);
		
		System.out.println(BarCodesScaner.getInstance().calculateTotalPrice());
	}

}
