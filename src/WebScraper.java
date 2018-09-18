import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

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

    public static int wordCounter(final String url) {
        String newString = url;
        String[] allWords = newString.split(" ");
        int totalWords = 0;
        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].isEmpty()) {
                continue;
            }
            totalWords++;
        }
        return totalWords;
    }

    public static int wordOccurrences(final String url, final String word) {
        String newString = url;
        String[] allWords = newString.split(" ");
        int occurrences = 0;
        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].equals(word)) {
                occurrences++;
            }
        }
        return occurrences;
    }


    public static void main(String[] args) {
        int totalWords = wordCounter(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int occurrences = wordOccurrences(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Exit");
        System.out.println(totalWords);
        System.out.println(occurrences);
    }
}
