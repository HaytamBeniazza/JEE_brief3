package servlet;

import dao.ClientDAO;
import dao.ClientDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import Util.Tools;
import service.ClientService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addclient", "/clientlist", "/updateclient", "/deleteclient"})
public class ClientServlet extends HttpServlet {
    ClientDAO clientDAO;
    ClientService clientService;

    public void init() {
        clientDAO = new ClientDAOImpl();
        clientService = new ClientService(clientDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        switch (path) {


//            case "edit":
//                showUpdateForm(request, response);
//                break;
            case "/clientlist":
                String search = request.getParameter("search");
                List<Client> searchedClients;
                if (search != null){
                    if (search.isEmpty()){
                        List<Client> clients = clientService.getClients();
                        request.setAttribute("clientlist", clients);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
                    }
                    searchedClients = clientService.searchedClient(search);
                    request.setAttribute("clientlist", searchedClients);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
                }

                    List<Client> clients = clientService.getClients();
                    request.setAttribute("clientlist", clients);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);

                break;
            case "/addclient":
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/Client.jsp").forward(request, response);
                break;
            case "/deleteclient":
                delete(request, response);
                clients = clientService.getClients();
                request.setAttribute("clientlist", clients);
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
                break;
            case "/updateclient":
                try {
                    String code = request.getParameter("id");
                    int intCode = Integer.parseInt(code);
                    Client client = clientService.getClientByCode(intCode);
                    request.setAttribute("client", client);
                }catch (Exception e){
                    e.printStackTrace();
                }
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/UpdateClient.jsp").forward(request, response);
                break;
            default:
//                getClients(request, response);
                break;
        }

    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = new Client();
        client.setFirstName(request.getParameter("firstName"));
        client.setLastName(request.getParameter("lastName"));
        client.setPhone(request.getParameter("phone"));
        client.setAddress(request.getParameter("address"));
        client.setBirthDay(LocalDate.parse(request.getParameter("birthDate")));
        Optional<Client> optionalClient = clientService.addClient(client);
        String message = null;
        if (optionalClient.isPresent()) {
            message = "Client Inserted Successfuly";
        } else {
            message = "Client Not Inserted";
        }
        request.setAttribute("message", message);
        //getClients(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String delete;
        String id = request.getParameter("id");
        int code = Integer.parseInt(id);
        if(clientService.deleteClient(code) != 0){
            delete = "client deleted";
        }else{
            delete = "client not deleted";
        }
        request.setAttribute("delete", delete);
    }

    private void getClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        List<Client> clients = clientService.getClients();
        if(clients != null){
            String msg = "Hello world";
        }
        request.setAttribute("clients", clients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/ClientTable.jsp");
        dispatcher.forward(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        Client client = new Client();
        client.setCode(Integer.parseInt(id));
        client.setFirstName(request.getParameter("firstName"));
        client.setLastName(request.getParameter("lastName"));
        client.setBirthDay(LocalDate.parse(request.getParameter("birthDate")));
        client.setPhone(request.getParameter("phone"));
        client.setAddress(request.getParameter("address"));
        Optional<Client> optionalClient = clientService.updateClient(client);
        String message = null;
        if (optionalClient.isPresent()) {
            message = "Client Inserted Successfuly";
        } else {
            message = "Client Not Inserted";
        }
        request.setAttribute("message", message);
//        response.sendRedirect("/WEB-INF/view/Client.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        String path = request.getRequestURI();
        request.getServletPath();
        String id = request.getParameter("id");
        System.out.println(id);
        switch (path) {
            case "/addclient":
                insertClient(request,response);
                List<Client> clients = clientService.getClients();
                request.setAttribute("clientlist", clients);
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
                break;
            case "/updateclient":
                updateClient(request, response, id);
                clients = clientService.getClients();
                request.setAttribute("clientlist", clients);
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
//                response.sendRedirect("/clientlist");
//                this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
//            case "/clientlist":
//                getClients(request, response);
//                this.getServletContext().getRequestDispatcher("/WEB-INF/view/ClientTable.jsp").forward(request, response);
//                break;
        }
        doGet(request, response);

    }


    // Add other methods (doGet, doPut, doDelete) for retrieving, updating, and deleting clients


}
