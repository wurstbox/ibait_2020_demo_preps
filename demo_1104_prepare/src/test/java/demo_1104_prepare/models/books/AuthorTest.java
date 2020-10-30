package demo_1104_prepare.models.books;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import demo_1104_prepare.model.books.Author;

public class AuthorTest
{
	@Test
	public void authorsWithEqualNameMustBeEqual()
	{
		Author a = new Author("Max Mustermann");
		Author b = new Author("Max Mustermann");

		var result = Objects.equals(a, b);

		Assertions.assertEquals(true, result);
	}
}
