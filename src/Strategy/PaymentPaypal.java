package Strategy;

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
	public void pay(GridPane gridPane) {
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

	private void delete(GridPane gridPane) {
		// TODO Auto-generated method stub
		 Set<Node> deleteNodes = new HashSet();
		    for (Node child : gridPane.getChildren()) 
		    {
		        // get index from child
		        Integer rowIndex = GridPane.getRowIndex(child);
		        int i=3;
		        while(i<=6) {
		        	if(rowIndex == i)
			        {
			            deleteNodes.add(child);
			            i=i+1;
			        }
		        }
		        
		    }

		    // remove nodes from row
		    gridPane.getChildren().removeAll(deleteNodes);
	}

}
