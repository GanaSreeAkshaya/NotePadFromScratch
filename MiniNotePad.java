package apps.NotePadCustom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IO;
import java.io.IOException;
import java.util.Scanner;

public abstract class MiniNotePad {
    public static void writeNote(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String fName=sc.nextLine();
        fName+=".txt";
        try{
        FileWriter fw=new FileWriter(fName);
        BufferedWriter bw=new BufferedWriter(fw);
        System.err.println("Please start your notes");
        String sinput;
        while(!(sinput=sc.nextLine()).equalsIgnoreCase("exit")){
            bw.write(sinput);bw.newLine();
        }
        bw.flush();
        bw.close();
    }catch(IOException e){
        System.out.println("error");
        e.printStackTrace();
    }
        System.out.println("End of Notes");
    }
    public static void viewNote(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter name of the file");
        try{
        FileReader fr=new FileReader(sc.nextLine());    
        BufferedReader br=new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        fr.close();
    }catch(IOException e){
        System.out.println("error occured reading file");
    }
    }
    public abstract  void clearNote();
    public abstract  void backupNote();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice\n1. Write Notes\r\n" + //
                        "2. View Notes\r\n" + //
                        "3. Clear Notes\r\n" + //
                        "4. Backup Notes\r\n" + //
                        "5. Exit");
        //int function=sc.nextInt();
        switch (sc.nextInt()) {
            case 1:
                writeNote();
                break;
            case 2:
            viewNote();
            break;
            case 3:
            //clearNote();break;
            case 4:
            //backupNote();break;
            default:
                break;
        }
        
    }
}
