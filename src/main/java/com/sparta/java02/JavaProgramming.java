package com.sparta.java02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Fruit {

  private String name;
  private Integer price;

  public Fruit(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}


public class JavaProgramming {

  public static void main(String[] args) {
//    List<Fruit> fruits = Arrays.asList(
//        new Fruit("Apple", 1500),
//        new Fruit("Banana", 2500),
//        new Fruit("Orange", 3000)
//    );
//
//    List<String> expensiveFruitNameNew = fruits.stream()
//        .filter(fruit -> fruit.getPrice() >= 2000)
//        .map(fruit -> fruit.getName().toUpperCase())
//        .toList();
//    System.out.println("스트림 결과 : " + expensiveFruitNameNew);

    List<String> languages = Arrays.asList("JAVA", "Python", "Go", "JavaScript");
    List<String> result = languages.stream().filter(lang -> lang.length() > 3)
        .peek(lang -> System.out.println("필터링 후 : " + lang))
        .map(String::toUpperCase)
        .peek(lang -> System.out.println("대분자변환후:" + lang))
        .collect(Collectors.toList());
    System.out.println("최종 결과 리스트:" + result);
  }
}
