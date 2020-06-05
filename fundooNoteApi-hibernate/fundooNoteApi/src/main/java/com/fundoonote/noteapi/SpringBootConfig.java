package com.fundoonote.noteapi;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import com.fundoonote.noteapi.controller.UserController;
import com.fundoonote.noteapi.model.YAMLConfig;

//Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
//rabbitMq:http://localhost:15672/
//usrname:password=guest
//radis cache:start the cli-redis-cli-ping*pong response-get name-set name-keys *(shows all your cache stored)
//redis-server-start server-redis-server-6379 port id.->verify whether data stored using getbyid method in postman.
//elasticsearch-start the server-elasticsearch.bat->open localhost:9200/userdata/Users/your id.->basic in client(search by id)
//kibana-start server-kibana.bat->localhost:5601/app/kibana#-discover-shows all your users->dev tools-you can test and work  on all rest api's.

//Note:if connectors port issue:1)find process,2)kill process->cmd->1)netstat -ao | find "8081",2)Taskkill /PID  20712 /F


@SpringBootApplication
@ComponentScan
@EnableCaching
public class SpringBootConfig implements CommandLineRunner {

	@Autowired
	private UserController contrl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfig.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Profiles....working On..");
		contrl.getCurrentprofiles();

	}
}
