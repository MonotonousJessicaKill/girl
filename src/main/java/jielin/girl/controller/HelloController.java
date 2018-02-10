package jielin.girl.controller;

import jielin.girl.properties.GIrlPropertis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 要返回页面时不能使用@RestController
@Controller
public class HelloController {
    @Autowired
    private GIrlPropertis gIrlPropertis;

    // @RequestMapping(value = {"/hello"，"/hi"},method = RequestMethod.GET)
    //hi和hello都可以访问到

    //@RequestMapping(value = "{person}/hello/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(){
        return "index";
    }
}
