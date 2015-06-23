package com.yuriyb.pointofsale.handlers;

/**
 * Handler interface which will be implemented by handlers
 * @version 1.80 12 April 2015
 * @author  Yuriy B.
 */
public interface Handler {
	public void setNext(Handler nextInChain);
	public void process(String scanedCode);
}
