package org.cba.exec3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequentialPinger {
    public static void main(String args[]) throws Exception {
        long startTime = System.nanoTime();
        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
                "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://cphbusiness.dk/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://dr.dk", "http://pol.dk", "https://www.google.dk",
                "http://phoronix.com", "http://www.webupd8.org/",
                "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
                "http://docs.oracle.com", "https://fronter.com",
                "http://imgur.com/", "http://www.imagemagick.org"
        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < hostList.length; i++) {
            final String url = hostList[i];
            futures.add(
                    executor.submit(() -> getStatus(url))
            );
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
        long endTime = System.nanoTime();
        System.out.println("Execution finished in :" + (endTime - startTime) / 1000000000 + " seconds");
    }

    public static String getStatus(String url) throws IOException {

        String result = "Error";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200)
                result = "Green";
            if (code == 301)
                result = "Redirect";
        } catch (Exception e) {
            result = "->Red<-";
        }
        return url + " | Status:" + result;
    }
}
