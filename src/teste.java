
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import org.hibernate.mapping.Index;



public class teste extends JFrame {
	private JPanel jpnCentro;
	private  DateField datefield;
	
public void cria(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,340);
		jpnCentro = new JPanel(new FlowLayout());
		DateField datefield = CalendarFactory.createDateField();
		jpnCentro.add(datefield);
                setVisible(true);
}
	
	public static void main(String[] args) {
		teste tela = new teste();
               tela.cria();
	}
}