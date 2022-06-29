import java.util.ArrayList;

import Strategy.PaymentCard;
import Strategy.PaymentPaypal;
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
		
		Button pay=new Button("Pay now");
		pay.setId("buttonOrange");
		/*Text info = new Text(" Card Information");
		info.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		info.setEffect(dropShadow);
		Label nomCarte=new Label("Name : ");
		TextField nom=new TextField();
		Label numCard=new Label("Number of card");
		TextField num=new TextField();
		Label expiryDate=new Label("Expiry Date : ");
		TextField expiration=new TextField();
		Label ccv=new Label("Secret code");
		TextField code=new TextField();
		products.addAll(panier.listeProduct());*/
		// display the list of products
		if(products.size()>0) {
			for(int i=0;i<products.size();i++) {
				Label name=new Label(products.get(i).getName());
				gridPane.add(name, 0, i+1);
				
			}
		}
			Label prix=new Label("total price "+panier.paiment());
			prix.setId("label");
			gridPane.add(prix, 0, products.size()+1);
			gridPane.add(pay, 4, products.size()+1);
			/*
			pay.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					gridPane.add(info, 0, 3);
					gridPane.add(nomCarte, 0, 5);
					gridPane.add(nom, 1, 5);
					gridPane.add(numCard, 0, 6);
					gridPane.add(num, 1, 6);
					gridPane.add(expiryDate, 0, 7);
					gridPane.add(expiration, 1, 7);
					gridPane.add(ccv, 2, 7);
					gridPane.add(code, 3, 7);
					Button confirm=new Button("Confirm ");
					confirm.setId("buttonlogin");
					gridPane.add(confirm, 0, 9);
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
			});
		}
		else {
			Label notext=new Label("Baskt is empty !");
		}*/
		// the Logo of home page
			primaryStage.setHeight(500);
			CheckBox card = new CheckBox("Master or Visa card");
			CheckBox paypal = new CheckBox("Paypal");
			card.setId("checkbox");	
			paypal.setId("checkbox");
			gridPane.add(card, 7, products.size()+1);
			gridPane.add(paypal, 8, products.size()+1);
	card.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					paimentCard(gridPane);

					
			
					
				}
			});
			paypal.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					paimentPaypal(gridPane);
					
				}
			});

			
				Button button=new Button();
			    ImageView imageView = new ImageView(getClass().getResource("logo.jpg").toExternalForm());
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
			primaryStage.titleProperty()
					.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
			// primaryStage.setResizable(false);
			primaryStage.show();
		
		// paiment
			primaryStage.setHeight(500);
			primaryStage.setWidth(1000);
		

		
	}
	public void paimentCard(GridPane p) {
		
	}
public void paimentPaypal(GridPane p) {
		
	}
	

}
