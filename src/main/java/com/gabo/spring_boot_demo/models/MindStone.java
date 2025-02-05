package com.gabo.spring_boot_demo.models;


import org.springframework.beans.factory.annotation.Value;

import lombok.ToString;
import lombok.extern.java.Log;

@ToString(callSuper = true) 
@Log
public class MindStone extends Stone {

    public MindStone(
        String colorProperty,
        String nameProperty,
        String locationProperty,
        Integer energyLevelProperty
    ) {
        super(colorProperty, nameProperty, locationProperty, energyLevelProperty);
    }
    
    @Override
    public void usePower() {

        System.out.println("Mind control in stone" + super.toString());
    }
}
