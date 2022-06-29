package AOPfinal;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
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
	ArrayList<String> files;
	ArrayList<Product> products;
	Paiment paimentStrategy;
	public User user;
	int year;
	public GoCheckout(Panier panier, ArrayList<String> files,User user) {
		this.panier = panier;
		this.files = files;
		products = new ArrayList<Product>();
		this.user=user;
		this.year=user.getCalendar().get(Calendar.YEAR);
	}

	public float prixtotal() {
		return panier.paiment();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// information of payment
		primaryStage.setTitle("Details of basket ");
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
		Text text = new Text(" Finalize your purchase ! ");
		text.setId("text");
		// Adding text to HBox
		hb.getChildren().add(text);
		bp.setId("bp");
		gridPane.setId("root");
		bp.setTop(hb);
		bp.setCenter(gridPane);

		CheckBox card = new CheckBox("Master or Visa card");
		CheckBox paypal = new CheckBox("Paypal");
		card.setId("checkbox");
		paypal.setId("checkbox");
		gridPane.add(card, 7, products.size() + 1);
		gridPane.add(paypal, 8, products.size() + 1);
		if(year >2002) {
			isYoung(gridPane,products.size() + 2);
			card.setDisable(true);
			paypal.setDisable(true);
		}
		card.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				paimentStrategy=new PaymentCard();
				paimentStrategy.pay(gridPane,products.size() + 2);
			}
		});
		paypal.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				paimentStrategy=new PaymentPaypal();
				paimentStrategy.pay(gridPane,products.size() + 2);

			}
		});
		Label basket=new Label("Basket :");
		basket.setId("labelProduct");
		Text info = new Text(" Card Information");
		info.setId("textCard");
		info.setEffect(dropShadow);
		products.addAll(panier.listeProduct());
		// display the list of products
		if (products.size() > 0) {
			for (int i = 0; i < products.size(); i++) {
				Label name = new Label(products.get(i).getName());
				name.setId("label");
				gridPane.add(name, 1, i + 1);

			}
			gridPane.add(basket, 0, 1);
			Label prix = new Label("total price " + panier.paiment());
			prix.setId("labelProduct");
			gridPane.add(prix, 4, products.size() );

		} else {
			Label notext = new Label("Baskt is empty !");
		}
		// the Logo of home page
		ImageView imageView = new ImageView("home.png");
		Button button = new Button("", imageView);
		button.setContentDisplay(ContentDisplay.LEFT);
		imageView.setFitHeight(30);
		imageView.setFitWidth(60);
		button.setId("buttonImage");
		// adding logo to HBox
		hb.getChildren().add(button);
		hb.setMargin(button, new Insets(10, 10, 10, 900));
		hb.setMargin(text, new Insets(10, 10, 10, 10));

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
		if (files.size() == 1) {
			scene.getStylesheets().add(getClass().getClassLoader().getResource(files.get(0)).toExternalForm());

		}
		if (files.size() == 2) {
			String cssFile1 = this.getClass().getResource(files.get(0)).toExternalForm();
			String cssFile2 = this.getClass().getResource(files.get(1)).toExternalForm();
			scene.getStylesheets().addAll(cssFile1, cssFile2);
		}
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(1200);
		primaryStage.titleProperty()
				.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
		// primaryStage.setResizable(false);
		primaryStage.show();

		// paiment

	}

	public void isYoung(GridPane gridPane,int l) {
		// TODO Auto-generated method stub
		
	}

	public void paimentCard(GridPane gridPane, int l) {
		
	}

	public void paimentPaypal(GridPane gridPane, int l) {
		
	}

}
