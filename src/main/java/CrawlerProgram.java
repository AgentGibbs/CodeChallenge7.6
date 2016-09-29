import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Christian Gibbs on 9/29/2016.
 */
public class CrawlerProgram {


    public static int maxThreadCount;

    private static void crawlSite(String initialUrl) throws Exception {

        HashSet<String> crawledList = new HashSet<String>();
        Queue<String> toCrawlList = new LinkedList<String>();

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
                    for(String newUrl : newUrls) {
                        if (!toCrawlList.contains(newUrl) && !crawledList.contains(newUrl) && newUrl.contains(initialUrl)) {
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
            while ( !toCrawlList.isEmpty() ) {
                String urlToCrawl = toCrawlList.poll();
                futures.add(threadPool.submit(new Crawl(urlToCrawl)));
                crawledList.add(urlToCrawl);
            }
            Thread.sleep(300);
        }
    }
*/
}
