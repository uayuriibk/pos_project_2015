package com.yuriyb.pointofsale.exceptions;

public class InvalidBarCodeException extends Exception {

	/**
	 * 
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
