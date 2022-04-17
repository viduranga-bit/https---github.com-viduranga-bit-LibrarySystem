package LendItems;

public class Journal extends Book{

    private int volume;

    public Journal(String name, String auth, String pub, int volumeNo){
        super(name,auth,pub,1, false);
        this.setVolume(volumeNo);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

  //  @Override
    public void getDetails() {
        System.out.print("Book ID: " + this.getBookID() +
                "\nName: " + this.getBookName() +
                "\nAuthor: " + this.getAuthor() +
                "\nPublisher: " + this.getPublisher() +
                "\nVolume Number: " + this.getVolume() +
                "\nAvailability: " + (this.getCopiesCurrent() >= 1 ? "Available" : "Not Availble") + "\n");
    }
}