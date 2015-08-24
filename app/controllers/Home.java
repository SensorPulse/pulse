package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Home extends Controller {

    public Result index() {
        readData();
        return ok(home.render());
    }

    private void readData(){
        int last = 0 , max = 0, average = 0;

        Logger.info("retrieving data from file");
        Path path = Paths.get("./data.txt");

        //TODO not efficient to stream 3 times.
        //change to stream once into a arraylist and process there.
        try (Stream<String> stream = Files.lines(path)){
            last = stream.mapToInt(n -> Integer.parseInt(n))
                              .reduce((a, b) -> b).getAsInt();
        }catch (IOException e) {
            Logger.error("file io error when reading data from file");
            e.printStackTrace();
        }
        try (Stream<String> stream = Files.lines(path)){
            max =  stream.mapToInt(n -> Integer.parseInt(n))
                    .max().getAsInt();

        }catch (IOException e) {
            Logger.error("file io error when reading data from file");
            e.printStackTrace();
        }
        try (Stream<String> stream = Files.lines(path)){
            average = (int) stream.mapToInt(n -> Integer.parseInt(n))
                    .average()
                    .getAsDouble();

        }catch (IOException e) {
            Logger.error("file io error when reading data from file");
            e.printStackTrace();
        }

        Logger.info("last data is: " + last);
        Logger.info("max data is: "  + max);
        Logger.info("average data is: " + average);
    }

}
