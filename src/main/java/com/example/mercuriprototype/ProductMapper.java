package com.example.mercuriprototype;

import com.example.mercuriprototype.domain.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductMapper {

    public void createProduct(Product product) throws Exception {
        try {
            Connection con = DB2Connector.getConnection();
            String SQL = "INSERT INTO products (name, price, stocknumber) VALUES (?, ?, ?)";




            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setInt(3,product.getStocknumber());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public int deleteProduct(int productID) throws Exception {

        Connection con = DB2Connector.getConnection();


        String SQL = "delete from products where id=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, productID);


        //hvis executeUpdate returnere 0, er intet ændret, altså den kan ikke finde en task med nummeret.
        int numberOfRowCounts = ps.executeUpdate();

        return numberOfRowCounts;
    }


    public void updateProduct(Product product) throws SQLException {
        Connection con = DB2Connector.getConnection();
        String SQL = "Update products set name=?, stocknumber=?, price=? where id=? ";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, product.getName());
        ps.setInt(2,product.getStocknumber());
        ps.setInt(3,product.getPrice());
        ps.setInt(4,product.getId());
        ps.executeUpdate();



    }

    public ArrayList<Product> getAll() throws SQLException {
        Connection con = DB2Connector.getConnection();
        ArrayList<Product> products = new ArrayList<>();

        String SQL = "select * from products";
        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("stocknumber"), rs.getInt("price"));
            products.add(product);
        }


        return products;
    }

    public Product getById(int productId) throws SQLException {
        Product product1 = new Product();
        Connection con = DB2Connector.getConnection();
        String SQL = "select product from products where id=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1,productId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            return new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("stocknumber"),rs.getInt("price"));
        }
        return product1;
    }
}
