package com.task5;

public class Customer {
	private String name;

private Long  customerId;
 private  String email;
 private String address;
 private String contactNumber;
 
 public Customer(String name, String contactNumber, String email, String address, Long customerId) {
	super();
	this.name = name;
	this.customerId = customerId;
	this.email = email;
	this.address = address;
	this.contactNumber = contactNumber;
}
 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 public Long getCustomerId() {
	return customerId;
 }
 public void setCustomerId(Long customerId) {
	this.customerId = customerId;
 }
 public String getEmail() {
	return email;
 }
 public void setEmail(String email) {
	this.email = email;
 }
 public String getAddress() {
	return address;
 }
 public void setAddress(String address) {
	this.address = address;
 }
 public String getContactNumber() {
	return contactNumber;
 }
 public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
 }
 @Override
 public String toString() {
	return "Customer [name=" + name + ", customerId=" + customerId + ", email=" + email + ", address=" + address
			+ ", contactNumber=" + contactNumber + "]";
 }
 
}
