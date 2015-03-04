package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;

import com.avaje.ebean.*;

@Entity
public class UserActivity extends Model {

    @Id
    public int id;
    public String name;
    @ManyToOne
    public User belongsTo;
    
    public UserActivity(int id, String name, User belongsTo) {
      this.id = id;
      this.name = name;
      this.belongsTo = belongsTo;
    }

    public static Finder<Long,UserActivity> find = new Finder<Long,UserActivity>(
        Long.class, UserActivity.class
    ); 
    
    public static List<UserActivity> all() {
        return find.all();
    }
}