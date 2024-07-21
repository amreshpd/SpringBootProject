package com.nt.jdbc; 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Bank3 {
	static Connection con=null;
	static Scanner sc=null;
   private static Logger logger=Logger.getLogger(Bank3.class);
		   
public static void main(String[] args) {
		Bank3.connection();
		float transferAmount;
		long senderAccount,receiverAccount;
		logger.debug("start of main method");
		try {
			PreparedStatement stm1 = con.prepareStatement("select * from Account where accnumber=?");
			PreparedStatement stm2 = con.prepareStatement("update account set balance=balance+? where accnumber=?");
			con.setAutoCommit(false);
			sc=new Scanner(System.in);
			
			System.out.println("Enter sender account number: ");
			senderAccount=sc.nextLong();
			stm1.setLong(1, senderAccount);
			ResultSet exe1 = stm1.executeQuery();
			if(exe1.next()) {
				if(exe1.getLong(1)==senderAccount) {
					Float bal=exe1.getFloat(2);
					System.out.println("Enter Receiver Account number");
					receiverAccount=sc.nextLong();
					stm1.setLong(1, receiverAccount);
					ResultSet exe2 = stm1.executeQuery();
					while(exe2.next()) {
						if(exe2.getLong(1)==receiverAccount) {
							System.out.println("Enter balance to send");
							transferAmount=sc.nextFloat();
							if(transferAmount<=bal) {
								stm2.setFloat(1, -transferAmount);
								stm2.setLong(2, senderAccount);
								 int k1 = stm2.executeUpdate();
								
								stm2.setFloat(1, +transferAmount);
								stm2.setLong(2, receiverAccount);
								int k = stm2.executeUpdate();
								logger.warn("Warning message in JDBC for SQl Query");
								if(k==1 && k1==1) {
								con.commit();
								System.out.println("success");
															
								}else {
									System.err.println("interupted exception");
									con.rollback();
									con.close();
									logger.debug("Resultset is proceed");
								}
							}else {
								System.out.println("insufficient ammount");
								
							}
							
						}else {
							System.out.println("invalid receiver account");
						}
					}
				}else {
					System.out.println("invalid sender account");
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			logger.error("Known DB is problem"+e.getMessage()+"SQL QUERY ERROR");
		}catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Unknown problem "+e.getMessage());
		}finally {
			
		}
		
		
	}
    
    public static void connection() {
    try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amresh","amresh1998");
    
    //LOJ4G
    //create Layout object
    PropertyConfigurator.configure("src/main/java/com/nt/cmn/log4j.properties");
      logger.info("log4 setup ready");
     
     
    }catch (Exception e) {
		e.printStackTrace();
		logger.fatal("Test problem while setting up log4j");
	}
  }    
}