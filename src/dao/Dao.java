package dao;

import conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import vo.Controlador;
import vo.Usuario;

public class Dao {

    public boolean salvaUsuario(Usuario user) {
        String query = ("INSERT INTO usuario(Bairro,apelido,complemento,cpf_cnpj,data_cadastro,email,endereco,nm_usuario,senha,telefone,nm_cidade) VALUES"
                + "('" + user.getBairro() + "','" + user.getApelido() + "','" + user.getComplemento() + "','" + user.getCpf_cnpj() + "','" + user.getData_cadastro()
                + "','" + user.getEmail() + "','" + user.getEndereco() + "','" + user.getNome() + "','" + user.getSenha() + "','" + user.getTelefone() + "','" + user.getCidade() + "')");
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query)) {

                if (st.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO SALVAR USUARIO " + e.getMessage());
        }
        return false;
    }
    
    public boolean atualisaUsuario(Usuario user) {
        String query = ("UPDATE usuario SET Bairro='"+user.getBairro()+"', apelido='"+user.getApelido()+"', complemento='"+user.getComplemento()+"', cpf_cnpj='"+user.getCpf_cnpj()
                +"', email='"+user.getEmail()+"',endereco='"+user.getEndereco()+"', nm_usuario='"+user.getNome()+"', senha='"+user.getSenha()
                +"',telefone='"+user.getTelefone()+"',nm_cidade='"+user.getCidade()+"' WHERE cd_usuario ="+user.getId());
                
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query)) {

                if (st.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR USUARIO " + e.getMessage());
        }
        return false;
    }
    
    public boolean removeUsuario(Usuario user) {
        String query = ("DELETE FROM usuario WHERE cd_usuario ="+user.getId());
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query)) {

                if (st.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR USUARIO " + e.getMessage());
        }
        return false;
    }

    public Usuario buscaUsuario(Integer id) {
        String query = ("SELECT * FROM usuario WHERE cd_usuario= " + id);
        System.out.println(query);
        Usuario user = new Usuario();
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    user.setApelido(rs.getString("apelido"));
                    user.setId(rs.getInt("cd_usuario"));
                    user.setBairro(rs.getString("Bairro"));
                    user.setComplemento(rs.getString("complemento"));
                    user.setCpf_cnpj(rs.getString("cpf_cnpj"));
                    user.setEmail(rs.getString("email"));
                    user.setEndereco(rs.getString("endereco"));
                    user.setNome(rs.getString("nm_usuario"));
                    user.setSenha(rs.getString("senha"));
                    user.setTelefone(rs.getString("telefone"));
                    user.setCidade(rs.getString("nm_cidade"));
                    user.setData_cadastro(rs.getString("data_cadastro"));
                    // falto controlador
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO BUSCA USUARIO " + e.getMessage());
        }
        return user;
    }

    public Usuario buscaUsuario(String email_cpf) {
        String query = ("SELECT * FROM usuario WHERE email like '%" + email_cpf + "%' OR cpf_cnpj like '%" + email_cpf + "%'");
        System.out.println(query);
        Usuario user = new Usuario();
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    user.setApelido(rs.getString("apelido"));
                    user.setId(rs.getInt("cd_usuario"));
                    user.setBairro(rs.getString("Bairro"));
                    user.setComplemento(rs.getString("complemento"));
                    user.setCpf_cnpj(rs.getString("cpf_cnpj"));
                    user.setEmail(rs.getString("email"));
                    user.setEndereco(rs.getString("endereco"));
                    user.setNome(rs.getString("nm_usuario"));
                    user.setSenha(rs.getString("senha"));
                    user.setTelefone(rs.getString("telefone"));
                    user.setCidade(rs.getString("nm_cidade"));
                    user.setData_cadastro(rs.getString("data_cadastro"));
                    // falto controlador
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO BUSCA USUARIO " + e.getMessage());
        }
        return user;
    }

    public List<Usuario> buscaUsuario() {
        String query = ("SELECT * FROM usuario");
        System.out.println(query);
        Usuario user = new Usuario();
        List lista = new ArrayList();
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    user.setId(rs.getInt("cd_usuario"));
                    user.setBairro(rs.getString("Bairro"));
                    user.setComplemento(rs.getString("complemento"));
                    user.setCpf_cnpj(rs.getString("cpf_cnpj"));
                    user.setEmail(rs.getString("email"));
                    user.setEndereco(rs.getString("endereco"));
                    user.setNome(rs.getString("nm_usuario"));
                    user.setSenha(rs.getString("senha"));
                    user.setTelefone(rs.getString("telefone"));
                    user.setCidade(rs.getString("nm_cidade"));
                    user.setData_cadastro(rs.getString("data_cadastro"));
                    // falto controlador

                    lista.add(user);
                }
                return lista;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO BUSCAR TODOS USUARIOS " + e.getMessage());
        }
        return null;
    }

    public Integer validaLogin(String email, String senha) {
        String query = ("SELECT cd_usuario FROM usuario u WHERE u.email= '" + email + "' AND u.senha= '" + senha + "'");
        Integer id = null;
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("cd_usuario");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO VALIDA LOGIN " + e.getMessage());
        }
        return id;
    }

    public boolean validaConstrolador(Controlador controlador) {
        Integer ns_controlador = controlador.getNumero_serie();
        Integer senha_controlador = controlador.getSenha_serie();
        String query = ("SELECT * from NS" + ns_controlador + " WHERE numero_serie =" + ns_controlador + " AND senha_serie =" + senha_controlador + " AND id=1");
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean relacionaConstrolador(Controlador controlador, Usuario user) {
        Integer ns_controlador = controlador.getNumero_serie();
        Integer cd_usuario = user.getId();
        String query = ("INSERT INTO usuario_controlador VALUES (" + controlador.getNumero_serie() + "," + user.getId() + ") ");
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { //codigo do erro de duplicar chave Primaria MYSQL
                JOptionPane.showMessageDialog(null, "Controlador já está Cadastrado para este Usuario \n\n >> " + e.getMessage());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO RELACIONAR CONTROLADOR COM USUARIO \n\n >> " + ex.getMessage());
        }
        return false;
    }

    public boolean removeConstrolador(Controlador controlador, Usuario user) {
        Integer ns_controlador = controlador.getNumero_serie();
        Integer cd_usuario = user.getId();
        String query = ("DELETE FROM usuario_controlador WHERE cd_usuario =" + user.getId() + " AND cd_controlador =" + controlador.getNumero_serie());
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO EXCLUIR CONTROLADOR \n\n >> " + e.getMessage());
            return false;
        }
    }

    public List<Controlador> buscaNSRelacionados(Integer cd_usuario) {
        String query = ("SELECT c.cd_controlador FROM usuario u , usuario_controlador c  WHERE u.cd_usuario = c.cd_usuario AND u.cd_usuario = " + cd_usuario);
        System.out.println(query);
        List lista = null;
        Controlador cnt = new Controlador();
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                lista = new ArrayList();
                while (rs.next()) {
                    cnt = new Controlador();
                    cnt.setNumero_serie(rs.getInt("cd_controlador"));
                    lista.add(cnt);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO BUSCA NS RELACIOANDOS " + e.getMessage());
        }
        return lista;
    }

    public List<Controlador> dadosConstrolador(Integer ns) {
        String query = ("SELECT * FROM NS" + ns + " ORDER BY id DESC LIMIT 100");
        Controlador controlador = null;
        List<Controlador> lista = new ArrayList<>();
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    controlador = new Controlador();
                    controlador.setUmid_ajst(rs.getInt("umid_ajst"));
                    controlador.setTemp_ajst(rs.getInt("temp_ajst"));
                    controlador.setTemp(rs.getInt("temp"));
                    controlador.setUmid(rs.getInt("umid"));
                    controlador.setSenha_serie(rs.getInt("senha_serie"));
                    controlador.setNumero_serie(rs.getInt("numero_serie"));
                    controlador.setNumero_lote(rs.getInt("numero_lote"));
                    controlador.setNum_falha(rs.getInt("num_falha"));
                    controlador.setVentoinha(rs.getInt("ventoinha") == 1 ? "Ligado" : "Desligado");
                    controlador.setAlarme(rs.getInt("alarme") == 1 ? "Ligado" : "Desligado");
                    controlador.setData(rs.getDate("data"));
                    controlador.setTime(rs.getTime("time"));
                    lista.add(controlador);
                }
                return lista;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO ATUALISA DADOS CONTROLADOR \n >> " + e.getMessage());
        }
        return null;
    }

    public List<Controlador> dadosConstrolador(Integer ns, String data_inicio, String data_fim) {
        String query = ("SELECT * FROM NS" + ns + " WHERE date('" + data_fim + "') >= data AND date('" + data_inicio + "') <= data ORDER BY id DESC LIMIT 100");
        System.out.println(query);
        Controlador controlador = null;
        List<Controlador> lista = new ArrayList<>();
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    controlador = new Controlador();
                    controlador.setUmid_ajst(rs.getInt("umid_ajst"));
                    controlador.setTemp_ajst(rs.getInt("temp_ajst"));
                    controlador.setTemp(rs.getInt("temp"));
                    controlador.setUmid(rs.getInt("umid"));
                    controlador.setSenha_serie(rs.getInt("senha_serie"));
                    controlador.setNumero_serie(rs.getInt("numero_serie"));
                    controlador.setNumero_lote(rs.getInt("numero_lote"));
                    controlador.setNum_falha(rs.getInt("num_falha"));
                    controlador.setVentoinha(rs.getInt("ventoinha") == 1 ? "Ligado" : "Desligado");
                    controlador.setAlarme(rs.getInt("alarme") == 1 ? "Ligado" : "Desligado");
                    controlador.setData(rs.getDate("data"));
                    controlador.setTime(rs.getTime("time"));
                    lista.add(controlador);
                }
                return lista;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO ATUALISA DADOS CONTROLADOR FILTRANDO DATA \n >> " + e.getMessage());
        }
        return null;
    }

    public Controlador dadosConstroladorTempoReal(Integer ns) {
        String query = ("SELECT * FROM NS" + ns + " WHERE id = 1");
        Controlador controlador = null;
        System.out.println(query);
        try (Connection con = ModuloConexao.conector()) {
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    controlador = new Controlador();
                    controlador.setUmid_ajst(rs.getInt("umid_ajst"));
                    controlador.setTemp_ajst(rs.getInt("temp_ajst"));
                    controlador.setTemp(rs.getInt("temp"));
                    controlador.setUmid(rs.getInt("umid"));
                    controlador.setSenha_serie(rs.getInt("senha_serie"));
                    controlador.setNumero_serie(rs.getInt("numero_serie"));
                    controlador.setNumero_lote(rs.getInt("numero_lote"));
                    controlador.setNum_falha(rs.getInt("num_falha"));
                    controlador.setVentoinha(rs.getInt("ventoinha") == 1 ? "Ligado" : "Desligado");
                    controlador.setAlarme(rs.getInt("alarme") == 1 ? "Ligado" : "Desligado");
                    controlador.setData(rs.getDate("data"));
                    controlador.setTime(rs.getTime("time"));

                }
                return controlador;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO ATUALISA DADOS CONTROLADOR TEMPO REAL >> " + e.getMessage());
        }
        return null;
    }

}
