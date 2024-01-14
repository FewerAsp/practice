package ru.neoflex.practice.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class CalcController {

    //Метод суммы
    @GetMapping("/plus/{a}/{b}")
    public int plus(@PathVariable("a") int a, @PathVariable("b") int b){
        return a + b;
    }
    //Метод разности
    @GetMapping("/minus/{a}/{b}")
    public int minus(@PathVariable("a") int a, @PathVariable("b") int b) {
        return a - b;
    }
}