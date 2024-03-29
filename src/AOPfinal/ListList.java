package AOPfinal;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListList extends Application {

	final ListView listView = new ListView();

	@Override
	public void start(Stage primaryStage) {

		List<Hyperlink> links = new ArrayList<>();

		AnchorPane pane = new AnchorPane();
		VBox vBox = new VBox();
		final Hyperlink link = new Hyperlink("http://blog.professional-webworkx.de");
		Hyperlink link2 = new Hyperlink("http://www.stackoverflow.com");

		links.add(link);
		links.add(link2);

		for (final Hyperlink hyperlink : links) {
			hyperlink.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					getHostServices().showDocument(hyperlink.getText());
				}
			});
		}

		listView.getItems().addAll(links);
		HBox hBox = new HBox();
		final TextField urlField = new TextField();
		Button b = new Button("Add Links");
		hBox.getChildren().addAll(b, urlField);

		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				addLink(urlField.getText().trim());
				urlField.clear();
			}
		});
		vBox.getChildren().add(hBox);
		vBox.getChildren().add(listView);
		pane.getChildren().add(vBox);
		Scene scene = new Scene(pane, 800, 600);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	private void addLink(final String url) {
		final Hyperlink link = new Hyperlink(url);
		link.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				getHostServices().showDocument(link.getText());
				// openBrowser(link.getText());
			}

		});
		listView.getItems().add(link);
	}

	private void openBrowser(final String url) {
		getHostServices().showDocument(url);
	}
}