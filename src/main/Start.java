package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Start {
	public static boolean ok=false;
	public static String id="";
	public static void main(String args[]){
		new consle();
		consle.out("��������...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e2) {
			//Ignore
		}
		consle.out("���׹����й�! NeteaseMCCrack Beta0.5.3 Made by lyc8503");
		consle.out("----------------------------------------------------");
		consle.out("����:������������װ����MOD");
		consle.out("ע��:��MOD�޷���������,�볢�Խ�MCLDownload/ext/jre-v32-xxxx(��v64-xxxx)�µ�jre7��jre8����");
		consle.out("----------------------------------------------------");
		consle.out("����Hypixel���ҽ���");
		consle.out("A.LiquidBounce����:https://pan.baidu.com/s/1gfTSi23 ��ȡ��:r96s");
		consle.out("B.Nofall Autoblock HypixelHop�ȻᱻWatchDog���");
		consle.out("Ŀǰ�����ÿ���: Killaura Velocity Scaffold �ȶ�����");
		consle.out("C.Have Fun!");
		consle.out("----------------------------------------------------");
		consle.out("��ȡ�����ļ�...");
		File config=new File("NeteaseMCCrack.properties");
		if(!config.exists()){
			try {
				config.createNewFile();
				FileWriter fw=new FileWriter(config);
				fw.write("SBNeteaseMods="+"\r\nRealMods="+"\r\nKillLauncher=true"+"\r\nrandomidprefix=lyc");
				fw.close();
			} catch (IOException e) {
				consle.out(e.toString());
			}
		}
		FileReader fr;
		Properties properties=new Properties();
		try {
			fr = new FileReader(config);
			properties.load(fr);
			fr.close();
		} catch (IOException e1) {
			consle.out(e1.toString());
		}
		String WYmods=properties.getProperty("SBNeteaseMods");
		String realmods=properties.getProperty("RealMods");
		boolean killlauncher=Boolean.parseBoolean(properties.getProperty("KillLauncher"));
		id=properties.getProperty("randomidprefix");
		consle.out("��ȡ�ɹ�!");
		getrandomid.get(id);
		consle.out(WYmods);
		File WYModsfile=new File(WYmods);
		consle.out(realmods);
		File modsfile=new File(realmods);
		
		if(WYModsfile.isDirectory() && modsfile.isDirectory()){
			if(!killlauncher){
				consle.out("----------------------------------------------------");
				consle.out("����:���������ļ��йر���KillLauncher����");
				consle.out("���ڽ�����Ϸ���õ�������������Ӷ�����ֹ�����");
				consle.out("----------------------------------------------------");
			}
			consle.out("����DeleteMe.jar�ȴ���������");
			File deleteme=new File(WYModsfile.getAbsolutePath()+"/deleteme.jar");
			consle.out("Path:"+WYModsfile.getAbsolutePath()+"/deleteme.jar");
			try {
				deleteme.createNewFile();
			} catch (IOException e) {
				consle.out(e.toString());
			}
			while(deleteme.exists()){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					//Ignore
				}
			}
			consle.out("��⵽��������!");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				consle.out(e.toString());
			}
			File Neateasemods[]=WYModsfile.listFiles();
			for(File Neateasemod:Neateasemods){
				consle.out("ɾ��:"+Neateasemod.getName());
				Neateasemod.delete();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				consle.out(e.toString());
			}
			File mods[]=modsfile.listFiles();
			for(File mod:mods){
				try{
					if(mod.getName().contains("jar")){
						consle.out("����:"+mod.getName());
						FileInputStream inputStream=new FileInputStream(mod);
						File targetfile=new File(WYModsfile.getAbsolutePath()+"/"+mod.getName());
						FileOutputStream outputStream=new FileOutputStream(targetfile);
						byte buff[]=new byte[inputStream.available()];
						inputStream.read(buff);
						inputStream.close();
						outputStream.write(buff);
						outputStream.close();
						
					}else{
						consle.out("����jar�ļ�:"+mod.getName());
					}
				}catch (Exception e) {
					consle.out(e.toString());
				}
			}
			if(killlauncher){
				consle.out("����5���Ӻ��Զ��ر�������!");
				consle.out("��Ҳ�����ڽ�����Ϸ���ڱ����ڰ���Enter�����ȴ�");
				ok=true;
				try {
					Thread.sleep(1000*5*60);
				} catch (InterruptedException e) {
					//Ignore
				}
				kill();
			}else{
				consle.out("���!����5����˳�");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					//Ignore
				}
				System.exit(0);
			}
		}else{
			consle.out("Ŀ¼�����ļ���!");
		}
	}
	synchronized public static void kill(){
		consle.out("ǿ�ƽ���WPFLauncher.exe");
		try {
			Process process=Runtime.getRuntime().exec("taskkill /IM WPFLauncher.exe /F");
			BufferedReader input=new BufferedReader(new InputStreamReader(process.getInputStream()));
			Thread.sleep(1000);
			consle.out(input.readLine());
			input.close();
		} catch (IOException e) {
			consle.out(e.toString());
		} catch (InterruptedException e) {
			consle.out(e.toString());
		}
		consle.out("�ɹ�!");
		consle.out("���!����5����˳�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//Ignore
		}
		System.exit(0);
	}
}

class MyListener implements KeyListener{
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10 && Start.ok){
			new Thread(new Runnable() {
				public void run() {
					Start.kill();
				}
			}).start();;
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	
}
