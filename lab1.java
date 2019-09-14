
public class lab1 {
	
	void detect(int n) {
		
		if(n <= 0) {
			System.out.println("Input can't be less than 1");
			return;
		}
		
		int i, sum = 0;
		
		System.out.println("Divisors:");
		
		for(i=1;i<n;i++) {
			
			if(n % i == 0) {
				sum += i;
				System.out.println(i);
				
			}
			
		}
		
		System.out.println("");
		System.out.println("Your number was " + n + ".  Sum of the divisors = " + sum);
		System.out.println("");
		
		if(n == sum) {
			System.out.println("The number is perfect!");
		}
		
		else if (sum < n) {
			System.out.println("The number is deficient!");
		}
		
		else {
			System.out.println("The number is abundant!");
		}
	}

	public static void main(String[] args) {
	
		lab1 PerfectNumber = new lab1();
		
		PerfectNumber.detect(28);
	}

}
