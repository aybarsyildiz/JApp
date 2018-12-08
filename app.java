import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;


class App{
    public static void dosyalama(String isim, String sifre){
        try{
            FileWriter fw = new FileWriter(isim+".txt");
            PrintWriter pw = new PrintWriter(fw);
            

            pw.println(sifre);
            pw.close();
        }
        catch(IOException e){
            out.println("Error!");
        }

    }

    public static void kayit(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nKayit olmak icin isminizi girin: ");
        String name = scan.nextLine();
        
        while(true){
            System.out.println("\nSifrenizi giriniz: ");
            String password = scan.nextLine();
            

            System.out.println("\nSifrenizi onaylayin: ");
            String passwordK = scan.nextLine();  
            

            if (password.equals(passwordK)){
                dosyalama(name,password);
                break;
            }
            else{
                System.out.println("\nLutfen sifrenizi kontrol edin. ");
                continue;
            }
        
        }
        
        System.out.println("Basari ile kayit oldunuz!");
        
     scan.close();   
    }


    public static void giris(String isim, String sifre){

        try{
    
            FileReader fr = new FileReader(isim+".txt");
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            if(sifre.equals(str)){
                System.out.println("Giris basarili!");
            }
            else{
                System.out.println("Lutfen sifrenizi kontrol edin.");
                String[] call = null;
                main(call);
            }
        
        
        
        }
        catch(IOException e){
            out.println("Kullanici bulunamadi.");
        }


    br.close();
    }



    public static void main(String[] argh){
        Scanner scan = new Scanner(System.in);

        System.out.println("Kayit olmak icin - 1 / Giris yapmak icin -2, tuslayiniz: " );
        int cevap = scan.nextInt();

        switch (cevap) {
            case 1:
                kayit();
                

            case 2:
                scan.nextLine();
                System.out.println("\nGiris yapmak icin isminizi girin: ");
                String name = scan.nextLine();
                System.out.println("\nSifrenizi girin: ");
                String password = scan.nextLine();
                giris(name,password);
                break;
        
            default:
                break;
        }
        
        
    
    scan.close();
    }


}