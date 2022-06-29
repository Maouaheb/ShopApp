package AOPfinal;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PaymentPaypal extends Paiment {
	public void pay(GridPane gridPane, int l) {
		Text info = new Text("Connect to your paypal account");
		info.setId("labelTitle");
		Label email = new Label("Email : ");
		email.setId("label");
		TextField emailT = new TextField();
		Label pwd = new Label(" password of paypal  account");
		pwd.setId("label");
		TextField pwdT = new TextField();
		gridPane.add(info, 0, l + 2);
		gridPane.add(email, 0, l + 5);
		gridPane.add(emailT, 1, l + 5);
		gridPane.add(pwd, 0, l + 8);
		gridPane.add(pwdT, 1, l + 8);

		Button confirm = new Button("Confirm ");
		confirm.setId("btnconfirm");
		gridPane.add(confirm, 0, l + 10);
	}

}
