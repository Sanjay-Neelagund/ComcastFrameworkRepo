package com.comcast.crm.organizationtest;

import org.testng.annotations.Test;

import Com.Comcast.crm.baseutility.BaseClassPractice;


public class PracOrgtest extends BaseClassPractice {
	@Test
	public void CreateOrg() {
		System.out.println("Created org and verified");
	}
	@Test
	public void CreateOrgwithindustry() {
		System.out.println("Created org with industry");
	}

	
}
