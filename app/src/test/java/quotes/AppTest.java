/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import static org.junit.Assert.*;
import static quotes.App.*;


public class AppTest {
    @Test public void testSearchByAuthorName() throws Exception {
        Gson gson =new Gson();
        File file = new File("../app/src/main/resources/recentquotes.json");
        Reader reader=new FileReader(file);
        Quotes[] quotes = gson.fromJson(reader,  Quotes[].class);
        reader.close();
        searchByAuthorName(quotes,"Klune");
    }

    @Test public void testSearchByTextContain() throws Exception {
        Gson gson =new Gson();
        File file = new File("../app/src/main/resources/recentquotes.json");
        Reader reader=new FileReader(file);
        Quotes[] quotes = gson.fromJson(reader,  Quotes[].class);
        reader.close();
        searchByAuthorName(quotes,"love");
    }

    @Test public void testSearchByRandom() throws Exception {
          String localPath= "src/main/resources/recentquotes.json";
          String remoteApiPath= "https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        Gson gson =new Gson();
        File file = new File("../app/src/main/resources/recentquotes.json");
        Reader reader=new FileReader(file);
        Quotes[] quotes = gson.fromJson(reader,  Quotes[].class);
        reader.close();
        searchByRandom(quotes);

    }

    @Test public void testSearchByRandomRemote() throws Exception {

        String remoteApiPath= "https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        Gson gson =new Gson();
        File file = new File("../app/src/main/resources/recentquotes.json");
        Reader reader=new FileReader(file);
        Quotes[] quotes = gson.fromJson(reader,  Quotes[].class);
        reader.close();
        searchByRandom(quotes);

        int StatusCode =  initializeRemote(remoteApiPath);

        if(StatusCode != 200) {

            System.out.println("Somthing went Wrong From Api A Saved Quote will be generated ");
            quotes = initialize();
            System.out.println(searchByRandom(quotes));
        }
    }


}
