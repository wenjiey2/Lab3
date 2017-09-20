import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * A class of Lab 3.
 * <p>
 *
 * @author yuwenjie
 */
public class Lab3 {

    /**
     * The String we need to find in the file.
     * <p>
     * Do not change this value.
     */
    static final String WORD = "you";

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Print the URLs as Strings.
     * <p>
     *
     * @param args input parameters.
     */
    public static void main(final String[] args) {
        int count = 0;
        // Print the urls as Strings
        // System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String file = urlToString("http://erdani.com/tdpl/hamlet.txt");

        // set all the letters to be lowercased
        file.toLowerCase();

        // look for the word and count the number
        for (int i = 0; i < file.length() - 2; i++) {
            if (file.substring(i, i + WORD.length()).equals(WORD)) {
                count++;
            }
        }

        System.out.println("There are " + count + " of the specific word in the file.");
    }

}
