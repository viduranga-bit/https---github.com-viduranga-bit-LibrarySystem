package Store;

import Users.User;

import java.util.ArrayList;

public class UserStore {
    private static ArrayList<User> userList = new ArrayList<User>();

    public boolean addUser(User u){
        for (User usr: userList ) {
            if(usr.getName().equals(u.getName())){
                System.out.println("Error!!, User already present in the database");
                return false;
            }
        }
        
        userList.add(u);
       
        return true;
        
    }

    public User removeUser(String userName){
        for (User usr: userList ) {
            if(usr.getName().equals(userName)){
                userList.remove(usr);
                return usr;
            }
        }
        System.out.println("User is not registered in the Library");
        return null;
    }

    public User getUser(String userName){
        for (User usr: userList ) {
            if(usr.getName().equals(userName)){
                return usr;
            }
        }
        // System.out.println("Error! User Not Found");
        return null;
    }

    public void printUsers(){
        for(User usr : userList){
            usr.printUserDetails();
        }
    }

    public int getSize(){
        return userList.size();

    }
}