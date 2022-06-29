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
	String file;
	public DetailedProduct(Product product, String file, Panier panier) {
		this.product = product;
		this.file=file;
		this.panier=panier;
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
		text.setEffect(dropShadow);
		text.setId("text");
		// Adding text to HBox
		hb.getChildren().add(text);
		bp.setId("bp");
		gridPane.setId("root");
		bp.setTop(hb);
		bp.setCenter(gridPane);
		// adding information of the product
		 ImageView imageView = new ImageView(getClass().getResource(product.getImage()).toExternalForm());
		    imageView.setFitHeight(40);
		    imageView.setFitWidth(40);
		    gridPane.setAlignment(Pos.CENTER);
		    gridPane.add(imageView, 1, 0);
		    Label nameProduct = new Label("Name ");
			Label brandProduct = new Label("Brand ");
			Label priceProduct = new Label("Price ");
			Label quantityProduct = new Label("Quantity ");
			nameProduct.setId("label");
			brandProduct.setId("label");
			priceProduct.setId("label");
			quantityProduct.setId("label"); 
			gridPane.add(nameProduct, 0, 1);
			gridPane.add(brandProduct, 1, 1);
			gridPane.add(priceProduct, 2, 1);
			gridPane.add(quantityProduct, 3, 1);
			Label pname=new Label(product.getName());
			gridPane.add(pname, 0,2);
			Label pbrand=new Label(product.getBrand());
			gridPane.add(pbrand, 1,2);
			Label price=new Label(""+product.getPrice());
			gridPane.add(price, 2,2);
			Label quantity=new Label(""+product.getQuantity());
			gridPane.add(quantity, 3,2);
			// ajouter panier 
			Button achat=new Button("add to basket");
			achat.setId("buttonOrange");
			gridPane.add(achat, 0, 3);
			Button pay=new Button("Go to checkout");
			pay.setId("buttonOrange");
			gridPane.add(pay, 1, 3);
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
					GoCheckout check=new GoCheckout(panier);
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
		scene.getStylesheets().add(getClass().getClassLoader().getResource(file).toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Product Details");
		primaryStage.show();

	}
}
