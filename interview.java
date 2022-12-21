import java.util.ArrayList;
import java.util.List;

public class interview {

    public static void print(String s){
        System.out.println(s);
    }

    public static List<String> sortBoxes(List<String> boxList) {
        // Write your code here
            List<String> oldCodes=new ArrayList<>();
            List<String> newCodes=new ArrayList<>();
            
            for(String s:boxList){
                if(s.split(" ")[1].charAt(0)<58){
                    oldCodes.add(switchHeader(s));
                }else{
                    newCodes.add(switchHeader(s));
                }
            }
            dumbInsertionSort(oldCodes);
            dumbInsertionSort(newCodes);

            boxList=new ArrayList<>();
            for(String s:oldCodes){
                boxList.add(reverseHeader(s));
            }
            for(String s:newCodes){
                boxList.add(reverseHeader(s));
            }

            return boxList;
    }

    public static String switchHeader(String s) {
        String[] list = s.split(" ");
        String ns="";
        for(int i=1;i<list.length;i++){
            ns += list[i]+" ";
        }
        ns+=list[0];
        return ns;
    }

    public static String reverseHeader(String s) {
        String[] list = s.split(" ");
        String ns=list[0]+" ";
        for(int i=1;i<list.length;i++){
            ns += list[i]+" ";
        }
        return ns.trim();
    }


    public static List<String> dumbInsertionSort(List<String> list){
        for(int i=0; i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))<0){

                }else{
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static boolean isSmallerString(String a,String b){
        if(a.compareTo(b)<0)return true;
        return false;
    }
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("d");
        list.add("c");
        list.add("a");
        list.add("b");

        dumbInsertionSort(list);
        print(list.toString());
        
        sortBoxes(list);
    }
}
