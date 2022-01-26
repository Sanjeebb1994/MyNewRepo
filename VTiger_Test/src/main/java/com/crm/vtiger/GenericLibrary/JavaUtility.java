/**
 * 
 */
package com.crm.vtiger.GenericLibrary;

import java.util.Date;
import java.util.Random;


/**
 * @author DELL
 *
 */
public class JavaUtility {
	/**
	 * This method is use to generate RandomNumber.
	 * @param num
	 * @return
	 */
	public int getRandomNum(int num) {
		Random random=new Random();
		return random.nextInt(num);
	}
	
	/**
	 * This Method is Use to Give Complete Date Format.
	 * @return
	 */
	public String getDateAndTimeFormate(){
		Date dt=new Date();
		String formate=dt.toString();
		String yyyy=formate.split(" ")[5];
		String dd=formate.split(" ")[2];
		int mm=dt.getMonth()+1;
		String finalFormat=yyyy+"_"+mm+"_"+dd;
		return finalFormat;
	}
}
