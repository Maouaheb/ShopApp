package AOPfinal;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public aspect Young {
	pointcut young( GridPane gridPane, int l) : execution(void GoCheckout.isYoung(GridPane, int))&& args(gridPane,l);
	after(GridPane gridPane,int l) returning() : young(gridPane,l) {
		Label info = new Label("  Gift card information ");
		info.setId("labelProduct");
		Label solde=new Label("Current balance : ");
		solde.setId("label");
		Label soldeactuel=new Label("120 euros ");
		soldeactuel.setId("labelProduct");
		Label numCard=new Label("Number of card");
		numCard.setId("label");
		Label infocard = new Label("  1254x7y ");
		infocard.setId("labelProduct");
		gridPane.add(info, 0, l+2);
		gridPane.add(numCard, 0, l+4);
		gridPane.add(infocard, 2, l+4);
		gridPane.add(solde, 0, l+6);
		gridPane.add(soldeactuel, 2, l+6);
		Button confirm=new Button("Confirm ");
		confirm.setId("btnconfirm");
		gridPane.add(confirm, 0, l+8);
	}

}
