package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
			}else {
				return a+b;
			}
	}

	// This method is to test whether two integers produce 
	public int moduloEven(int a, int b) {
		if(a % b != 0) {
			throw new IllegalArgumentException("Remainder must be even.");
		}else {
			return a%b;
	}
	}	
	public int randomNumberSquared() {
		int a = getRandomInt();
		return a*a;
		
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
}
}