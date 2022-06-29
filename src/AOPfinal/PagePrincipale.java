package AOPfinal;

import java.util.ArrayList;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PagePrincipale extends Application {
	public ArrayList<Product> products;
	public ArrayList<String> files;
	public Panier panier;
	public User user;
	public PagePrincipale(ArrayList<String> files,User user) {
		this.files = files;
		// TODO Auto-generated constructor stub
		products = new ArrayList<Product>();
		panier = new Panier();
		this.user=user;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Start your shopping");
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
		Text text = new Text("Start your shopping");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));

		// Adding text to HBox
		hb.getChildren().add(text);
		
		// Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		text.setId("text");
		bp.setTop(hb);
		bp.setCenter(gridPane);
		// choix Produits Femme
		ComboBox<String> femme = new ComboBox<String>();
		femme.getItems().add("Dress");
		femme.getItems().add("Bags");
		femme.getItems().add("Shoes");
		femme.getItems().add("Denim");
		femme.setId("listView");
		femme.setValue("Femme");
		gridPane.add(femme, 0, 0);
		/*femme.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> arg0) {
				// TODO Auto-generated method stub
				ListCell<String> articles=new ListCell<String>() {
					@Override
					public void updateItem(String string,boolean empty) {
						if(femme.getValue().equals("Dress") || femme.getValue().equals("Bags") ||femme.getValue().equals("Shoes")|| femme.getValue().equals("Denim")) {
							setTextFill(Color.BEIGE);
						}
						else {
							setTextFill(Color.BLACK);
						}
					}
				};
				
				return articles;
			}
		});*/

		// choix Produits Homme
		ComboBox<String> homme = new ComboBox<String>();
		homme.getItems().add("Shirt");
		homme.getItems().add("Denim");
		homme.getItems().add("Shoes");
		homme.setId("listView");
		homme.setValue("Homme");
		gridPane.add(homme, 1, 0);
		// choix Produits Homme
		ComboBox<String> enfant = new ComboBox<String>();
		enfant.getItems().add("Clothes");
		enfant.getItems().add("Toys");
		enfant.getItems().add("Essential for babies");
		enfant.setId("listView");
		enfant.setValue("Enfant");
		gridPane.add(enfant, 2, 0);
		// choix Produits Homme
		ComboBox<String> electro = new ComboBox<String>();
		electro.getItems().add("Kitchen machines");
		electro.getItems().add("electronics");
		electro.getItems().add("Bricolage");
		electro.setId("listView");
		electro.setValue("Home appliance");
		gridPane.add(electro, 3, 0);

		// adding the search bar

		TextField textSearch = new TextField();
		textSearch.setPromptText("Search here!");
		textSearch.setFocusTraversable(false);
		gridPane.add(textSearch, 4, 0);
		textSearch.setId("textSearch");
		textSearch.setPrefHeight(40); // sets height of the TextArea to 400 pixels
		textSearch.setPrefWidth(300);

		// add the products to vbox

		electro.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ConnectionLogIn connexion = new ConnectionLogIn();
				// TODO Auto-generated method stub
				if (electro.getValue() == "electronics") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("electronic");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (electro.getValue() == "Kitchen machines") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("kitchen-machines");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (electro.getValue() == "Bricolage") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("bricolage");
					products.addAll(p);
					addProducts(products, gridPane);
				}
			}

		});

		// product for kids

		enfant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ConnectionLogIn connexion = new ConnectionLogIn();

				// TODO Auto-generated method stub
				if (enfant.getValue() == "Clothes") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("clothes");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (enfant.getValue() == "Essential for babies") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("essential");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (enfant.getValue() == "Toys") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("toys");
					products.addAll(p);
					addProducts(products, gridPane);
				}
			}
		});

		femme.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ConnectionLogIn connexion = new ConnectionLogIn();

				// TODO Auto-generated method stub
				if (femme.getValue() == "Dress") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("dress");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (femme.getValue() == "Bags") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("bags");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (femme.getValue() == "Denim") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("denim-femme");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (femme.getValue() == "Shoes") {
					ArrayList<Product> p = new ArrayList<Product>();
					p = connexion.getProducts("shoes-femme");
					products.addAll(p);
					addProducts(products, gridPane);
				}
			}
		});

		// product for homme

		homme.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ConnectionLogIn connexion = new ConnectionLogIn();
				// TODO Auto-generated method stub
				if (homme.getValue() == "Denim") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("denim-homme");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (homme.getValue() == "Shoes") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("shoes-homme");
					products.addAll(p);
					addProducts(products, gridPane);
				}
				if (homme.getValue() == "Shirt") {
					ArrayList<Product> p = new ArrayList<Product>();

					p = connexion.getProducts("shirt");
					products.addAll(p);
					addProducts(products, gridPane);
				}
			}

		});
		

		// Creating the check boxes
		CheckBox fnak = new CheckBox("Fnak");
		CheckBox amazon = new CheckBox("Amazing");
		CheckBox local = new CheckBox("Local");
		fnak.setId("checkbox");
		amazon.setId("checkbox");
		local.setId("checkbox");
		gridPane.add(fnak, 5, 0);
		gridPane.add(amazon, 6, 0);
		gridPane.add(local, 7, 0);
		gridPane.setHalignment(fnak, HPos.RIGHT);
		// the Logo of home page
		ImageView imageView = new ImageView("home.png");
		Button button = new Button("", imageView);
		button.setContentDisplay(ContentDisplay.LEFT);
		imageView.setFitHeight(40);
		imageView.setFitWidth(70);
		button.setId("buttonImage");
		hb.setMargin(button, new Insets(10, 10, 10, 900));
		hb.setMargin(text, new Insets(10, 10, 10, 10));

		// adding logo to HBox
		hb.getChildren().add(button);
		// set action for Logo image to go back to the welcome screen
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WelcomeScreen welcome = new WelcomeScreen();
				try {
					welcome.start(new Stage());
					primaryStage.hide();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		amazon.setOnAction(new EventHandler<ActionEvent>() {
		@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			AmazingAPI api=new AmazingAPI();
			api.parseData();
			ArrayList<Product> l=api.getProducts();
			products.addAll(l);
			addProducts(products, gridPane);

				
			}
		});
		fnak.setOnAction(new EventHandler<ActionEvent>() {
		@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			FnakAPI api=new FnakAPI();
			api.parseData();
			ArrayList<Product> l=api.getProducts();
			products.addAll(l);
			addProducts(products, gridPane);

				
			}
		});
		// get textfield when selecting local
		local.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String research = textSearch.getText();
				ConnectionLogIn request = new ConnectionLogIn();
				ArrayList<Product> p = new ArrayList<Product>();
				p = request.getProductsMotCles(research);
				products.addAll(p);
				//addProducts(products, gridPane);

			}
		});

		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);
		if (files.size() == 1) {
			scene.getStylesheets().add(getClass().getClassLoader().getResource(files.get(0)).toExternalForm());

		}
		if (files.size() == 2) {
			String cssFile1 = this.getClass().getResource(files.get(0).toString()).toExternalForm();
			String cssFile2 = this.getClass().getResource(files.get(1).toString()).toExternalForm();

			scene.getStylesheets().addAll(cssFile1, cssFile2);
		}
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(1500);
		primaryStage.setTitle("Do your shopping");
		primaryStage.show();
	}

	private void addProducts(ArrayList<Product> products, GridPane gridPane) {
		Label nameProduct = new Label("Name ");
		Label brandProduct = new Label("Brand ");
		Label priceProduct = new Label("Price ");
		Label quantityProduct = new Label("Quantity ");

		Label image = new Label("Image");
		nameProduct.setId("labelProduct");
		brandProduct.setId("labelProduct");
		priceProduct.setId("labelProduct");
		quantityProduct.setId("labelProduct");
		image.setId("labelProduct");

		if (products.size() > 0) {
			gridPane.add(nameProduct, 0, 8);
			gridPane.add(brandProduct, 1, 8);
			gridPane.add(priceProduct, 2, 8);
			gridPane.add(quantityProduct, 3, 8);
			gridPane.add(image, 4, 8);
			for (int i = 0; i < products.size(); i++) {
				int cpt = 0;
				Product p = products.get(i);
				System.out.println(p.getName()+"  hello   ");
				ImageView imageview = new ImageView(getClass().getResource("../" + p.getImage()).toExternalForm());
				imageview.setFitHeight(30);
				imageview.setFitWidth(30);
				p.setImageView(imageview);
				imageview.setId("imageview");
				Label pname = new Label(p.getName());
				gridPane.add(pname, cpt, 9 + i);
				Label pbrand = new Label(p.getBrand());
				gridPane.add(pbrand, cpt + 1, 9 + i);
				Label price = new Label("" + p.getPrice());
				gridPane.add(price, cpt + 2, 9 + i);
				Label quantity = new Label("" + p.getQuantity());
				pname.setId("infoProduct");
				pbrand.setId("infoProduct");
				quantity.setId("infoProduct");
				price.setId("infoProduct");
				gridPane.add(quantity, cpt + 3, 9 + i);
				gridPane.add(imageview, cpt + 4, 9 + i);
				imageview.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					DetailedProduct detailedproduct = new DetailedProduct(p, files, panier,user);
					try {
						detailedproduct.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					event.consume();
				});
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
