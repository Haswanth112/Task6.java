import java.util.ArrayList;
import java.util.List;
class LibraryItem {
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}





class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public List<LibraryItem> getItems() {
        return items;
    }
}



public class librarysystem{
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Magazine magazine1 = new Magazine("National Geographic", 256);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);
        library.removeItem(book1);

        List<LibraryItem> items = library.getItems(); 

        System.out.println("Items in the library:");
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                System.out.println("Book: " + item.getTitle() + " by " + ((Book) item).getAuthor());
            } else if (item instanceof Magazine) {
                System.out.println("Magazine: " + item.getTitle() + " Issue " + ((Magazine) item).getIssueNumber());
            }
        }
    }
}
