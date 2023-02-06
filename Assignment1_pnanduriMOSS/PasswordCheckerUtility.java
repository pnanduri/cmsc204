import java.util.ArrayList;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
	
	if (password.equals(passwordConfirm)) {
	}
	else {
		throw new UnmatchedException();
	}
	
	
}

public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
	
	boolean validity = false;
	
	if (password.equals(passwordConfirm)) {
		
		validity = true;
	}
	
	return validity;
	
}

public static boolean isValidLength(String password) throws LengthException{
	if (password.length()>=6) {
	}
	else {
		throw new LengthException();
	}
	return true;
}

public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
Pattern p = Pattern.compile("(?=.*[A-Z])");
Matcher m = p.matcher(password);

if (m.find()) {	
}
else {
	throw new NoUpperAlphaException();
}

return true;
}

public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
	Pattern p = Pattern.compile("(?=.*[a-z])");
	Matcher m = p.matcher(password);
	if (m.find()) {	
	}
	else {
		throw new NoLowerAlphaException();
	}
	return true;
	
}

public static boolean hasDigit(String password) throws NoDigitException{
	Pattern p = Pattern.compile("(?=.*\\d)");
	Matcher m = p.matcher(password);
	
	if (m.find()) {
	}
	else {
		throw new NoDigitException();
	}
	
	return true;
}

public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
	Pattern p = Pattern.compile("[^A-Za-z0-9]");
	Matcher m = p.matcher(password);
	
	if (m.find()) {
		
	}
	else {
		
		throw new NoSpecialCharacterException();
	}
	
	return true;
}

public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
	Pattern p = Pattern.compile("((.)\\2{2,})");
	Matcher m = p.matcher(password);
	
	if (m.find()) {
		throw new InvalidSequenceException();
	}
	return false;
}

public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
		NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	
	boolean validity = false;
	 if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password)
			&& hasSpecialChar(password) && !NoSameCharInSequence(password)) {
		validity = true; 
	 }
	 
	 return validity;
}

public static boolean hasBetweenSixAndNineChars(String password) {
	boolean validity = false;
	
	 if (password.length() >= 6 && password.length() <= 9) {
		 validity = true;
	 }
	 
	 return validity;
}

public static boolean isWeakPassword(String password) throws WeakPasswordException {
	
	if (hasBetweenSixAndNineChars(password)) {
		throw new WeakPasswordException();
	}
	return false;
	
}

public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
	ArrayList<String> notValid = new ArrayList<String>();
	
	for(String password: passwords){
		
		try {
			isValidPassword(password);
		
		} catch (LengthException e) {
		
			notValid.add(password+" The password has to be at least 6 characters long");
		
		} catch (NoUpperAlphaException e) {
		
			notValid.add(password+" The password has to contain at least one uppercase alphabetic character");
		
		} catch (NoLowerAlphaException e) {
		
			notValid.add(password+" The password has to contain at least one lowercase alphabetic character");
		
		} catch (NoDigitException e) {
			
			notValid.add(password+" The password has to contain at least one digit");
		
		} catch (NoSpecialCharacterException e) {
		
			notValid.add(password+" The password has to contain at least one special character");
		
		} catch (InvalidSequenceException e) {
		
			notValid.add(password+" The password can't have more than two of the same character in sequence");
		
		}
	}
	return notValid;
}
}
	
	
	



