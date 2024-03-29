package kalyan;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.sql.SQLException;

import kalyan.entity.AcctType;
import kalyan.entity.BankAccount;
import kalyan.entity.SQLCONNECTION;
import kalyan.entity.Transaction;
import kalyan.entity.TransactionType;
import kalyan.entity.User;
import kalyan.entity.wallet;

public class RunPaymentsAPP {
	
	private static final String uId = null;

	public static List<User> usersList =new ArrayList<User>();
	public static Map<Integer, wallet> walletList = new HashMap<Integer,wallet>();
	public static List<BankAccount> bankAcctList = new ArrayList<BankAccount>();
	public static int currUserId = -1;
	
	static BankAccount ba=new BankAccount();
	
	private static double amount;
	static int currentUserId = -1;
//	private static List<User> userList;
//	public static User[] userList=new User[6];
//	Vector vc=new Vector();
	public static void main (String[] args) {
	


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
						System.out.println("7. Check Wallet Balance");
						System.out.println("8. list of all users BankAccount");
						System.out.println("9. Self Transaction");
						System.out.println("10. Transcation");
						System.out.println("11.Check BankAccount Balance");
						System.out.println("12. Mini Statement");
						System.out.println("13.Delete BankAccount");
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
				         }else if(optStr.equalsIgnoreCase("-1")) {
								System.out.println("No user logged in");
								break;
						 }else if(optStr.equalsIgnoreCase("3")) {
							 userId = login();
							addBankAccount();
						}else if(optStr.equalsIgnoreCase("4")) {
							ops.printUserList( );
						}else if(optStr.equalsIgnoreCase("5")) {
							 ops.currentUser();
						}else if(optStr.equalsIgnoreCase("6")) {
							addMoney();
						}else if(optStr.equalsIgnoreCase("7")) {
							 userId = login();
						System.out.println("your current balance is "+wallet.getBalance());
						
						}else if(optStr.equalsIgnoreCase("8")) {
							 userId = login();
							System.out.println("BANKACCOUNT===" + ba.printBankAcctDetails());
						}else if(optStr.equalsIgnoreCase("9")) {
							 userId = login();
							SelfTransaction();
						}else if(optStr.equalsIgnoreCase("10")) {
							 userId = login();
				                performTransaction(userId);
						}else if(optStr.equalsIgnoreCase("11")) {
							 System.out.println("Updated bank account balance: " + BankAccount.getBalance());
						}else if(optStr.equalsIgnoreCase("12")) {
						}else if(optStr.equalsIgnoreCase("13")) {
						
					
						}else {
							
					}
						}
				opt.close();
			
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
	
	try {
		SQLCONNECTION SqlCon = new SQLCONNECTION();
		SQLCONNECTION.UserTODB(u);
	}catch(Exception e){
		e.printStackTrace();
	}
	
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
	    
	    try {
			SQLCONNECTION SqlCon = new SQLCONNECTION();
			SqlCon.addAccountToDB(ba);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	    
	
	}
	
	public static void PrintCurrUserBankaccountList() {
		UserOperations ops = new UserOperations();
		Map<User,List<BankAccount>> mapItems = ops.getBankAccountList();
		for(User u : mapItems.keySet()) {
			List<BankAccount> baList = mapItems.get(u);
			System.out.println(u);
			if(baList != null) {
				for(BankAccount ba : baList) {
					System.out.println("-->" + ba.printBankAcctDetails());
				}
			}
		}
		
	}

	 
private static void addMoney() {
		
		if(currUserId!=-1) {
		
		Scanner opt = new Scanner(System.in);
		System.out.println("Enter amount : ");
		double amount = opt.nextDouble();
		if(amount <=20000.00) {
			wallet wallet = new wallet();
			wallet.setBalance(kalyan.entity.wallet.getBalance()+amount);
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
private static void logout() {
	currentUserId = -1;
}

public static BankAccount getBankAccountByUserId(int userId) {
	for (BankAccount bankAccount : bankAcctList) {
        if (bankAccount.getUserid() == userId) {
            return bankAccount;
        }
    	}
    return null;
}


public static void SelfTransaction() {
	
	int selectedOption=0;	
	Scanner st = new Scanner(System.in);
	
	System.out.println("1.Wallet To BankAccount");
	System.out.println("2.BankAccount To Wallet");

	String op = st.next();
	
	try {
		selectedOption = Integer.parseInt(op);
	}catch(Exception e) {
		e.printStackTrace();
		e.getMessage();
		System.out.println("Some Error Occured Please choose another option.");
	}finally{
		System.out.println();
	}
	System.out.println("User selected "+selectedOption);
	UserOperations ops = new UserOperations();
	

	if(op.equalsIgnoreCase("1")) {
		Wallet_To_BA();
    }else if(op.equalsIgnoreCase("2")) { 
    	BA_To_Wallet();
	 } 
}
public static void Wallet_To_BA() {


	       
	        Transaction transaction = new Transaction();
	        Date date = new Date();
	        BankAccount ba=new BankAccount();
	        wallet wa = new wallet();
	      
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the amount to transfer from wallet to bank account:");
	        double amount = scanner.nextDouble();

	        if (wa.getBalance() >= amount) {
     	
	            transaction.setAmount(amount);
	            transaction.setTimestamp(date);
	            transaction.setTransactionId(date.getTime());
	            ba.addBalance(amount);
	            wa.deductBalance(amount);
	            ba.setBalance(ba.getBalance() + amount);
	            System.out.println("Transaction successful!");
	        } else {
	            System.out.println("Insufficient balance in wallet!");
	        }

	        System.out.println("Updated wallet balance: " + wa.getBalance());
	        System.out.println("Updated bank account balance: " + ba.getBalance());

	    }

public static void BA_To_Wallet() {
	   Transaction transaction = new Transaction();
       Date date = new Date();
       BankAccount ba=new BankAccount();
       wallet wa = new wallet();
     
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the amount to transfer from BANK ACCOUNT to WALLET:");
       double amount = scanner.nextDouble();

       if (ba.getBalance() >= amount) {
	
           transaction.setAmount(amount);
           transaction.setTimestamp(date);
           transaction.setTransactionId(date.getTime());
           wa.addBalance(amount);
           ba.deductBalance(amount);
           wa.setBalance(wa.getBalance() + amount);
           System.out.println("Transaction successful!");
       } else {
           System.out.println("Insufficient balance in wallet!");
       }

       System.out.println("Updated wallet balance: " + wa.getBalance());
       System.out.println("Updated bank account balance: " + ba.getBalance());

   }

private static void performTransaction(int userId) {

	int selectedOption=0;	
	Scanner Ts = new Scanner(System.in);
	 Transaction tr = new Transaction();
     Date date = new Date();
     BankAccount ba=new BankAccount();
     wallet wa = new wallet();
	 
	 tr.setTransactionType(TransactionType.DEBIT);
	 System.out.println("Select which type of transfer you want to perform");
	 System.out.println("1.Wallet to Wallet");
	 System.out.println("2.Bank to Bank");
	 System.out.println("3.Bank to Wallet");
	 System.out.println("4.Wallet to Bank");

	String op = Ts.next();
	
	try {
		selectedOption = Integer.parseInt(op);
	}catch(Exception e) {
		e.printStackTrace();
		e.getMessage();
		System.out.println("Some Error Occured Please choose another option.");
	}finally{
		System.out.println();
	}
	System.out.println("User selected "+selectedOption);
	UserOperations ops = new UserOperations();
	

	if(op.equalsIgnoreCase("1")) {
		Wallet_To_Wallet();
    }else if(op.equalsIgnoreCase("2")) { 
    	BAnk_To_BANK();
	 } else if(op.equalsIgnoreCase("3")) {
		 BANK_TO_WALLET();
	 }else if(op.equalsIgnoreCase("4")) {
		 WALLET_To_BANK();
	 }
}
public static void Wallet_To_Wallet() {
	UserOperations ops = new UserOperations();
	 Transaction transaction = new Transaction();
     Date date = new Date();
     BankAccount ba=new BankAccount();
     wallet wa = new wallet();
     Scanner sc = new Scanner(System.in);
	 System.out.println("Enter Transaction Amount : ");
	 double tAmount = sc.nextDouble();
	 if (ba.getBalance() >= amount) {
			
         transaction.setAmount(amount);
         transaction.setTimestamp(date);
         transaction.setTransactionId(date.getTime());
         
         wallet source = walletList.get(currUserId);
		 transaction.setSourceWallet(source);
		 System.out.println("enter receiver userId : ");
		 int receiver = sc.nextInt();
		 wallet destination = walletList.get(receiver);
		 transaction.setDestinationWallet(destination);
		    boolean result = ops.doTransaction(source, destination, transaction.getTransactionType(),tAmount);
		    if(result) {
				 System.out.println("transaction successful");
			 }
			 else {
				 System.out.println("Transaction failed");
			 }

}
}
public static void BAnk_To_BANK() {
	
}

public static void BANK_TO_WALLET() {
	
}

public static void WALLET_To_BANK() {
	
}

//	    Scanner opt = new Scanner(System.in);
//
//	    Transaction tr = new Transaction();
//
//	    System.out.println("Select transaction type (1: DEBIT, 2: CREDIT): ");
//	    int typeOption = opt.nextInt();
//
//	    TransactionType transactionType = (typeOption == 1) ? TransactionType.DEBIT : TransactionType.CREDIT;
//	    BankAccount userBankAccount = getBankAccountByUserId(userId);
//
//	    if (userBankAccount != null) {
//
//
//	            if (transactionType == TransactionType.CREDIT) {
//	            	 System.out.println("Enter transaction amount: ");
//	         	    double Amount = opt.nextDouble();
//	         	    tr.setAmount(kalyan.entity.Transaction.getAmount()+Amount);
//	         	    System.out.println("Your current balance is " + tr.getAmount());
////	                userBankAccount.setBalance(userBankAccount.getBalance() + Amount);
//	            } else {
//	            	 System.out.println("Enter transaction amount: ");
//	         	    double Amount = opt.nextDouble();
//	         	    tr.setAmount(kalyan.entity.Transaction.getAmount()-Amount);
//	         	    System.out.println("Your current balance is " + tr.getAmount());
////	                userBankAccount.setBalance(userBankAccount.getBalance() - Amount);
//	            }
//	            System.out.println("Transaction successful");
//	            System.out.println("Updated balance: " + userBankAccount.getBalance());
//	        
//	    } else {
//	        System.out.println("User's bank account not found. Transaction failed.");
//	    }
//	
}






