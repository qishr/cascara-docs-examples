package io.github.qishr.cascara.docs.examples.subject;

import io.github.qishr.cascara.common.lang.annotation.Serializable;

@Serializable
public class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    // Getters and Setters
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
}
