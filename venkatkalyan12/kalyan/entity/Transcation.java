package kalyan.entity;

import java.util.Date;

public class Transcation {
	 private int transactionId;
	    private Date timestamp;
	    private int userId;
	    private double amount;
	    private TransactionType transactionType;
	    public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public TransactionType getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(TransactionType transactionType) {
			this.transactionType = transactionType;
		}
		private int userId;
	    private double amount;
	    private TransactionType transactionType;	 

@Override
public String toString() {
    return "Transaction{" +
            "transactionId=" + transactionId +
            ", timestamp=" + timestamp +
            ", userId=" + userId +
            ", amount=" + amount +
            ", transactionType=" + transactionType +
            '}';
}
}


