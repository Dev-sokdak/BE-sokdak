package com.example.sokdak.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@Getter
@AllArgsConstructor
public enum CareerTag {

    Tag_0(0, "신입"),
    Tag_1(1, "1년차 이상"),
    Tag_2(2, "2년차 이상"),
    Tag_3(3, "3년차 이상"),
    Tag_4(4, "4년차 이상"),
    Tag_5(5, "5년차 이상"),
    Tag_6(6, "6년차 이상"),
    Tag_7(7, "7년차 이상"),
    Tag_8(8, "8년차 이상"),
    Tag_9(9, "9년차 이상"),
    Tag_10(10, "10년차 이상");

    private final int careerTag;
    private final String TagMsg;

    public static CareerTag valueOfCareerTag(int careerTag){
        return Arrays.stream(values())
                .filter(value -> value.careerTag==(careerTag))
                .findAny()
                .orElse(null);
    }
}
