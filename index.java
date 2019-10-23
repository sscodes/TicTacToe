import java.io.*;
public class TicTacToe
{
    public static void main(String args[])throws IOException
    {
        char[][] T = new char[3][3];
        int[][] N = new int[3][3];
        int a=0, k=0, c, q=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                T[i][j]=' ';
                N[i][j]=0;
            }
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        TicTacToe t3=new TicTacToe();
        while(a<=9)
        {
            t3.X(T, N);
            a++;
            t3.display(T);
            c=t3.check(N);
            if(c==3)
            {
                System.out.println("\tX is the winner");
                k++;
                break;
            }
            else if(c==-3)
            {
                System.out.println("\tO is the winner");
                k++;
                break;
            }
            if(a==9)
            break;
            t3.O(T, N);
            a++;
            t3.display(T);
            c=t3.check(N);
            if(c==3)
            {
                System.out.println("\tX is the Winner");
                k++;
                break;
            }
            else if(c==-3)
            {
                System.out.println("\tO is the winner");
                k++;
                break;
            }
        }
        if(k==0)
        System.out.println("\tMatch Draw");
        while(q==0)
        {
            System.out.print("\nWant to play again(Y for yes & N for no):");
            char again=(char)br.read();;
            if(((int)again)==10)    //idea by Arkaprovo sarkar
            again=(char)br.read();  //idea by Arkaprovo sarkar
            if(again=='Y')
            {
                main(new String[0]);
                q++;
            }
            else if(again=='N')
            {
                System.out.print("\nThanks for playing!");
                q++;
            }
            else 
            System.out.print("\nWrong Input");
        }
    }
    public void X(char[][] m, int[][] z)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nX's turn");
        System.out.println("Enter coordinates : ");
        int x=Integer.parseInt(br.readLine());
        int y=Integer.parseInt(br.readLine());
        int q=0, r=0;
        while(q!=1)
        {
            if(x>3 || x<1 || y>3 || y<1)
            {
                System.out.println("Invalid board position. Enter again : ");
                x=Integer.parseInt(br.readLine());
                y=Integer.parseInt(br.readLine());
            }
            else
            q=1;
        }
        while(r!=1)
        {
            if(z[x-1][y-1]==0)
            {    
                m[x-1][y-1]='X';
                z[x-1][y-1]=1;
                r=1;
            }
            else
            {
                System.out.println("Board position occupied. Try another : ");
                x=Integer.parseInt(br.readLine());
                y=Integer.parseInt(br.readLine());
            }
        }
    }
    public void O(char[][] m, int[][] z)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nO's turn");
        System.out.println("Enter coordinates : ");
        int x=Integer.parseInt(br.readLine());
        int y=Integer.parseInt(br.readLine());
        int q=0, r=0;
        while(q!=1)
        {
            if(x>3 || x<1 || y>3 || y<1)
            {
                System.out.println("Invalid board position. Enter again : ");
                x=Integer.parseInt(br.readLine());
                y=Integer.parseInt(br.readLine());
            }
            else
            q=1;
        }
        while(r!=1)
        {
            if(z[x-1][y-1]==0)
            {    
                m[x-1][y-1]='O';
                z[x-1][y-1]=-1;
                r=1;
            }
            else
            {
                System.out.println("Board position occupied. Try another : ");
                x=Integer.parseInt(br.readLine());
                y=Integer.parseInt(br.readLine());
            }
        }
    }
    public int check(int[][] z)    
    {    
        int s=0, d=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s=s+z[i][j];
            }
            if(s==3 || s==-3)
            {
                d++;
                break ;
            }
            s=0;
        }
        if(d==1)
        return s;
        else
        {
            s=0;
            d=0;
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(i==j)
                s=s+z[i][j];
            }
        }
        if(s==3 || s==-3)
        return s;
        else
        s=0;
        s=z[0][2]+z[1][1]+z[2][0];
        if(s==3 || s==-3)
        return s;
        else
        s=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s=s+z[j][i];
            }
            if(s==3 || s==-3)
            {
                d++;
                break;
            }
            s=0;
        }
        if(d==1)
        return s;
        else
        {
            s=0;
            d=0;
            return 0;
        }
    }
    public void display(char[][] m)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(j!=2)
                System.out.print("  "+m[i][j]+"  |");
                else
                System.out.println("  "+m[i][j]);
            }
            if(i!=2)
            System.out.println(" ----------------");
        }
    }
}
