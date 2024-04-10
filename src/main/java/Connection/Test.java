//package Connection;
//
//import java.sql.*;
//
//public class Test {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/ltm";
//        String name = "root";
//        String password = "123456789";
//        try {
//            Connection cnn = DriverManager.getConnection(url, name, password);
//            System.out.println("Connect success");
//
////            String query = "select * from sinhvien";
////            PreparedStatement statement = cnn.prepareStatement(query);
////            ResultSet rs = statement.executeQuery();
//
////            while (rs.next()){
////                System.out.println(rs.getString("name"));
////            }
////
////            String querydelete = "delete from sinhvien where id=1112";
////            PreparedStatement statement = cnn.prepareStatement(querydelete);
////            int rs = statement.executeUpdate();
////            if (rs>0){
////                System.out.println("Delete success");
////            }
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
////    }
////}