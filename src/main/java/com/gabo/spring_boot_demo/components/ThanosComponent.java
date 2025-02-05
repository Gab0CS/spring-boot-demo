package com.gabo.spring_boot_demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.gabo.spring_boot_demo.models.ThanosModel;
import com.gabo.spring_boot_demo.services.GaunletService;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
//Use conditional on class when our bean depends on third libraries
@ConditionalOnClass(value = Faker.class)
public class ThanosComponent {
    private final GaunletService gaunletService;
    private final ThanosModel thanosModel;

    public ThanosComponent(GaunletService gaunletService, 
    ThanosModel thanosModel){
        this.gaunletService = gaunletService;
        this.thanosModel = thanosModel;
    }

    @PostConstruct
    public void init(){
        log.info("Loading thanos with configs: {}" ,thanosModel);
    }
    public void snap(){
        final var faker = new Faker();

        final var country = faker.country().name();

        log.info("Thanos is using the gaunlet to perform snap in: " + country);
        this.gaunletService.useFullPower();

        final var impactPoint = faker.random().nextInt(1000);

        log.info("Thanos get to make danger: " + impactPoint);
    }
}
