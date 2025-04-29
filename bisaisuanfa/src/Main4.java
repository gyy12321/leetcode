import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader x2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter x3 = new BufferedWriter(new OutputStreamWriter(System.out));

        //shurun
        int n=Integer.parseInt(x2.readLine().trim());
        String[] tokens=x2.readLine().trim().split("\\s+");
        Set<Integer> usable=new HashSet<>();
        //jihedingyiasas

        //xunhuan
        for(int i=0;i<n;++i){
            usable.add(Integer.valueOf(tokens[i]));
        }
        int q=Integer.parseInt(x2.readLine().trim());
        tokens=x2.readLine().trim().split("\\s+");

        //jihedingyi
        StringBuilder sb=new StringBuilder(q);
        for(int i=0;i<q;++i){
            int b=Integer.parseInt(tokens[i]);
            if(usable.contains(b))
                sb.append('Y');
            else
                sb.append('N');
        }


        x3.write(sb.toString());
        x3.newLine();
        x3.flush();
    }
}

//public class Main4 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        //shurun
//        int n=Integer.parseInt(br.readLine().trim());
//        String[] tokens=br.readLine().trim().split("\\s+");
//        Set<Integer> usable=new HashSet<>();
//        //jihedingyi
//
//        //xunhuan
//        for(int i=0;i<n;++i){
//            usable.add(Integer.valueOf(tokens[i]));
//        }
//        int q=Integer.parseInt(br.readLine().trim());
//        tokens=br.readLine().trim().split("\\s+");
//
//        StringBuilder sb=new StringBuilder(q);
//        for(int i=0;i<q;++i){
//            int b=Integer.parseInt(tokens[i]);
//            if(usable.contains(b))
//                sb.append('Y');
//            else
//                sb.append('N');
//        }
//        bw.write(sb.toString());
//        bw.newLine();
//        bw.flush();
//    }
//}
