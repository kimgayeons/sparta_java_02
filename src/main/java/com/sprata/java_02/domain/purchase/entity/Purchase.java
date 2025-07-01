package com.sprata.java_02.domain.purchase.entity;

import com.sprata.java_02.common.enums.PurchaseStatus;
import com.sprata.java_02.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
//@Data는 쓰지 말기 Getter, setter도 있고, setter를 제어할 수 없기 때문에 가능하면 사용하지 말기
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Purchase { //주문

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  User user;

  //소수점도 포함하고, 정확도가 높기 때문에 가격같은거에서 추천 long으로
  @Column
  BigDecimal totalPrice;

  @Enumerated(EnumType.STRING)//string값으로 status값으로 보내기 위해서 사용
  @Column(nullable = false, length = 20)
  //사용하지 않으면 1 ,2 숫자값들이 들어가게된다
  PurchaseStatus status;//상태값은 enum으로 관리하는게 좋다

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  LocalDateTime createdAt;

  @UpdateTimestamp
  @Column
  LocalDateTime updatedAt;

  @Builder
  public Purchase(User user, BigDecimal totalPrice, PurchaseStatus status) {
    this.user = user;
    this.totalPrice = totalPrice;
    this.status = status;
  }

  public void setStatus(PurchaseStatus status) {
    if (!ObjectUtils.isEmpty(status)) {
      this.status = status;
    }
  }

  //null을 혀용하는 경우는 @Setter을 사용해도 되지만
  // 유효성 체크를 해줘야 하는 경우가 많기 때문에 setter에 하나씩 제약조건을 넣어준다
//  public void setTotalPrice(BigDecimal totalPrice) {
//    if(totalPrice > 0){
//    this.totalPrice = totalPrice;
//    }
//  }
}
