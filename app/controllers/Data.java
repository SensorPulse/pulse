package controllers;


import play.mvc.Controller;
import play.mvc.Result;

public class Data extends Controller {
    public Result save(int data){
        System.out.println("received data: " + data);

        return ok();
    }
}
