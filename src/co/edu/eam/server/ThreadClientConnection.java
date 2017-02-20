package co.edu.eam.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

import co.edu.eam.controller.LoginController;
import co.edu.eam.dao.UsersDAO;
import co.edu.eam.dto.LoginDTO;
import co.edu.eam.dto.RegistrarDTO;

public class ThreadClientConnection implements Runnable {

	private String user;
	
	private Socket con;
	
	private ObjectOutputStream salida;
	
	private ObjectInputStream entrada;
	
	private Server server;
	
	Boolean login;
	
	LoginController lg = new LoginController();
	
		
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
			
			System.out.println("conexion establecida:" + con.getInetAddress().getCanonicalHostName());
			
			Object dto = entrada.readObject();
			
			if(dto instanceof RegistrarDTO){
				
				boolean msj = true;
				
				RegistrarDTO resgisDTO = (RegistrarDTO)dto;
				
				resgisDTO.setIp( con.getInetAddress().getCanonicalHostName());
				
				boolean res = lg.addUser(resgisDTO);
				
				if(res){
					
					msj = true;// "Se ha registrado Correctamente";
					
				}else{
					
					msj = false;// "El usuario no se puede registrar";
					
				}
				
				enviarMensaje(msj);
				
			}
			
			if(dto instanceof LoginDTO){
				
				LoginDTO loginDTO = (LoginDTO) dto;
				
				System.out.println("leo objeto");
				
				System.out.println(loginDTO.getUser() + " "+ loginDTO.getPassword());
				
				loginDTO.setIp( con.getInetAddress().getCanonicalHostName());
				
				login =  lg.findUser(loginDTO);
				
				enviarMensaje(login);
				
				
			}
			
			
				
//			while(true){
//				
//			
//					
//					
//					
//				}
				
				
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void enviarMensaje(Object obj){
		
		try {
			
			salida.writeObject(obj);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
