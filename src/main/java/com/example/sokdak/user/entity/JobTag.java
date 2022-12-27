package com.example.sokdak.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum JobTag {

    서버개발자(0, "서버 개발자"),
    프론트엔드개발자(1, "프론트엔드 개발자"),
    웹개발자(2, "웹 개발자"),
    앱개발자(3, "앱 개발자"),
    게임개발자(4, "게임 개발자"),
    QA(5, "QA"),
    DevOps(6, "DevOps");

    private final int jobTag;
    private final String TagMsg;

    public static JobTag valueOfJobTag(int jobTag){
        return Arrays.stream(values())
                .filter(value -> value.jobTag==(jobTag))
                .findAny()
                .orElse(null);
    }

    public static JobTag valueOfJobTag(String TagMsg){
        return Arrays.stream(values())
                .filter(value -> value.TagMsg.equals(TagMsg))
                .findAny()
                .orElse(null);
    }
}
