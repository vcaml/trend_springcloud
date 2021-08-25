package cn.how2j.trend.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Value("${version}")
    String version;

    @GetMapping("/")
    public String view(Model model) throws Exception {
        model.addAttribute("version",version);
        return "view";
    }
}