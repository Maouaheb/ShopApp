package AOPfinal;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailedProduct extends Application {
	Product product;
	Panier panier;
	ArrayList<String> files;
	public User user;

	public DetailedProduct(Product product, ArrayList<String> files, Panier panier, User user) {
		this.product = product;
		this.files = files;
		this.panier = panier;
		this.user = user;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Details of " + product.getName());
		primaryStage.getIcons().add(new Image("logo.jpg"));

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("More information about " + product.getName());
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setId("text");
		// Adding text to HBox
		hb.getChildren().add(text);
		bp.setId("bp");
		gridPane.setId("root");
		bp.setTop(hb);
		bp.setCenter(gridPane);
		// adding information of the product
		ImageView imageView = new ImageView(getClass().getResource("../" + product.getImage()).toExternalForm());
		imageView.setFitHeight(40);
		imageView.setFitWidth(40);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(imageView, 2, 0);
		Label nameProduct = new Label("Name ");
		Label brandProduct = new Label("Brand ");
		Label priceProduct = new Label("Price ");
		Label quantityProduct = new Label("Quantity ");
		nameProduct.setId("labelProduct");
		brandProduct.setId("labelProduct");
		priceProduct.setId("labelProduct");
		quantityProduct.setId("labelProduct");
		gridPane.add(nameProduct, 0, 2);
		gridPane.add(brandProduct, 1, 2);
		gridPane.add(priceProduct, 2, 2);
		gridPane.add(quantityProduct, 3, 2);
		Label pname = new Label(product.getName());
		gridPane.add(pname, 0, 5);
		Label pbrand = new Label(product.getBrand());
		gridPane.add(pbrand, 1, 5);
		Label price = new Label("" + product.getPrice());
		gridPane.add(price, 2, 5);
		Label quantity = new Label("" + product.getQuantity());
		gridPane.add(quantity, 3, 5);
		pname.setId("infoProduct");
		pbrand.setId("infoProduct");
		quantity.setId("infoProduct");
		price.setId("infoProduct");

		// ajouter panier
		Button achat = new Button("add to basket");
		achat.setId("buttonOrange");
		gridPane.add(achat, 1, 8);
		Button pay = new Button("Go to checkout");
		pay.setId("buttonOrange");
		gridPane.add(pay, 2, 8);
		// add product into basket
		achat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				achat.setDisable(true);
				achat.setId("disabled");
				panier.addToBasket(product);
			}
		});
		// Go to basket
		pay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GoCheckout check = new GoCheckout(panier, files, user);
				try {
					check.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});
		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);
		if (files.size() == 1) {
			scene.getStylesheets().add(getClass().getClassLoader().getResource(files.get(0)).toExternalForm());

		}
		if (files.size() == 2) {
			String cssFile1 = this.getClass().getResource(files.get(0)).toExternalForm();
			String cssFile2 = this.getClass().getResource(files.get(1)).toExternalForm();
			scene.getStylesheets().addAll(cssFile1, cssFile2);
		}
		primaryStage.setScene(scene);
		primaryStage.setTitle("Product Details");
		primaryStage.show();

	}
}
