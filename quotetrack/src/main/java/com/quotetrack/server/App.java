import com.quotetrack.server.feedcollector.FeedCollectorServer;
import com.quotetrack.server.feedcollector.ShutdownThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        App app = new App();
        try {
            FeedCollectorServer s = new FeedCollectorServer(10001, null);
            app.attachShutDownHook(s);
            ExecutorService es = Executors.newFixedThreadPool(5);
            es.submit(s);
            s.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void attachShutDownHook(FeedCollectorServer server) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread(server));
        System.out.println("Shut Down Hook Attached.");
    }
}
