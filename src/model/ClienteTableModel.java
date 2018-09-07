package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.codehaus.groovy.syntax.Reduction;
import vo.Controlador;



public class ClienteTableModel extends AbstractTableModel{

       private List<Controlador> controlador = null;
       String[] colunas = {"Data","Hora","Temperatura","Temperatura Ajuste","Umidade","Umidade Ajuste","Status Alarme","Status Ventoinha"};
       
       
       public ClienteTableModel(List<Controlador> controladores){
           this.controlador = controladores;
       }
    
    @Override
    public int getRowCount() {
        return controlador.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }
    
    
    

    @Override
    public Object getValueAt(int rowindex, int collumnindex) {
        Controlador control = controlador.get(rowindex);
        switch(collumnindex){
            case 0: 
               return control.getData();
            case 1:
                return control.getTime().toString();
            case 2:
                return control.getTemp();
            case 3:
                return control.getTemp_ajst();
            case 4: 
                return control.getUmid();
            case 5: 
                return control.getUmid_ajst();
            case 6:
                return control.getAlarme();
            case 7: 
                return control.getVentoinha();
        }
        return null;
    }

    
    
}
