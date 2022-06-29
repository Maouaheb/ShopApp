package AOPfinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShopLogin extends Application {
	public String checkUser;
	public String checkPw;
	public static String file;
	public static String fileSize;
	public User user;
	ArrayList<String>files;
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public ShopLogin() {
		file=null;
		files=new ArrayList<String>();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Login");
        primaryStage.getIcons().add(new Image("logo.jpg"));

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox(5);
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
        ImageView imageDecline1 = new ImageView("fleche.png");
		Button btnLogin = new Button("Login",imageDecline1);
		imageDecline1.setFitHeight(20);
		imageDecline1.setFitWidth(20);
		btnLogin.setContentDisplay(ContentDisplay.RIGHT);
		
		final Label lblMessage = new Label();
		lblUserName.setId("label");
		lblPassword.setId("label");
		// Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(btnLogin, 4, 1);
		gridPane.add(lblMessage, 1, 2);

		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Login to your account");
		text.setId("text");
		// Adding text to HBox 
		hb.getChildren().add(text);
		// the Logo of home page
		 ImageView  imageView = new ImageView("home.png");
	  // ImageView   = new ImageView(getClass().getResource("../home.png").toExternalForm());
			Button button=new Button("",imageView);
			button.setContentDisplay(ContentDisplay.LEFT);
	    imageView.setFitHeight(30);
	    imageView.setFitWidth(60);
	    button.setId("buttonImage");
	    // adding logo to HBox
	    hb.getChildren().add(button);
	
	    // set action for Logo image to go back to the welcome screen
	    button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WelcomeScreen welcome=new WelcomeScreen();
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
		// Action for btnLogin
		btnLogin.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				 checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
				ConnectionLogIn c=new ConnectionLogIn();
				String handicap="";
				user=new User();
				boolean result=c.getConnection(checkUser, checkPw, lblMessage, user);					
				// myopic
				if(user.isHandicap() == false) {
					files.add("login.css");
				}
				else {
					if(user.isPresbytie()) {
						files.add(User.filePresbytie);
					}
					if(user.isColorblind()) {
						files.add(User.fileColorblind);
					}
				}
				
				txtUserName.setText("");
				pf.setText("");
				if(result==true) {
					PagePrincipale shop=new PagePrincipale(files,user);
					try {
						shop.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					primaryStage.hide();
				}
			}

			
		});
		// Add HBox and GridPane layout to BorderPane Layout
		
		bp.setTop(hb);
		bp.setCenter(gridPane);
		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.titleProperty()
				.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
		primaryStage.show();

	}

	
		
	}


