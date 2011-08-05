package com.collections.connectionWidArray.eg1;

public class Song {
	String name;
	String composer;
	int sId;
	public Song(String nam, String com, int id) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.composer = com;
		this.sId=id;	
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	public String getName(){
		return this.name;
	}
}
