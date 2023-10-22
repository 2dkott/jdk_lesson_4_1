import domain.UrlSource;
import services.ParrelelDownloader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<UrlSource> urlSources = new ArrayList<>();

        for(int i =0; i<=1000; i++) {
            urlSources.add(new UrlSource());
        }

        ParrelelDownloader parrelelDownloader = new ParrelelDownloader(urlSources);
        parrelelDownloader.downloadWithThreads(5);
    }
}