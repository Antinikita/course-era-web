package com.example.springlab3;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@RestController
public class UserContoller {
    public static class User{
        private int id;
        @NotEmpty(message = "not null")
        private String name;
        @Min(value = 18,message = "more than 18")
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
    @PutMapping("/update/{id}")
    public User update(@PathVariable int id, @RequestBody User updatedUser){
        updatedUser.setId(id);
        return updatedUser;
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        boolean userdeleted= deleteUserById(id);
        if (userdeleted){
            return "User with ID "+id+" was deleted.";
        } else {
            return "User not found.";
        }

    }
    private boolean deleteUserById(int id){
        return true;
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
        // Проверяем наличие ошибок валидации
        if (result.hasErrors()) {
            // Собираем ошибки валидации в сообщение
            StringBuilder errorMessage = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }

        // Если всё хорошо, возвращаем подтверждение создания пользователя
        return ResponseEntity.ok("User created: " + user.getName());
    }
}
