package kalyan;

import java.util.*;

public class RunPaymentsAPP {
	
	static int x=20;
	private static List<User> userList;
//	public static User[] userList=new User[6];
//	Vector vc=new Vector();
	public static void main (String[] args) {
	

			int selectedOption=0;	
			int x=10;
			try (Scanner opt = new Scanner(System.in)) {
				while(true) {
						System.out.println("Payments App Actions:");
						System.out.println("1. Register New User");
						System.out.println("2. Login");
						System.out.println("3. ADD Bank Account");
						System.out.println("4. List of Users");
						System.out.println("-1. Quit/ Logout");
						System.out.println("Choose an Option:");
						
						String optStr = opt.next();
						try {
							selectedOption = Integer.parseInt(optStr);
							int currBal=10;
							
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
							
							

							User u = ops.doUserRegistration(fName, lName, password, phNo, dob, addr);
							System.out.println(u);
						   	for(int i=0;i<userList.size();i++) {
								if(userList.get(i)==null) {
									userList.get(i).setUserId(i);
									break;
									
								}
							}
							
						
				         }else if(optStr.equalsIgnoreCase("2")) {
				        		System.out.println("user ID:");
								System.out.println("password:");
								opt.next();
							
						}else if(optStr.equalsIgnoreCase("3")) {
							
						}else if(optStr.equalsIgnoreCase("4")) {
//						ops.printUserList(userList);
			
						
						System.out.println("Last Name:");
						
						System.out.println("Phone Number:");
						
						System.out.println("Date Of Birth:");
						
						System.out.println("Address:");
						
						System.out.println("Password:");
						
						}else if(optStr.equalsIgnoreCase("-1")) {
							break;
						}else {
							
						}
					}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		
			}

	