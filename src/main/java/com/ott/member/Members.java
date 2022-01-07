package com.ott.member;

import java.util.Map;

public class Members {
    private Map<String, String> memberData;

    public Map<String, String> getMemberData() {
        return memberData;
    }

    public void setMemberData(Map<String, String> memberData) {
        this.memberData = memberData;
    }

    public String getMember(String id) {
        return memberData.get(id);
    }
}
