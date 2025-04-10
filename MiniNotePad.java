package apps.NotePadCustom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IO;
import java.io.IOException;
import java.util.Scanner;

public class MiniNotePad {
    public static void writeNote(String fName){
        Scanner sc=new Scanner(System.in);
        fName+=".txt";
        try{
            File ff=new File(fName);
            if(ff.exists()){System.out.println("Ooops note already exits..Do you want to add to it?(y/n)");
            if(sc.nextLine().equalsIgnoreCase("n"))
            {
                System.out.println("Give another name");
            writeNote(sc.nextLine());
            return;
            }
        }

        FileWriter fw=new FileWriter(fName,true);
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
    public static void viewNote(String fName){
        fName+=".txt";
        try{
        FileReader fr=new FileReader(fName);    
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
    public static void clearNote(String s){
        try{
            s+=".txt";
        FileWriter fw =new FileWriter(s);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.close();
        fw.close();
        }
        catch(IOException e){
            System.out.println("cant open file desired");
        }
        System.out.println("File deleted successfully");
    }
    public static void backupNote(String fName){
        fName+=".txt";
        try{
        FileReader fr=new FileReader(fName);
        BufferedReader br =new BufferedReader(fr);
        fName="copy"+fName;
        FileWriter fw=new FileWriter(fName);
        BufferedWriter bw=new BufferedWriter(fw);
        String t;
        while((t=br.readLine())!=null){
            bw.write(t);bw.flush();bw.newLine();
        }
        bw.close();
        br.close();
    }catch(IOException e){
        System.out.println("error occured copying");
    }
    finally{
        System.out.println("copied files into "+fName);}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice\n1. Write Notes\r\n" + //
                        "2. View Notes\r\n" + //
                        "3. Clear Notes\r\n" + //
                        "4. Backup Notes\r\n" + //
                        "5. Exit");
        int function=sc.nextInt();sc.nextLine();
        switch (function) {
            case 1:
            System.out.println("Enter name of notes");
            writeNote(sc.nextLine());
            break;
            case 2:
            System.out.println("Enter notes you want to view");
            viewNote(sc.nextLine());
            break;
            case 3:
            System.out.println("Enter notes to be cleared");
            clearNote(sc.nextLine());break;
            case 4:
            System.out.println("Enter notes to be copied");
            backupNote(sc.nextLine());break;
            default:
                break;
        }
        
    }
}
