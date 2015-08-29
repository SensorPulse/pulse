package controllers;


import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Data extends Controller {
    public Result save(int data){
        Logger.info("received data: " + data);
        File datafile = Play.application().getFile("conf/data.txt");
        Path path = Paths.get(datafile.getAbsolutePath());
        try {
            Files.write(path, (String.valueOf(data) + "\n").getBytes() , StandardOpenOption.APPEND);
        } catch (IOException e) {
            Logger.error("file io error when writing data to file");
            e.printStackTrace();
        }
        return ok();
    }
}
