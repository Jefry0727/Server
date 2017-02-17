import co.edu.eam.server.Server;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server = new Server();
		new Thread(server).start();

	}

}
