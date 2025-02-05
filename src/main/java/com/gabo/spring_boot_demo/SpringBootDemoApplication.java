package com.gabo.spring_boot_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.gabo.spring_boot_demo.models.PowerStone;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:configs/stone.properties"),
	@PropertySource("classpath:configs/mind_stone.properties"),
	@PropertySource("classpath:configs/power_stone.properties"),
	@PropertySource("classpath:configs/reality_stone.properties"),
	@PropertySource("classpath:configs/soul_stone.properties"),
	@PropertySource("classpath:configs/space_stone.properties"),
	@PropertySource("classpath:configs/time_stone.properties")
})
public class SpringBootDemoApplication implements CommandLineRunner {

	//DI, properties, configs and env variables, and java methods
	// @Value(value = "#{T(java.time.LocalDateTime).now()}")
	// @Value(value = "${stones.power.create}")
	private String value; 

	@Value("${stones.soul.enabled}")
	private Boolean soulEnabled;
	@Autowired
	private PowerStone powerStone;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(powerStone);
		System.out.println(soulEnabled);
	}
	
}
