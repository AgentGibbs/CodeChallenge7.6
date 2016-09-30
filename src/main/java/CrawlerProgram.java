import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Christian Gibbs on 9/29/2016.
 */
public class CrawlerProgram {


    private static int maxThreadCount = 5;
    private static HashSet<String> crawledList = new HashSet<String>();
    private static Queue<String> toCrawlList = new LinkedList<String>();
    private static String domainName;

 /*   public CrawlerProgram(String url){
        try {
            crawlSite(url);
        }
        catch(Exception e){
            System.out.println("Now you've done it...");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
*/
    public static void crawlSite(String initialUrl) throws Exception {
        extractDomainName(initialUrl);

        ConcurrentLinkedQueue<Future<List<String>>> futures = new ConcurrentLinkedQueue<Future<List<String>>>();
        ExecutorService threadPool = Executors.newFixedThreadPool(maxThreadCount);
        int lineNumber = 1;

        Crawl crawl = new Crawl(initialUrl);
        crawledList.add(initialUrl);

        futures.add(threadPool.submit(crawl));
        while (!futures.isEmpty()) {
            List<Future<List<String>>> completedFutures = new ArrayList<Future<List<String>>>();
            for (Future<List<String>> future : futures) {
                if (future.isDone()) {
                    List<String> newUrls = future.get();
                    for (String newUrl : newUrls) {
                        if (UrlIsOkay(newUrl)) {
                            System.out.println("New URL found: " + newUrl);
                            toCrawlList.add(newUrl);
                            //WriteToFile.writeOutput(validUrlsOutFile, "\n[" + lineNumber + "] " + newUrl);
                            lineNumber++;
                        }
                    }
                    completedFutures.add(future);
                }
            }
            System.out.println("Visited URLs: " + crawledList.size());
            System.out.println("URLs to visit: " + futures.size());
            futures.removeAll(completedFutures);
            while (!toCrawlList.isEmpty()) {
                String urlToCrawl = toCrawlList.poll();
                futures.add(threadPool.submit(new Crawl(urlToCrawl)));
                crawledList.add(urlToCrawl);
            }
            Thread.sleep(300);
        }
    }

    private static boolean UrlIsOkay(String newUrl) {
        boolean isOkay = false;
        if (!toCrawlList.contains(newUrl) && !crawledList.contains(newUrl) && newUrl.contains(domainName) && newUrl.contains("blog")==false){
            isOkay = true;
        }
        return isOkay;
    }

    private static void extractDomainName(String initialURL) {
        try {
            URL url = new URL(initialURL);
            domainName = url.getHost();
            System.out.println("Domain name " +domainName);
        } catch (MalformedURLException e) {
            System.out.println(initialURL + " is not a valid web address.");

        }
    }
}
