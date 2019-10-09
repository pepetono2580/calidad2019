package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class AccountParametrized2 {
	
	public Account testParametrizado = new Account();
	
	private double balance1;
	private double comissions1;
	private int zone1;
	private double balanceExpected;
	
	public AccountParametrized2(double balanceExpected, double balance, double comissions, int zone) {
		this.balance1 = balance;
		this.comissions1 = comissions;
		this.zone1 = zone;
		this.balanceExpected = balanceExpected;
	}
	
	@Parameters
	public static Collection<Object[]>data(){
		return Arrays.asList(new Object[][] {
			{400.0, 500.0, 0.0, 1}, 
			{1200.0, 1300.0, 0.0, 2},
			{600.0, 700.0, 0.0, 3}
		});
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testeo() {
		assertThat(this.balanceExpected, is(equalTo(testParametrizado.withdraw(100.0))));
	}

}
