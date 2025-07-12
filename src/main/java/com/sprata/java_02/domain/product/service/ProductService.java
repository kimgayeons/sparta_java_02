package com.sprata.java_02.domain.product.service;

import com.sprata.java_02.domain.product.dto.ProductRequest;
import com.sprata.java_02.domain.product.dto.ProductResponse;
import com.sprata.java_02.domain.product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getAll() {
    return new ArrayList<>();
  }

  public ProductResponse getById(Long id) {
    return null;
  }

  public ProductResponse create(ProductRequest request) {
    return null;
  }

  public ProductResponse update(Long id, ProductRequest request) {
    return null;
  }

  public void delete(Long id) {

  }
}