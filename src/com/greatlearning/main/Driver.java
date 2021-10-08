package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.services.StockPricesOperations;
import com.greatlearning.services.BinarySearch;
import com.greatlearning.services.LinearSearch;
import com.greatlearning.services.MergeSort;
public class Driver {
	public static void main(String[] args) {
		int noOfCompanies;
		int option;
		System.out.println("Enter the no of Companies");
		Scanner sc = new Scanner(System.in);
		noOfCompanies = sc.nextInt();
		double priceArray[] = new double[noOfCompanies];
		boolean profitArray[] = new boolean[noOfCompanies];

		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of the Company " + (i + 1));
			priceArray[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			profitArray[i] = sc.nextBoolean();
		}

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(priceArray, 0, priceArray.length - 1);

		StockPricesOperations stockOperations = new StockPricesOperations();
		LinearSearch linearSearch = new LinearSearch();

		BinarySearch binearySearch = new BinarySearch();

		do {

			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total  no of companies  for which stock prices rose today");
			System.out.println("4. Display the total  no of companies  for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			option = sc.nextInt();
			switch (option) {

			case 0:
				option = 0;
				break;
			case 1: {
				stockOperations.displayPricesAscendingOrder(priceArray);

			}
				break;
			case 2: {
				stockOperations.displayPricesDescendingOrder(priceArray);

			}
				break;
			case 3: {
				System.out.println("Total no of companies whose stock price rose today : "
						+ linearSearch.countCompaniesInProfit(profitArray));

			}
				break;
			case 4: {
				System.out.println("Total no of companies whose stock price declined today : "
						+ (noOfCompanies - linearSearch.countCompaniesInProfit(profitArray)));

			}
				break;
			case 5: {
				double key;
				System.out.println("Enter the key value");
				key = sc.nextDouble();
				binearySearch.searchValue(priceArray, key);

			}

				break;
			default:
				System.out.println("Enter valid option");
			}

		} while (option != 0);
		System.out.println("Exited successfully");
		sc.close();
	}
}
