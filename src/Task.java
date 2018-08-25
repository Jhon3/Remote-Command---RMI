/*
 ===============================================================================
 ARQUIVO............: CommandShell.java
 DESCRICAO..........: Codigo-fonte correspondente a definicao de uma interface 
 					  remota, que especifica os metodos a serem providos do lado
 					  servidor.
 AUTOR..............: Jhonattan Cabral (jhonattan.yoru@gmail.com);
 AUTOR..............: Igor Nogueira (--);
 MODIFICADO EM......: 23/08/2018
 ===============================================================================
*/

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Task extends Remote{
	
	public String executeCommand(String command) throws RemoteException;
}
