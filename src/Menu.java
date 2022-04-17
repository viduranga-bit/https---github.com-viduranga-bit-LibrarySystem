import java.util.Scanner;
import java.util.StringTokenizer;
import Store.UserStore;
import Store.BookStore;
import Users.*;

public class Menu {

    Scanner userInput = new Scanner(System.in);
    UserStore users = new UserStore();
    BookStore books = new BookStore();

    public void MainMenu(){

        // Add a new Administrator to the System First
        users.addUser(new Administrator("Admin","admin@admin.com",24));

       int i=0;
       
       while(i<1){
        System.out.println("************Library System***************");
        System.out.println("Please Enter your Name: ");//use username as Admin
        String userName = this.userInput.next();
         
       
        // this.userMenu(1);
        // Check whether the user is present in the user-List if present go to user menu otherwise display an Error message.
        User loginUser = users.getUser(userName);
        if(loginUser != null){
            this.userMenu(loginUser);
        }
    }
      
       i=1;
    }
    public void userMenu(User loggedUser){
        
        
        int userLevel = loggedUser.getUserLevel();
        System.out.println("Welcome");
        System.out.println("Please choose a function: ");
        if(userLevel == 1){
            System.out.println("1. Add New User \n2. Update an existing User \n3. Remove User");
            String result = userInput.next();
            Administrator admin = (Administrator)loggedUser;
            switch(result){
                case "1":
                    System.out.println("Please Enter the following details separated by commas\n" +
                            "name, Email Address, Age, User Level");
                    result = userInput.next();

                    //  Add the new User to the User-list
                    StringTokenizer st = new StringTokenizer(result, ",");
                    admin.addUser(st.nextToken(), st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                    System.out.println("User added successfully");
                    break;

                case "2":
                    System.out.println("Please enter the name of the user and the new level to be updated" +
                            " seperated by a comma: ");
                    result = userInput.next();
        
                    //  Update the User
                    st = new StringTokenizer(result, ",");
                    admin.updateUser(st.nextToken(), Integer.parseInt(st.nextToken()));
                    System.out.println("User Updated successfully");

                    break;
                case "3":
                    System.out.println("Please enter the name of the user to be removed from the System: ");
                    result = userInput.next();

                    //  Remove the User

                    st = new StringTokenizer(result, ",");
                    admin.removeUser(st.nextToken());
                    System.out.println("User Admin"+result+" Removed successfully");

                    break;
                default:
                    System.out.println("Invalid selection");
                    
                 
            }

        }else if(userLevel == 2){
            int j=0;
            while(j<1){
            Librarian lb = (Librarian)loggedUser;
            System.out.println("1. Add New Book \n2. Add copies to an existing book \n3. Remove Book \n4. Renew Time for a User\n5. Exit ");
            String result = userInput.next();
            switch(result){
                case "1":
                    System.out.println("Please Enter the following details separated by commas\n" +
                            "name, Author, Publication, Initial copies, Age restricted (T or F)");
                    result = userInput.next();

                    //  Add the new Book to the Book-list
                    StringTokenizer st = new StringTokenizer(result, ",");
                    lb.addNewBook(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Boolean.parseBoolean(st.nextToken()));
                    System.out.println("Book added into the database successfully");
                    break;
                case "2":
                    System.out.println("Please enter the name of the Book and the additional copy count to be updated" +
                            " seperated by a comma: ");
                    result = userInput.next();

                    //  Update the Book
                    st = new StringTokenizer(result, ",");
                    lb.addCopy(st.nextToken(), Integer.parseInt(st.nextToken()));
                    System.out.println("additional copies into the database successfully");
                    break;
                case "3":
                    System.out.println("Please enter the name of the Book to be removed from the System: ");
                    result = userInput.next();

                    //  Remove the Book
                    lb.removeBook(result, -1);
                    System.out.println("Book removed from the database successfully");
                    break;
                case "4":
                    System.out.println("Please enter the name of the user and the name of the book " +
                            "which needs the time renewal separated by a comma: ");
                    result = userInput.next();

                    //  Update the renewal time for the given user
                    st = new StringTokenizer(result, ",");
                    lb.renewTime(st.nextToken(), st.nextToken());
                    System.out.println("Book renewal done ");
                    break;
                case "5" :
                    
                    j=1;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
              
            }
        }else if(userLevel == 3){
            int k =0;
            
            while(k<1){
            Member mb = (Member)loggedUser;
            System.out.println("1. Request a New Book \n2. return a burrowed book \n2. Exit");
            String result = userInput.next();
            switch(result){
                case "1":
                    System.out.println("Please Enter the Book Name to be burrowed: ");
                    result = userInput.next();

                    //  Add the burrowed book to the user's burrowed book list
                    mb.requestBook(result);
                    break;
                case "2":
                    System.out.println("Please Enter the Book Name to be returned: ");
                    result = userInput.next();

                    //  Return the book
                    mb.returnBook(result);
                    break;
                    
                case "3":
                    k=1;
                    break;    
                default:
                    System.out.println("Invalid selection");
            }
        }
        }
    }
    }
