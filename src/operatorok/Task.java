package operatorok;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Task {

    FileManager fmObj = new FileManager();
    List<Entity> operator = new ArrayList<Entity>();

    public void fileRead(String fileName) {
        operator = fmObj.fileRead(fileName);
    }

    public int dataSize() {
        return operator.size();
    }

    public int containMod() {
        int allMods = 0;
        for (Entity entity : operator) {
            if (entity.getOperatorSignal().equalsIgnoreCase("mod")) {
                allMods++;
            }
        }
        return allMods;
    }

    public void divideBy10() {
        int amount = 0;
        for (Entity entity : operator) {
            if (entity.getFirstOperator() % 10 == 0 && entity.getSecondOperator() % 10 == 0) {
                amount++;
            }
        }
        if (amount > 0) {
            System.out.println("Van ilyen kifejezés!");
        } else {
            System.out.println("Nincs ilyen kifejezés");
        }
    }

    public void statistics() {
        Set<String> statistic = new HashSet<String>();
        for (Entity entity : operator) {
            if (entity.getOperatorSignal().equalsIgnoreCase("mod") ||
                    entity.getOperatorSignal().equalsIgnoreCase("/") ||
                    entity.getOperatorSignal().equalsIgnoreCase("div") ||
                    entity.getOperatorSignal().equalsIgnoreCase("-") ||
                    entity.getOperatorSignal().equalsIgnoreCase("*") ||
                    entity.getOperatorSignal().equalsIgnoreCase("+")) {
                statistic.add(entity.getOperatorSignal());
            }
        }
        int amount = 0;
        System.out.println("Statisztika: ");
        for (String s : statistic) {
            for (Entity entity : operator) {
                if (entity.getOperatorSignal().equalsIgnoreCase(s)) {
                    amount++;
                }
            }
            System.out.println("\t" + s + " -> " + amount + "db");
            amount = 0;
        }
    }

    public String expression(String expression) {
        String returnBack = "";
        String base = "";
        if (expression.equalsIgnoreCase("vége")) {
            return "vége";
        }
        String[] spliter = expression.split(" ");
        base = spliter[0] + " " + spliter[1] + " " + spliter[2] + " = ";
        try {
            int amount = 0;
            for (Entity entity : operator) {
                if (entity.getOperatorSignal().equalsIgnoreCase(spliter[1])) {
                    amount++;
                }
            }
            if (amount <= 0) {
                return base + "Hibás operátor!";
            } else {
                switch (spliter[1]) {
                    case "mod":
                        returnBack = base + "" + (Integer.parseInt(spliter[0]) % Integer.parseInt(spliter[2]));
                        break;
                    case "div":
                        returnBack = base + "" + (Integer.parseInt(spliter[0]) / Integer.parseInt(spliter[2]));
                        break;
                    case "/":
                        returnBack = base + "" + (Double.parseDouble(spliter[0]) / Double.parseDouble(spliter[2]));
                        break;
                    case "-":
                        returnBack = base + "" + (Integer.parseInt(spliter[0]) - Integer.parseInt(spliter[2]));
                        break;
                    case "*":
                        returnBack = base + "" + (Integer.parseInt(spliter[0]) * Integer.parseInt(spliter[2]));
                        break;
                    case "+":
                        returnBack = base + "" + (Integer.parseInt(spliter[0]) + Integer.parseInt(spliter[2]));
                        break;
                }
            }
            return returnBack;
        } catch (Exception e) {
            return base + "Egyéb hiba!";
        }
    }

    public void askExpression(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = "";
        while (!data.equalsIgnoreCase("vége")){
            System.out.print("7.feladat: Kérek egy kifejezést (pl.: 1 + 1): ");
            try {
                data = br.readLine();
                if (expression(data).equalsIgnoreCase("vége")){
                    data = expression(data);
                } else {
                    System.out.print(expression(data)+ "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void result(){
        String data = "";
        try {
            RandomAccessFile ra = new RandomAccessFile("eredmények.txt", "rw");
            for (Entity entity : operator) {
                data = entity.getFirstOperator() + " " + entity.getOperatorSignal() + " " + entity.getSecondOperator();
                ra.writeBytes(expression(data)+ "\n");
            }
            ra.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
