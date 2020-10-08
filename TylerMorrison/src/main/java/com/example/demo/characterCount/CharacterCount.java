package com.example.demo.characterCount;

public class CharacterCount 
{
	public int letterCount(String string)
	{
		int count = 0;
		char[] chars = string.toCharArray();
		for(char i : chars)
		{
			if(Character.isLetter(i))
				count++;
		}
		
		return count;
	}
	
	public int digitCount(String string)
	{
		int count = 0;
		char[] chars = string.toCharArray();
		for(char i : chars)
		{
			if(Character.isDigit(i))
				count++;
		}
		
		return count;
	}
}
