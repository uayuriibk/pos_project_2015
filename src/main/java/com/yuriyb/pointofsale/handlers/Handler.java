package com.yuriyb.pointofsale.handlers;

public interface Handler {
	public void setNext(Handler nextInChain);
	public void process(String scanedCode);
}
