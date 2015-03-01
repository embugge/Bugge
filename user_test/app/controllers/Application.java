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
                views.html.index.render(Person.all(), personForm)
        );
    }

    public static Result newUser() {
        Form<Person> filledForm = personForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(Person.all(), filledForm)
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

    static Form<Person> personForm = Form.form(Person.class);

}
