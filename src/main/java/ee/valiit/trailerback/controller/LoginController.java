package ee.valiit.trailerback.controller;

import ee.valiit.trailerback.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password){
        loginService.login(username, password);
    }

}
