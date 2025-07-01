package com.sprata.java_02.domain.purchase.repository;

import com.sprata.java_02.common.enums.PurchaseStatus;
import com.sprata.java_02.domain.purchase.entity.Purchase;
import com.sprata.java_02.domain.user.entity.User;
import com.sprata.java_02.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@Transactional //테스트 안에서 변경된 db내용이 실제로 저장되지 않는다
@SpringBootTest//테스트라는걸 의미
public class PurchaseRepositoryTest {

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  void save() {
//    User user = userRepository.save(User.builder()
//        .name("d4")
//        .email("d4")
//        .passwordHash("d4")
//        .build());

    User user = userRepository.findById(11L).get();

    //save는 단건
    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.valueOf(1000))
        .status(PurchaseStatus.PENDING)
        .build();
    Purchase purchase1 = purchaseRepository.save(purchase);
  }

  @Test
  void modify() {
    User user = userRepository.save(User.builder()
        .name("d")
        .email("d")
        .passwordHash("d")
        .build());

    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.valueOf(1000))
        .status(PurchaseStatus.PENDING)
        .build();
    Purchase savePurchase = purchaseRepository.save(purchase);
    savePurchase.setStatus(PurchaseStatus.COMPLETION);
    purchaseRepository.save(savePurchase);
  }

  @Test
  void delete() {
    User user = userRepository.save(User.builder()
        .name("d2")
        .email("d2")
        .passwordHash("d2")
        .build());

    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.valueOf(1000))
        .status(PurchaseStatus.PENDING)
        .build();
    Purchase savePurchase = purchaseRepository.save(purchase);

    purchaseRepository.delete(savePurchase);
    //purchaseRepository.deleteAll();//인자 없이 실행하게 되면, id갯수만큼 모두 for문을 돌며 delete 쿼리문을 수행
  }

  @Test
  void find() {
    Purchase purchase = purchaseRepository.findById(11L)
        .orElseThrow(() -> new RuntimeException("주문내역이 없음!"));
    //orElseThrow: findById(11L) 해서 나온 결과값이 없을 경우 에러 발생
    System.out.println("결과 : " + purchase.getTotalPrice());
  }
}
