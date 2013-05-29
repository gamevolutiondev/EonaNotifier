package notifier;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DisplayPanel display = null;

	public static void main(String args[]){
		Main x = new Main();
		x.create();
	}
	
	
	
	public void create(){
		this.setSize(new Dimension(200, 100));
		this.setLocation(getOptimalLocation());
		this.setTitle("Eona Notifier");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setOpacity(0.6f);
		display = new DisplayPanel(this);
		this.add(display);
		reloader d = new reloader();
		new Thread(d).start();
		this.addMouseListener(new bewegen());
		this.setVisible(true);
	}
	
	
	private Point getOptimalLocation(){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Point x = new Point(d.width - 200, 50);
		return x;
	}
	
	
	private class ThreadBewegen implements Runnable{

		private boolean stopper = true;
		
		
		@Override
		public void run() {
			System.out.println("gestartet");
			while(stopper){
				setLocation( MouseInfo.getPointerInfo().getLocation());
			}
			System.out.println("beendet");
		}
		
	}
	
	private class bewegen implements MouseListener{
		
		private ThreadBewegen d = null;
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1 && e.getSource() instanceof JFrame){
				d = new ThreadBewegen();
				new Thread(d).start();
			}else{
				e.consume();
			}
		}
		

		@Override
		public void mouseReleased(MouseEvent e) {
			d.stopper = false;
		}
		
	}
	
	
	
	public void lade(){
		display.reload();
		
	}
	
	private class reloader implements Runnable{

		@Override
		public void run() {
			while(true){
				try{
					lade();
					Thread.sleep(60000);
				}catch(Exception e){
					
				}
			}
		}
		
	}
	
}
