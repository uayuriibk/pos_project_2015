package com.yuriyb.pointofsale.exceptions;

/**
 * InvalidBarCodeException class
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public class InvalidBarCodeException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4552987095348667371L;

	/**
	 * * Creates InvalidBarCodeException instance
	 * */
	public InvalidBarCodeException(){		
	}
		
	/**
	 * * Creates InvalidBarCodeException instance and put the parameter into super class instance
	 * */
	public InvalidBarCodeException(String message){
		super(message);
	}
}
