package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Home extends Controller {

    public Result index() {
        readData();
        return ok(home.render());
    }

    private void readData(){
        Logger.info("retrieving data from file");
        Path path = Paths.get("./data.txt");

        try {
            List<String> dataList = Files.readAllLines(path);
            for (String dataString : dataList){
                Logger.info(dataString);
            }
        }catch (IOException e) {
            Logger.error("file io error when reading data from file");
            e.printStackTrace();
        }
    }

}
