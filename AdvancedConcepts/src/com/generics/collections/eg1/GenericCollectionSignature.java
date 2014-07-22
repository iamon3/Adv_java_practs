package com.generics.collections.eg1;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionSignature {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<Car>();
		ArrayList<? extends Vehicle> cars1 = new ArrayList<Car>();
		cars1.add(new Car());
	}
}


class Vehicle{}

class Car extends Vehicle{}

class Truck extends Vehicle{}