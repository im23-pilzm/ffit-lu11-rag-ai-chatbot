package ch.bzz.rag;

import ch.bzz.rag.service.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        WikiPageCollectorService collector = new WikiPageCollectorService();
        String namespace = "de:modul:ffit:3-jahr:java:learningunits:lu11:";
        Set<String> pages = collector.collectPagesForNamespace("https://wiki.bzz.ch", namespace);
        log.info(pages.toString());
    }
}
