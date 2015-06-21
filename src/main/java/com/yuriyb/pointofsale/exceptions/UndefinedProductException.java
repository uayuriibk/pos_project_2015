package com.yuriyb.pointofsale.exceptions;

/**
 * UndefinedProductException class. Written checked exception.
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public class UndefinedProductException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2892594339356126640L;

	/**
     * Creates UndefinedProductException instance
     */
	public UndefinedProductException(){		
	}
	
	/**
     * Creates UndefinedProductException instance and put the parameter into super class instance
     */
	public UndefinedProductException(String message){
		super(message);
	}
}
