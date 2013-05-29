package dynmap_support;


public class DynmapStarter {

	
	
	
	public DynmapStarter(String host, int port,String playername){
		System.out.println("HOST: " +  host + "| Port: " + port + "|Player: " + playername); 
		String pfad = "http://" + host +":" + port + "/?playername=" + playername;
		System.out.println(pfad);
		String os = System.getProperty("os.name");
		try{
			if(os.contains("Windows")){
				System.out.println("Starte Windows");
				Runtime.getRuntime().exec("cmd /c start " + pfad);
			}else{
				System.out.println("Starte Linux/Mac");
				Runtime.getRuntime().exec("firefox " + pfad);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
