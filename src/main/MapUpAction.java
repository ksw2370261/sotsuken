//MapUpAction.java
package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MapUpAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("map_up.jsp").forward(req, res);
    }
}

