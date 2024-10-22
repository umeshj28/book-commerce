    //package servlets;
    //
    //import java.io.IOException;
    //import java.io.PrintWriter;
    //
    //import javax.servlet.RequestDispatcher;
    //import javax.servlet.ServletException;
    //import javax.servlet.http.HttpServlet;
    //import javax.servlet.http.HttpServletRequest;
    //import javax.servlet.http.HttpServletResponse;
    //
    //import com.bittercode.model.UserRole;
    //import com.bittercode.util.StoreUtil;
    ////Http Servlet extended class for showing the about information
    //public class AboutServlet extends HttpServlet {
    //
    //    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    //        PrintWriter pw = res.getWriter();
    //        res.setContentType("text/html");
    //        //If the store is logged in as customer or seller show about info
    //        if (StoreUtil.isLoggedIn(UserRole.CUSTOMER, req.getSession())) {
    //            RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
    //            rd.include(req, res);
    //            StoreUtil.setActiveTab(pw, "about");
    ////            pw.println("<iframe src=\"https://flowcv.me/shashirajraja\" class=\"holds-the-iframe\"\r\n"
    ////                    + "        title=\"My Personal Website\" width=\"100%\" height=\"100%\"></iframe>");
    //
    //        } else if (StoreUtil.isLoggedIn(UserRole.SELLER, req.getSession())) {
    //            RequestDispatcher rd = req.getRequestDispatcher("SellerHome.html");
    //            rd.include(req, res);
    //            StoreUtil.setActiveTab(pw, "about");
    ////            pw.println("<iframe src=\"https://flowcv.me/shashirajraja\" class=\"holds-the-iframe\"\r\n"
    ////                    + "        title=\"My Personal Website\" width=\"100%\" height=\"100%\"></iframe>");
    //
    //        } else {
    //            //If the user is not logged in, ask to login first
    //            //Proceed only if logged in or forword to login page
    //            RequestDispatcher rd = req.getRequestDispatcher("login.html");
    //            rd.include(req, res);
    //            pw.println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
    //        }
    //
    //    }
    //
    //}
    package servlets;
    
    import java.io.IOException;
    import java.io.PrintWriter;
    
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    import com.bittercode.model.UserRole;
    import com.bittercode.util.StoreUtil;
    
    public class AboutServlet extends HttpServlet {
    
        public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
            PrintWriter pw = res.getWriter();
            res.setContentType("text/html");
    
            // Array of names and roll numbers to print
            String[][] nameRollNumbers = {
                {"Srijana", "HU21CSEN0100566"},
                {"Madhurya", "HU21CSEN0100578"},
                {"Umesh", "HU21CSEN0101353"},
                {"Akash", "HU21CSEN0100672"}
            };
    
            // If the store is logged in as customer or seller, show about info
            if (StoreUtil.isLoggedIn(UserRole.CUSTOMER, req.getSession())) {
                RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
                rd.include(req, res);
                StoreUtil.setActiveTab(pw, "about");
    
                // Print the names and roll numbers for the customer, centered in the page, inside a styled box
                pw.println("<div style='display: flex; justify-content: center; align-items: center; height: 100vh;'>");
                pw.println("<div style='text-align: center; border: 2px solid #000; padding: 20px; width: 300px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #f0f0f0;'>");
                pw.println("<h2 style='font-weight: bold;'>Book Commerce:</h2>");
                pw.println("<ul style='list-style-type: none; padding: 0; font-weight: bold; font-size: 1.5em;'>");
                for (String[] nameRoll : nameRollNumbers) {
                    pw.println("<li style='padding: 5px;'>" + nameRoll[0] + " - " + nameRoll[1] + "</li>");
                }
                pw.println("</ul>");
                pw.println("</div>");
                pw.println("</div>");
    
            } else if (StoreUtil.isLoggedIn(UserRole.SELLER, req.getSession())) {
                RequestDispatcher rd = req.getRequestDispatcher("SellerHome.html");
                rd.include(req, res);
                StoreUtil.setActiveTab(pw, "about");
    
                // Print the names and roll numbers for the seller, centered in the page, inside a styled box
                pw.println("<div style='display: flex; justify-content: center; align-items: center; height: 100vh;'>");
                pw.println("<div style='text-align: center; border: 2px solid #000; padding: 20px; width: 300px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #f0f0f0;'>");
                pw.println("<h2 style='font-weight: bold;'>Names and Roll Numbers:</h2>");
                pw.println("<ul style='list-style-type: none; padding: 0; font-weight: bold; font-size: 1.5em;'>");
                for (String[] nameRoll : nameRollNumbers) {
                    pw.println("<li style='padding: 5px;'>" + nameRoll[0] + " - " + nameRoll[1] + "</li>");
                }
                pw.println("</ul>");
                pw.println("</div>");
                pw.println("</div>");
    
            } else {
                // If the user is not logged in, ask to login first
                // Proceed only if logged in or forward to login page
                RequestDispatcher rd = req.getRequestDispatcher("login.html");
                rd.include(req, res);
                pw.println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
            }
        }
    }
