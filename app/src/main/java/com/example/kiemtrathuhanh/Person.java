package com.example.kiemtrathuhanh;

import java.io.Serializable;

public class Person implements Serializable {
    private String id,name,age,Dep;

    public Person(String id, String name, String age, String dep) {
        this.id = id;
        this.name = name;
        this.age = age;
        Dep = dep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String dep) {
        Dep = dep;
    }
}
