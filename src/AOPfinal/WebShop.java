package AOPfinal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebShop  extends Application {

    private WebView webView;

    @Override
    public void start(Stage stage) {
        this.webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.google.com/");

        BorderPane pane = new BorderPane(this.webView);
        Scene scene = new Scene(pane, 500, 500);

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

  /*  public static void main(String[] args) {
        launch(args);
    }*/
}
