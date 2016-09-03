import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	private List<Book> library = Lists.newArrayList();

	public static void main(String[] args)
	{
		Stream stream = new Stream();

		stream.buildLibrary();

		stream.filterBooks();
	}

	private void filterBooks()
	{
		List<Author> authors = library.stream()
									  .filter(book -> book.getTitle().length() > 20)
									  .map(book -> book.getAuthor())
									  .filter(author -> author.getGender().equals(GENDER.MALE))
									  .distinct()
									  .collect(Collectors.toList());

		System.out.print(authors);

	}

	private void buildLibrary()
	{
		Author salinger = new Author(56, GENDER.MALE, "Salinger");
		Author nesbo = new Author(23, GENDER.MALE, "Nesbo");
		Author szabo = new Author(77, GENDER.FEMALE, "Szabo");

		Book nineStories = new Book(salinger, "Nine Stories");
		Book seymour = new Book(salinger, "Raise High the Roof Beam, Carpenters");

		Book snowman = new Book(nesbo, "The Snowman");

		Book theDoor = new Book(szabo, "The Door");

		library.add(nineStories);
		library.add(seymour);
		library.add(snowman);
		library.add(theDoor);
	}

	enum GENDER {
		MALE, FEMALE;
	}

	class Book {
		Author author;
		String title;

		public Book(Author author, String title)
		{
			this.author = author;
			this.title = title;
		}

		public Author getAuthor()
		{
			return author;
		}

		public String getTitle()
		{
			return title;
		}
	}

	private class Author {
		private int age;
		private GENDER gender;
		private String surName;

		public Author(int age, GENDER gender, String surName)
		{
			this.age = age;
			this.gender = gender;
			this.surName = surName;
		}

		public int getAge()
		{
			return age;
		}

		public GENDER getGender()
		{
			return gender;
		}

		public String getSurName()
		{
			return surName;
		}
	}
}


