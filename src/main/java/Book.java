public class Book {
    String title;
    String year;
    String ISBN;

    public Book(String title, String year, String ISBN) {
        this.title = title;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
