package kalyan;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RunPaymentsAPP {
	
	private static final String uId = null;

	public static List<User> usersList =new ArrayList<User>();
	public static List<BankAccount> bankAcctList = new ArrayList<BankAccount>();
	public static int currUserId = -1;

//	private static List<User> userList;
//	public static User[] userList=new User[6];
//	Vector vc=new Vector();
	public static void main (String[] args) {
	
//		Transcation TXN=new Transcation();

			int selectedOption=0;	
	
			Scanner opt = new Scanner(System.in);
				while(true) {
						System.out.println("Payments App Actions:");
						System.out.println("1. Register New User");
						System.out.println("2. Login");
						System.out.println("3. ADD Bank Account");
						System.out.println("4. List of Users");
						System.out.println("5. Current User");
						System.out.println("6. ADD MONEY TO WALLET");
						System.out.println("7. Transcation");
						System.out.println("-1. Quit/ Logout");
						System.out.println("Choose an Option:");
						
						String optStr = opt.next();
						try {
							selectedOption = Integer.parseInt(optStr);
//							int currBal=10;
							
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
						
						System.out.println("User selected "+selectedOption);
						UserOperations ops = new UserOperations();
//					    userList = null;
						int userId = 0;
						if(optStr.equalsIgnoreCase("1")) {
							userId = register();
							
						
				         }else if(optStr.equalsIgnoreCase("2")) { 
				        	   login();
						 }else if(optStr.equalsIgnoreCase("3")) {
							 userId = login();
							addBankAccount();
							  linkBankAccountToUser(currUserId, bankAcctList.size() - 1);
						}else if(optStr.equalsIgnoreCase("4")) {
							ops.printUserList( );
//						ops.printUserList(userList);
						}else if(optStr.equalsIgnoreCase("5")) {
							 ops.currentUser();
						}else if(optStr.equalsIgnoreCase("6")) {
							addMoney();
						}else if(optStr.equalsIgnoreCase("7")) {
//							userId = login();
//							deposit(userId);
							 userId = login();
				                performTransaction(userId);
							
						}else if(optStr.equalsIgnoreCase("-1")) {
							break;
						}else {
							
					}
						}
			
	}
		

public static int register() {
     try{
    	 Scanner opt1 = new Scanner(System.in);
	System.out.println("Please do provide user details as asked:");
	System.out.println("First Name:");
	String fName = opt1.next();
	System.out.println("Last Name:");
	String lName = opt1.next();
	System.out.println("Phone Number:");
	long phNo = Long.parseLong(opt1.next());
	System.out.println("gmail:");
	String gmail = opt1.next();
	System.out.println("Date Of Birth:");
	String dob = opt1.next();
	System.out.println("Address:");
	String addr = opt1.next();
	System.out.println("Password:");
	String password = opt1.next();
	       UserOperations ops = new UserOperations();
	User u = ops.doUserRegistration(fName, lName, password,phNo, gmail, dob, addr);
	int userId = u.getUserId();
		usersList.add(u);
		ops.printUserList( );
		return userId;
	} catch (Exception e) {
		e.printStackTrace();
	}
     return 0;
    
}
		

	private static int login() {
		Scanner opt = new Scanner(System.in);
		if(currUserId==-1) {
			System.out.println("enter user credentials to login");
			System.out.println();
			System.out.println("enter userid");
			int userid=opt.nextInt();
			System.out.println("enter password");
			String password=opt.next();
			 UserOperations ops = new UserOperations();
			 ops.userLogIn(userid,password);
			 currUserId = userid;
		}
		else {
			System.out.println("if you want to login into another account logout from current account");
		}
		return currUserId;
		
	}
	
	private static void addBankAccount() {
		BankAccount ba=new BankAccount();
		Scanner opt = new Scanner(System.in);
		System.out.println("Enter BankAccout ditals");
		System.out.println("Enter bankAcctNumber");
	    String bankAccNumber=opt.next();
		System.out.println("Enter bankAcctBankName");
		String bankAccBankName=opt.next();
		System.out.println("Enter bankAcctIFSC");
		String IFSC=opt.next();
		System.out.println();
		System.out.println("Select bankAcctAcct Type from below");
		for(AcctType type : AcctType.values()) {
			System.out.println("      "+type);
		}
		String actTypeStr = opt.next();
		
		try {
			AcctType acctType = AcctType.valueOf(actTypeStr);
			ba.setAcctType(acctType);
		}
		catch(IllegalArgumentException e) {
			System.out.println("User should enter only one of the following values");
			for(AcctType type : AcctType.values()) {
				System.out.println("      "+type);
			}
		}
	 
		
		System.out.println("Enter Account Pin");
		String pin = opt.next();
		
		 
		ba.setBankName(bankAccBankName);
		ba.setAcctNumber(bankAccNumber);
		ba.setIFSC(IFSC);
		ba.setAcctPin(pin);
		ba.setUserid(currUserId);
		
		bankAcctList.add(ba);

	    System.out.println("Bank account added successfully.");
	    
		linkBankAccountToUser(currUserId, bankAcctList.size() - 1);
	
	}
	 private static void linkBankAccountToUser(int userId, int acctNumber) {
	        if (userId != -1 && acctNumber >= 0 && acctNumber < bankAcctList.size()) {
	            BankAccount bankAccount = bankAcctList.get(acctNumber);
	            bankAccount.setUserid(userId);
	            System.out.println("Bank Account linked to User successfully.");
	        } else {
	            System.out.println("Invalid user ID or bank account ID.");
	        }
	    }
	
	 
private static void addMoney() {
		
		if(currUserId!=-1) {
		
		Scanner opt = new Scanner(System.in);
		System.out.println("Enter amount : ");
		double amount = opt.nextDouble();
		if(amount <=20000.00) {
			wallet wallet = new wallet();
			wallet.setBalance(wallet.getBalance()+amount);
			System.out.println("your current balance is "+wallet.getBalance());
		}
		else {
			System.out.println("Maximum deposit is 25,000 ");
		}
	 
		 
	}
		else {
			System.out.println("user must log in to add money to wallet");
		}
	}

public static BankAccount getBankAccountByUserId(int userId) {
	for (BankAccount bankAccount : bankAcctList) {
        if (bankAccount.getUserid() == userId) {
            return bankAccount;
        }
    	}
    return null;
}

//if (bankAccount != null) {
//    System.out.println("User's bank account found: " + BankAccount.getAcctNumber());
//    System.out.println("Account Pin: " + BankAccount.getAcctPin());
//} else {
//    System.out.println("User's bank account not found.");
//}
//return 0;
//}


private static void performTransaction(int userId) {

	 Scanner opt = new Scanner(System.in);

	    System.out.println("Enter transaction amount: ");
	    double amount = opt.nextDouble();

	    System.out.println("Select transaction type (1: Deposit, 2: Withdrawal): ");
	    int typeOption = opt.nextInt();

	    TransactionType transactionType = (typeOption == 1) ? TransactionType.DEPOSIT : TransactionType.WITHDRAWAL;

	    // Get the user's bank account
	    BankAccount userBankAccount = getBankAccountByUserId(userId);

	    if (userBankAccount != null) {
	        // Check if there is enough balance for withdrawal
	        if (transactionType == TransactionType.WITHDRAWAL && amount > userBankAccount.getBalance()) {
	            System.out.println("Insufficient funds. Transaction failed.");
	        } else {
	            // Add the transaction
//	            transactionType.add(amount);
	        	 Transaction transaction = new Transaction();
	        	 //
	        	 //    
     	         transactionType.add(transaction);
	        	 //

	         
	            if (transactionType == TransactionType.DEPOSIT) {
	                userBankAccount.setBalance(userBankAccount.getBalance() + amount);
	            } else {
	                userBankAccount.setBalance(userBankAccount.getBalance() - amount);
	            }

	            System.out.println("Transaction successful. Updated balance: " + userBankAccount.getBalance());
	        }
	    } else {
	        System.out.println("User's bank account not found. Transaction failed.");
	    }
	}
//
//		
}
//
//	
