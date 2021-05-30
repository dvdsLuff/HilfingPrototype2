package com.example.mercuriprototype;

import com.example.mercuriprototype.domain.Product;

import java.sql.*;

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


    public void updateProduct(){

    }

}
