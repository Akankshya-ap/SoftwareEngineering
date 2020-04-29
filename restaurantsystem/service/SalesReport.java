/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.service;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurantsystem.model.Item;

import restaurantsystem.model.OrderLine;

/**
 *
 * @author Akankshya
 */
public class SalesReport {
    
   
    public SalesReport() {
    }
    
  /*  public List<OrderLine> getAll() {
        List<OrderLine> orders = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/orderLine.txt"))) {
            while (scanner.hasNextLine()) {
                String orderLine = scanner.nextLine();

                String orderInfo[] = orderLine.split(",");
                //System.out.println(orderInfo);
                OrderLine order;
                order = new OrderLine(Integer.parseInt(orderInfo[0]),orderInfo[1], Integer.parseInt(orderInfo[2]),Double.parseDouble(orderInfo[3]));

                orders.add(order);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }*/

    public List<OrderLine> getAll() {
        List<OrderLine> sales = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/orderLine.txt"))) {
            while (scanner.hasNextLine()) {
                String orderLine = scanner.nextLine();
                //orderLine=scanner.nextLine();
                
                //System.out.println(orderLine);
                String orderInfo[] = orderLine.split(",");
                //System.out.println(Double.parseDouble(orderInfo[3]));
                OrderLine ol = new OrderLine(Integer.parseInt(orderInfo[0]),orderInfo[1], Integer.parseInt(orderInfo[2]),Double.parseDouble(orderInfo[3]));
                
                sales.add(ol);
                //System.out.println(sales);
            }
        } catch (Exception ex) {
            Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }
    
    
    public OrderLine getorderByIndex(int index) {
        List<OrderLine> listOforder = getAll();

        if (listOforder.size() >= index) {
            return listOforder.get(index - 1);
        }

        return null;
    }
}

    