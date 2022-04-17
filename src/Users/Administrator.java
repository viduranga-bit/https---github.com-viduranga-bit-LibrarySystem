package Users;

import Store.UserStore;

public class Administrator extends Librarian{

    private UserStore users = new UserStore();

    public Administrator(String name, String email, int age){
        super(name, email, age);
        this.setBookLimit(5);
        this.setUserLevel(1);
    }


    public void addUser(String name, String email, int age, int level){
        User usr = users.getUser(name);
        if(usr == null){
            switch (level){
                case 1:
                    users.addUser(new Administrator(name, email, age));
                    break;
                case 2:
                    users.addUser(new Librarian(name, email, age));
                    break;
                case 3:
                    users.addUser(new Member(name, email, age));
                    break;
                default:
                    System.out.println("invalid role");
            }
        }else{
            System.out.println("Error, User already present");
        }
    }

    public void removeUser(String name){
        User usr = users.getUser(name);
        if(usr != null){
            users.removeUser(name);
        }else{
            System.out.println("User not found");
        }
    }

    public void updateUser(String user, int level){
        User usr = users.getUser(user);
        if(usr != null){
            users.removeUser(usr.getName());
            switch (level){
                case 1:
                    users.addUser(new Administrator(usr.getName(), usr.getEmail(), usr.getAge()));
                    break;
                case 2:
                    users.addUser(new Librarian(usr.getName(), usr.getEmail(), usr.getAge()));
                    break;
                case 3:
                    users.addUser(new Member(usr.getName(), usr.getEmail(), usr.getAge()));
                    break;
                default:
                    System.out.println("invalid role");
            }
        }else{
            System.out.println("User not found");
        }
    }



}