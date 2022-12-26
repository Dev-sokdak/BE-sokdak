package com.example.devsokdak.board.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;


@Getter
@AllArgsConstructor
public enum InterestTag {

    개발(0),
    IT기술(1),
    디자인(2),
    경영전략(3),
    CSCX(4),
    MD컨텐츠제작(5),
    HR(6);

    private final int interestTag;

    public static InterestTag valueOfInterestTag(int interestTag){
        return Arrays.stream(values())
                .filter(value -> value.interestTag==(interestTag))
                .findAny()
                .orElse(null);
    }
    public static InterestTag valueOfInterestTag(List<Integer> integerList){
        return Arrays.stream(values())
                .filter(value -> value.interestTag==(integerList.get(0)))
                .filter(value -> value.interestTag==(integerList.get(1)))
                .filter(value -> value.interestTag==(integerList.get(2)))
                .findAny()
                .orElse(null);
    }
}