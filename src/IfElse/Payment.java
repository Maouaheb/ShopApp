package IfElse;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Payment {
	public void paypal(GridPane gridPane) {
		//delete(gridPane);
		Text info = new Text("paypal account");
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
				
	}
	public void paycard(GridPane gridPane) {
		Text info = new Text(" Card Information");
		info.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		Label nomCarte=new Label("Name : ");
		TextField nom=new TextField();
		Label numCard=new Label("Number of card");
		TextField num=new TextField();
		Label expiryDate=new Label("Expiry Date : ");
		TextField expiration=new TextField();
		Label ccv=new Label("Secret code");
		TextField code=new TextField();
		gridPane.add(info, 0, 3);
		gridPane.add(nomCarte, 0, 5);
		gridPane.add(nom, 1, 5);
		gridPane.add(numCard, 0, 6);
		gridPane.add(num, 1, 6);
		gridPane.add(expiryDate, 0, 7);
		gridPane.add(expiration, 1, 7);
		gridPane.add(ccv, 2, 7);
		gridPane.add(code, 3, 7);
	}
}
