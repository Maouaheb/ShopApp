package AOPfinal;
import javafx.scene.image.ImageView;

public class Product {
	public Product() {
		
	}
private int id;
private String image;
private ImageView imageView;
public ImageView getImageView() {
	return imageView;
}
public void setImageView(ImageView imageView) {
	this.imageView = imageView;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
private String name;
private String type;
private String brand;
private int quantity;
private float price;
public Product(int id, String name, String type, String brand, int quantity,float price) {
	this.id=id;
	this.name=name;
	this.type=type;
	this.brand=brand;
	this.quantity=quantity;
	this.price=price;
}
public Product(int id, String name, String type, String brand, int quantity,float price, String image) {
	this.id=id;
	this.name=name;
	this.type=type;
	this.brand=brand;
	this.quantity=quantity;
	this.price=price;
	this.image=image;
}
public Product( String name, String brand,float price, int quantity, ImageView imageview) {
	this.name=name;
	this.brand=brand;
	this.price=price;
	this.quantity=quantity;
	this.imageView=imageview;

}
}
