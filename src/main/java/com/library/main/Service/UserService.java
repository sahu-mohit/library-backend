package com.library.main.Service;

import com.library.main.Entities.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> registration(Map<String, Object> param);

    ResponseEntity<?> login(Map<String, Object> param);
}
