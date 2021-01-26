package com.example.getcontainers.domain;

import com.example.getcontainers.dto.TestDto;


import java.sql.*;
import java.util.Arrays;
import java.util.Vector;

public class GetContainers {

    private static Vector<String> devide(String s){
        String substring = s.substring(0, s.length());
        //以逗号分割，得出的数据存到 result 里面
        String[] result = substring.split(",");
        return new Vector<>(Arrays.asList(result));
    }

    private static boolean judge(Vector<String> versions, String pagetype, TestDto dto){
        for (String v : versions) {
            if((v.equals(dto.getVersion()))&& pagetype.equals(dto.getPagetype())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("success");// 测试加载驱动有没有成功，成功就打印succese
        String url = "jdbc:mysql://121.43.187.16:3306/cb_mcc_test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";// 声明数据库news的url
        String user = "ybbdev121";// 数据库账号
        String password = "devdba!@#999";// 数据库密码
        Connection conn = DriverManager.getConnection(url, user, password);
        // 4.定义SQL语句
        String sql = "SELECT * FROM `mc_version_level`";// 查询语句
        // 5.获取执行sql的对象 Statement
        Statement stmt = (Statement) conn.createStatement();
        // 6.执行sql
        stmt.execute(sql);
        ResultSet rs = stmt.getResultSet();// 把查询的结果赋值给结果集对象
        TestDto dto = new TestDto("3.0.0","special");
        // 7.处理结果，输出查询语句
        while (rs.next()) {// 遍历结果集
            //System.out.print(rs.getString("versions") + "\n");
            Vector<String> versions = devide(rs.getString("versions"));
            if(judge(versions,rs.getString("pagetype"),dto)) {
                System.out.print(rs.getLong("id") +"\n");
                System.out.print(rs.getString("containers") + "\n");
                System.out.print(rs.getString("desc") + "\n");
                System.out.print(rs.getString("pagetype") + "\n");
            }
        }
        // 8.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
