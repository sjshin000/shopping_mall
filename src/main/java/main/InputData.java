package main;

import java.util.Scanner;

/**
 * Created by sjshin on 2016-04-13.
 */
public class InputData {
	public int inputInt() {
		Scanner input = new Scanner(System.in);
		int inputDatas = input.nextInt();
		return inputDatas;
	}

	public String inputString() {
		Scanner input = new Scanner(System.in);
		String inputDatas = input.next();
		return inputDatas;
	}
}
