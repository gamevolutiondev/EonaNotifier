package notifier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JLabel;

import dynmap_support.DynmapStarter;

public class Spielerliste {

	
	private ArrayList<String> data = new ArrayList<String>();
	
	
	public Spielerliste(){
		URL url = null;
		URLConnection urlConnection = null;
		
		try {
			url = new URL("http://eona.gamevolution.de/extern/server/spielerliste.php");
			urlConnection = url.openConnection();
			urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");

			InputStream input = null;
			input = urlConnection.getInputStream();
		
			BufferedReader reader = null;
	        reader = new BufferedReader(new InputStreamReader(input));
		
			String s = reader.readLine();
			while(s != null){
				data.add(s);
				s = reader.readLine();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public JLabel[] getPlayers(){
		JLabel ret[] = new JLabel[getAnzahl()];
		int d = 2;
		for(int i = 0; i < ret.length;i++){
			JLabel x = new JLabel();
			String name = getName(data.get(d));
			x.setText(name);
			x.setName(name);
			x.addMouseListener(new wenngedrueckt(name));
			d++;
			
			ret[i] = x;
		}
		return ret;
	}
	
	private int getAnzahl(){
		int x = 0;
		for(int i = 2; i < data.size(); i++){
			x++;
		}
		return x;
	}
	
	
	private String getName(String d){
		try{
			int pos = d.indexOf("</span>");
			String a = d.substring(pos + 8);
			pos = a.indexOf("</a>");
			char as[] = a.toCharArray();
			String erg = "";
			for(int i = 0; i < pos;i++){
				erg += as[i];
			}
			return erg;
		}catch (Exception e) {
			return "";
		}
		
	}
	
	private class wenngedrueckt implements MouseListener{
		String name = "";
		
		public wenngedrueckt(String name){
			this.name = name;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			DynmapStarter d = new DynmapStarter("eona.gamevolution.de", 8123,name);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
}
