
import java.util.Scanner;
class Book{
	private String Title;
	private String Author;
	private String ISBN;
	
	public Book(String Title, String Author, String ISBN) {
		this.Title = Title;
		this.Author = Author;
		this.ISBN = ISBN;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public String getauthor() {
		return Author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void displayBookDetails() {
		System.out.println("Book Title: "+ Title);
		System.out.println("author Name: "+Author);
		System.out.println("ISBN num: "+ISBN);
	}
}
class EBook extends Book {
	private int fileSize;
	
	public EBook(String Title, String Author, String ISBN, int fileSize) {
		super(Title, Author, ISBN);
		this.fileSize = fileSize;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	
	public void displayBookDetails() {
		super.displayBookDetails();
		System.out.println("File Size :"+ fileSize +"MB");
	}
}
class Library {
	private Book[] books;
	private int booksNum;
	
	public Library(int capacity) {
		books = new Book[capacity];
		booksNum = 0;
	}
	
	public void addBooks(Book book) {
		if(booksNum<books.length) {
			books[booksNum] = book;
			booksNum++;
			System.out.println("Book added to the library");
		}
		else {
			System.out.println("Library is Full !. Cannot add more books");
		}
	}
	public void displayAllBooks() {
		for(int i=0; i<booksNum; i++) {
			books[i].displayBookDetails();
			System.out.println();
		}
	}
	public void displayBookByAuthor(String Author) {
		for(int i=0; i<booksNum; i++) {
			if(books[i].getauthor().equalsIgnoreCase(Author)) {
				books[i].displayBookDetails();
				System.out.println();
			}
		}
	}
	public void removeBookByISBN(String ISBN) {
		int indexRemove = -1;
		for(int i=0; i<booksNum; i++) {
			if(books[i].getISBN().equals(ISBN)) {
				indexRemove = i;
				break;
			}
		}
		if(indexRemove != -1) {
			for(int i = indexRemove; i<booksNum-1; i++) {
				books[i] = books[i+1];
			}
			booksNum--;
			System.out.println("Book with ISBN "+ISBN+"has been removed from the libarary");
		}
		else {
			System.out.println("Book with ISBN "+ISBN+" Was not found in the library");
		}
	}
}



public class librarysystem{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capacity of Library: ");
		int cap = sc.nextInt();
		Library library = new Library(cap);
		while(true) {
			System.out.println(" 1. ADD BOOK \n 2. ADD EBOOK \n 3. DISPLAY ALL BOOKS \n 4. FIND BOOK \n 5. REMOVE BOOK \n 6. EXIT");
			int choice = sc.nextInt();
			int i = choice;
            sc.nextLine();
			if(i==1) {
				System.out.println("Enter the Title , Author, ISBN number: ");
				String title = sc.nextLine();
				String author = sc.nextLine();
				String ISBN = sc.nextLine();
				Book book1 = new Book(title, author, ISBN);
				library.addBooks(book1);
			}
			else if(i==2){
				System.out.println("Enter the Title , Author, ISBN number, File Size: ");
				String title = sc.nextLine();
				String author = sc.nextLine();
				String ISBN = sc.nextLine();
				int file = sc.nextInt();
				EBook book2 = new EBook(title, author, ISBN, file);
				library.addBooks(book2);
			}
			else if(i==3) {
				System.out.println(" ALL BOOKS DISPLAYED! ");
				library.displayAllBooks();
			}
			else if(i==4) {
				System.out.println("Enter the author name to find book: ");
				String author = sc.nextLine();
				library.displayBookByAuthor(author);
			}
			else if(i==5) {
				System.out.println("Enter the ISBN number to Remove book: ");
				String isbn = sc.nextLine();
				library.removeBookByISBN(isbn);
			}
			else if (i==6) {
				System.out.println("Exit the Library! \n Thank You");
			}
			else {
				System.out.println("Invalid choice ");
			}
			if(i==6) {
				break;
				
			}
		}
		sc.close();
		
	}
}