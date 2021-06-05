package receipt.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import receipt.model.Product;

public class APIService {

	//Here goes your JSON URL
	private static final String POST_API_URL = "";

	/**
	 * This method is use to get all the API products and store them in to a List
	 * 
	 * @return List of products
	 * @throws IOException 
	 */
	public List<Product> getProductsFromApi() throws IOException {

		List<Product> products = new ArrayList<>();

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json")
					.uri(URI.create(POST_API_URL)).build();

			HttpResponse<String> response = null;
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper mapper = new ObjectMapper();
			products = mapper.readValue(response.body(), new TypeReference<List<Product>>() {
			});
		}

		 catch (InterruptedException e) {
			e.printStackTrace();
		} 
		return products;
	}
}
