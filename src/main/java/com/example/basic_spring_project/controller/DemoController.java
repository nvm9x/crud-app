package com.example.basic_spring_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
// RestController - обработчик http запросов
public class DemoController {

    @GetMapping("/home")
    public String homePage() {
        return "Hello world";
    }

    //localhost:8080/home


//    @GetMapping("/home")
//    public String homePage(@RequestParam String name) {
//        return "Hello " + name;
//    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int a, @RequestParam int b, @RequestParam String operation) {
        if (operation.equals("plus")) {
            return a+"+"+b+"="+(a+b);
            //a+b=c;
        } if (operation.equals("multiply")) {
            return a + "*" + b + "=" +(a*b);
        }
        if (operation.equals("subtract")) {
            return a + "-" + b + "=" + (a-b);
        }
        if(operation.equals("divide")){
            if(b==0){
                return "Деление на ноль";
            }
            return a + "/" + b + "=" + (a/b);
        }

        return null;

    }


   @GetMapping("/sort")
    public String sortNums(@RequestParam List<Integer> numbers, @RequestParam String order){
        if(order.equals("asc")){
            numbers.sort(Comparator.naturalOrder());
            return numbers.toString();

        } else if (order.equals("desc")) {
            numbers.sort(Comparator.reverseOrder());
            return numbers.toString();
        } else {
            return "Выберите asc или desc";
        }

   }
/*   @GetMapping("/time")
    public String getCurrentTimeDate(){

   }*/

}
