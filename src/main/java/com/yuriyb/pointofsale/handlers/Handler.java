package com.yuriyb.pointofsale.handlers;

import com.yuriyb.pointofsale.exceptions.ProductNotFoundException;

public interface Handler {
	public void setNext(Handler nextInChain);
	public void process(String scanedCode);
}
