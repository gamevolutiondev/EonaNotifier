package notifier;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Main frm = null;
	
	public DisplayPanel(Main x){
		frm = x;
		JLabel d = new JLabel();
		d.setText("Warte auf nächste Aktualisierung");
		this.add(d);
	}
	
	
	public void reload(){
		this.removeAll();
		lade();
	}
	
	private void lade(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Spielerliste data = new Spielerliste();
		JLabel d[] = data.getPlayers();
		for(int i = 0; i < d.length; i++){
			this.add(d[i]);
		}
		frm.setSize(200,this.getComponentCount() * 20);
	}
	
	public String toString(){
		return "Display";
	}
	
}

