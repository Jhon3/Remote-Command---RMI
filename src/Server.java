/*
 ===============================================================================
 ARQUIVO............: CommandShell.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao do servidor,
 					  fazendo uso do servente que implementa a interface remota.
 AUTOR..............: Jhonattan Cabral (jhonattan.yoru@gmail.com);
 AUTOR..............: Igor Nogueira (--);
 MODIFICADO EM......: 23/08/2018
 ===============================================================================
*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Execução do modulo de referencia remota (RMI Registry)
		LocateRegistry.createRegistry(1099);
		
		// Instanciacao do servente
		CommandShell commandShell = new CommandShell();
		
		// Registro do servente no modulo de referencia remota (RMI Registry)
		Naming.rebind("rmi://localhost/CommandShell", commandShell);
		System.out.println("Servidor pronto e registrado no RMI Registry.");
	}
}
