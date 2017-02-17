package co.edu.eam.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import co.edu.eam.dto.RegistrarDTO;

public class ThreadClientConnection implements Runnable {

	private String user;
	
	private Socket con;
	
	ObjectOutputStream salida;
	
	ObjectInputStream entrada;
	
	Server server;
	
		
	public ThreadClientConnection(Socket con) {
		
		super();
		
		this.con = con;
		
	}



	@Override
	public void run() {
		
		System.out.println("Recibe peticion...");
		
		try {
			
			salida = new ObjectOutputStream(con.getOutputStream());
			
			entrada = new ObjectInputStream(con.getInputStream());
			
			while(true){
				
				Object dto = entrada.readObject();
				
				if(dto instanceof RegistrarDTO){
					
					RegistrarDTO re = (RegistrarDTO)dto;
					
					System.out.println("leo objeto");
					System.out.println(re.getUser() + " "+ re.getPassword());
					
					salida.writeObject(dto);
					
				}
				
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
