package com.eu.factory.local.controller;

import com.eu.factory.local.entity.LocalPlant;
import com.eu.factory.local.service.LocalPlantService;
import com.eu.factory.result.Result;
import com.eu.factory.result.ResultFactory;
import com.eu.factory.utils.HttpClientUtils;
import com.sun.deploy.net.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FactoryController {
    private Logger logger = LoggerFactory.getLogger(FactoryController.class);

    @Autowired
    LocalPlantService localPlantService;

    @CrossOrigin
    @GetMapping(value = "/api/getPlant")
    @ResponseBody
    public List<LocalPlant> getPlant(){
        List<LocalPlant> plants = localPlantService.findAll();
        if(plants.size() > 0){
            return plants;
        }else{
            return null;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/api/savePlant")
    @ResponseBody
    public Result savePlant(@RequestBody LocalPlant plant){
        String message = "";
        logger.info("into save plant method");
        if(plant.getPlantName().isEmpty()){
            message = "车间名为空，请输入后保存。";
            return ResultFactory.buildFailResult(message);
        }
        plant.setPlantId(HttpClientUtils.getUUID());
        localPlantService.save(plant);
        message = "保存成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @GetMapping(value = "/api/getPit")
    @ResponseBody
    public Result getPit(@RequestParam String plantId){
        LocalPlant plant = localPlantService.getByPlantId(plantId);
        logger.info(plant.toString());
        String message = "获取垮区成功";
        return ResultFactory.buildSuccessResult(message);
    }
}
