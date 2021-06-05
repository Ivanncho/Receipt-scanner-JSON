package receipt.main;

import java.io.IOException;

import receipt.service.APIService;
import receipt.service.ReceiptService;

public class App {
	public static APIService productService = new APIService();
	public static ReceiptService receiptService = new ReceiptService();

	public static void main(String[] args) {
		try {
			receiptService.getProducts(productService.getProductsFromApi());
		} catch (IOException e) {
			System.out.println("Invalid data");
		}
	}
}
