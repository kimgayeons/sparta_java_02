package com.sprata.java_02.domain.user.controller;

import com.sprata.java_02.domain.user.dto.UserCreateRequest;
import com.sprata.java_02.domain.user.dto.UserSearchResponse;
import com.sprata.java_02.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller//뷰를 그리는 controller
@RestController//controller+responseBody
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/{userId}")
  //GET /api/users/12?email="asd@naver.com"
  public ResponseEntity<UserSearchResponse> findAll(
      @RequestParam(name = "email", required = false) String email,
      @PathVariable Long userId) {
    return ResponseEntity.ok().body(UserSearchResponse.builder().build());
  }

  @PostMapping
  public void save(@RequestBody UserCreateRequest request) {
    userService.save();
  }

  @PutMapping("/{userId}")
  public void update(@PathVariable long userId,
      @RequestBody UserCreateRequest request) {

  }

  @PatchMapping("/{userId}")
  public void updateStatus(@PathVariable long userId,
      @RequestBody UserCreateRequest request) {

  }

  @DeleteMapping("/{userId}")
  public void delete(@PathVariable long userId) {

  }
}
