package com.hand13.communcate;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by hd110 on 2017/7/23.
 */

public class BackWork extends AsyncTask<String,Void,Void> {
	@Override
	protected Void doInBackground(String... params) {
		if(params.length!=3)
			return null;
		String fName=params[0];
		String tName=params[1];
		String message=params[2];
		Socket socket=new Socket();
		SocketAddress sa=new InetSocketAddress("192.168.1.115",4321);
		try {
			socket.connect(sa);
			if(!socket.isConnected())
				return null;
			String aMessage=new StringBuilder().append("up\r")
					.append(fName+"\r")
					.append(tName+"\r")
					.append(message+"\n\r").toString();
			OutputStream out=socket.getOutputStream();
			out.write(aMessage.getBytes("UTF-8"));
		}
		catch (IOException ioe){
			Log.d(ConActivity.backWork,ioe.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (IOException ioe){

				Log.d(ConActivity.backWork,ioe.getMessage());
			}
		}
		return null;
	}
}

