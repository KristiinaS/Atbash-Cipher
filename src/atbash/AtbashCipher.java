package atbash;


import java.util.*;


/**
 * Created by Kristiina on 26.10.2015.
 */
public class AtbashCipher {
    public static void main(String[] args) {

        //Tähestiku sisestamine
        //Scanner ABC = new Scanner(System.in);
        //System.out.println("Sisesta tähestik");
        //String input = ABC.nextLine();

        //Tähestikust tühikute eemaldamine, teksti muutmine väikesteks tähtedeks

        String input = "A B C D E F G H I J K L M N O P Q R S Š Z Ž T U V W Õ Ä Ö Ü X Y";
        String ABCnew = input.trim().replaceAll("\\s", "").toLowerCase();
        System.out.println("Tähestik on: " + ABCnew);


        //Tähestik listiks
        List<String> abclist = new ArrayList<String>(Arrays.asList(ABCnew.split("")));
        //System.out.println("Tähestiku list: " + abclist);

        //Tähestiku listi pikkus
        int LettersInABC = abclist.size();
        //System.out.println("Tähestiku pikkus: " + LettersInABC);




        //Sõna sisestamine, mida tahetakse šifreerida
        Scanner CipherWord = new Scanner(System.in);
        System.out.println("Sisesta šifreeritav sõna");
        String input2 = CipherWord.nextLine();

        //Sõna väikeste tähtedega
        input2 = input2.toLowerCase();
        //String input2 = "ac";
        System.out.println("Sisestatud sõna on: " + input2);

        //Sõna pikkus
        int WordLength = input2.length();
        //System.out.println("Sisestatud sõna pikkus on " + WordLength);


        //Sõna listiks
        List<String> CipherWordList = new ArrayList<String>(Arrays.asList(input2.split("")));
        //System.out.println("Sõna list:" + CipherWordList);

        //Sõna listi pikkus
        int LettersInWord = CipherWordList.size();
        //System.out.println("Tähti sõna listis: " + LettersInWord);

        //Väljundi (dešifreeritud sõna) list
        List<String> CipherOutputList = new ArrayList<String>();


        //Tähtede ümbervahetamine
        for (int i=0; i<LettersInWord;i++){
            //System.out.println(i);

            //Indeksi leidmine tähestikust sõna vastavale tähele
            int ABCIndex = abclist.indexOf(CipherWordList.get(i));
            //System.out.println(CipherWordList.get(i));
            //System.out.println("Originaal: " + ABCIndex);

            //Tähele vastav atbashi indeks
            int ABCIndex2 = (LettersInABC - 1) - ABCIndex;
            //System.out.println("Atbash: " + ABCIndex2);

            //Atbashi tähtede lisamine väljundi listi
            CipherOutputList.add(i, abclist.get(ABCIndex2));
        }

            //System.out.println("Väljund: " + CipherOutputList);

            //Listi tegemine sõnaks
            String CipherOutput = String.join("",CipherOutputList);
            System.out.println("Šifreeritud tekst on: " + CipherOutput);

    }
}

