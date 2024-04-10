package Connection;

import com.example.demo.controllers.NguoiThueNha;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAO {
private Connection connection;
   public DAO(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quanlynhachothue?user=root&password=123456789");
           System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
       }catch (Exception e){
e.printStackTrace();
       }
   }
public boolean addNguoiThueNha (NguoiThueNha nguoiThueNha){
       String sql = "INSERT INTO danhsachnguoithue(STT, MaNguoiThue, HoTen, SoDienThoai, SoCCCD, NgayThue, KieuNha, KhuVucThue, ThoiHanThue) " +
               "VALUES (?,?,?,?,?,?,?,?,?)";
       try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setInt(1, nguoiThueNha.getStt());
           ps.setString(2, nguoiThueNha.getId());
           ps.setString(3,nguoiThueNha.getName());
           ps.setInt(4,nguoiThueNha.getSdt());
           ps.setInt(5,nguoiThueNha.getSocccd());
           ps.setDate(6, java.sql.Date.valueOf(nguoiThueNha.getFormattedNgayThue()));
            ps.setString(7, nguoiThueNha.getKieuNha() );
        ps.setString(8, nguoiThueNha.getKhuVuc());
        ps.setString(9,nguoiThueNha.getThoihanThue() );
        return ps.executeUpdate()>0;
       }catch (Exception e){
           e.printStackTrace();
       }
       return false;
}
public ArrayList<NguoiThueNha> getNguoiThueNhaList (){
       ArrayList<NguoiThueNha> list = new ArrayList<>();
       String sql = "SELECT * FROM danhsachnguoithue";
       try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               NguoiThueNha nguoiThueNha = new NguoiThueNha();
               nguoiThueNha.setStt(rs.getInt("STT"));
               nguoiThueNha.setId(rs.getString("MaNguoiThue"));
               nguoiThueNha.setName(rs.getString("HoTen"));
               nguoiThueNha.setSdt(rs.getInt("SoDienThoai"));
               nguoiThueNha.setSocccd(rs.getInt("SoCCCD"));
               nguoiThueNha.setNgaythue(rs.getObject("NgayThue", LocalDate.class));
               nguoiThueNha.setKieuNha(rs.getString("KieuNha"));
               nguoiThueNha.setKhuVuc(rs.getString("KhuVucThue"));
               nguoiThueNha.setThoihanThue(rs.getString("ThoiHanThue"));
               list.add(nguoiThueNha);
           }

       }catch (Exception e){
e.printStackTrace();
       }
       return list;
}
    public static void main(String[] args) {
        new DAO();
    }
}
