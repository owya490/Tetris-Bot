import java.util.*;
import java.awt.Color;
import java.awt.Robot;
//import java.awt.Rectangle;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// class Block {
//     String type;
//     int rotation;

//     public Block(String type) {
//         this.type = type;
//     }
// }

public class Tetris extends Thread{
    
    public static int[][] grid;
    public static String hold;
    public static String current;
    public static Robot robot;

    public static void logic() {
        for (int i = 0 ; i < 4; i ++) {
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.delay(10);
        }

        for (int x = 0; x < 10; x ++) {
            for (int y = 19; y >= 0; y --) {
        // for (int y = 19; y >= 0; y --) {
        //     for (int x = 0; x < 10; x ++) {
                if (current == "O") {
                    if (o_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "J") {
                    if (j_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "L") {
                    if (l_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "Z") {
                    if (z_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "S") {
                    if (s_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "T") {
                    if (t_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
                else if (current == "I") {
                    if (i_logic(x, y)) {
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.delay(10);
                        current = "None!";
                        return;
                    }
                }
            }
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            robot.delay(10);
        }
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(10);
        for (int i = 0 ; i < 20; i ++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public static boolean o_logic(int x, int y) {
        System.out.println(x);
        if (x >= 9 || y <= 0) {
            return false;
        }
        if (grid[y][x] == 1) {
            return false;
        }
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (grid[y-1][x] == 1) {
            return false;
        }
        if (grid[y-1][x+1] == 1) {
            return false;
        }

        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
            else if (grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y][x+1] = 1;
        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        // for (int i = 0 ; i < 20; i ++) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        return true;

    }

    public static boolean j_logic(int x, int y) {
        System.out.println(y);
        //Orientation 1
        if (j_logic_orient_1(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.delay(10);
        if (j_logic_orient_2(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (x != 0) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            robot.delay(10);
        }
        if (j_logic_orient_3(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (j_logic_orient_4(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);

        return false;
    }

    public static boolean j_logic_orient_1(int x, int y) {
                //Orientation 1
                if (grid[y][x] == 1) {
                    return false;
                }
                if (y > 0) {
                    if (grid[y-1][x] == 1) {
                        return false;
                    }
                }
                if (grid[y][x+1] == 1) {
                    return false;
                }
                if (grid[y][x+2] == 1) {
                    return false;
                }
                if (y < 19) {
                    //System.out.println("Here!");
                    if (grid[y+1][x] == 0) {
                        return false;
                    }
                    else if (grid[y+1][x+1] == 0) {
                        return false;
                    }
                    else if (grid[y+1][x+2] == 0) {
                        //System.out.println("Here!");
                        return false;
                    }
                }
                System.out.println(y < 19);
                grid[y][x] = 1;
                grid[y-1][x] = 1;
                grid[y][x+1] = 1;
                grid[y][x+2] = 1;
                return true;
    }

    public static boolean j_logic_orient_2(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
            if (grid[y-2][x + 1] == 1) {
                return false;
            }
        }
        if (y < 19){
            if (grid[y + 1][x] == 0) {
                return false;
            }
            if (grid[y + 1][x + 1] == 0) {
                return false;
            }
            if (grid[y][x+1] == 0) {
                return false;
            }
            if (y > 1) {
                if (grid[y-1][x+1] == 0) {
                    return false;
                }
            }
        }

        grid[y][x] = 1;
        grid[y-1][x] = 1;
        grid[y-2][x] = 1;
        grid[y-2][x+1] = 1;
        return true;
    }
    
    public static boolean j_logic_orient_3(int x, int y) {
        System.out.println("logic 3");
        if (y > 0) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-1][x+2] == 1) {
                return false;
            }
        }
        if (grid[y][x+2] == 1) {
            return false;
        }
        if (grid[y][x] == 0) {
            return false;
        }
        if (grid[y][x+1] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x+2] == 0) {
                return false;
            }
        }

        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        grid[y-1][x+2] = 1;
        grid[y][x+2] = 1;
        return true;
    }

    public static boolean j_logic_orient_4(int x, int y) {
        System.out.println("logic 4");
        if (grid[y][x] == 1) {
            return false;
        }
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x+1] == 1) {
                return false;
            }
        }

        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
            if (grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y][x+1] = 1;
        grid[y-1][x+1] = 1;
        grid[y-2][x+1] = 1;
        return true;
    }
    
    public static boolean l_logic(int x, int y) {
        System.out.println(y);
        //Orientation 1
        if (l_logic_orient_1(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.delay(10);
        if (l_logic_orient_2(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (x != 0) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            robot.delay(10);
        }
        if (l_logic_orient_3(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (l_logic_orient_4(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);

        return false;
    }

    public static boolean l_logic_orient_1(int x, int y) {
        //Orientation 1
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 0) {
            if (grid[y-1][x+2] == 1) {
                return false;
            }
        }
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (grid[y][x+2] == 1) {
            return false;
        }
        if (y < 19) {
            //System.out.println("Here!");
            if (grid[y+1][x] == 0) {
                return false;
            }
            else if (grid[y+1][x+1] == 0) {
                return false;
            }
            else if (grid[y+1][x+2] == 0) {
                //System.out.println("Here!");
                return false;
            }
        }
        System.out.println(y < 19);
        grid[y][x] = 1;
        grid[y-1][x+2] = 1;
        grid[y][x+1] = 1;
        grid[y][x+2] = 1;
        return true;
    }

    public static boolean l_logic_orient_2(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (grid[y][x + 1] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
        }
        if (y < 19){
            if (grid[y + 1][x] == 0) {
                return false;
            }
            if (grid[y + 1][x + 1] == 0) {
                return false;
            }
            
        }

        grid[y][x] = 1;
        grid[y-1][x] = 1;
        grid[y-2][x] = 1;
        grid[y][x+1] = 1;
        return true;
    }

    public static boolean l_logic_orient_3(int x, int y) {
        System.out.println("logic 3");
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 0) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-1][x+2] == 1) {
                return false;
            }
        }
        if (grid[y][x+1] == 0) {
            return false;
        }
        if (grid[y][x+2] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
        }

        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        grid[y-1][x+2] = 1;
        grid[y][x] = 1;
        return true;
    }

    public static boolean l_logic_orient_4(int x, int y) {
        System.out.println("logic 4");
        if (grid[y][x+1] == 1) {
            return false;
        }

        if (y > 1) {
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
        }

        if (y < 19) {
            if (grid[y+1][x+1] == 0) {
                return false;
            }
            if (grid[y+1][x] == 0) {
                return false;
            }
        }
        if (grid[y][x] == 0) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 0) {
                return false;
            }
        }

        grid[y][x+1] = 1;
        grid[y-1][x+1] = 1;
        grid[y-2][x+1] = 1;
        grid[y-2][x] = 1;
        return true;
    }
    
    public static boolean z_logic(int x, int y) {
        if (z_logic_orient_1(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (x % 2 == 0) {
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.delay(10);
            if (x != 0) {
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                robot.delay(10);
            }
        }
        if (z_logic_orient_2(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        return false;
    }

    public static boolean z_logic_orient_1(int x, int y) {
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (grid[y][x+2] == 1) {
            return false;
        }
        if (y  > 0) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
        }

        if (grid[y][x] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x+1] == 0) {
                return false;
            }
            if (grid[y+1][x+2] == 0) {
                return false;
            }
        }
        grid[y][x+1] = 1;
        grid[y][x+2] = 1;
        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        return true;
    }   

    public static boolean z_logic_orient_2(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x+1] == 1) {
                return false;
            }
        }
        if (grid[y][x+1] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
        }
        grid[y][x] = 1;
        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        grid[y-2][x+1] = 1;
        return true;
    }
    
    public static boolean s_logic(int x, int y) {
        if (s_logic_orient_1(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (x % 2 == 0) {
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.delay(10);
            if (x != 0) {
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                robot.delay(10);
            }
        }
        if (s_logic_orient_2(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        return false;
    }

    public static boolean s_logic_orient_1(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (y > 0) {
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-1][x+2] == 1) {
                return false;
            }
        }
        
        if (grid[y][x+2] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
            if (grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y][x+1] = 1;
        grid[y-1][x+1] = 1;
        grid[y-1][x+2] = 1;
        return true;
    }

    public static boolean s_logic_orient_2(int x, int y) {
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
        }
        if (grid[y][x] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y][x+1] = 1;
        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        grid[y-2][x] = 1;
        return true;
    }
    
    public static boolean t_logic(int x, int y) {
        if (t_logic_orient_1(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.delay(10);
        if (t_logic_orient_2(x, y)) {
            return true;
        }
        if (x != 0) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            robot.delay(10); 
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (t_logic_orient_3(x, y)) {
            return true;
        }

        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        if (t_logic_orient_4(x, y)) {
            return true;
        }
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(10);
        return false;
    }

    public static boolean t_logic_orient_1(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (grid[y][x+2] == 1) {
            return false;
        }
        if (y > 0) {
            if (grid[y-1][x+1] == 1) {
                return false;
            }
        }

        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
            if (grid[y+1][x+1] == 0) {
                return false;
            }
            if (grid[y+1][x+2] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y][x+1] = 1;
        grid[y][x+2] = 1;
        grid[y-1][x+1] = 1;
        return true;
    }

    public static boolean t_logic_orient_2(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
        }
        if (grid[y][x+1] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y-1][x] = 1;
        grid[y-2][x] = 1;
        grid[y-1][x+1] = 1;
        return true;
    }

    public static boolean t_logic_orient_3(int x, int y) {
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (y > 0) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-1][x+2] == 1) {
                return false;
            }
        }

        if (grid[y][x] == 0) {
            return false;
        }
        if (grid[y][x+2] == 0) {
            return false;
        }
        if (y < 19) {
            if(grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y-1][x] = 1;
        grid[y-1][x+1] = 1;
        grid[y-1][x+2] = 1;
        grid[y][x+1] = 1;
        return true;
    }
    
    public static boolean t_logic_orient_4(int x, int y) {
        if (grid[y][x+1] == 1) {
            return false;
        }
        if (y > 1) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-1][x+1] == 1) {
                return false;
            }
            if (grid[y-2][x+1] == 1) {
                return false;
            }
        }
        if (grid[y][x] == 0) {
            return false;
        }
        if (y < 19) {
            if (grid[y+1][x+1] == 0) {
                return false;
            }
        }

        grid[y][x+1] = 1;
        grid[y-1][x+1] = 1;
        grid[y-1][x] = 1;
        grid[y-2][x+1] = 1;
        return true;
    }

    public static boolean i_logic(int x, int y) {
        if (x == 0 && y == 19) {
            robot.keyPress(KeyEvent.VK_UP);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_UP);
            robot.delay(10);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.delay(10);
        }
        if (i_logic_orient_1(x, y)) {
            return true;
        }
        return false;
    }

    public static boolean i_logic_orient_1(int x, int y) {
        if (grid[y][x] == 1) {
            return false;
        }
        if (y > 3) {
            if (grid[y-1][x] == 1) {
                return false;
            }
            if (grid[y-2][x] == 1) {
                return false;
            }
            if (grid[y-3][x] == 1) {
                return false;
            }
        }

        if (y < 19) {
            if (grid[y+1][x] == 0) {
                return false;
            }
        }

        grid[y][x] = 1;
        grid[y-1][x] = 1;
        grid[y-2][x] = 1;
        grid[y-3][x] = 1;
        return true;
    }
    public static void main(String[] args) {
        grid = new int[20][10];
        try {
            robot = new Robot();
            robot.mouseMove(790,720); //New Game button

            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_F4);
            robot.delay(40);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.delay(1800);
            System.out.println("Now!");     
            //for (int i = 0; i < 10; i ++) {
                for (;;){
                Color color = robot.getPixelColor(735, 215);
                // System.out.println("Red   = " + color.getRed());
                // System.out.println("Green = " + color.getGreen());
                // System.out.println("Blue  = " + color.getBlue());

                if (color.getRed() == 215) {
                    System.out.println("Its Red!");
                    current = "Z";
                }
                else if (color.getGreen() == 177) {
                    System.out.println("Its Green!");
                    current = "S";
                }
                else if (color.getBlue() == 215) {
                    System.out.println("Its Light Blue!");
                    current = "I";
                }
                else if (color.getRed() == 175) {
                    System.out.println("Its Purple!");
                    current = "T";
                }
                else if (color.getGreen() == 159) {
                    System.out.println("Its Yellow!");
                    current = "O";
                }
                else if (color.getGreen() == 91) {
                    System.out.println("Its Orange!");
                    current = "L";
                }
                else if (color.getBlue() == 198) {
                    System.out.println("Its Dark Blue!");
                    current = "J";
                }
                robot.delay(100);

                //do logic
                logic();

                // robot.keyPress(KeyEvent.VK_SPACE);
                // robot.delay(40);
                // robot.keyRelease(KeyEvent.VK_SPACE);

            }
        } catch(AWTException e) {
            e.printStackTrace();
        }
    }
}