package com.sprata.java_02.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")//클래스명과 테이블명이 같을 경우 생략 가능
@DynamicUpdate//기존에 있는거랑 비교해서 값이 같은 경우는 UPDATE하지 않고, 값이 변경된것만 값을 UPDATE해준다
@DynamicInsert
@Getter
@NoArgsConstructor//빈생성자
//@AllArgsConstructor//모든 필드를 가지고 있는 생성자
//@RequiredArgsConstructor//private만 생성자로 만들어주는 어노테이션
@FieldDefaults(level = AccessLevel.PRIVATE)//필드들을 일괄 private로 하겠다
public class User {

  @Id//pk가 되는 값
  @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment의해서 진행할것이다
  Long id;

  //@Column 어노테이션을 추가해주지 않으면 인식하지 못한다
  //name 값은 같은 경우 생략이 가능하다
  //nullable : 필수값으로 하고 싶은 경우 false
  //length = 50 : VARCHAR(50)
  @Column(name = "name", nullable = false, length = 50)//
      String name;//카멜방식으로 사용

  //length값은 기본값이 255이기 때문에 생략 가능
  @Column
  String email;

  //(name = "password_hash") -> passwordHash 알아서 치환되게 된다
  @Column
  String passwordHash;

  @Column(nullable = false, updatable = false)//update할때 값이 update되면 안되기 때문에 updatahle값 추가
  @CreationTimestamp
  LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  LocalDateTime updatedAt;

  @Builder
  public User(String name, String email, String passwordHash) {
    this.name = name;
    this.email = email;
    this.passwordHash = passwordHash;
  }

  //insert 생성잘 만듬
  //update : Setter로 값 변경 ex user.setName("이름")
}
