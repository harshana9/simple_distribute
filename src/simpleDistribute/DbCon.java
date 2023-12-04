package simpleDistribute;
import java.sql.*;

public final class DbCon {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int numAffectedRows;
    
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://b4kqgebpx5azhitvdtvz-mysql.services.clever-cloud.com:3306/b4kqgebpx5azhitvdtvz";
            //String url = "jdbc:mysql://littlelionagencyinstance.c8soxrhsg1w7.ap-southeast-1.rds.amazonaws.com:3306/agency";
            String user = "uenmoomtemlvajs7";
            String password = "GqSjLCMiyuPpQ3YfG0VH";
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB Connection Error@ClassDbCon: "+e);
        }
    }
    
    public ResultSet query(String sql){
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;            
        } catch (SQLException e) {
            System.out.println("DB Querying Error@ClassDbCon: "+e);
        }
        return null;
    }
    
    public int update(String sql){
        try {
            st = con.createStatement();
            numAffectedRows = st.executeUpdate(sql);
            return numAffectedRows;            
        } catch (SQLException e) {
            System.out.println("DB Querying Error@ClassDbCon: "+e);
        }
        return 0;
    }
    
    public int singleReturnQuery(String sql){
        int result=0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                try {
                    result=Integer.parseInt(rs.getString(1));
                } catch (NumberFormatException | SQLException e) {}
            }
            return result;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public void close(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { /* Ignored */}
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) { /* Ignored */}
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) { /* Ignored */}
        }
    }
}
