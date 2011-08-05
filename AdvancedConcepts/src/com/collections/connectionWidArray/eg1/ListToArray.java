package com.collections.connectionWidArray.eg1;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ListToArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Song> playList = new LinkedList<Song>();
		
		playList.add(new Song("abc","xyz",3));
		playList.add(new Song("xyz","pqr",1));
		playList.add(new Song("pqr","mno",2));
		
		Song[]  songs = new Song[5];
		songs = playList.toArray(songs);
		songs[1].setName("changedName");
		
		playList.add(new Song("mno","abc",4));

		System.out.println("Array Songs:- "+songs.length+" List Songs :- "+playList.size());
		System.out.println("Arr Song[1] :- "+songs[1].getName()+" Play List Song1 =  "+playList.get(1).getName());
		System.out.println("Arr Song[4] :- "+songs[4].getName());
	}
}