package org.agoncal.book.javaee7.chapter21;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebServlet(urlPatterns = "/servletEJBConsumer")
public class ServletEJBConsumer extends HttpServlet {

  @EJB
  private EJBConsumer ejbConsumer;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.print("<h1>Servlet Consumer</h1><br/>");

    CreditCard creditCard = new CreditCard();
    creditCard.setNumber("12341234");
    creditCard.setExpiryDate("10/12");
    creditCard.setType("VISA");
    creditCard.setControlNumber(1234);

    out.print(ejbConsumer.validate(creditCard) + "<br/>");

    creditCard.setNumber("12341233");
    out.print(ejbConsumer.validate(creditCard) + "<br/>");
  }
}
