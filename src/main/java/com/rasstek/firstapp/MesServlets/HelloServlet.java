package com.rasstek.firstapp.MesServlets;//C'est le Namespace de la classe

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")/*cette annotation permet de définir le nom de la servlet(objet) et
 l'url sur laquelle elle est accessible/ il instancie la classe (name= helloServlet et le chemin ( value = /hello-servlet)*/

public class HelloServlet extends HttpServlet {
    private String message;
    private final StringBuilder strreponse = new StringBuilder();

    public void init() {
        message = "servlet Hello World!";
        strreponse.append("Je suis la methode init de la servlet <br>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // informer le client du type de la réponse
        response.setContentType("text/html;charset=UTF-8");
        // récupérer le buffer de sortie associe à la réponse
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"hello-servlet\" method=\"post\">");
            out.println("Numero : <input type=\"text\" id=\"txtnumero\" name=\"txtnumero\"/></br>");
            out.println("Nom : <input type=\"text\" name=\"txtnom\"/></br>");
            out.println("Salaire : <input type=\"text\" name=\"txtsalaire\"/></br>");
            out.println("<input type=\"submit\" name=\"btsubmit\" value=\"Submit\"/></br>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        strreponse.append("Je suis la methode service de la servlet <br>");
        super.service(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // informer le client du type de la réponse
        response.setContentType("text/html;charset=UTF-8");
        // récupérer le buffer de sortie associe à la réponse
        PrintWriter out = response.getWriter();
        try {
            String numero = request.getParameter("txtnumero");
            String nom = request.getParameter("txtnom");
            String salaire = request.getParameter("txtsalaire");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Les données saisies sont : </h1>");
            out.println("<h2>Numero : " + numero + "</h2>");
            out.println("<h2>Nom : " + nom + "</h2>");
            out.println("<h2>Salaire : " + salaire + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    public void destroy() {
        // Code pour libérer des ressources, fermer des connexions, etc.
      //  System.out.println("La servlet est en train d'être détruite.");

    }
}