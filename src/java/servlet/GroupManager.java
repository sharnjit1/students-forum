/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.DBManager;
import db.Group;
import db.User;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author halfblood
 */
public class GroupManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            //SHOW USERS FOLLOWING THE GROUP BUT INVISIBLE 
            DBManager manager = (DBManager) getServletContext().getAttribute("dbmanager");
            String groupParam = request.getParameter("id");
            Group groupToEdit = null;
            if (groupParam != null) {
                groupToEdit = manager.getGroup(Integer.parseInt(request.getParameter("id")));

                if (groupToEdit == null) {
                    return;
                }
            }
            int groupId = groupToEdit == null ? 0 : groupToEdit.getId();

            LinkedList<User> visibleFollowinUsers = manager.getUsersForGroupAndVisible(groupId);
            LinkedList<User> notVisibleFollowinUsers = manager.getUsersForGroupAndNotVisible(groupId);
            LinkedList<User> otherUsers = manager.getUsersNotInGroup(groupId);

            //SETTING GROUP NAME TABLE
            String titleString = "Create New Group";
            String nameString = "";
            if (groupToEdit != null) {
                titleString = "Edit Name";
                nameString = groupToEdit.getName();
            }

            request.setAttribute("visibleFollowinUsers", visibleFollowinUsers);
            request.setAttribute("notVisibleFollowinUsers", notVisibleFollowinUsers);
            request.setAttribute("otherUsers", otherUsers);
            request.setAttribute("groupTitle", titleString);
            request.getRequestDispatcher("/groupManager.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}