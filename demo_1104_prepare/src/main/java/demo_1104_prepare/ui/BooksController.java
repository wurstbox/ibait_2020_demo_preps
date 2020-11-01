package demo_1104_prepare.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import demo_1104_prepare.model.books.Book;
import demo_1104_prepare.model.service.BookServiceProvider;
import demo_1104_prepare.model.service.ServiceException;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class BooksController implements Initializable
{
	@FXML
	private TableView<UIBook> table;
	@FXML
	private Button deleteButton;

	private final SimpleListProperty<UIBook> items;
	private final SimpleBooleanProperty deleteButtonDisabled;
	private final SimpleObjectProperty<UIBook> selected;

	public BooksController()
	{
		this.items = new SimpleListProperty<>();
		this.deleteButtonDisabled = new SimpleBooleanProperty();
		this.selected = new SimpleObjectProperty<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.makeBindings();
		this.populateData();
	}

	private void makeBindings()
	{
		this.items.bindBidirectional(this.table.itemsProperty());
		this.deleteButtonDisabled.bindBidirectional(this.deleteButton.disableProperty());
		this.selected.bind(this.table.getSelectionModel().selectedItemProperty());
				
		this.deleteButtonDisabled.bind(Bindings.isNull(this.selected));
	}

	private void populateData()
	{
		var books = getBooksFromService();
		var uiBooks = convertToUIModel(books);

		this.items.setAll(uiBooks);
	}

	private ObservableList<UIBook> convertToUIModel(List<Book> books)
	{
		return books.stream().map(UIBook::new).collect(Collectors.toCollection(FXCollections::observableArrayList));
	}

	private List<Book> getBooksFromService()
	{
		List<Book> books;

		try
		{
			var dataProvider = BookServiceProvider.get();
			books = dataProvider.getBooks();
		}
		catch (ServiceException e)
		{
			books = new ArrayList<>();

			e.printStackTrace();
		}

		return books;
	}

	@FXML
	private void onDeleteButtonClick()
	{
		this.items.remove(this.selected.getValue());
	}

}