package com.example.viewWithSecurity.controller;


import com.example.viewWithSecurity.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class callMongoService {


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getCars")
    @ResponseBody
    public Object gerCars() {

        ResponseEntity re;
        re = restTemplate.getForEntity("http://localhost:5050/cars", String.class);

        return re;
    }

    @RequestMapping(value = "/getCar/{id}")
    @ResponseBody
    public Object gerCar(@PathVariable String id) {

        ResponseEntity re;
        re = restTemplate.getForEntity("http://localhost:5050/cars/" + id, String.class);

        return re;
    }

    @RequestMapping(value = "/upCar/{id}")//update
    @ResponseBody
    public Object updateCar(@PathVariable String id, @RequestBody Car car) {

        ResponseEntity re;

//        re = restTemplate.exchange("http://localhost:5050/cars/"+id, HttpMethod.PUT, car,String.class);
        restTemplate.put("http://localhost:5050/cars/" + id, car, String.class);
        return "success";
    }

    @RequestMapping(value = "/delCar/{id}")//delete
    @ResponseBody
    public Object deleteCar(@PathVariable String id) {

        ResponseEntity re;

//        re = restTemplate.exchange("http://localhost:5050/cars/"+id, HttpMethod.PUT, car,String.class);
        restTemplate.delete("http://localhost:5050/cars/" +id);
        return "success";
    }

    @RequestMapping(value = "/setCar")//create
    @ResponseBody
    public Object setCar(@RequestParam("id") int id, @RequestParam("model") String model) {


        Car car = new Car((long) id, model);
        ResponseEntity re;
        re = restTemplate.postForEntity("http://localhost:5050/cars", car, String.class);

        return re;

    }
}
