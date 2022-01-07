package com.ott.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MembersConfig {
    @Value("${ottmember.filepath}")
    private String ottMemberFilepath;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    public Members loadMembers() {
        Members members = new Members();

        Map<String, String> memberData = new HashMap<>();

        String filepath = System.getProperty("user.home") + File.separator + ottMemberFilepath;
        log.info("FILE PATH==>{}", filepath);

        String[] info = null;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8))) {
            String str;

            while ((str = reader.readLine()) != null) {
                log.info(str);
                info = str.split("=");
                memberData.put(info[0], info[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        members.setMemberData(memberData);

        return members;
    }
}
