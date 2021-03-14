package meituan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BorrowBook {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int q = Integer.parseInt(params[2]);
        int op, x, y;
        boolean[] locked = new boolean[10001];    // 表示第i行书架是否被上锁
        boolean[] hasBook = new boolean[10001];   // 表示第i本书是否在小团手上
        // 记录第i本书在第j行书架上
        int[] pos = new int[10001];
        for(int i = 0; i < q; i++){
            params = br.readLine().trim().split(" ");
            if(params.length == 3){
                op = Integer.parseInt(params[0]);
                x = Integer.parseInt(params[1]);
                y = Integer.parseInt(params[2]);
                // 书架在小团手上，操作无效
                if(hasBook[x]) continue;
                // 这行书架被锁了，操作无效
                if(locked[y]) continue;
                // 如果这本书在一行上了锁的书架上，操作无效
                if(pos[x] != 0 && locked[pos[x]]) continue;
                // 否则将x放在第y行书架上
                pos[x] = y;
            }else{
                op = Integer.parseInt(params[0]);
                if(op == 2){
                    // 直接加锁
                    y = Integer.parseInt(params[1]);
                    locked[y] = true;
                }else if(op == 3){
                    // 直接去掉锁
                    y = Integer.parseInt(params[1]);
                    locked[y] = false;
                }else if(op == 4){
                    x = Integer.parseInt(params[1]);
                    // 如果x已经放在了书架上，且该层书架又没上锁，就直接输出
                    if(pos[x] != 0 && !locked[pos[x]]){
                        System.out.println(pos[x]);
                        pos[x] = 0;
                        hasBook[x] = true;
                    }else
                        System.out.println(-1);
                }else{
                    x = Integer.parseInt(params[1]);
                    // 这本书不在小团手上，操作无效
                    if(!hasBook[x]) continue;
                    // 否则直接令小团失去这本书
                    hasBook[x] = false;
                }
            }
        }
    }
}