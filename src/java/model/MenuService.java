/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bob
 */
public class MenuService {
    private IMenuItemDAO dao = new MenuItemDAO();
    List<MenuItem> menuItems;
    public MenuService(){ 
    }
    
    
    public List<MenuItem> getMenu() throws SQLException{
        menuItems = dao.getMenu();
        return menuItems;
    }
    
}
