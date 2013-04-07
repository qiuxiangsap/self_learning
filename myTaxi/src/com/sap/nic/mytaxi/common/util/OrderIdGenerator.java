/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 */
package com.sap.nic.mytaxi.common.util;

import java.util.Random;

public class OrderIdGenerator {
	
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	private static int CL_ORDER_LENGTH = 50;
	private static int CT_ORDER_LENGTH = 25;
	
	public static String createClOrderId(){
		return randomString(CL_ORDER_LENGTH);
	}
	
	public static String createCtOrderId(){
		return randomString(CT_ORDER_LENGTH);
	}
	
	private static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        if (randGen == null) {
               randGen = new Random();
               numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                 
                }
        char [] randBuffer = new char[length];
        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
}
}
