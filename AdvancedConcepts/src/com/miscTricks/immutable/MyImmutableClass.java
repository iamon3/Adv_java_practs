package com.miscTricks.immutable;

public class MyImmutableClass {
  private final int value;
  private final String name;
  public MyImmutableClass(int someVal, String someName) {
	// TODO Auto-generated constructor stub
	  this.value=someVal;
	  this.name=someName;
}
public int getValue() {
	return value;
}
public String getName() {
	return name;
}
public void setValue(int modifyValue) {
	this.value=modifyValue;
}
public void setName(String modifyValue) {
	this.name=modifyValue;
}
  
}
