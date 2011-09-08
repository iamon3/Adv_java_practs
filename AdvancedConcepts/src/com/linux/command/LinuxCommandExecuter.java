package com.linux.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinuxCommandExecuter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Process p;
		try {
			p = Runtime.getRuntime().exec("ps -ef");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				System.out.println("line: " + s);
			p.waitFor();
			System.out.println ("exit: " + p.exitValue());
			p.destroy();
		} catch (Exception e) {}

	}
}
