package kalyan;

import java.util.List;
import java.util.Vector;
import java.util.*;
public class UserOperations {
	 List<User>list = RunPaymentsAPP.usersList;
public User doUserRegistration(String fName, String lName, String password, long phNum,String gmail, String dob,String addr) {
//	Vector vc=new Vector();
//    vc.add("fName");
//    vc.add("lName");
//    vc.add("password");
//    vc.add("phNo");
//    vc.add("dob");
//    vc.add("addr");
	User u = new User();
	u.setFirstName(fName);
	u.setLastName(lName);
	u.setPhoneNum(phNum);
	u.setGmail(gmail);
	u.setDateOfBirth(dob);
	u.setCommunicationAddr(addr);
	u.setPassword(password);
	
	u.setUserId();
	return u;
//	  if (isValidGmail(gmail)) {
//          System.out.println("Valid Gmail address!");
//      } else {
//          System.out.println("Invalid Gmail address")
//      }
//  
//  public static boolean isValidGmail(String email) {
//      return email.contains("@") && email.endsWith("gmail.com");
  }

	
//	FileOps fileOps = new FileOps();
//	fileOps.userToFile(u);
//	return u;


public void printUserList( ){
 for(User u : list) {
	 System.out.println(u);
 }
}

public void currentUser() {
	if(RunPaymentsAPP.currUserId==-1) {
		System.out.println("No user logged in");
	}
	 for(User u : list) {
		 if(RunPaymentsAPP.currUserId == u.getUserId()) {
			 System.out.println(u.getFirstName()+" "+u.getLastName());
		 }
		 else {
			 System.out.println("please enter valid credentials");
		 }
	 }
	
}

public void userLogIn(int userId, String password) {
	for(User u : list) {
		if(u.getUserId()==userId&&u.getPassword( ).equals(password))
			System.out.println("welcome Mr."+u.getFirstName()+" "+u.getLastName());
		   RunPaymentsAPP.currUserId = userId;
		}
	}

	



}