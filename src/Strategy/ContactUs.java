package Strategy;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContactUs extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Contact");
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
		Label telephone = new Label("+32467820280");
		Label email = new Label("contactUs@gmail.com");
		Label address = new Label("Rue de Bruno , 5000 Namur, Belgique ");
		// photos for each information
		ImageView phone = new ImageView(getClass().getResource("../phone.jpg").toExternalForm());
	    phone.setFitHeight(15);
	    phone.setFitWidth(15);
	    ImageView mailSymbol = new ImageView(getClass().getResource("../email.png").toExternalForm());
	    mailSymbol.setFitHeight(15);
	    mailSymbol.setFitWidth(15);
	    ImageView gps = new ImageView(getClass().getResource("../address.png").toExternalForm());
	    gps.setFitHeight(15);
	    gps.setFitWidth(15);
		// Adding Nodes to GridPane layout
		gridPane.add(phone, 0, 0);
		gridPane.add(telephone, 1, 0);
		gridPane.add(mailSymbol, 0, 1);
		gridPane.add(email, 1, 1);
		gridPane.add(gps, 0, 2);
		gridPane.add(address, 1, 2);


		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Meet Us");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);

		// Adding text to HBox 
		hb.getChildren().add(text);
		// the Logo of home page
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
	}

}
