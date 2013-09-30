package controller;

import database.MenuDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MenuItem;
import model.MenuItemDAO;
import model.service.MenuService;

/**
 *
 * @author Bob
 */
public class MenuController extends HttpServlet {
    private static final String MENU_PAGE = "/menu.jsp";
    private static final String UPDATE_PAGE = "/update.jsp";
    private static final String ACTION_KEY = "action";


    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

public MenuController(){
    super();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        MenuService service = new MenuService();
        List<MenuItem> menuItems = service.getMenu();
        request.setAttribute("menuList", menuItems);
      
        RequestDispatcher view =
                request.getRequestDispatcher(MENU_PAGE);
        view.forward(request, response);  
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {     
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request,response);
//      response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//       
//        MenuItemDAO dao = new MenuItemDAO();
//        List<MenuItem> menuItems = new ArrayList<MenuItem>();
//       
//        
//        menuItems = dao.getCurrentMenuChoices();
//        
//        request.setAttribute("menuList", menuItems);
//        
//        RequestDispatcher view =
//                request.getRequestDispatcher(MENU_PAGE);
//        view.forward(request, response);
    } catch (Exception ex) {
        Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
