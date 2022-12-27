package com.example.sokdak.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@Getter
@AllArgsConstructor
public enum InterestTag {

    개발(0,"개발"),
    IT기술(1,"IT기술"),
    디자인(2,"디자인"),
    경영전략(3,"경영전략"),
    CSCX(4,"CSCX"),
    MD컨텐츠제작(5,"MD컨텐츠제작"),
    HR(6,"HR");

    private final int interestTag;
    private final String TagMsg;

    public static InterestTag valueOfInterestTag(int interestTag){
        return Arrays.stream(values())
                .filter(value -> value.interestTag==(interestTag))
                .findAny()
                .orElse(null);
    }
    public static InterestTag valueOfInterestTag(String TagMsg){
        return Arrays.stream(values())
                .filter(value -> value.TagMsg.equals(TagMsg))
                .findAny()
                .orElse(null);
    }
}