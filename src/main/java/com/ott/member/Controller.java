package com.ott.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    Members members;

    @GetMapping("members/{id}")
    public String getMember(@PathVariable String id) {
        log.info("### Received: {}", id);

        String msg = id + " => " + members.getMember(id);
        log.info("### Sent: {}", msg);
        return msg;
    }

    @GetMapping("host")
    public String getHost() {
        return "Host=>" + System.getenv("HOSTNAME");
    }
}
