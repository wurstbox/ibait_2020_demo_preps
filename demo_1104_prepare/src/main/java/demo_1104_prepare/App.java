package demo_1104_prepare;

import demo_1104_prepare.model.service.BookMockService;
import demo_1104_prepare.model.service.BookServiceProvider;
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
		BookServiceProvider.set(new BookMockService());
		
		var books = BookServiceProvider.get().getBooks();
		
		books.forEach( 
				book -> System.out.println( book.getAuthor().getName() + " - " + book.getTitle() ) );
		
//		var title = "Hello World";
//
//		primaryStage.setTitle(title);
//		primaryStage.show();
	}


	

}
