package com.example.WorkOUT.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo")
public class GymAPIController {

    //private GetDataAPI getDataAPI = new GetDataAPI();
    //private ArrayList<GymObject> gymObjectList = getDataAPI.getAllGymInfo();


    @GetMapping(path = "/apigym")
    public @ResponseBody List<GymObject> getAllApiLocation() {
        GetDataAPI getData = new GetDataAPI();
        getData.loadFromAPI();
        return getData.getAllGymInfo();
    }

/*    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Greeting> greeting() {
        Greeting greeting1 = new Greeting(1, "One");
        Greeting greeting2 = new Greeting(2, "Two");
        List<Greeting> list = new ArrayList<>();
        list.add(greeting1);
        list.add(greeting2);
        return list;
    }*/
}
