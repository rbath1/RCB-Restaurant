/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.IMenuDB;
import database.MenuDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bob
 */
public class MenuItemDAO implements IMenuItemDAO {
    private IMenuDB database;
    
    public MenuItemDAO(){
    database = new MenuDB();}
    
    public List<MenuItem> getMenu() throws RuntimeException, SQLException {
        List<MenuItem> items = new ArrayList<MenuItem>();
        
        try {
           
            database.openConnection();
            
            String query = "SELECT * FROM item";
            
         
            List<Map> rawData = database.findRecords(query, true);
            for(Map record : rawData) {
                MenuItem item = new MenuItem();
                int id = Integer.valueOf(record.get("item_id").toString());
                item.setItemId(id);
                String name = String.valueOf(record.get("item_name"));
                item.setItemName(name);
                Double price = Double.valueOf(record.get("item_price").toString());
                item.setItemPrice(price);
                items.add(item); 
            }
            return items;
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        } 
    }
 
    public static void main(String[] args) throws RuntimeException, SQLException {
//        MenuItemDAO dao = new MenuItemDAO();
//        List<MenuItem> items = dao.getMenu();
//        for(MenuItem item : items){
//             String itemName = item.getItemName();
//                            double itemPrice = item.getItemPrice();
//                            System.out.println(itemName + ", " + itemPrice);
//        }
    
        
    }
}
    

