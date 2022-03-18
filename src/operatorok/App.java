package operatorok;

public class App {
    public static void main(String[] args) {

        Task taskObj = new Task();

        taskObj.fileRead("kifejezesek.txt");

        // 2. feladat
        System.out.println(taskObj.dataSize());
        System.out.println();

        // 3. feladat
        System.out.println(taskObj.containMod());
        System.out.println();

        // 4. feladat
        taskObj.divideBy10();

        // 5. feladat
        taskObj.statistics();

        // 6. feladat
        taskObj.askExpression();

        // 8. feladat
        taskObj.result();



    }
}
