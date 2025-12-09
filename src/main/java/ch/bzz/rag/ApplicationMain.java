package ch.bzz.rag;

import ch.bzz.rag.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        String namespaceUrl = "https://wiki.bzz.ch/de/modul/ffit/3-jahr/java/";
        String regexFilter = "^(?!.*\\/start$).*";
        boolean overwriteExisting = false;

        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);
        WikiCrawlerPipelineService pipeline = ctx.getBean(WikiCrawlerPipelineService.class);
        pipeline.runPipeline(namespaceUrl, regexFilter, overwriteExisting);
        ctx.close();
    }
}
