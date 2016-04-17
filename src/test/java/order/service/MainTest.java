package order.service;

import main.Screen;

/**
 * Created by sjshin on 2016-04-17.
 */
public class MainTest {
	public static void main(String[] args) {
		String param = "123456,tmon,C2,H|1|C2";
		String[] dataOrder = param.split(",");
		String[] deat2 = dataOrder[3].split("\\|");
		System.out.println(Screen.ANSI_PURPLE
				+"\ndataOrder[0] "+ dataOrder[0]
				+"\ndataOrder[1] "+ dataOrder[1]
				+"\ndataOrder[2] "+ dataOrder[2]
				+"\ndataOrder[3] "+ dataOrder[3]
				+"\ndeat2[0] "+ deat2[0]
				+"\ndeat2[1] "+ deat2[1]
				+"\ndeat2[2] "+ deat2[2]
		+ Screen.ANSI_RESET);

		String i = "0";
//		if(i ==)

	}
}
