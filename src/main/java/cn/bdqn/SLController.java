package cn.bdqn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sl")
public class SLController {
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "login";
    }
    @RequestMapping("/toIndex2")
    public String toIndex2(){
        return "index";
    }
    @RequestMapping("/toIndex3")
    public String toIndex3(){
        return "index";
    }
    @RequestMapping("/toIndex4")
    public String toIndex4(){
        return "index";
    }
    @RequestMapping("/toIndex5")
    public String toIndex5(){
        System.out.println("");
        return "index";
    }

}
