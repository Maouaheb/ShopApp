package Strategy;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class GoCheckout extends Application {
	Panier panier;
	GridPane gridPane;
	@feature
	Paiment paymentstrategy;
	ArrayList<Product>products;
	public GoCheckout(Panier panier) {
		

		this.panier=panier;
		products=new ArrayList<Product>();
	}
	public float prixtotal() {
		return panier.paiment();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//information of payment 
		primaryStage.setTitle("Details of basket ");
		primaryStage.getIcons().add(new Image("logo.jpg"));

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		gridPane = new GridPane();
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
		Text text = new Text(" See your basket ");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);
		text.setId("text");
		// Adding text to HBox
		hb.getChildren().add(text);
		bp.setId("bp");
		gridPane.setId("root");
		bp.setTop(hb);
		bp.setCenter(gridPane);
		
		//Button pay=new Button("Pay now");
		//pay.setId("buttonOrange");
		CheckBox card = new CheckBox("Master or Visa card");
		CheckBox paypal = new CheckBox("Paypal");
		card.setId("checkbox");	
		paypal.setId("checkbox");
		
		products.addAll(panier.listeProduct());
		// display the list of products
		if(products.size()>0) {
			for(int i=0;i<products.size();i++) {
				Label name=new Label(products.get(i).getName());
				gridPane.add(name, 0, i+1);
				
			
		}
			Label prix=new Label("total price "+panier.paiment());
			prix.setId("label");
			gridPane.add(prix, 0, products.size()+1);
			gridPane.add(card, 4, products.size()+1);
			gridPane.add(paypal, 6, products.size()+1);
			Button confirm=new Button("Confirm ");
			gridPane.add(confirm, 0, 9);
			confirm.setId("buttonlogin");

			card.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					paymentstrategy=new PaymentCard();
					paymentstrategy.pay(gridPane);
					
			
					
				}
			});
			paypal.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					paymentstrategy=new PaymentPaypal();
					paymentstrategy.pay(gridPane);
					
				}
			});
			confirm.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					ConnectionLogIn login=new ConnectionLogIn();
					// TODO Auto-generated method stub
					for(int i=0;i<products.size();i++) {
						int count=products.get(i).getQuantity()-1;
						products.get(i).setQuantity(count);					
						login.updateProduct(products.get(i));
						primaryStage.hide();
					}
					
				}
			});
		}
		else {
			Label notext=new Label("Baskt is empty !");
		}
		// the Logo of home page
			primaryStage.setHeight(500);

				Button button=new Button();
			    ImageView imageView = new ImageView(getClass().getResource("../logo.jpg").toExternalForm());
			    imageView.setFitHeight(20);
			    imageView.setFitWidth(20);
			    button.setGraphic(imageView);
			    button.setId("buttonImage");
			    // adding logo to HBox
			    hb.getChildren().add(button);
			    // set action for Logo image to go back to the welcome screen
			    button.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						primaryStage.hide();
					}
				});
			    bp.setId("bp");
				gridPane.setId("root");
				bp.setTop(hb);
				bp.setCenter(gridPane);


			// Adding BorderPane to the scene and loading CSS
			Scene scene = new Scene(bp);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setHeight(500);
			primaryStage.setWidth(1000);
			primaryStage.titleProperty()
			
					.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
			// primaryStage.setResizable(false);
			primaryStage.show();
		
		// paiment
		
		paimentCard(gridPane);
		

		
	}
	public void paimentCard(GridPane p) {
		
	}
public void paimentPaypal(GridPane p) {
		
	}
	

}
