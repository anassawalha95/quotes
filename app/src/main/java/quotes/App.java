/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static Quotes[] initialize() throws Exception {
        Gson gson = new Gson();
        Path path = Paths.get("src/main/resources/recentquotes.json");
        File file = new File(path.toAbsolutePath().toUri());
        Reader reader = new FileReader(file);
        Quotes[] quotes = gson.fromJson(reader, Quotes[].class);
        reader.close();
        return quotes;
    }

    public static String searchByAuthorName(Quotes[] quotes, String authorName) throws Exception {

        for (Quotes quote : quotes) {
            if (quote.getAuthor().contains(authorName))
                return quote.toString();
        }
        return "Author Not Found";
    }

    public static String searchByTextContain(Quotes[] quotes, String words) throws Exception {

        for (Quotes quote : quotes) {
            if (quote.getText().contains(words))
                return quote.toString();
        }
        return "Can't Search Words ";
    }

    public static String searchByRandom(Quotes[] quotes) throws Exception {
        int random= (int) (Math.random() * quotes.length) ;
        Quotes quote = quotes[random];
        return quote.toString();
    }


    public static void main(String[] args) throws Exception {
        Quotes[] quotes;

        if (args.length == 2 && args[0].equals("author") ) {
            quotes = initialize();
            System.out.println(searchByAuthorName(quotes, args[1]));

        } else if (args.length == 2 && args[0].equals("contains")) {
            quotes = initialize();
            System.out.println(searchByTextContain(quotes, args[1]));

        } else if (args.length == 1 && args[0].equals("random")) {
            quotes = initialize();
            System.out.println(searchByRandom(quotes));

        } else {
            System.out.println("Allowed parameters are \'author <author name>\' or  \'contains <words>\' or random ");
        }


    }

}
