package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Application.persons());
    }

    public static Result persons() {
        return ok(
                views.html.index.render(Person.all(), personForm, UserActivity.all(), uaForm)
        );
    }

    public static Result newUser() {
        Form<Person> filledForm = personForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(Person.all(), filledForm, UserActivity.all(), uaForm)
            );
        } else {
            Person.create(filledForm.get());
            return redirect(routes.Application.persons());
        }
    }

    public static Result deleteUser(Long id) {
        Person.delete(id);
        return redirect(routes.Application.persons());
    }
    
    public static Result login() {
        return ok(
                views.html.login.render("Erik Bugge")
        );
    }
    
    public static Result newUA() {
        Form<UserActivity> filledForm = uaForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
            		views.html.index.render(Person.all(), personForm, UserActivity.all(), uaForm)
            );
        } else {
        	UserActivity.create(filledForm.get());
            return redirect(routes.Application.persons());
        }
    }    

    static Form<Person> personForm = Form.form(Person.class);
    static Form<UserActivity> uaForm = Form.form(UserActivity.class);

}
