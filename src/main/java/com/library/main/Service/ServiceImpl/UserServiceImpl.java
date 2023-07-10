package com.library.main.Service.ServiceImpl;

import com.library.main.Entities.User;
import com.library.main.Repository.UserRepo;
import com.library.main.Service.UserService;
import com.library.main.Utility.DataTypeUtility;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public ResponseEntity<String> registration(Map<String, Object> param) {
        Long id = DataTypeUtility.longvalue(param.get("id"));
        String firstname = DataTypeUtility.stringvlue(param.get("firstname"));
        String lastname = DataTypeUtility.stringvlue(param.get("lastname"));
        String emailid = DataTypeUtility.stringvlue(param.get("emailid"));
        String password = DataTypeUtility.stringvlue(param.get("password"));
        Boolean checkout = DataTypeUtility.booleanvalue(param.get("checkout"));

        if(checkout){
            User user = new User();
            user.setId(id);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmailid(emailid);
            user.setPassword(password);
            user.setCheckout(checkout);
            userRepo.save(user);
            return ResponseEntity.ok("successefully");
        }else{
            return ResponseEntity.ok("not registerd");
        }

    }

    @Override
    public ResponseEntity<?> login(Map<String, Object> param) {
        String emailid = DataTypeUtility.stringvlue(param.get("emailid"));
        String password = DataTypeUtility.stringvlue(param.get("password"));
        User user = userRepo.findByEmailidAndPassword(emailid,password);
        if(user != null){
            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.ok("failed");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
