package IfElse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ConnectionLogIn {
	public boolean getConnection(String userName, String password, Label lblMessage, User user) {
		boolean result=false;
		boolean colorblind=false;
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select id, name, password, handicap from student where name=? and password=?");
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				String p = rs.getString(3);
				String h = rs.getString("handicap");
				int idUser = rs.getInt(1);
				//User user = new User();
				user.setUserName(name);
				user.setPassword(password);
				user.setDisability(User.handicap.valueOf(h));
				lblMessage.setText("Congratulations!");
				lblMessage.setTextFill(Color.GREEN); result= true;
				
			} else {
				lblMessage.setText("Incorrect user or pw.");
				lblMessage.setTextFill(Color.RED);
				result= false;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return result;
	}

	public User addUser(String userName, String password, String handicap, Label lblMessage, double count, Date date) {
		User user = new User();

		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("insert into student (name, password,handicap,severity, date) values (?, ?, ?, ?, ?)");

			st.setString(1, userName);
			st.setString(2, password);
			st.setString(3, handicap);
			st.setDouble(4, count);
			st.setDate(5, date);
			st.executeUpdate();
			
				user.setUserName(userName);
				user.setPassword(password);
				user.setDisability(User.handicap.valueOf(handicap));
				lblMessage.setText("Congratulations!");
				lblMessage.setTextFill(Color.GREEN);
				System.out.println(userName + "   " + password + "   " + handicap + " ");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return user;
	}
	public ArrayList<Product> getProducts(String type) {
			Connection connection;
			ArrayList<Product>products=new ArrayList<Product>();
			try {
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
						"root", "root");
				PreparedStatement st = (PreparedStatement) connection
						.prepareStatement("Select id, name, type, brand, price, quantity, image from items where type=?");
				st.setString(1, type);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					String name = rs.getString(2);
					String t = rs.getString(3);
					String brand = rs.getString(4);
					int id = rs.getInt(1);
					float price=rs.getFloat(5);
					int quantity=rs.getInt(6);
					String image=rs.getString(7);
					Product product =new Product(id, name, type, brand, quantity, price, image);
					products.add(product);
					System.out.println(product.getName()+" de marque "+product.getBrand());
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
		return products;
	}
	
	public ArrayList<Product> getProductsMotCles(String name) {
		Connection connection;
		ArrayList<Product>products=new ArrayList<Product>();
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");
			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select id, type, brand, price, quantity, image from items where name=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String type = rs.getString(2);
				String brand = rs.getString(3);
				int id = rs.getInt(1);
				float price=rs.getFloat(4);
				int quantity=rs.getInt(5);
				String image=rs.getString(6);
				Product product =new Product(id, name, type, brand, quantity, price, image);
				products.add(product);
				System.out.println(product.getName()+" de marque "+product.getBrand());
		} }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	return products;
}

	
	public void updateProduct(Product p) {
		Connection connection;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");
			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("update items set quantity=? where id=?");
			int id=p.getId();
			int quantity=p.getQuantity();
			st.setInt(1, quantity);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
