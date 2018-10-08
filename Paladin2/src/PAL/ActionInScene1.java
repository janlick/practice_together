package PAL;

/*
 * <第一幕的人物動作>場景：李逍遙的房間
 * 輸入<E/W/S/N>指令可使人物向-東(E)南(S)西(W)北(N)4個方位移動
 * E>> Y>>人物移動至一樓柴房  N>>重新選擇移動方向
 * W>> 人物移動至走廊，遇見李大娘
 * S>> Nothing Happend
 * N>> Nothing Happend
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionInScene1 {
 public static void main(String[] args) throws IOException {
  InputStreamReader input = new InputStreamReader(System.in);
  BufferedReader reader = new BufferedReader(input);
  String inputNull;
  String inputDirection;
  String inputYN;
  System.out.print("Action in Scene1 starts, please press <E/W/S/N> to choose the direstions.<ENTER>");
  inputNull = reader.readLine();
  int a = 1;
  while (a == 1) {
   System.out.print("請問逍遙要往哪個方向走？<E/W/S/N>");
   inputDirection = reader.readLine();
   if (inputDirection.equals("E")) {
    a = 2;
    while (a == 2) {
     System.out.print("通往樓下柴房的密道，是否進入？<Y/N>");
     inputYN = reader.readLine();
     if (inputYN.equals("Y")) {
      System.out.print("走出房間，在一樓柴房");
      break;
     }
     if (inputYN.equals("N")) {
      a = 1;
     } else {
      continue;
     }
    }
   }
   if (inputDirection.equals("W")) {
    System.out.print("走出房間，在走道上遇見李大娘");
    break;
   }
   if (inputDirection.equals("S") || inputDirection.equals("N")) {
    System.out.println("只是一面普通的牆壁，什麼也沒有……");
    continue;
   } else {
    continue;
   }
  }
  System.out.println("");
  System.out.print("-Action in Scene1 Ends-");
 }
}