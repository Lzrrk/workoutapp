package com.example.WorkOUT.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
     // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/all")
    public @ResponseBody List<User> getAllUsers() throws Throwable {
        // This returns a JSON or XML with the users
        try{
            List<User> listOfUsers = userRepository.findAll();
            return listOfUsers;
        }
        catch (Exception exception){
            throw exception.getCause();
        }


    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String username
            , @RequestParam String email, @RequestParam String password, @RequestParam String gender) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUsername(username);
        user.setGender(gender);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }



    @PostMapping(path="/login/{email}/{password}")// Map ONLY POST Requests
    public @ResponseBody String loginUser (@PathVariable String email, @PathVariable String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Logged in";
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteUser (@RequestParam String userName){
        User user = new User();
        user.setUsername(userName);
        userRepository.delete(user);
        return "Removed";
    }
}