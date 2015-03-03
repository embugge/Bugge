package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class User extends Model {

    @Id
    public String email;
    
    @Required
    public String name;
    
    @Required
    public String password;
    
    @Required
    public boolean isAdmin;
    
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
      }
    
    public static Finder<String,User> find = new Finder<String,User>(
            String.class, User.class
        ); 
    
    public static List<User> all() {
        return find.all();
    }

    public static void create(User user) {
        user.save();
    }

    public void delete(String email) {
        find.ref(email).delete();
    }

}