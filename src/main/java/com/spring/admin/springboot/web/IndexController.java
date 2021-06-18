package com.spring.admin.springboot.web;

import com.spring.admin.springboot.config.auth.LoginUser;
import com.spring.admin.springboot.config.auth.dto.SessionUser;
import com.spring.admin.springboot.service.PostsService;
import com.spring.admin.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());


       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/


        if (user != null) {
            model.addAttribute("userNm", user.getName());

            System.out.println("user : " +user.getName());
            System.out.println("user : " + user.getEmail());
        }
        return "index";
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
