import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String wA = sc.nextLine();
        String wB = sc.nextLine();
        int result = 1;
        int index = 0;
        for(char bChar : wB.toCharArray()){
            int bCharIndex = wA.indexOf(bChar);
            if(index <= bCharIndex){
                index = bCharIndex;
                result++;
            }else{
                index = 0;
            }
        }
        System.out.println(result);
    }
}