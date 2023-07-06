package com.library.main.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> registration(Map<String, Object> param);
}
