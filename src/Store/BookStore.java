package Store;

import LendItems.Book;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookStore {

    private static ArrayList<Book> bookList = new ArrayList<Book>();

    public boolean addBook(Book newBook){
        for(Book b: bookList){
            if(b.getBookName().equals(newBook.getBookName())){
                return false;
            }
        }
        bookList.add(newBook);
        return true;
    }

    public Book removeBook(String bookName){
        for(Book b: bookList){
            if(b.getBookName().equals(bookName)){
                bookList.remove(b);
                return b;
            }
        }
        System.out.println("Given Book is not found in the Library");
        return null;
    }

    public Book searchBook(String bookName){
        for(Book b: bookList){
            if(b.getBookName().equals(bookName)){
               return b;
            }
        }
        System.out.println("Given Book is not found in the Library");
        return null;
    }

    public void printBookList(){
        for (Book book: bookList ) {
           book.getDetails();
        }
    }
}