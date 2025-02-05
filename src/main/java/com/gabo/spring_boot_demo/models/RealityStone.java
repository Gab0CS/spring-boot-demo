package com.gabo.spring_boot_demo.models;

import lombok.ToString;
import lombok.extern.java.Log;

@ToString(callSuper = true)
@Log
public class RealityStone extends Stone {

    public RealityStone(
        String colorProperty,
        String nameProperty,
        String locationProperty,
        Integer energyLevelProperty
    ) {
        super(colorProperty, nameProperty, locationProperty, energyLevelProperty);
    }
    
    @Override
    public void usePower() {
        System.out.println("Altering reality" + super.toString());
    }
}
