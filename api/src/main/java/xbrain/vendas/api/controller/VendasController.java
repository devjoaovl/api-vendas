package xbrain.vendas.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendas")
public class VendasController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
