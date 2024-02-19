package kalyan;

import java.util.List;
import java.util.Vector;

public class UserOperations {
public User doUserRegistration(String fName, String lName, String password, long phNum, String dob,String addr) {
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
	u.setDateOfBirth(dob);
	u.setCommunicationAddr(addr);
	u.setPassword(password);
	
	u.setUserId( (int) ((Math.random()*1000)+500));
	return u;
}
public void printUserList(List<User> users){
	for(User u:users) {
		if(users != null) {
			System.out.println("User Details of "+ u.getFirstName());
			System.out.println(u);
		}
	}
}

//public void printUserList(List<User> userlist){
//	for(int i=0;i<userlist.size();i++) {
//		if(userlist.get(i) != null) {
//			System.out.println("User Details of "+ userlist.get(i).getFirstName());
//			System.out.println(userlist.get(i));
//		}
//		
//	}
//}

//int i=0;
//public void verifyuserid(String userId,String password,List<User> Users) {
//	if(String.valueOf(Users.get(i).equals(userId))!= null) {
//		if(password.equals(password)) {
//			return;
//}
//	}
//}


public boolean verifyUserLogin(String uid, String password) {
	List<User> users;
	for(int i=0;i<users.size();i++) {
		if(String.valueOf(users.get(i).getUserId()).equals(userId)) {
			if(password.equals(users.get(i).getPassword())) {
				return true;
			}
		}
	}
	return false;
}
}
