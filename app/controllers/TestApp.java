package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class TestApp extends Controller {

    public Result index() {
        return ok(test.render("Test title", "Hello, this is a test app!"));
    }

}
