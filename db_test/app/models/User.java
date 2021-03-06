package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String name;

    public String password;

    public boolean is_admin;

    public static Finder<Long,User> find = new Finder<Long,User>(
            Long.class, User.class
    );

}