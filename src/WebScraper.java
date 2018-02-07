import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String word = "prince";
        System.out.println(wordCount(text));
        System.out.println(countOneWord(word, text));
    }

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

    public static int wordCount(final String text) {
        // make lowercase
        String textLowerCase = text.toLowerCase();

        // split string
        int count = 0;
        String[] textArray = text.split(" ");
        count = textArray.length;
        return count;
    }

    public static int countOneWord(final String word, final String text) {
        // make lowercase
        String textLowerCase = text.toLowerCase();

        // split string
        String[] textArray = text.split(" ");

        // count number of same word
        int count = 0;
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].contains(word)) {
                count++;
            }
        }
        return count;
    }

}