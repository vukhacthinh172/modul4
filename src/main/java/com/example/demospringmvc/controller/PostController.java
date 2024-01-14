package com.example.demospringmvc.controller;

import com.example.demospringmvc.model.Post;
import com.example.demospringmvc.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;
    @RequestMapping(value = "/home",method = RequestMethod.GET )
    public  String home(Model model){
        // lay ra danh sach bai dang va gui den views
        model.addAttribute("list",postService.findAllPost());
        return "Home";
    }
    @RequestMapping(value ="/search",method = RequestMethod.GET)
    public String search (@RequestParam String search , Model model){
        model.addAttribute("search",postService.findAllPostByTitleOrContent(search));
        model.addAttribute("search",search);
        return "Home";
    }
    @RequestMapping (value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam Integer id ){
        postService.deletePost(id);
        return "redirect:home";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add (@ModelAttribute Post add ){
        postService.addPost(add);
        return "redirect:/home";
    }
@RequestMapping (value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute Post post){
        postService.updatePost(post);
        return "redirect:home";
}
@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Integer id , Model model){
      Post post =  postService.findById(id);
      model.addAttribute("post",post);
        return "update" ;
}
}
