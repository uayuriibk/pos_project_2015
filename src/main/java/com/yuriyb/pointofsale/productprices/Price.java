package com.yuriyb.pointofsale.productprices;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Price class. It describes product price. It includes currency.
 * @version 1.05 22 June 2015
 * @author  Yuriy B.
 */
public class Price {

	private BigDecimal value;
	private Currency currency;
	
	/**
	 * Constructor of Price. It creates a new Price with specified <tt>value</tt> and <tt>currency</tt>.
	 * 
	 * @param value    price value
     * @param currency defines the currency of the price
	 */
	public Price(BigDecimal value, Currency currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
     * Creates a new Price with specified <tt>value</tt> in US currency.
     *
     * @param value price value
     */
	public Price(BigDecimal value){
		this.value = value;
		currency = Currency.getInstance(Locale.US);
	}
	
	/**
     * Gets the value of the price.
     */
	public BigDecimal getValue() {
		return value;
	}

	/**
     * Sets the value of the price.
     */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
     * Gets the currency of the price.
     */
	public Currency getCurrency() {
		return currency;
	}

	/**
     * Sets the currency of the price.
     */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	/**
     * Overriden toString() method for class Price
     */
	@Override
	public String toString(){
		return value + currency.getSymbol();
	}
}
