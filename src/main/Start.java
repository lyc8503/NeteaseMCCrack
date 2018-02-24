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
		consle.out("正在启动...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e2) {
			//Ignore
		}
		consle.out("网易滚出中国! NeteaseMCCrack Beta0.5.3 Made by lyc8503");
		consle.out("----------------------------------------------------");
		consle.out("功能:可以在网易中装任意MOD");
		consle.out("注意:若MOD无法正常加载,请尝试将MCLDownload/ext/jre-v32-xxxx(或v64-xxxx)下的jre7与jre8互换");
		consle.out("----------------------------------------------------");
		consle.out("网易Hypixel开挂建议");
		consle.out("A.LiquidBounce配置:https://pan.baidu.com/s/1gfTSi23 提取码:r96s");
		consle.out("B.Nofall Autoblock HypixelHop等会被WatchDog封号");
		consle.out("目前该配置可用: Killaura Velocity Scaffold 稳定不封");
		consle.out("C.Have Fun!");
		consle.out("----------------------------------------------------");
		consle.out("读取配置文件...");
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
		consle.out("读取成功!");
		getrandomid.get(id);
		consle.out(WYmods);
		File WYModsfile=new File(WYmods);
		consle.out(realmods);
		File modsfile=new File(realmods);
		
		if(WYModsfile.isDirectory() && modsfile.isDirectory()){
			if(!killlauncher){
				consle.out("----------------------------------------------------");
				consle.out("警告:你在配置文件中关闭了KillLauncher功能");
				consle.out("请在进入游戏后用第三方软件给盒子断网防止封盒子");
				consle.out("----------------------------------------------------");
			}
			consle.out("生成DeleteMe.jar等待网易启动");
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
			consle.out("检测到网易启动!");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				consle.out(e.toString());
			}
			File Neateasemods[]=WYModsfile.listFiles();
			for(File Neateasemod:Neateasemods){
				consle.out("删除:"+Neateasemod.getName());
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
						consle.out("复制:"+mod.getName());
						FileInputStream inputStream=new FileInputStream(mod);
						File targetfile=new File(WYModsfile.getAbsolutePath()+"/"+mod.getName());
						FileOutputStream outputStream=new FileOutputStream(targetfile);
						byte buff[]=new byte[inputStream.available()];
						inputStream.read(buff);
						inputStream.close();
						outputStream.write(buff);
						outputStream.close();
						
					}else{
						consle.out("不是jar文件:"+mod.getName());
					}
				}catch (Exception e) {
					consle.out(e.toString());
				}
			}
			if(killlauncher){
				consle.out("将在5分钟后自动关闭启动器!");
				consle.out("你也可以在进入游戏后在本窗口按下Enter跳过等待");
				ok=true;
				try {
					Thread.sleep(1000*5*60);
				} catch (InterruptedException e) {
					//Ignore
				}
				kill();
			}else{
				consle.out("完成!将在5秒后退出");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					//Ignore
				}
				System.exit(0);
			}
		}else{
			consle.out("目录不是文件夹!");
		}
	}
	synchronized public static void kill(){
		consle.out("强制结束WPFLauncher.exe");
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
		consle.out("成功!");
		consle.out("完成!将在5秒后退出");
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
