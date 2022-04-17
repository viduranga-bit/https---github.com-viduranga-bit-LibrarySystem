package Users;

import LendItems.Book;
import Store.*;

import java.util.ArrayList;

public class User {
    private String ID;
    private String name;
    private String email;
    private int age;
    private int bookLimit;
    private int userLevel;

    private ArrayList<String[]> burrowedBooks;
    //private Book book[] = new Book[10];

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public ArrayList<String[]> getBurrowedBooks() {
        return burrowedBooks;
    }

    public void setBurrowedBooks(ArrayList<String[]> burrowedBooks) {
        this.burrowedBooks = burrowedBooks;
    }

    public void printUserDetails(){
        System.out.print( "Name: " + this.getName() +
                "\nEmail: " + this.getEmail() +
                "\nAge: " + this.getAge() +
                "\nMaximum book Limit: " + this.getBookLimit()+
                "\nCurrently Burrowed: " + this.burrowedBooks.size() + "\n");
    }

    public Book searchBookbyName(String bookName){
        Book b = new BookStore().searchBook(bookName);
        return b;
    }





}