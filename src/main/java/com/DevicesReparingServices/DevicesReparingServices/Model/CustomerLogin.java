package com.DevicesReparingServices.DevicesReparingServices.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class CustomerLogin {
	    @Id
	    private String email;
	    private long mobNo;
	    private String password;
	    private String address;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getMobNo() {
			return mobNo;
		}
		public void setMobNo(long mobNo) {
			this.mobNo = mobNo;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public CustomerLogin(String email, long mobNo, String password, String address) {
			super();
			this.email = email;
			this.mobNo = mobNo;
			this.password = password;
			this.address = address;
		}
		public CustomerLogin() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "CustomerLogin [email=" + email + ", mobNo=" + mobNo + ", password=" + password + ", address="
					+ address + "]";
		}

	    
}
