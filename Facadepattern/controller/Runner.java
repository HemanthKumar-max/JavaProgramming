package com.bridgelabz.Facadepattern.controller;

import java.sql.Connection;

import com.bridgelabz.Facadepattern.design.facade.Helperfacade;
import com.bridgelabz.Facadepattern.design.facade.MysqlHelper;
import com.bridgelabz.Facadepattern.design.facade.OracleHelper;



public class Runner 
{
	public static void main(String[] args) 
	{
	String tableName="employee";
	
	//generating MySql HTML report and Oracle PDF report without using Facade
	System.out.println("=======Generating mysql report  without using facade==========");
	Connection con = MysqlHelper.getMySqlDBConnection();
	MysqlHelper mySqlHelper = new MysqlHelper();
	mySqlHelper.generateMySqlHTMLReport(tableName, con);
    Connection con1 = OracleHelper.getOracleDBConnection();
	OracleHelper oracleHelper = new OracleHelper();
	oracleHelper.generateOraclePDFReport(tableName, con1);
	System.out.println("===========================================================");
	//generating MySql HTML report and Oracle PDF report using Facade
	System.out.println("========Generating  Mysql report using facade================");
	Helperfacade.generateReport(Helperfacade.DBTypes.MYSQL, Helperfacade.ReportTypes.HTML, tableName);
	Helperfacade.generateReport(Helperfacade.DBTypes.ORACLE, Helperfacade.ReportTypes.PDF, tableName);
}
}