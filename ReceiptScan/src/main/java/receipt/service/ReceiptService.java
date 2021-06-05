package receipt.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import receipt.model.Product;

public class ReceiptService {
	private int domesticSum;
	private int importedSum;
	private int domesticCounter;
	private int importedCounter;

	/**
	 * This method is used for sorting the objects depending if objects are domestic
	 * or imported in to a List, setting the price for each list, setting counter
	 * variables to the number of products stored in each List, sorting products by
	 * name alphabetically and calling methods that are printing the desired outputs
	 * 
	 * @param products is a List from that is processed
	 */
	public void getProducts(List<Product> products){
		List<Product> domesticProducts = new ArrayList<>();
		List<Product> importedProducts = new ArrayList<>();

		for (Product product : products) {
			float price = product.getPrice();
			if (product.isDomestic()) {
				domesticProducts.add(product);
				domesticSum += price;
				domesticCounter++;
				domesticProducts.sort(Comparator.comparing(Product::toString));
			} else {
				importedProducts.add(product);
				importedSum += price;
				importedCounter++;
				importedProducts.sort(Comparator.comparing(Product::toString));
			}
		}
		getDomesticProducts(domesticProducts);
		getImportedProducts(importedProducts);
		getSum(domesticSum, importedSum);
		countProducts(domesticCounter, importedCounter);
	}

	/**
	 * This method is for getting the domestic products
	 * 
	 * @param list is list of domestic products
	 */

	private void getDomesticProducts(List<Product> list) {
		System.out.println(". Domestic");
		printProducts(list);
	}

	/**
	 * This method is for getting the imported products
	 * 
	 * @param list is list of imported products
	 */
	private void getImportedProducts(List<Product> list) {
		System.out.println(". Imported");
		printProducts(list);
	}

	/**
	 * This method determines the sum of each category
	 * 
	 * @param domesticSum is the sum of all products in domestic list
	 * @param importedSum is the sum of all products in imported list
	 */
	private void getSum(int domesticSum, int importedSum) {

		System.out.println("Domestic cost: $" + domesticSum);
		System.out.println("Imported cost: $" + importedSum);
	}

	/**
	 * This method counts products and displays them according to their source
	 * 
	 * @param domesticCount counts domestic products
	 * @param importedCount counts imported products
	 */
	private void countProducts(int domesticCount, int importedCount) {
		System.out.println("Domestic count: " + domesticCount);
		System.out.println("Imported count: " + importedCount);
	}

	/**
	 * This method is printing all of the product values and displaying them
	 * 
	 * @param list is a list that needs to be printed
	 */
	private void printProducts(List<Product> list) {
		for (Product product : list) {
			String name = product.getName();
			float price = product.getPrice();
			String description = product.getDescription();
			int weight = product.getWeight();

			System.out.println("... " + name);
			System.out.println("    Price: " + price);

			if (description.length() > 30) {
				System.out.println("    " + description.substring(0, 30) + "...");
			} else {
				System.out.println("    " + description);
			}

			if (weight == 0) {
				System.out.println("    Weight: N/A");
			} else {
				System.out.println("    Weight: " + weight);
			}
		}
	}
}
