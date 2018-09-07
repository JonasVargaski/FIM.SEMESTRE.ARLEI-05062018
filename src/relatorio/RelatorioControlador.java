package relatorio;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import vo.Usuario;

public final class RelatorioControlador {

    List listadados = new ArrayList();
    Usuario user = new Usuario();

    public RelatorioControlador(List list, Usuario usuario) {
        this.listadados = list;
        this.user = usuario;
        geraRelatorioCidade(listadados, user);
    }

    public void geraRelatorioCidade(List lista, Usuario user) {
        Map param = new HashMap<>();

        param.put("NM_USUARIO", user.getNome());
        param.put("CPF_USUARIO", user.getCpf_cnpj());
        param.put("TELEFONE_USUARIO", user.getTelefone());

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);

        InputStream stream = getClass().getResourceAsStream("relatorio-controlador.jasper");

        JasperPrint print;

        try {
            print = JasperFillManager.fillReport(stream, param, ds);
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, lista.get(0));
        }

    }
}
