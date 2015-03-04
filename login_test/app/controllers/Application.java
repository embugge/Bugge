package controllers;

import play.*;
import play.mvc.*;
import models.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(User.all(), UserActivity.all()));
    }

    public static Result login() {
        return ok(login.render("Your new application is ready."));
    }
    
    public static Result signup() {
        return ok(signup.render("Your new application is ready."));
    }
}
