package LendItems;

public class Magazine extends Book{

    private int issue;
    private int year;

    public Magazine(String name, String auth, String pub, int year, int issue, boolean restriction){
        super(name,auth,pub,1, restriction);
        this.setYear(year);
        this.setIssue(issue);
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

   // @Override
    public void getDetails() {
        System.out.print( "Book ID: " + this.getBookID() +
                "\nName: " + this.getBookName() +
                "\nAuthor: " + this.getAuthor() +
                "\nPublisher: " + this.getPublisher() +
                "\nIssue and Year: " + this.getIssue() + "/ " + this.getYear() +
                "\nAvailability: " + (this.getCopiesCurrent() >= 1 ? "Available" : "Not Availble") + "\n");
    }
}