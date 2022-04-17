package Users;

import LendItems.Book;
import Store.BookStore;

import java.util.ArrayList;

public class Member extends User{

    BookStore ac = new BookStore();

    public Member(String name, String email, int age){
        this.setBookLimit(2);
        this.setAge(age);
        this.setBurrowedBooks(new ArrayList<String[]>());
        this.setEmail(email);
        this.setName(name);
        this.setUserLevel(3);
    }

    public void requestBook(String bookName){
        if (this.getBurrowedBooks().size() >  this.getBookLimit()){
            System.out.print("Burrowing limit reached. please return a book in order to burrow the current one");
        }else{
            Book bk = ac.searchBook(bookName);
            if(bk != null ) {
                this.getBurrowedBooks().add(new String[]{bookName, "14"});
                bk.setCopiesCurrent(bk.getCopiesCurrent()-1);
                System.out.println("Success");
            }
        }
    }

    public void returnBook(String bookName){
        for ( String book[] : this.getBurrowedBooks()) {
            if(book[0] == bookName){
                this.getBurrowedBooks().remove(book);
                System.out.println("Successfully Returned");
            }
            else {
                System.out.println("Book name is invalied");
            }
        }
    }



}