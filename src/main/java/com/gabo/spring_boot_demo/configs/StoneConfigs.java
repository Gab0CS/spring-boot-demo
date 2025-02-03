package com.gabo.spring_boot_demo.configs;

import com.gabo.spring_boot_demo.models.*;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StoneConfigs {
    
    @Bean(name="mind")
    @Scope("prototype")
    public MindStone mindStone(){
        return new MindStone();
    }
    
    @Bean(name="power")
    @Scope("prototype")
    public PowerStone powerStone(){
        return new PowerStone();
    }

    @Bean(name="reality")
    @Scope("prototype")
    public RealityStone realityStone(){
        return new RealityStone();
    }

    @Bean(name="soul")
    @Scope("prototype")
    public SoulStone soulStone(){
        return new SoulStone();
    }

    @Bean(name="space")
    @Scope("prototype")
    public SpaceStone spaceStone(){
        return new SpaceStone();
    }

    @Bean(name="time")
    @Scope("prototype")
    public TimeStone timeStone(){
        return new TimeStone();
    }
}
