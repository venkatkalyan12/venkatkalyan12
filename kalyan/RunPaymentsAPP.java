package kalyan;

import java.util.*;

public class RunPaymentsAPP {
	
	private static final String uId = null;
	public static List<User> usersList =new ArrayList<User>();
	public static List<BankAccount> bankAcctList = new ArrayList<BankAccount>();
	public static int currUserId = -1;

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
						System.out.println("6. List All User Bank Accounts");
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
						if(optStr.equalsIgnoreCase("1")) {
							register();
							
						
				         }else if(optStr.equalsIgnoreCase("2")) {if(currentUserid==-1) {
				 			System.out.println("enter user to credentials to login");
							System.out.println();
							System.out.println("enter userid");
							int userid=opt.nextInt();
							System.out.println("enter password");
							String password=opt.next();
							 UserOperations ops = new UserOperations();
							 ops.userLogin(userid,password);
						}
						else {
							System.out.println("if you want to login into another account logout from current account");
						}
				        	 
				        	
		
							
						}else if(optStr.equalsIgnoreCase("3")) {
							
							
						}else if(optStr.equalsIgnoreCase("4")) {
//						ops.printUserList(userList);
						}else if(optStr.equalsIgnoreCase("5")) {
							
						}else if(optStr.equalsIgnoreCase("6")) {
							
						}else if(optStr.equalsIgnoreCase("-1")) {
							break;
						}else {
							
						}
					}
			} 
//	catch (NumberFormatException e) {
//							e.printStackTrace();
//			}
		}
public static void register() {
     tr{
	System.out.println("Please do provide user details as asked:");
	System.out.println("First Name:");
	String fName = opt.next();
	System.out.println("Last Name:");
	String lName = opt.next();
	System.out.println("Phone Number:");
	long phNo = Long.parseLong(opt.next());
	System.out.println("Date Of Birth:");
	String dob = opt.next();
	System.out.println("Address:");
	String addr = opt.next();
	System.out.println("Password:");
	String password = opt.next();
	       UserOperations ops = new UserOperations();
	User u = ops.doUserRegistration(fName, lName, password, phNo, dob, addr);
		wallet =new wallet();
		usersList.add(u);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
		
		
	private static void login() {
		Scanner opt = new Scanner(System.in);
		if(currentUserid==-1) {
			System.out.println("enter user to credentials to login");
			System.out.println();
			System.out.println("enter userid");
			int userid=opt.nextInt();
			System.out.println("enter password");
			String password=opt.next();
			 UserOperations ops = new UserOperations();
			 ops.userLogin(userid,password);
		}
		else {
			System.out.println("if you want to login into another account logout from current account");
		}
		
	}

	