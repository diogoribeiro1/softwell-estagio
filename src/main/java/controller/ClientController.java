package controller;

import com.google.gson.Gson;
import dao.ClientDao;
import model.ClientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ClientController", urlPatterns = { "/home" })
public class ClientController extends HttpServlet {

    private ClientDao clientDao = new ClientDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);

        } else {

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

                            clientModel = new ClientModel(nome, email, data, rg, cpf, celular, nomeMae, nomePai,
                                    timestamp);
                            clientDao.saveClient(clientModel);

                            resp.setStatus(HttpServletResponse.SC_CREATED);
                            PrintWriter out = resp.getWriter();
                            out.print(new Gson().toJson("Cliente Salvo"));
                            out.flush();

                        } else {

                            timestamp = clientModel.getDataCadastrada();
                            Date datehoje = new Date(timestamp.getTime());
                            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            String timestampString = sdf1.format(datehoje);

                            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            PrintWriter out = resp.getWriter();
                            out.print(new Gson().toJson("Cliente ja possui cadastro: " +
                            timestampString));
                            out.flush();
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    protected void cadastroSucesso(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("cadastroSucesso.jsp");
        rd.forward(req, resp);
    }

    protected void cadastroErro(HttpServletRequest req, HttpServletResponse resp, Timestamp timestamp)
            throws ServletException, IOException {
        req.setAttribute("timestamp", timestamp);
        RequestDispatcher rd = req.getRequestDispatcher("cadastroErro.jsp");
        rd.forward(req, resp);
    }
}
