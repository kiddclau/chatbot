package ro.vladfernoaga.telegram_chatbot_starter.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ro.vladfernoaga.telegram_chatbot_starter.dto.GeographyDto;

public class DatabaseMethod  {
	
	/** The Constant LOGGER. */
	 private static final Logger LOGGER = LogManager.getLogger();
	
	public String cities;
	public int population;
	
	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}


	public int populatie;
	public String climate;
	public String history;
	
	
	
	public GeographyDto getOrasDetails(String oras) {
		
		GeographyDto entity = new GeographyDto();
		
		
	    String url = "jdbc:postgresql://localhost:5432/starterDb";
        String user = "postgres";
        String password = "cla02ned";
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from geography where place_name='"+oras+"'")) {

        	while(rs.next()) {
        		entity.setId(rs.getLong(1));
        		entity.setPlace_name(rs.getString(2));
        		entity.setClimate(rs.getString(3));
        		entity.setPopulation(rs.getLong(4));
        		entity.setHistory(rs.getString(5));
        		entity.setOther_details(rs.getString(6));
        	}
        	rs.close();
           
       
        } catch (SQLException ex) {
                LOGGER.error(ex);   
        }
        
        return entity;
}
	public ArrayList<String> getOrase() {
		ArrayList<String> list = new ArrayList<String>();
	    String url = "jdbc:postgresql://localhost:5432/starterDb";
        String user = "postgres";
        String password = "cla02ned";
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT place_name from geography")) {
    
        	while(rs.next()) {
        		list.add(rs.getString(1));
        	}
           
       
        } catch (SQLException ex) {
                LOGGER.error(ex);   
        }
        
        return list;
}
       
	/* public String getCities() {
	  		return cities;
	  	}
	  	
	  	public void setCities(String city) {
	  		this.cities=city;
	  	}
	*/

public int checkPopulatie(String Oras,String cuvantpopulatie ) {
    String url = "jdbc:postgresql://localhost:5432/starterDb";
    String user = "postgres";
    String password = "cla02ned";
    try (Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT population from geography where lower(place_name)='brasov'"))
    		{

    	while(rs.next()) {
        	
        	populatie = rs.getInt(1);
            System.out.println(populatie);
    	}
                 	
        
        
    } catch (SQLException ex) {
            LOGGER.error(ex);   
    }
    
    return populatie;
}

public String checkClima() {
    String url = "jdbc:postgresql://localhost:5432/starterDb";
    String user = "postgres";
    String password = "cla02ned";
    try (Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT climate from geography where lower(place_name)='brasov'"))
    		{

    	while(rs.next()) {
        	
        	climate = rs.getString(1);
            System.out.println(climate);
    	}
                 	
        
        
    } catch (SQLException ex) {
            LOGGER.error(ex);   
    }
    
    return climate;
}


public String checkHistory() {
    String url = "jdbc:postgresql://localhost:5432/starterDb";
    String user = "postgres";
    String password = "init1234";
    try (Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT history from geography where lower(place_name)='brasov'"))
    		{

    	while(rs.next()) {
        	
        	history = rs.getString(1);
            System.out.println(history);
    	}
                 	
        
        
    } catch (SQLException ex) {
            LOGGER.error(ex);   
    }
    
    return history;
}

  

}
