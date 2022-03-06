package operatorok;

import java.util.ArrayList;
import java.util.List;

public class Task {

    FileManager fmObj = new FileManager();
    List<Entity> operator = new ArrayList<Entity>();

    public void fileRead(String fileName){
        operator = fmObj.fileRead(fileName);
    }

    public int dataSize(){
        return operator.size();
    }

    public int containMod(){
        int allMods = 0;
        for (Entity entity : operator) {
            if (entity.getOperatorSignal().equalsIgnoreCase("mod")){
                allMods++;
            }
        }
        return allMods;
    }

}
