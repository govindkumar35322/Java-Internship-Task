package com.task5;

import java.util.Random;

public class Bank {
	private String bankId;
    private String name;
    private String branchName;
    private String ifscCode;
    
    
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(String bankId, String name, String branchName, String ifscCode) {
		super();
		this.bankId = bankId;
		this.name = name;
		this.branchName = branchName;
		if(ifscCode==null) {
			this.ifscCode=generateIFSCCode();
		}
		else {
		this.ifscCode = ifscCode;
		}
	}
	public static String generateIFSCCode () {
        StringBuilder ifsc = new StringBuilder();
        Random random = new Random();

        // 4 uppercase alphabets
        for (int i = 0; i < 4; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            ifsc.append(letter);
        }

        // Fixed '0' in the middle (as per IFSC format)
        ifsc.append('0');

        // 6 digits
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            ifsc.append(digit);
        }

        return ifsc.toString();
    }
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", name=" + name + ", branchName=" + branchName + ", ifscCode=" + ifscCode
				+ "]";
	}
	
	
	
	
	
}
