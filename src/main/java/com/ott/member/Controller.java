package com.ott.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
public class Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${testdata.idinfo}")
    private String testIdInfo;

    @GetMapping("{id}")
    public String getMember(@PathVariable String id, @RequestHeader HttpHeaders headers) {

        headers.forEach((key, value) -> {
            log.info(">>>>> Header '{}' => {}", key, value);
        });

        log.info("### Received: {}", id);

        String msg = id + " => " + testIdInfo;
        log.info("### Sent: {}", msg);
        return msg;
    }
}
