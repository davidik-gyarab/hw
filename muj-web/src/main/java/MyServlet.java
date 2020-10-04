import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/timezone")
public class MyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();

    String get = req.getParameter("zone");
    Set<String> tzs = ZoneId.getAvailableZoneIds();
    boolean time = false;
    for (String str : tzs) {
      if (str != null && str.equals(get)) {
        time = true;
        break;
      }
    }
    String info = "Wrong Timezone";
    if (time == true) {
      ZoneId zone = ZoneId.of(get);
      ZonedDateTime posttz = ZonedDateTime.now(zone);
	info = 	"Your Timezone is" + posttz;
    }

    out.println("<html><body>");
    out.println(info);
    out.println("<a href=`/`>,back</a>");
    out.println("</body></html>");
  }
}
