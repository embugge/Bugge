package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {
	
	private static int lastID;

    @Id
    public Long id;

    @Required
    public String label;
    
    @Required
    public String name;

    public static Finder<Long,Task> find = new Finder(
            Long.class, Task.class
    );
    public static List<Task> all() {
        return find.all();
    }


    public static void create(Task task) {
        task.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

}