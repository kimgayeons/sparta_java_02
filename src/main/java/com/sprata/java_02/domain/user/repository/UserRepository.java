package com.sprata.java_02.domain.user.repository;

import com.sprata.java_02.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository//이클래스는 리포지터리다 라고 스프링한테 알려주는것 안써도 되는데 쓰면 좋다
//User라는 클래스의 pk값이 Long이기 때문에 <User, Long> 으로 사용
public interface UserRepository extends JpaRepository<User, Long> {

  //테이블명을 entity 객체랑 맞게 사용해야한다
  //파라미터값으로 들어온 name 값을 :name으로 알아서 치환해준다
  //쿼리는 진짜 필요한 경우가 아니면 사용하지 않는다
  //get~은 필수로 있는경우 find~는 있을수도 있고 없을수도 있다 그래서 Optional 사용
  @Query("SELECT u FROM User u WHERE u.name = :name")
  Optional<User> findUser(String name);
  //Optional<User> findFirstByNameAndEmail(String name); 이렇게 사용해도 되고,
  // 메서드 명이 너무 길어지게 되면 Query를 사용해서 메서드명을 간단하게 하고 쿼리문을 사용할수있다

  //위에랑 같은 코드다
  Optional<User> findFirstByNameAndEmail(String name, String email);

}
