package PaymentsApp;

public class RunPaymentsApp {
	
import java.util.Scanner;

	public static void main (string[]args) {
		static int =0;
		int SelectedOption = 0;
		
		Scanner sc=new Scanner(system.in);
		while(true) {
			System.out.println("Payments App Actions:");
			System.out.println("1. REGISTER NEW USER");
			System.out.println("2. LOGIN");
			System.out.println("3. ADD BANK ACCOUNT");
			System.out.println("4. LIST OF USERS");
			System.out.println("5. CURRENT USER");
			System.out.println("6. ADD MONEY TO WALLET");
			System.out.println("7. CHECK WALLET BALANCE");
			System.out.println("8. LIST OF ALL USERS BANKACCOUNTS");
			System.out.println("9. SELF TRANSACTION");
			System.out.println("10. TRANSACTION");
			System.out.println("11.CHECK BANKACCOUNT BALANCE");
			System.out.println("12. MINI STATEMENT");
			System.out.println("13.DELETE BANKACCOUNT");
			System.out.println("14.LOGOUT");
			System.out.println("-1. QUIT");
			System.out.println("Choose an Option:");
			
			String optStr = sc.next();
			try {
				selectedOption = Integer.parseInt(optStr);

				
			}catch(NumberFormatException e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("Number format Error Occured Please choose another option.");
				
			}catch(ArithmeticException e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("arithmetic Error Occured Please choose another option.");
				
			}catch(Exception e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("Some Error Occured Please choose another option.");
			}finally{
				System.out.println();
			}
			
			System.out.println("User Selected" +OptStr);
			UserOperation ops=new UserOperation();
			if(optStr.equalsIgnoreCase("1")) {
				registerUser();
	
			  }else if(optStr.equalsIgnoreCase("2")) { 
			  }else if(optStr.equalsIgnoreCase("3")) { 
			  }else if(optStr.equalsIgnoreCase("4")) { 
			  }else if(optStr.equalsIgnoreCase("5")) { 
			  }else if(optStr.equalsIgnoreCase("6")) { 
			  }else if(optStr.equalsIgnoreCase("7")) {
			  }else if(optStr.equalsIgnoreCase("8")) { 
			  }else if(optStr.equalsIgnoreCase("9")) { 
			  }else if(optStr.equalsIgnoreCase("10")) { 
			  }else if(optStr.equalsIgnoreCase("11")) {
			  }else if(optStr.equalsIgnoreCase("12")) { 
			  }else if(optStr.equalsIgnoreCase("13")) { 
			  }else if(optStr.equalsIgnoreCase("14")) { 
			  }else if(optStr.equalsIgnoreCase("-1")) { 
			  break;
		
		}
}
	}
	public static void registerUser(){
		Scanner opt = new Scanner(System.in); 
		
		Useroperations ops = new Useroperations();
		System.out.println("Please do provide user details as asked:");
		System.out.println("First Name:");
		String fName = opt1.next();
		System.out.println("Last Name:");
		String lName = opt1.next();
		System.out.println("Phone Number:");
		long phNo = Long.parseLong(opt1.next());
		System.out.println("Date Of Birth:");
		String dob = opt1.next();
		System.out.println("Address:");
		String addr = opt1.next();
		System.out.println("Password:");
		String password = opt1.next();
		
		User u = null;
		
		try {
			 u = ops.doUserRegistration(fName, lName, password,phNo, dob, addr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wallet w = new Wallet();
		int UserId = u.getUserId();
		Walletlist.put(UserId, w);
	}

	



