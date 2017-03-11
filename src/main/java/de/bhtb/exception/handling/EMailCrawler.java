package de.bhtb.exception.handling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Naive web crawler (try-catch demo)
 */
public class EMailCrawler {

    public static void main(String... args) {
        List<String> eMailsFrom = allEMailsFrom("https://gradadmissions.stanford.edu/about");
        eMailsFrom.forEach(System.out::println);
    }

    private static List<String> allEMailsFrom(String url) {
        List<String> result = new ArrayList<>();
        try {
            URL webUrl = new URL(url);
            Scanner scanner = new Scanner(webUrl.openStream());


            Pattern pattern = Pattern.compile("[\\w|-]+@\\w[\\w|-]*\\.[a-z]{2,3}");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String email = line.substring(matcher.start(), matcher.end());
                    result.add(email);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newResult
                = result.stream().map(String::trim).distinct().collect(Collectors.toList());
        return newResult;
    }
}
