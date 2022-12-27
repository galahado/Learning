package com.powernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        var out = servletResponse.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/powernode";
            String username = "root";
            String password = "Zcq0323#";
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from t_student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String no = rs.getString("no");
                String name = rs.getString("name");
                out.print(no + ", " + name + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
