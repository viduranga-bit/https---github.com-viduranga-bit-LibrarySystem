package Users;

import LendItems.Book;
import Store.BookStore;
import Store.UserStore;

import java.util.ArrayList;

public class Librarian extends Member{

    private BookStore store = new BookStore();

    public Librarian(String name, String email, int age){
        super(name, email, age);
        this.setBookLimit(3);
        this.setUserLevel(2);
    }

    public void addNewBook(String name, String auth, String pub, int initialCopies, boolean restriction){
        Book newBook = new Book(name, auth, pub, initialCopies, restriction);
        boolean isNew = store.addBook(newBook);
        if(!isNew){
            this.addCopy(name, initialCopies);
        }
    }

    public boolean addCopy(String bookName, int copyCount){
        Book temp = store.searchBook(bookName);
        if(temp != null){
            temp.addCopy(copyCount);
            return true;
        }
        return false;
    }

    public void removeBook(String bookname, int count){
        
        Book temp = store.searchBook(bookname);
        if(temp != null){
            temp.removeCopy(count);
            if(temp.getCopiesTotal() <= 0){
                store.removeBook(bookname);
            }
        }else {
            System.out.println("Error!, Book not found in the Library");
        }
    }

    public void renewTime(String memName, String bookName){
        User reqUsr = new UserStore().getUser(memName);
        if(reqUsr != null){
            for(String book[] : reqUsr.getBurrowedBooks()){
                if(book[0].equals(bookName)){
                    book[1] = "" + (Integer.parseInt(book[1]) + 7);
                }
            }
        }
    }


}