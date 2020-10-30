package demo_1104_prepare;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
	
	public static void main(String[] args)
	{
		launch();
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		var title = "Hello World";

		primaryStage.setTitle(title);
		primaryStage.show();
	}
	

}
