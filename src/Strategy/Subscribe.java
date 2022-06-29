package Strategy;
import java.sql.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Subscribe extends Application {
	double count = 10.0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Subscribe");
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

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username");
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField pf = new PasswordField();
		Label lblconfirmPassword = new Label("confirm your Password");
		PasswordField pfconfirm = new PasswordField();
		Button btnLogin = new Button("register");
		final Label lblMessage = new Label();
		ComboBox<String> listView = new ComboBox<String>();
		listView.setId("buttonComboboxDisability");
		listView.getItems().add("colorblind");
		listView.getItems().add("myopic");
		listView.getItems().add("normal");
		listView.setValue("normal");
		Label choix = new Label("Kind of Disability");
		 // create a date picker
		Label date=new Label("Date of birth");
        DatePicker d = new DatePicker();
        d.setId("date");
  		// add increment and decrease button
		Button plus = new Button("+");
		Button moins = new Button("-");
		Label indice = new Label("  ");
		Label indiceL=new Label("Blind Severity");
		// incrementer
		plus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				count= count+ 0.5;
				indice.setText("" + count);

			}
		});
		// desincrementer
		moins.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (count>=0) {
					count = count- 0.5;
					indice.setText("" + count);
				}
				

			}
		});
		plus.setId("buttonSecondaire");
		moins.setId("buttonSecondaire");

		// Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(lblconfirmPassword, 0, 2);
		gridPane.add(pfconfirm, 1, 2);
		gridPane.add(choix, 0, 3);
		gridPane.add(listView, 1, 3);
		//listview myopic
			listView.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(listView.getValue() == "myopic") {
						gridPane.add(indiceL, 2, 3);
						gridPane.add(plus, 3, 3);
						gridPane.add(indice, 4, 3);
						gridPane.add(moins, 5, 3);
						System.out.println("myopic selected ");}

					
					
				}
			});
		
		
		gridPane.add(date, 0, 4);
		gridPane.add(d, 1, 4);
		gridPane.add(btnLogin, 1, 5);
		gridPane.add(lblMessage, 1, 6);

		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Suscribe");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);

		// Adding text to HBox
		hb.getChildren().add(text);
		// the Logo of home page
		Button button = new Button();
		ImageView imageView = new ImageView(getClass().getResource("../logo.jpg").toExternalForm());
		imageView.setFitHeight(20);
		imageView.setFitWidth(20);
		button.setGraphic(imageView);
		button.setId("button");
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
		// Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		text.setId("text");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ConnectionLogIn c = new ConnectionLogIn();
				String handicap = listView.getValue();
				if (handicap =="myopic") {
					double indice=count;
				}
				Date date= java.sql.Date.valueOf(d.getValue());
				String name = txtUserName.getText();
				String pwd = pf.getText();
				c.addUser(name, pwd, handicap, lblMessage,count,date);

			}
		});
		// Action for btnLogin

		// Add HBox and GridPane layout to BorderPane Layout
		bp.setTop(hb);
		bp.setCenter(gridPane);

		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.titleProperty()
				.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
		// primaryStage.setResizable(false);
		primaryStage.setHeight(500);
		primaryStage.setWidth(700);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
