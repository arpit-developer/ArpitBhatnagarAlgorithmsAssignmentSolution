package com.greatlearning.services;

public class LinearSearch {
	public int countCompaniesInProfit(boolean array[]) {
		int count =0;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==true)
				count++;
		}
		return count;
	}
}
