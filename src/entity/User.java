package PaymentsApp;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String firstName;
	private String lastName;
	private long phoneNo;
	private String DateOfBirth;
	private String Address;
	private int userId;
	private String passWord;
	private Wallet wallet;
	private List<Transaction> Txnlist = new ArrayList<Transaction>();
	private List<Bankaccount> Bankacctlist = new ArrayList<Bankaccount>();