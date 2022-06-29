
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {
	public String filecss;
	@Override
	public void start(Stage primaryStage) throws Exception {


		primaryStage.setTitle("Shop welcome screen");
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
		//choix layout
		ComboBox<String> listView=new ComboBox<String>();
		listView.getItems().add("Vertical");
		listView.getItems().add("Horizontal");
		listView.getItems().add("Border");
		listView.getItems().add("Flow");
		TilePane tilePane = new TilePane(listView);
		listView.setId("listView");
		listView.setValue("Choose Layout");
		
		
		// Implementing Nodes for GridPane
		Button btnLogin = new Button("Sign in");
		Button btnsubscribe = new Button("Sign up");
		Button btncontact = new Button("Contact us");

		// Adding Nodes to GridPane layout
		gridPane.add(btnLogin, 0, 0);
		gridPane.add(btnsubscribe, 1, 0);
		gridPane.add(btncontact, 2, 0);
		gridPane.add(listView, 3, 0);
		
		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Welcome to your shopping application");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);
	

		// Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		btnsubscribe.setId("btnsubscribe");
		btncontact.setId("btncontact");
		text.setId("text");

		// Action for btnLogin
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ShopLogin shop = new ShopLogin();
				try {
					shop.start(new Stage());
					primaryStage.hide();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// Action for btncontact
		btncontact.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ContactUs contact = new ContactUs();
				try {
					contact.start(new Stage());
					primaryStage.hide();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// action for subscribe button
		btnsubscribe.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Subscribe subscribe = new Subscribe();
				try {
					subscribe.start(new Stage());
					primaryStage.hide();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// Add HBox and GridPane layout to BorderPane Layout
		hb.getChildren().add(text);
		bp.setTop(hb);
		bp.setCenter(gridPane);

		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);
		filecss="login.css";
		scene.getStylesheets().add(getClass().getClassLoader().getResource(filecss).toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setHeight(250);
		primaryStage.setTitle("Shop");
		primaryStage.show();

	}

	public static void main(String args[]) {
		// launch the application
		launch(args);
	}

}
