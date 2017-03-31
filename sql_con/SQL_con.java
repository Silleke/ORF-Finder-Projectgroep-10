/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_con;

import FileHandler.FileReader;
import java.sql.*;
import java.util.ArrayList;
import ORF.findORF;

/**
 *
 * @author tim
 */
public class SQL_con {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://xirect.nl:3306/";
    static final String DB_NAME = "pg10";
    static final String USER = "pg10";
    static final String PASS = "blaat1234";
    
    static ResultSet row_in_database;
    static ArrayList<Object> all_results_database = new ArrayList<>();
    
    /**
     * Deze methode connect met de database en vult de database met de gevonden ORF statistieken van de desbetreffende sequentie.
     */
    public void connect() {
        ArrayList<Object> countListDNA = new ArrayList<Object>();
        Connection conn = null;
        Statement stmt = null;
        int dnaID = 0;

        try {
            findORF orf = new findORF();
            FileReader reader = new FileReader();
            
            // laden van de JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connectie met de database.
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
           
            stmt = conn.createStatement();
            
            // HIER MOET JE EVENTJES BIJZETTEN WAT HET DOET!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            ResultSet result = stmt.executeQuery("SELECT ORFfinder_ID FROM DNA");
            
            while (result.next()) {
                countListDNA.add(new Integer(result.getInt(1)));
            }
            
            dnaID = countListDNA.size() + 1;
            stmt = conn.createStatement();
            
            // Toevoegen van het dnaID en de template strand.
            String sql = "INSERT INTO DNA(ORFfinder_ID, DNA_seq)"
                    + "VALUES (" + dnaID + ",'" + reader.getTemplateStrand() + "')";
            stmt.executeUpdate(sql);
            stmt = null;
            stmt = conn.createStatement();
            
            // Toevoegen van de gegevens van het ORF aan het dnaID van de desbetreffende sequentie.
            int ORFcount = 0;
            while (ORFcount < orf.getORFsequenceComp().size()) {
                sql = "INSERT INTO ORF(DNA_ID_fkey, ORFseq,ReadingFrame,start,stop)" + "VALUES (" + dnaID + ",'" + orf.getORFsequenceComp().get(ORFcount) + "','-" + orf.getORFrfComp().get(ORFcount) + "'," + orf.getORFstartComp().get(ORFcount) + "," + orf.getORFendComp().get(ORFcount) + ")";
                stmt.executeUpdate(sql);
                ORFcount++;
            }
            
            stmt = null;
            stmt = conn.createStatement();

            int countTempORF = 0;
            
            // Toevoegen van de gegevens van het ORF aan het dnaID van de desbetreffende sequentie.
            while (countTempORF < orf.getORFsequenceTemp().size()) {
                sql = "INSERT INTO ORF(DNA_ID_fkey, ORFseq,ReadingFrame,start,stop)"
                        + "VALUES (" + dnaID + ",'" + orf.getORFsequenceTemp().get(countTempORF) + "','+" + orf.getORFrfTemp().get(countTempORF) + "'," + orf.getORFstartTemp().get(countTempORF) + "," + orf.getORFendTemp().get(countTempORF) + ")";
                stmt.executeUpdate(sql);
                countTempORF++;

            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    /**
     * Deze methode haalt alles op uit de database en slaat het op in een arraylist zodat de arraylist opgehaald kan 
     * worden doormiddel van een getter.
     */
    public void setDatabaseItems(){
        try {
            Connection conn = null;
            Statement stmt = null;
            
            // De kolomnamen toevoegen aan de arraylist zodat deze doormiddel van een getter opgehaald kunnen worden.
            all_results_database.add("ORF ID" + "\t" + "Reading frame"
                        + "\t" + "Start positie"+ "\t" + "Stop positie"
                        + "\t" +"\n");
            
            // Laden van de JDBC Driver. 
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connectie maken met de SQL database. 
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            String query = "select ORFfinder_ID,ReadingFrame,start,stop from DNA inner join ORF on DNA.ORFfinder_ID = ORF.DNA_ID_fkey";       
            stmt = conn.createStatement();
            SQL_con.row_in_database = stmt.executeQuery(query);
            
            // Het ophalen van alle gegevens uit de database en in de arraylist zetten zodat de gegevens opgehaald kunnen worden 
            // doormiddel van een getter. 
            while (SQL_con.row_in_database.next()) {          
                all_results_database.add(SQL_con.row_in_database.getInt("ORFfinder_ID") + "\t");
                all_results_database.add(SQL_con.row_in_database.getString("ReadingFrame") + "\t");
                all_results_database.add(SQL_con.row_in_database.getInt("start") + "\t");
                all_results_database.add(SQL_con.row_in_database.getInt("stop") + "\n");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @return all_results_database     Ophalen van alle gegevens in de database.
     */
    public ArrayList getDatabaseItems(){
        return all_results_database;
    }
}
