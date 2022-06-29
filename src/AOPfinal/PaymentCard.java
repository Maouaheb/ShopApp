package AOPfinal;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PaymentCard extends Paiment {
	public void pay(GridPane gridPane, int l) {
		Text info = new Text(" Card Information");
		info.setId("labelTitle");
		Label nomCarte = new Label("Name : ");
		TextField nom = new TextField();
		Label numCard = new Label("Number of card");
		TextField num = new TextField();
		Label expiryDate = new Label("Expiry Date : ");
		TextField expiration = new TextField();
		Label ccv = new Label("Secret code");
		TextField code = new TextField();
		nomCarte.setId("label");
		numCard.setId("label");
		expiryDate.setId("label");
		ccv.setId("label");
		gridPane.add(info, 0, l + 2);
		gridPane.add(nomCarte, 0, l + 4);
		gridPane.add(nom, 1, l + 4);
		gridPane.add(numCard, 0, l + 7);
		gridPane.add(num, 1, l + 7);
		gridPane.add(expiryDate, 0, l + 10);
		gridPane.add(expiration, 1, l + 10);
		gridPane.add(ccv, 3, l + 10);
		gridPane.add(code, 4, l + 10);
		Button confirm = new Button("Confirm ");
		confirm.setId("btnconfirm");
		gridPane.add(confirm, 0, l + 15);
	}
}
