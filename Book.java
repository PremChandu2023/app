public class Book {

    private int id;
    private String title;
    private String author;

    private double rating=1;

    private double rentperday=0.0;

    private String booktype;

    private String status="exists";

    Book(int id,String booktype, String title, String author,double rentperday) {
        this.id = id;
        this.booktype=booktype;
        this.title = title;
        this.author = author;
        this.rentperday=rentperday;

    }

    public String getStatus() {
        return status;
    }

    public void set(double rating)
    {
        this.rating=rating;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }

    public double getRentperday() {
        return rentperday;
    }

    public String getBooktype() {
        return booktype;
    }

    public double calculateRent(int numberofdays) {
        return rentperday*numberofdays;
    }
}
