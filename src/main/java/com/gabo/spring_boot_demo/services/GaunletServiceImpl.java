package com.gabo.spring_boot_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gabo.spring_boot_demo.models.MindStone;
import com.gabo.spring_boot_demo.models.PowerStone;
import com.gabo.spring_boot_demo.models.RealityStone;
import com.gabo.spring_boot_demo.models.SoulStone;
import com.gabo.spring_boot_demo.models.Stone;
import com.gabo.spring_boot_demo.models.TimeStone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@Getter
@Primary
//Use when this bean depends on our local beans
@ConditionalOnBean(value = {
    MindStone.class,
    PowerStone.class,
    RealityStone.class,
    SoulStone.class,
    TimeStone.class
})

public class GaunletServiceImpl implements GaunletService {
    //DI
    private final Stone mind;
    private final Stone power;
    private final Stone reality;
    private final Stone soul;
    private final Stone space;
    private final Stone time;
    
    //DI by constructor recommended for Spri
    @Autowired
    public GaunletServiceImpl(
    @Qualifier("mind") Stone mind,
    @Qualifier("power") Stone power,
    @Qualifier("reality") Stone reality,
    @Qualifier("soul") Stone soul,
    @Qualifier("space") Stone space,
    @Qualifier("time") Stone time) {
        this.mind = mind;
        this.power = power;
        this.reality = reality;
        this.soul = soul;
        this.space = space;
        this.time = time;
    }


    @Override
    public void useGaunlet(String stoneName){
        switch (stoneName) {
            case "mind":
                log.info("Use stone " + this.mind);   
                break;
            case "power":
                log.info("Use stone " + this.power);   
                break;
            case "reality":
                log.info("Use stone " + this.reality);   
                break;
            case "soul":
                log.info("Use stone " + this.soul);   
                break;
            case "space":
                log.info("Use stone " + this.space);   
                break;
            case "time":
                log.info("Use stone " + this.time);   
                break;
            default:
                throw new IllegalArgumentException("Invalid name");
        }
    }
    public void useFullPower(){
        if(
            this.mind != null 
            && this.power != null 
            && this.reality != null 
            && this.soul !=null 
            && this.space != null 
            && this.time != null){
            log.info("Using all power");
        } else {
            throw new IllegalStateException("Can't be using full power if some fields are null");
        }
    }
}
