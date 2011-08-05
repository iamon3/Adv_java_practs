package com.collections.connectionWidArray.eg1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArrayToList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Song[]  songs= {new Song("abc","xyz",3),new Song("xyz","pqr",1),new Song("pqr","mno",2)};
		//ArrayList<Song>songList =  (ArrayList<Song>)Arrays.asList(songs);
		List<Song>songList =  new ArrayList(Arrays.asList(songs));
		songList.add(new Song("def","opd",4));
		System.out.println("Array Songs:- "+songs.length+"List Songs :- "+songList.size());
	}
}
