package com.test.tax;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used to calculate the tax amount and return the final amount of an item
 * 
 * @author Chandrika
 * 
 */
public class TaxCalculator {

	public static void main(String[] args) {

		try {
			// Scan the item for price and barcode
			Scanner item = new Scanner(System.in);
			System.out.println("Enter barcode");

			String barcode = item.next();
			System.out.println("barcode is :: " + barcode);
			System.out.println("Enter price");
			double price = item.nextDouble();
			System.out.println("price is :: " + price);

			// Check if the item is regular or luxury
			String itemType = new TaxCalculator().getItemType(barcode);
			System.out.println("itemType is::: " + itemType);

			// Calculate final price of the item
			double finalAmount = new TaxCalculator().getFinalAmount(itemType,
					price);
			System.out.println("final amount is ::: " + finalAmount);

		} catch (Exception ex) {
			if (ex instanceof InputMismatchException) {
				System.out
						.println("Price of the item is invalid. Please try again by entering valid price");
			} else {
				ex.printStackTrace();
				System.out
						.println("System error occured in TaxCalculator. Sorry!!!");
			}
		}

	}

	/**
	 * Return item type as regular or luxury based on item bar code
	 * 
	 * @param barcode
	 * @return type
	 */
	public String getItemType(String barcode) {
		String type = "";
		if (barcode.startsWith("R") || barcode.startsWith("r")) {
			type = "Regular";
		} else if (barcode.startsWith("L") || barcode.startsWith("l")) {
			type = "Luxury";
		}

		return type;

	}

	/**
	 * Calculates final amount after adding tax amount to the price
	 * 
	 * @param itemType
	 * @param price
	 * @return finalAmount
	 */
	public double getFinalAmount(String itemType, double price) {
		double finalAmount = 0;
		double taxRate = 0;
		double taxAmount = 0;

		// Calculate tax amount :if item type is regular then tax % is 1% else
		// if luxury then 9%
		if (itemType.equalsIgnoreCase("Regular")) {
			taxRate = 0.01;
		} else if (itemType.equalsIgnoreCase("Luxury")) {
			taxRate = 0.09;
		}
		taxAmount = price * taxRate;
		System.out.println("taxamount is :: " + taxAmount);
		finalAmount = price + taxAmount;

		return finalAmount;

	}

}
