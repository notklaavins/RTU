package lab2;

public class Lab2 {

	
	
	static long superDigit(long x) {
		
		if (x < 10) 
			return x; 
		
		long s = (x % 10 + superDigit(x / 10));
		
		if(s > 9) {
			
			x = s;
			s = superDigit(x);
			
		}
		
		return s;
		    
	}
		
	
	
	public static void main(String[] args) {
		
		long number = 123456;
		
		System.out.print("Super Digit of " + number + " is ");
		System.out.println(superDigit(number));

	}

}
