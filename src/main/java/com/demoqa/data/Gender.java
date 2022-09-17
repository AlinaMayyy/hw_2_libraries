package com.demoqa.data;

public class Gender {

    private String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public static Gender MALE = new Gender("Male");
    public static Gender FEMALE = new Gender("Female");
    public static Gender OTHER = new Gender("Other");

}
