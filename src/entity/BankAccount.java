package kalyan;

public class BankAccount {
//	int balance;
//	int previousTranscation;
	private static String acctNumber;
	private String IFSC;
	private static String acctPin;
	private String bankName;
	private AcctType acctType;
	private int userid;
	public static String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public static String getAcctPin() {
		return acctPin;
	}
	public void setAcctPin(String acctPin) {
		this.acctPin = acctPin;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public AcctType getAcctType() {
		return acctType;
	}
	public void setAcctType(AcctType acctType) {
		this.acctType = acctType;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setBalance(double d) {
		// TODO Auto-generated method stub
		
	}
}