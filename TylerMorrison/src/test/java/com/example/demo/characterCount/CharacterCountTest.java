package com.example.demo.characterCount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CharacterCountTest 
{
	private CharacterCount cc;
	
	@Before
	public void setup() {
		cc = new CharacterCount();
	}
	
	@Test
	public void testLetterCount() {
		
		int res = cc.letterCount("A B C DEFG");
		Assert.assertEquals(7, res);
	}
	
	@Test
	public void testDigitCount() {
		
		int res = cc.digitCount("A1 B2 C3 DEFG");
		Assert.assertEquals(3, res);
	}
	
	@Test
	public void testDigitCount2() {
		
		int res = cc.digitCount(";l ");
		Assert.assertEquals(0, res);
	}
}
