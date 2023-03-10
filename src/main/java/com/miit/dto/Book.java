package com.miit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Book {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private float price;


}
