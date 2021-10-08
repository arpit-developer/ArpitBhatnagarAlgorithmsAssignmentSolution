package com.greatlearning.services;

public class BinarySearch {
	public void searchValue(double priceArray[], double key) {
		int left = 0;
		int right = priceArray.length - 1;
		int mid = left + (right - left) / 2;

		while (left <= right) {

			if (key < priceArray[mid]) {
				// range is l to mid-1
				right = mid - 1;
			} else if (key > priceArray[mid]) {
				// range is mid+1 to r
				left = mid + 1;

			} else {
				System.out.println("Stock of value " + key + " is present ");
				break;
			}
			mid = left + (right - left) / 2;
		}

		if (left > right) {
			System.out.println("Value not found");
		}
	}
}
