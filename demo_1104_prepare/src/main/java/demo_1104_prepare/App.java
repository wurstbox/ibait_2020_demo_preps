package demo_1104_prepare;

import java.util.ResourceBundle;

import demo_1104_prepare.model.service.BookMockService;
import demo_1104_prepare.model.service.BookServiceProvider;
import demo_1104_prepare.ui.BooksController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
	
	public static void main(String[] args)
	{
		BookServiceProvider.set(new BookMockService());
		launch();
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception
	{		
		var fxml = getClass().getResource("/fxml/Books.fxml");
		var text = ResourceBundle.getBundle("i18n/books");
		var controller = new BooksController();
		
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(fxml);
		loader.setResources(text);
		loader.setController(controller);
		
    Parent root = loader.load();
    
    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    
    primaryStage.show();
	}


	

}
