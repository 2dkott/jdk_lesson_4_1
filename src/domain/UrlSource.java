package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UrlSource {
    static int counter;

    {
        counter+=1;
    }

    private final String url;

    public UrlSource() {
        this.url = String.format("http://test_url_%s", counter);
    }

    public void download() {
        System.out.printf("%s: File is downloading from url %s%n", LocalDateTime.now(), url);
    }
}
