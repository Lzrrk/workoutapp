package com.example.WorkOUT.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo")
public class GymAPIController {

    @GetMapping(path = "/apigym")
    public @ResponseBody List<GymObject> getAllApiLocation() {
        GetDataAPI getData = new GetDataAPI();
        getData.loadFromAPI();
        return getData.getAllGymInfo();
    }
}
