package until;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner instance;

    private ScannerSingleton() {
    }

    public static void closeInstance(){
        instance.close();
    }

    public static Scanner getInstance(){
        if (instance ==null){
            instance = new Scanner(System.in);
        }
        return instance;
    }

}
