package com.overloadOverride.staticEg1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Parent p1 = new Child();
		Child c = new Child();
		p.mtd(5);
		p1.mtd(10);
		c.mtd(15);
	}

}
