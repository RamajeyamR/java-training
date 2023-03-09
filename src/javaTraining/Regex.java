package javaTraining;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		System.out.println("\n************Regex************\n");
		
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isMatched = false;
		int totalMatches = 0;
		
		String image = "Saple.png";
//		String imgRegex = "";
		String imgSpliter = "\\.";
		
		pattern = Pattern.compile(imgSpliter);
		String[] resultImg = pattern.split(image);
		if(resultImg.length > 1 && resultImg.length < 3) {
			if(Pattern.matches("^(?![\\s\\W])([a-zA-Z0-9]{1,15})", resultImg[0])) {
				if(Pattern.matches("(bmp|jpg|gif|png)", resultImg[1])) {
					System.out.println("Image fileName is Valid !!");
				}
				else System.out.println("Image Extension is not Valid !!");
			}
			else System.out.println("Image FileName is not Valid !!");
		}
		else {
			System.out.println("Filename is not Valid !!");
		}
		
//		--------------------------------------------------------------
		
		String panCard = "AAAPZ1234A";
		String panRegex = "[A-Z]{5}[0-9]{4}[A,B,C,F,G,H,L,J,P,T]{1}";
		
		isMatched = Pattern.matches(panRegex, panCard);
		if(isMatched) {
			System.out.println("\nPancard Verified !!");
		}else {
			System.out.println("\nPancard is not Valid !!");
		}
		
//		---------------------------------------------------------------------
		
		String creditCard = "1234-5678-9512-3459";
		String creditRegex = "[0-9]{16}";
		String cardSpliter = "-";
		String finalCreditCard = "";
		
		pattern = Pattern.compile(cardSpliter);
		String[] resultCard = pattern.split(creditCard);
		
		for(String value : resultCard) {
//			System.out.println("Result Card : "+value);
			finalCreditCard = finalCreditCard.concat(value);
		}
//		System.out.println("Final Credit Card : "+finalCreditCard+"\n");
		isMatched = Pattern.matches(creditRegex, finalCreditCard);
		
		if(isMatched) {
			String Bin = "";
			String Account = "";
			String CheckDigit = "";
			Bin = finalCreditCard.substring(0,6);
			Account = finalCreditCard.substring(6,15);
			CheckDigit = finalCreditCard.substring(15,16);
			System.out.println("\nCredit Card Verified !! \n");
			System.out.println("Bin : "+Bin);
			System.out.println("Account Number : "+Account);
			System.out.println("Check Digit : "+CheckDigit);
		}else {
			System.out.println("\nCredit Card is not Valid !!");
		}
		
//		----------------------------------------------------------------
		
		String IpAddress = "0.0.1.18";
		String spliter = "\\.";
		String ipRegex = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
		
		pattern = Pattern.compile(spliter);
		
		String[] resultIP = pattern.split(IpAddress);
		
		
		if(resultIP.length > 3) {
			boolean ipMatched = true;
			for(String val : resultIP) {
				isMatched = Pattern.matches(ipRegex, val);
//				System.out.println("Splited IpAddress :"+val);
				if(!isMatched) ipMatched = false;
			}
			if(ipMatched) System.out.println("\nIpAddress Verified !!");
			else System.out.println("\nIpAddress is not Valid !!");
		}
		else {
			System.out.println("\nIpAddress is not Valid !!");
		}
		
	}

}
