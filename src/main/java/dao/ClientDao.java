package dao;

import model.ClientModel;

import java.sql.*;

public class ClientDao {

    Connection conn;
    PreparedStatement pstm;

    public void saveClient(ClientModel clientModel) throws Exception {

        String comandoSQL = "insert into \"prv_cliente\"(nome, data_nasc, rg, cpf, celular, email, nome_mae, nome_pai, data_cadastro) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn = new Conexao().getConnection();
        try {

            pstm = conn.prepareStatement(comandoSQL);
            pstm.setString(1, clientModel.getNome());
            pstm.setDate(2, clientModel.getDataNasc());
            pstm.setString(3, clientModel.getRg());
            pstm.setString(4, clientModel.getCpf());
            pstm.setString(5, clientModel.getCelular());
            pstm.setString(6, clientModel.getEmail());
            pstm.setString(7, clientModel.getNomeMae());
            pstm.setString(8, clientModel.getNomePai());
            pstm.setTimestamp(9, clientModel.getDataCadastrada());
            pstm.execute();

        } catch (SQLException e) {
            throw new Exception(e);
        }
        pstm.close();
    }

    public ClientModel getEventById(String rgClient) throws Exception {

        String comandoSQL = "select * from \"prv_cliente\" where rg = ?";

        conn = new Conexao().getConnection();

        try {
            pstm = conn.prepareStatement(comandoSQL);
            pstm.setString(1, rgClient);
            pstm.execute();

            ResultSet resultSet = pstm.getResultSet();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                java.util.Date dataNasc = resultSet.getDate("data_nasc");
                String celular = resultSet.getString("celular");
                String rg = resultSet.getString("rg");
                String cpf = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                String nomeMae = resultSet.getString("nome_mae");
                String nomePai = resultSet.getString("nome_pai");
                Timestamp dataCadastrada = resultSet.getTimestamp("data_cadastro");

                ClientModel clientModel = new ClientModel(id, nome, email, (Date) dataNasc,  rg,  cpf,  celular,  nomeMae,  nomePai, dataCadastrada);

                return clientModel;
            }
            return null;

        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}
