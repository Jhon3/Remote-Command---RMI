/*
 ===============================================================================
 ARQUIVO............: CommandShell.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao do cliente,
 					  fazendo invocao de metodos remotos disponibilizados no
 					  servidor.
 AUTOR..............: Jhonattan Cabral (jhonattan.yoru@gmail.com);
 AUTOR..............: Igor Nogueira (--);
 MODIFICADO EM......: 23/08/2018
 ===============================================================================
*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws RemoteException, 
	NotBoundException, MalformedURLException {
	

	Task stub = (Task) Naming.lookup("rmi://localhost/CommandShell");

	Scanner input = new Scanner(System.in);
	String command = null;
	
	try {
		// Interacao com o usuario, que escolhe a operacao a ser executada
		while (true) {
			System.out.println("\nRemote Command Shell");
			System.out.println("Digite o comando ou 'exit' para sair do programa: ");

			command = input.nextLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			else {
				String result = stub.executeCommand(command);
				System.out.println(result);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	input.close();
}
}
