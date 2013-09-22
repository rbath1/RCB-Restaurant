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
public interface IMenuItemDAO {
    public abstract List<MenuItem> getMenu() throws RuntimeException, SQLException;
}
