package services;

import domain.UrlSource;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParrelelDownloader {

    List<UrlSource> sourceList;

    public ParrelelDownloader(List<UrlSource> sourceList) {
        this.sourceList = sourceList;
    }

    public void downloadWithThreads(int threadsNumber) {
        ExecutorService service = Executors.newFixedThreadPool(threadsNumber);

        for (UrlSource source : sourceList) {
            service.execute(new MyTask(source));
        }

        service.shutdown();
        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Загрузка всех файлов остановлена!");
        }
    }

        static class MyTask implements Runnable {
            UrlSource source;

            public MyTask(UrlSource source) {
                this.source = source;
            }

            @Override
            public void run() {
                source.download();
            }
        }
}
