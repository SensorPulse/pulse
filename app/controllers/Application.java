package controllers;

import play.*;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result testPage() {
        //return ok("<h1>Pulse Sensor</h1>").as("text/html");
        return ok(views.html.main.render("pulse sensor", new Html("<h1>coen 315 project </h1>")));
    }

}
