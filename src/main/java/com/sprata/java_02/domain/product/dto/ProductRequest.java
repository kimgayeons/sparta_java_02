package com.sprata.java_02.domain.product.dto;

import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.wildfly.common.annotation.NotNull;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

  Long categoryId;

  String name;

  String description;

  @NotNull
  @Positive
  BigDecimal price;

  @NotNull
  @Positive
  Integer stock;
}
