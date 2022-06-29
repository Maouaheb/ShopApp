package AOPfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AmazingAPI {
	private ArrayList<Product> products;

	public ArrayList<Product> getProducts() {
		return products;
	}

	public static void main(String[] args) {
		AmazingAPI a = new AmazingAPI();
		a.parseData();
	}

	public void parseData() {

		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader("C:/Users/belarbim/Desktop/recherche/base/Amazing.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				String items[] = line.split(" ");
				String name = items[0];
				String type = items[1];
				String brand = items[2];
				float price = Float.parseFloat(items[3]);
				int quantity = Integer.parseInt(items[4]);
				String image = items[5];
				System.out.println("******************* " + image);

				Product item = new Product(1, name, type, brand, quantity, price, image);
				products.add(item);
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setProducts(ArrayList<Product> items) {
		this.products = items;
	}

	public AmazingAPI() {
		products = new ArrayList<Product>();
	}

	public void addItems(Product item) {
		products.add(item);
	}
}
