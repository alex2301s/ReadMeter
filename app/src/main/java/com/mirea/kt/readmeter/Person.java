package com.mirea.kt.readmeter;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String avatar;


    public Person(String firstName, String lastName, int age, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avatar = avatar;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getAvatar() {
        return avatar;
    }
}
