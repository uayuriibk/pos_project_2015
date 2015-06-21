package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.exceptions.UndefinedProductException;

public interface Handler {
	public abstract void setNext(Handler nextInChain);
	public abstract void process(String scanedCode) throws UndefinedProductException;
}
