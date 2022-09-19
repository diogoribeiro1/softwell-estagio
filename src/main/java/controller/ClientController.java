package controller;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import dao.ClientDao;
import model.ClientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ClientController", urlPatterns = {"/home"})
public class ClientController extends HttpServlet {

    private ClientDao clientDao = new ClientDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);

        }else {

            switch (action) {

                case "POST":

                    String nome = req.getParameter("nome");
                    String email = req.getParameter("email");
                    String nomeMae = req.getParameter("nomeMae");
                    String nomePai = req.getParameter("nomePai");
                    String cpf = req.getParameter("cpf");
                    String celular = req.getParameter("celular");
                    String rg = req.getParameter("rg");
                    String dataNasc = req.getParameter("dataNasc");
                    try {

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.sql.Date data = new java.sql.Date(sdf.parse(dataNasc).getTime());

                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                        if (email.isEmpty()) {
                            email = null;
                        }

                        ClientModel clientModel = clientDao.getClientById(rg);

                        if (clientModel == null) {

                            clientModel = new ClientModel(nome, email, data, rg, cpf, celular, nomeMae, nomePai, timestamp);
                            clientDao.saveClient(clientModel);

                            PrintWriter out = resp.getWriter();
                            out.print(new Gson().toJson("Cliente Salvo"));
                            out.flush();

//                            cadastroSucesso(req, resp);

                        } else {

                            timestamp = clientModel.getDataCadastrada();
                            Date datehoje = new Date(timestamp.getTime());
                            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            String timestampString = sdf1.format(datehoje);

                            PrintWriter out = resp.getWriter();
                            out.print(new Gson().toJson("Cliente ja possui cadastrado: " + timestampString));
                            out.flush();
//                            cadastroErro(req, resp, timestamp);
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    protected void cadastroSucesso(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("cadastroSucesso.jsp");
        rd.forward(req, resp);
    }

    protected void cadastroErro(HttpServletRequest req, HttpServletResponse resp, Timestamp timestamp) throws ServletException, IOException {
        req.setAttribute("timestamp", timestamp);
        RequestDispatcher rd = req.getRequestDispatcher("cadastroErro.jsp");
        rd.forward(req, resp);
    }
}
