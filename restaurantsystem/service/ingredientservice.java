/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurantsystem.model.Item;

/**
 *
 * @author Akankshya
 */
public class ingredientservice {
    public ingredientservice()
    {}
double pricer = 0;

public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
       
        try (Scanner scanner = new Scanner(new FileInputStream("storage/item.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Item item = new Item(itemInfo[0], Double.parseDouble(itemInfo[1]),
                        Integer.parseInt(itemInfo[2]));
                if(Integer.parseInt(itemInfo[2])<4)
                {
                    pricer+=Double.parseDouble(itemInfo[1]);
                    items.add(item);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
}

public String getPrice()
{
    return String.valueOf(pricer);
    
}
}