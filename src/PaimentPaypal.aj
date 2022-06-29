import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public aspect PaimentPaypal {
	pointcut risk(GridPane gridPane) : execution(void GoCheckout.paimentPaypal(GridPane))&& args(gridPane);
	after(GridPane gridPane) returning() : risk(gridPane) {
		System.out.println("paiment paypal aspect is injected when calling cover");
		Text info = new Text(" connect to your paypal account");
		info.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		Label email=new Label("Email : ");
		TextField emailT=new TextField();
		Label pwd=new Label(" password of paypal  account");
		TextField pwdT=new TextField();
		gridPane.add(info, 0, 3);
		gridPane.add(email, 0, 5);
		gridPane.add(emailT, 1, 5);
		gridPane.add(pwd, 0, 6);
		gridPane.add(pwdT, 1, 6);
		
		Button confirm=new Button("Confirm ");
		confirm.setId("buttonlogin");
		gridPane.add(confirm, 0, 7);
		}

}
