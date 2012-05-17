package com.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	private static String userName = "_foo_123";
	private static String orgName = "abc123abc";

	// Initialize regex for User Name with no specialChars
	private static String alphaNumericUserNameExpression = "[^!@#$%&'*+-/=?^`{}|\"~.]+$";
	private static Pattern alphaNumericUserNamePattern = Pattern.compile(alphaNumericUserNameExpression, Pattern.CASE_INSENSITIVE);

	// Initialize regex for Org name 
	private static String alphaNumericOrgNameExpression = "[a-zA-Z0-9]+";
	private static Pattern alphaNumericOrgNamePattern = Pattern.compile(alphaNumericOrgNameExpression, Pattern.CASE_INSENSITIVE);

	private final static String USERNAME_IGNORECHARS = "!@#$%&'*+-/=?^`{}|\"~.";
	private final static String ORG_IGNORECHARS = "_!@#$%&'*+-/=?^`{}|\"~.";

	public static void main(String[] args) {
		//Normalize userName
		userName = normalize(userName, USERNAME_IGNORECHARS, "_");
		System.out.println("Normalized User Name in DB :- " + userName); 
		isValidAlphaNumericUserName(userName);

		// Normalize domain name
		String inputOrgName = orgName;
		orgName = normalize(orgName, ORG_IGNORECHARS, "");
		System.out.println("Normalized Org Name in DB :- " + orgName);
		isValidAlphaNumericOrgName(inputOrgName);
	}

	/**
	 * Pattern Matching 2nd e.g.
	 */
	public static boolean isValidAlphaNumericOrgName(String input) {
		if (isBlank(input)) {
			System.out.println("Invalid Blank / empty => " + input) ;
			return false;
		}
		Matcher matcher = alphaNumericOrgNamePattern.matcher(input);
		boolean flag = matcher.matches();
		if(flag){
			System.out.println("Valid => " + input);
		}
		else{
			System.out.println("Invalid => " + input) ;
		}
		return flag;
	}

	/**
	 * Pattern Matching 1st e.g. 
	 */
	public static boolean isValidAlphaNumericUserName(String input) {
		if (isBlank(input)) {
			System.out.println("Invalid Blank / empty => " + input) ;
			return false;
		}
		Matcher matcher = alphaNumericUserNamePattern.matcher(input);
		boolean flag = matcher.matches();
		if(flag){
			System.out.println("Valid => " + input);
		}
		else{
			System.out.println("Invalid => " + input) ;
		}
		return flag;
	}

	/**
	 * Checks if string is null or empty
	 */
	public static boolean isBlank(String input) {
		return (input == null || input.trim().length() < 1);
	}    

	/**
	 * This function replaces specified specialChars with given replacementCharEequence
	 * in the sourceName
	 */
	private static String normalize(String sourceName, String specialCharSequence, String replacementCharSequence) {
		String result = sourceName;
		if (result != null && result.length() > 0) {
			for (Character currentChar : specialCharSequence.toCharArray()) {
				if (result.indexOf(currentChar) > -1) {
					String currentSeq = "" + currentChar;
					result = result.replace(currentSeq, replacementCharSequence);
				}
			}
		}
		return result;
	}

}
