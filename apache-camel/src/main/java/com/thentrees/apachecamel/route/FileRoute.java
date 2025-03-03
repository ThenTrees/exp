package com.thentrees.apachecamel.route;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        moveAllFile();
//        moveFileSpecific("myFile");
        moveFileSpecificWithBody("Java");
    }

    public void moveAllFile(){
        log.info("Moving all files staring");
        from("file://C:/Users/thien/OneDrive/Desktop/from?noop=true").to("file://C:/Users/thien/OneDrive/Desktop/to");
        log.info("Moving all files finished");
    }

    public void moveFileSpecific(String type){
        log.info("Moving specific file staring");
        from("file://C:/Users/thien/OneDrive/Desktop/from?noop=true")
                .filter(header(Exchange.FILE_NAME).startsWith(type))
                .to("file://C:/Users/thien/OneDrive/Desktop/to");
        log.info("Moving specific file finished");
    }

    public void moveFileSpecificWithBody(String content){
        log.info("Moving specific file staring");
        from("file://C:/Users/thien/OneDrive/Desktop/from?noop=true")
                .filter(body().contains(content))
                .to("file://C:/Users/thien/OneDrive/Desktop/to");
        log.info("Moving specific file finished");
    }
}
