package cn.answering.controller;

import cn.answering.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;
}
