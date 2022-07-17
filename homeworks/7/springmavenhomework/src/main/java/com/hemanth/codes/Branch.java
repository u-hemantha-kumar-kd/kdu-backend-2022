package com.hemanth.codes;

public class Branch {
	public int branchId;
	public String branchName;

	public Branch() {
		System.out.println("This is Branch from Constructor!");
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setBranchIdAndName() {
//		setBranchId(100);
//		setBranchName("Computer Science And Engineering");
		
		System.out.println("This is init method for Branch!");
	}

	public void destroy() {
		System.out.println("This Branch is now closed!");
	}

	public String toString() {
		return "Branch-ID: " + this.branchId + " " + "Branch-Name: " + this.branchName;
	}

}
