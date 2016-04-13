package org.quinnox.service;

public class OptionValidator {
	
	public String optionSelector(String optionName){
		if(optionName.equalsIgnoreCase("< 1 Hour")){
			return "reportPages/LessThan1Hour.jsp";
		} else if(optionName.equalsIgnoreCase("< 2 Hour")){
			return "reportPages/LessThan2Hour.jsp";	
		} else if(optionName.equalsIgnoreCase("< 4 Hour")){
			return "reportPages/LessThan4Hour.jsp";
		} else if(optionName.equalsIgnoreCase("< 8 Hour")){
			return "reportPages/LessThan8Hour.jsp";
		} else if(optionName.equalsIgnoreCase("< 12 Hour")){
			return "reportPages/LessThan12Hour.jsp";
		} else if(optionName.equalsIgnoreCase("< 24 Hour")){
			return "reportPages/LessThan24Hour.jsp";
		}
		return null;
	}
}
