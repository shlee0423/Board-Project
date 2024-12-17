package com.board.controller;

import com.board.dto.UserDTO;
import com.board.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "user/register";
    }

    @GetMapping("/{id}/exist")
    public ResponseEntity<?> isExist(@PathVariable String id) {
        boolean isExist = userService.checkUsername(id);
        return ResponseEntity.ok(isExist);
    }

    @PostMapping("/register")
    public String postRegister(
            @RequestParam("impUid") String impUid,
            @Validated UserDTO user,
            RedirectAttributes redirectAttributes
    ) {
        log.info("impUid:" + impUid);
        log.info("user:" + user);
        boolean result = userService.createUser(impUid, user);
        if (result) {
            return "redirect:/user/login";
        }
        redirectAttributes.addFlashAttribute("certErrorMsg", "본인인증이 완료되지 않았습니다.");
        return "redirect:/user/register";
    }
}
