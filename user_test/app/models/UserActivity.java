package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class UserActivity extends Model {

	public Long u_id;
	
    public Long a_id;
    
    public double step_count;


    public static Finder<Long,UserActivity> find = new Finder(
            Long.class, UserActivity.class
    );
    public static List<UserActivity> all() {
        return find.all();
    }

    public static void create(UserActivity ua) {
        ua.save();
    }

    public static void delete(Long u_id) {
        find.ref(u_id).delete();
    }

}