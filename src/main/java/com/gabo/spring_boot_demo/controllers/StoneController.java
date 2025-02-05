package com.gabo.spring_boot_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo.spring_boot_demo.models.PowerStone;
import com.gabo.spring_boot_demo.models.Stone;

@RestController
public class StoneController {
    
    private final Stone stone;

    @Autowired
    public StoneController(@Qualifier("power") Stone stone){
        this.stone = stone;
    }
    
    @GetMapping
    public PowerStone powerStone() {
        return (PowerStone) this.stone;
    }
}
