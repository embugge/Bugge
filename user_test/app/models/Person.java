package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Person extends Model {

    @Id
    public Long id;

    @Required
    public String name;
    
    @Required
    public String password;
    
    @Required
    public boolean isAdmin;

    public static Finder<Long,Person> find = new Finder(
            Long.class, Person.class
    );
    public static List<Person> all() {
        return find.all();
    }

    public static void create(Person user) {
        user.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

}