package operatorok;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    List<Entity> operator = new ArrayList<Entity>();

    public List<Entity> fileRead(String fileName){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            while (br.ready()) {
                String row = br.readLine();
                String[] rowData = row.split(" ");
                Entity entityObj = new Entity(
                        Integer.parseInt(rowData[0]),
                        rowData[1],
                        Integer.parseInt(rowData[2]));
                operator.add(entityObj);
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operator;
    }

}
