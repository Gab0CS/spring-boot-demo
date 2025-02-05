package com.gabo.spring_boot_demo.configs;

import com.gabo.spring_boot_demo.models.*;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
@Profile("series")
@PropertySources({
	@PropertySource("classpath:configs/stone-series.properties"),
	@PropertySource("classpath:configs/mind_stone.properties"),
	@PropertySource("classpath:configs/power_stone.properties"),
	@PropertySource("classpath:configs/reality_stone.properties"),
	@PropertySource("classpath:configs/soul_stone.properties"),
	@PropertySource("classpath:configs/space_stone.properties"),
	@PropertySource("classpath:configs/time_stone.properties")
})
public class StoneConfigsSeries {

    @Value("${subtitles.url}") private String subtitlesURL;
    @Value("${spring.profiles.active:default}") private String profile;

    @Value("${stone.mind.color}") private String colorMind;
    @Value("${stone.mind.name}") private String nameMind;
    @Value("${stone.mind.location}") private String locationMind;
    @Value("${stone.mind.energy-level}") private Integer energyMind;
    
    @Bean(name="mind")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.mind.enabled",
        havingValue = "TRUE"
    )
    public MindStone mindStone(){
        return new MindStone(colorMind, nameMind, locationMind, energyMind);
    }
    
    @PostConstruct
    public void init(){
        log.info("Loading subtitles : {}, with profile: {}", this.subtitlesURL, profile);
    }


    @Value("${stone.power.color}")
    private String colorPower;

    @Value("${stone.power.name}")
    private String namePower;

    @Value("${stone.power.location}")
    private String locationPower;

    @Value("${stone.power.energy-level}")
    private Integer energyPower;
    @Bean(name="power")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.power.enabled",
        havingValue = "TRUE"
    )
    public PowerStone powerStone(){
        return new PowerStone(colorPower, namePower, locationPower, energyPower);
    }

    @Value("${stone.reality.color}")
    private String colorReality;

    @Value("${stone.reality.name}")
    private String nameReality;

    @Value("${stone.reality.location}")
    private String locationReality;

    @Value("${stone.reality.energy-level}")
    private Integer energyReality;
    @Bean(name="reality")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.reality.enabled",
        havingValue = "TRUE"
    )
    public RealityStone realityStone(){
        return new RealityStone(colorReality, nameReality, locationReality, energyReality);
    }

    @Value("${stone.soul.color}")
    private String colorSoul;

    @Value("${stone.soul.name}")
    private String nameSoul;

    @Value("${stone.soul.location}")
    private String locationSoul;

    @Value("${stone.soul.energy-level}")
    private Integer energySoul;
    @Bean(name="soul")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.soul.enabled",
        havingValue = "TRUE"
    )
    public SoulStone soulStone(){
        return new SoulStone(colorSoul, nameSoul, locationSoul, energySoul);
    }

    @Value("${stone.space.color}")
    private String colorSpace;

    @Value("${stone.space.name}")
    private String nameSpace;

    @Value("${stone.space.location}")
    private String locationSpace;

    @Value("${stone.space.energy-level}")
    private Integer energySpace;
    @Bean(name="space")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.space.enabled",
        havingValue = "TRUE"
    )
    public SpaceStone spaceStone(){
        return new SpaceStone(colorSpace, nameSpace, locationSpace, energySpace);
    }

    @Value("${stone.time.color}")
    private String colorTime;

    @Value("${stone.time.name}")
    private String nameTime;

    @Value("${stone.time.location}")
    private String locationTime;

    @Value("${stone.time.energy-level}")
    private Integer energyTime;
    @Bean(name="time")
    @Scope("prototype")
    @ConditionalOnProperty(
        name = "stones.time.enabled",
        havingValue = "TRUE"
    )
    public TimeStone timeStone(){
        return new TimeStone(colorTime, nameTime, locationTime, energyTime);
    }
}
