package main;

import java.util.Random;

public class getrandomid {
	public static void get(String id){
		if(id==null){
			consle.out("用户名前缀不得为空!随机ID生成失败");
			return;
		}
		if(id.length()>=7){
			consle.out("用户名前缀过长!随机ID生成失败");
			return;
		}
		if(id.equals("")){
			consle.out("用户名前缀不得为空!随机ID生成失败");
			return;
		}
		consle.out("----------------------------------------------------");
		consle.out("你的随机ID:");
		for(int i=1;i<=5;i++){
			String finalid=id+"_";
			while(finalid.length()<12){
				finalid=finalid+randomchar();
			}
			consle.out(finalid);
		}
		consle.out("----------------------------------------------------");
	}
	public static char randomchar(){
		Random random=new Random();
		int i=random.nextInt(61);
		if((i+1)<=10){
			return (String.valueOf(i).toCharArray()[0]);
		}
		switch(i+1){
		case 11:
			return 'a';
		case 12:
			return 'b';
		case 13:
			return 'c';
		case 14:
			return 'd';
		case 15:
			return 'e';
		case 16:
			return 'f';
		case 17:
			return 'g';
		case 18:
			return 'h';
		case 19:
			return 'i';
		case 20:
			return 'j';
		case 21:
			return 'k';
		case 22:
			return 'l';
		case 23:
			return 'm';
		case 24:
			return 'n';
		case 25:
			return 'o';
		case 26:
			return 'p';
		case 27:
			return 'q';
		case 28:
			return 'r';
		case 29:
			return 's';
		case 30:
			return 't';
		case 31:
			return 'u';
		case 32:
			return 'v';
		case 33:
			return 'w';
		case 34:
			return 'x';
		case 35:
			return 'y';
		case 36:
			return 'z';
		case 37:
			return 'A';
		case 38:
			return 'B';
		case 39:
			return 'C';
		case 40:
			return 'D';
		case 41:
			return 'E';
		case 42:
			return 'F';
		case 43:
			return 'G';
		case 44:
			return 'H';
		case 45:
			return 'I';
		case 46:
			return 'J';
		case 47:
			return 'K';
		case 48:
			return 'L';
		case 49:
			return 'M';
		case 50:
			return 'N';
		case 51:
			return 'O';
		case 52:
			return 'P';
		case 53:
			return 'Q';
		case 54:
			return 'R';
		case 55:
			return 'S';
		case 56:
			return 'T';
		case 57:
			return 'U';
		case 58:
			return 'V';
		case 59:
			return 'W';
		case 60:
			return 'X';
		case 61:
			return 'Y';
		case 62:
			return 'Z';
		}
		return 0;
	}
}
