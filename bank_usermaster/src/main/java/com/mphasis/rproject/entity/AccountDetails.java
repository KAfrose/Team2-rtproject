package com.mphasis.rproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="account_details")
public class AccountDetails {
	
		@Id
		private String acc_number;
		private String custid;
		private String bid;
		private String balance;
		private String account_type;
		
		public AccountDetails() {}

		public AccountDetails(String acc_number, String custid, String bid, String balance, String account_type) {
			super();
			this.acc_number = acc_number;
			this.custid = custid;
			this.bid = bid;
			this.balance = balance;
			this.account_type = account_type;
		}

		public String getAcc_number() {
			return acc_number;
		}

		public void setAcc_number(String acc_number) {
			this.acc_number = acc_number;
		}

		public String getCustid() {
			return custid;
		}

		public void setCustid(String custid) {
			this.custid = custid;
		}

		public String getBid() {
			return bid;
		}

		public void setBid(String bid) {
			this.bid = bid;
		}

		public String getBalance() {
			return balance;
		}

		public void setBalance(String balance) {
			this.balance = balance;
		}

		public String getAccount_type() {
			return account_type;
		}

		public void setAccount_type(String account_type) {
			this.account_type = account_type;
		}

		@Override
		public String toString() {
			return "AccountDetails [acc_number=" + acc_number + ", custid=" + custid + ", bid=" + bid + ", balance="
					+ balance + ", account_type=" + account_type + "]";
		}
		
		
}