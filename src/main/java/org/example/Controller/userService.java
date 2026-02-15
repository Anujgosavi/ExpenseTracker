package org.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/public")
@RequestMapping("/public")
public class userService {

    @GetMapping("/getMSG")
    public String getMessage(){
        return "Hellooooo its working:))" ;
    }
}
