package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Creator: Zohidjon Akbarov
 */
public class BaseBoll {
    public static void main(String[] args) {
        System.out.println(callBall(new String[]{"5","2","C","D","+"}));
        Stack<Character> stack = new Stack<>();
        String s = "[]()";
        char [] chars = s.toCharArray();
        for (char c : chars) {

        }
    }
    public static int callBall(String[] ops){
        LinkedList<Integer> list = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < ops.length; i++) {
           if (ops[i] == "+"){
               int temp = list.get(list.size()-1)+list.get(list.size()-2);
               list.add(temp);

           }
         else  if (ops[i] == "D"){
               int temp = list.get(list.size()-1)*2;
               list.add(temp);

           }
         else  if (ops[i].equals("C")){
               list.remove(list.size()-1);

           }
         else {
             list.add(Integer.valueOf(ops[i]));
           }
        }
        for (int item : list) {
            result+=item;
        }
        return result;
    }
}
