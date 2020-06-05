package com.fundoonote.noteapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.annotation.JsonView;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	@JsonView(View.Summary.class)
	@Column
	private String name;

	@JsonView(View.Summary.class)
	@Column
	private String environment;

	@JsonView(View.Summary.class)
	@Column
	private List<String> servers = new ArrayList<>();

	@JsonView(View.Summary.class)
	@Column
	private String url;

	@JsonView(View.Summary.class)
	@Column
	private String newusername;

	@JsonView(View.Summary.class)
	@Column
	private String password;

	@JsonView(View.Summary.class)
	@Column
	private String driverclassname;

	@JsonView(View.Summary.class)
	@Column
	private String message;

	public YAMLConfig(String name, String environment, List<String> servers, String url, String newusername,
			String password, String driverclassname, String message) {
		super();
		this.name = name;
		this.environment = environment;
		this.servers = servers;
		this.url = url;
		this.newusername = newusername;
		this.password = password;
		this.driverclassname = driverclassname;
		this.message = message;
	}

	public YAMLConfig() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverclassname() {
		return driverclassname;
	}

	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "name=" + this.name + "Environment=" + this.environment + "servers=" + this.servers + "Url=" + this.url
				+ "NewUserName=" + this.newusername + "Password=" + this.password + "DriverClassname="
				+ this.driverclassname + "Message=" + this.message;
	}

}
