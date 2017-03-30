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
import javax.swing.JOptionPane;

/**
 *
 * @author tim
 */
public class SQL_con {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://xirect.nl:3306/";
    static final String dbName = "pg10";

    static final String USER = "pg10";
    static final String PASS = "blaat1234";

    public void connect() {
        Connection conn = null;
        Statement stmt = null;
        int dnaID = 0;

        try {
            
            findORF orf = new findORF();
      
            FileReader reader = new FileReader();
            String tempStr = reader.getTemplateStrand();
            orf.setORF(settings);
            System.out.println(orf.getORFstartComp().size());
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL + dbName, USER, PASS);
            System.out.println("Connected database successfully...");

            ArrayList<Object> dnacountlist = new ArrayList<Object>();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT ORFfinder_ID FROM DNA");
            while (result.next()) {

                dnacountlist.add(new Integer(result.getInt(1)));

            }
            dnaID = dnacountlist.size() + 1;

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO DNA(ORFfinder_ID, DNA_seq)"
                    + "VALUES (" + dnaID + ",'" + tempStr + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            System.out.println("Start ORF querrys");
            stmt = null;
            stmt = conn.createStatement();

            int ORFcount = 0;
            while (ORFcount < orf.getORFsequenceComp().size()) {

                sql = "INSERT INTO ORF(DNA_ID_fkey, ORFseq,ReadingFrame,start,stop)"
                        + "VALUES (" + dnaID + ",'" + orf.getORFsequenceComp().get(ORFcount) + "','-" + orf.getORFrfComp().get(ORFcount) + "'," + orf.getORFstartComp().get(ORFcount) + "," + orf.getORFendComp().get(ORFcount) + ")";
                stmt.executeUpdate(sql);
                ORFcount++;
                System.out.println("Inserted ORF records into the table...");
            }
            System.out.println("Start ORFTemp querrys");
            stmt = null;
            stmt = conn.createStatement();

            int ORFcountTemp = 0;
            while (ORFcountTemp < orf.getORFsequenceTemp().size()) {

                sql = "INSERT INTO ORF(DNA_ID_fkey, ORFseq,ReadingFrame,start,stop)"
                        + "VALUES (" + dnaID + ",'" + orf.getORFsequenceTemp().get(ORFcountTemp) + "','+" + orf.getORFrfTemp().get(ORFcountTemp) + "'," + orf.getORFstartTemp().get(ORFcountTemp) + "," + orf.getORFendTemp().get(ORFcountTemp) + ")";
                stmt.executeUpdate(sql);
                ORFcountTemp++;
                System.out.println("Inserted ORF records into the table...");
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
        System.out.println("Goodbye!");
    }
}
