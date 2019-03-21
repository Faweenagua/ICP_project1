package theGalamseyArea;

import java.util.regex.*;

/*
 *A class called regexValidator that allows us to validate the input that is being provided by the user.
 *@author Michael Dankwah AGYEMAN-PREMPEH
 *@author Alhassan ISSIFU
 *@author Francis AWEENAGUA
 *@author Eugenia AKPO
 */

public class regexValidator {
	/**
	 * Instance variables and final fields assigned the keyword, protected so that it can be accessed by other classes.
	 */
	protected Pattern thePattern1;
	protected Pattern thePattern2;
	protected Pattern thePattern3;
	
	protected Matcher theMatcher1;
	protected Matcher theMatcher2;
	protected Matcher theMatcher3;
	
	/**
	 * Pattern of some respective inputs to be entered by the user - NAME,YEAR and COUNTRY
	 */
	protected static final String OBYEAR_REGEX = "^\\d{4}$";
	protected static final String OBNAME_REGEX = "^[a-zA-Z]{1,20}$";
	protected static final String OBCOUNTRY_REGEX = "^[a-zA-Z]{4,20}$";
	
	/**
	 * Compilation of the patterns to matched with user inputs.
	 */
	public regexValidator() {
		thePattern1 = Pattern.compile(OBYEAR_REGEX);
		thePattern2 = Pattern.compile(OBNAME_REGEX);
		thePattern3 = Pattern.compile(OBCOUNTRY_REGEX);
	}
	
	/**
	 * 
	 * @param obyear acting as placeholder for the user's year input
	 * @return true or false. Is the input matching the predefined pattern?
	 */
	public boolean validateYear(final String obyear) {
		theMatcher1 = thePattern1.matcher(obyear);
			return theMatcher1.matches();
		}
	
	/**
	 * 
	 * @param obname acting as placeholder for the user's observatory name input
	 * @return true or false. Is the input matching the predefined pattern?
	 */
	public boolean validateName(final String obname) {
		theMatcher2 = thePattern2.matcher(obname);
			return theMatcher2.matches();
		}
	/**
	 * 
	 * @param obcountry acting as placeholder for the user's country name input
	 * @return true or false. Is the input matching the predefined pattern?
	 */
	public boolean validateCountry(final String obcountry) {
		theMatcher3 = thePattern3.matcher(obcountry);
			return theMatcher3.matches();
		}
	
	
	public static void main(String[] args) {
		
		
		regexValidator validate =  new regexValidator();
		
		System.out.println(validate.validateYear("1992"));
		System.out.println(validate.validateName("me"));
		System.out.println(validate.validateCountry("Madagascar"));
		
		
	}
		
	}

