package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcular")
public class Calculadora extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Inicio del HTML para mostrar la tabla
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultados de Seno y Coseno</title>");
        out.println("<link rel=\"stylesheet\" href=\"Styles.css\">");  // Si tienes un archivo CSS externo
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Resultados de Seno y Coseno</h1>");
        out.println("<table>");
        out.println("<tr><th>Ángulo (°)</th><th>Seno</th><th>Coseno</th></tr>");

        // Cálculo de los valores de seno y coseno
        for (int i = 0; i <= 360; i += 15) {
            double radianes = Math.toRadians(i);  // Convertir grados a radianes
            double seno = Math.sin(radianes);
            double coseno = Math.cos(radianes);

            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>" + String.format("%.4f", seno) + "</td>");
            out.println("<td>" + String.format("%.4f", coseno) + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
