/*
 ===============================================================================
 ARQUIVO............: CommandShell.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao de um servente,
 					  classe que define a implementacao dos metodos especificados
 					  na interface remota.
 AUTOR..............: Jhonattan Cabral (jhonattan.yoru@gmail.com);
 AUTOR..............: Igor Nogueira (--);
 MODIFICADO EM......: 23/08/2018
 ===============================================================================
*/

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CommandShell extends UnicastRemoteObject implements Task, Serializable{
 
 protected CommandShell() throws RemoteException {
		super();
	}

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String executeCommand(String command) throws RemoteException {
 
        final ArrayList<String> commands = new ArrayList<String>();
 
        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(command);
        BufferedReader br = null;
        String commandResult = "";
        try {
 
            final ProcessBuilder p = new ProcessBuilder(commands);
            final Process process = p.start();
            final InputStream is = process.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                commandResult += line + "\n";
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            secureClose(br);
        }
        return commandResult;
    }
 
    private void secureClose(final Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

