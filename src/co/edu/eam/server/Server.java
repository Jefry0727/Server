package co.edu.eam.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server implements Runnable {

	private Executor pool;
	
	@Override
	public void run() {

		try{
			
			pool = Executors.newFixedThreadPool(100);
			
			ServerSocket server = new ServerSocket(45000);
			
			while(true){
				
				
					
				
				
			System.out.println("Esperando peticion....");
				
			 Socket connection = server.accept();
			 
			 System.out.println("conexion establecida:" + server.getInetAddress().getCanonicalHostName());
			
			 ThreadClientConnection client = new ThreadClientConnection(connection);
			 
			 pool.execute(client);
			
			
			}
			
		}catch(IOException ex){
			
			ex.printStackTrace();
			
		}
		
	}

}
