package com.ssafy.stream;

import java.util.Objects;

public class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this(name);
		this.age = age;
	}
	public Person(String name) {
		this.name = name;
	}
	
	Person  increaseAge() {
		this.age++;
		return this;
	}
	
	void printInfo() {
		System.out.println(name+","+age);
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
