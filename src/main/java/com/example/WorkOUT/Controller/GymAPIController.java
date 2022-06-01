package com.example.WorkOUT.Controller;

import com.example.WorkOUT.Class.GymObject;
import com.example.WorkOUT.Service.GymAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/gym")
public class GymAPIController {

    // List of all outdoor gyms
    @GetMapping(path = "/all")
    public @ResponseBody
    List<GymObject> getAllApiLocation() {
        GymAPIService getData = new GymAPIService();
        getData.loadFromAPI();
        return getData.getAllGymInfo();
    }
}