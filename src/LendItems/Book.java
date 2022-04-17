package LendItems;

public class Book {

    private String bookID;
    private String bookName;
    private String Author;
    private String publisher;
    private int copiesTotal;
    private int copiesCurrent;
    private boolean isRestricted;


    public Book(String name, String auth, String pub, int initialCopies, boolean restriction){
        this.setBookName(name);
        this.setAuthor(auth);
        this.setPublisher(pub);
        this.setCopiesTotal(initialCopies);
        this.setCopiesCurrent(initialCopies);
        this.setRestricted(restriction);
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }

    public void setCopiesTotal(int copiesTotal) {
        this.copiesTotal = copiesTotal;
    }

    public int getCopiesCurrent() {
        return copiesCurrent;
    }

    public void setCopiesCurrent(int copiesCurrent) {
        this.copiesCurrent = copiesCurrent;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public void setRestricted(boolean restricted) {
        isRestricted = restricted;
    }


    public void addCopy(int copies){
        this.copiesTotal += copies;
    }

    public void removeCopy(int copies){
        if(copies == -1){
            this.copiesTotal = 0;
        }else{
            this.copiesTotal -= copies;
        }        
    }

    public void getDetails(){
        System.out.print( "Book ID: " + this.getBookID() +
                "\nName: " + this.getBookName() +
                "\nAuthor: " + this.getAuthor() +
                "\nPublisher: " + this.getPublisher() +
                "\nTotal Copies in Library: " + this.getCopiesTotal() +
                "\nTotal Available Copies " + this.getCopiesCurrent() + "\n");
    }


}