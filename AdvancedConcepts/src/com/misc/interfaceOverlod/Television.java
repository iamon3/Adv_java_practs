package com.misc.interfaceOverlod;

public class Television implements Watchable {
	int count=5;
	public int getWatchedCount(){
		return count;
	}
	
	public int getTVWatchedCount(){
		return Watchable.count;
	} 
}
