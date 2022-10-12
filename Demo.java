import java.util.*;
class Demo{
    static String[] StId=new String[0];
    static String[] StName=new String[0];
    static int[] DMS=new int[0];
    static int[] PLF=new int[0];
    public final static void clearConsole(){
        try{
            final String os=System.getProperty("os.name");
            if(os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }catch(final Exception e){
            e.printStackTrace();
        }
    }

    public static void mainMenu(){
        System.out.println("\t\t---------------------------------------------");
        System.out.println("\t\t   WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
        System.out.println("\t\t---------------------------------------------\n");
        System.out.println(" [1] Add new student\t\t\t[2] Add new student with marks");
        System.out.println(" [3] Add marks\t\t\t\t[4] Update student details");
        System.out.println(" [5] Update marks\t\t\t[6] Delete student ");
        System.out.println(" [7] Print student details\t\t[8] Print student ranks");
        System.out.println(" [9] Best in programming fundamentals\t[10] Best in database management system");
        System.out.println("\n");
        System.out.print(" Enter an option to continue  > ");
    }

    public static void addStudent(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\t\tADD NEW STUDENT");
        System.out.println();
        do{
            String[] a1=new String[StId.length+1];
            String[] a2=new String[StName.length+1];
            int[] a3=new int[PLF.length+1];
            int[] a4=new int[DMS.length+1];
            for(int i=0; i<StId.length; i++){
                a1[i]=StId[i];
                a2[i]=StName[i];
            }
            a3[a3.length-1]=-1;
            a4[a4.length-1]=-1;
            System.out.print("Enter student ID   : ");
            a1[a1.length-1]=input.nextLine();
            for(int i=0; i<StId.length; i++){
                if(StId[i].equals(a1[a1.length-1])){
                    System.out.println();
                    System.out.println("The student ID already exists");
                    System.out.println();
                    System.out.print("Enter student ID   : ");
                    a1[a1.length-1]=input.nextLine();
                }
            }
            System.out.print("Enter student name : ");
            a2[a2.length-1]=input.nextLine();
            StId=a1;
            StName=a2;
            PLF=a3;
            DMS=a4;
            System.out.println();
            System.out.print("Student has been added successfully.Do you wabt to add a new student (Y/N) ");
            String nav=input.nextLine();
            switch(nav){
                case "N" : return;
                case "n" : return;
            }
            System.out.println();
        }while(true);
    }

    public static void addStwithMarks(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\tADD NEW STUDENT WITH MARKS\n");
        do{
            String[] b1=new String[StId.length+1];
            String[] b2=new String[StName.length+1];
            int[] b3=new int[DMS.length+1];
            int[] b4=new int[PLF.length+1];
            for(int i=0; i<StId.length; i++){
                b1[i]=StId[i];
                b2[i]=StName[i];
                b3[i]=PLF[i];
                b4[i]=DMS[i];
            }
            System.out.print("Enter student ID   : ");
            b1[b1.length-1]=input.nextLine();
            System.out.print("Enter student name : ");
            b2[b2.length-1]=input.nextLine();
            System.out.println();
            System.out.print("Programming fundamentals marks   : ");
            b3[b3.length-1]=input.nextInt();
            if(b3[b3.length-1]>100 | b3[b3.length-1]<0){
                System.out.print("Invalid marks, please enter correct marks - ");
                b3[b3.length-1]=input.nextInt();
                System.out.println();
            }
            System.out.print("Database management system marks : ");
            b4[b4.length-1]=input.nextInt();
            if(b4[b4.length-1]>100 | b4[b4.length-1]<0){
                System.out.print("Invalid marks, please enter correct marks - ");
                b4[b4.length-1]=input.nextInt();
                System.out.println();
            }
            StId=b1;
            StName=b2;
            PLF=b3;
            DMS=b4;
            input.nextLine();
            System.out.println();
            System.out.print("Student has been added successfully. Do you want to add a new student (Y/N) ");
            String nav=input.nextLine();
            switch(nav){
                case "N" : return;
                case "n" : return;
            }
            System.out.println();
        }while(true);
    }

    public static void addMarks(){
        Scanner input=new Scanner(System.in);
        boolean b=false;
        int ind=0;
        System.out.println("\n\t\t\t\t  ADD MARKS\n");
        do{
            System.out.print("Enter student ID : ");
            String s1=input.nextLine();
            if(Arrays.asList(StId).contains(s1)){
                for(int i=0; i<StId.length; i++){
                    if(s1.equals(StId[i])){
                        ind=i;
                    }
                }
                System.out.println("Student name     : "+StName[ind]+"\n");
                System.out.println();
                if(PLF[ind]>=0 | DMS[ind]>=0){
                    System.out.println("This student's marks have been already added.");
                    System.out.println("If you want to update the marks, please use [4] Update marks option\n");
                    System.out.print("Do you want to add marks for another student (Y/N) ");
                    String nav=input.nextLine();
                    System.out.println();
                    switch(nav){
                        case "N" : return;
                        case "n" : return;
                    }
                }
                System.out.print("Programming fundamentals marks   : ");
                PLF[ind]=input.nextInt();
                if(PLF[ind]>100 | PLF[ind]<0){
                    System.out.print("Invalid marks. Please enter correct marks : ");
                    PLF[ind]=input.nextInt();
                    System.out.println();
                }
                System.out.print("Database management system marks : ");
                DMS[ind]=input.nextInt();
                if(DMS[ind]>100 | DMS[ind]<0){
                    System.out.print("Invalid marks. Please enter correct marks : ");
                    DMS[ind]=input.nextInt();
                    System.out.println();
                }
                input.nextLine();
                System.out.print("\nMarks have been added. Do you want to add marks for another student (Y/N) ");
                String nav1=input.nextLine();
                System.out.println();
                switch(nav1){
                    case "N" : return;
                    case "n" : return;
                }
            }else{
                System.out.println();
                System.out.print("Invalid student ID , Do you want to search againg (Y/N) ");
                String sch=input.nextLine();
                switch(sch){
                    case "N" : return;
                    case "n" : return;
                }
            }
        }while(true);
    }

    public static void updateStDetails(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\t   UPDATE STUDENT DETAILS\n");
        int ind=0;
        do{
            System.out.print("Enter student ID : ");
            String d1=input.nextLine();
            if(Arrays.asList(StId).contains(d1)){
                for(int i=0; i<StId.length; i++){
                    if(d1.equals(StId[i])){
                        ind=i;
                    }
                }
                System.out.println("Student name     : " + StName[ind] +"\n");
                System.out.print("Enter new student name : ");
                StName[ind]=input.nextLine();
                System.out.println();
                System.out.println("Student details has been updated successfully.\n");
                System.out.print("Do you want to update another student details (Y/N) ");
                String nav=input.nextLine();
                switch(nav){
                    case "N" : return;
                    case "n" : return;
                }
            }else{
                System.out.print("Invalid ID. Do you want to try againg (Y/N) ");
                String sch=input.nextLine();
                switch(sch){
                    case "N" : return;
                    case "n" : return;
                }
            }
        }while(true);
    }

    public static void updateMarks(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\t\tUPDATE MARKS\n");
        int ind=0;
        do{
            System.out.print("Enter student ID : ");
            String e1=input.nextLine();
            if(Arrays.asList(StId).contains(e1)){
                for(int i=0; i<StId.length; i++){
                    if(e1.equals(StId[i])){
                        ind=i;
                    }
                }
                if(PLF[ind]==-1 | DMS[ind]==-1){
                    System.out.println("This students marks yet to be added.");
                    System.out.print("Do you want to update marks for another student (Y/N) ");
                    String s=input.nextLine();
                    switch(s){
                        case "N" : return;
                        case "n" : return;
                    }
                }
                System.out.println("Student name     : " + StName[ind] +"\n");
                System.out.println("Programming fundamentals marks   : " + PLF[ind]);
                System.out.println("Database management system marks : " + DMS[ind] + "\n");
                System.out.print("Enter new programming fundamentals marks   : ");
                PLF[ind]=input.nextInt();
                if(PLF[ind]>100 | PLF[ind]<0){
                    System.out.print("Invalid input. Please input the correct marks : ");
                    PLF[ind]=input.nextInt();
                }
                System.out.print("Enter new database management system marks : ");
                DMS[ind]=input.nextInt();
                if(DMS[ind]>100 | DMS[ind]<0){
                    System.out.print("Invalid input. Please input the correct marks : ");
                    DMS[ind]=input.nextInt();
                }
                input.nextLine();
                System.out.println("\nMarks have been updates successfully.\n");
                System.out.print("Do you want to update marks for another student (Y/N) ");
                String nav=input.nextLine();
                switch(nav){
                    case "N" : return;
                    case "n" : return;
                }
                System.out.println();
            }else{
                System.out.print("\nInvalid ID. Do you want to try againg (Y/N) ");
                String s1=input.nextLine();
                switch(s1){
                    case "N" : return;
                    case "n" : return;
                }
                System.out.println();
            }
        }while(true);
    }

    public static void deleteSt(){
        Scanner input=new Scanner(System.in);
        int ind=0;
        System.out.println("\n\t\t\t\tDELETE STUDENT\n");
        do{
            if(StId.length==0){
                System.out.println("There is no account to delete ! ");
                System.out.print("\nEnter \"Q\" for go to main menu. ");
                String q=input.nextLine();
                switch(q){
                    case "Q" : return;
                    case "q" : return;
                }
            }
            String[] f1=new String[StId.length-1];
            String[] f2=new String[StName.length-1];
            int[] f3=new int[PLF.length-1];
            int[] f4=new int[DMS.length-1];
            System.out.print("Enter student ID : ");
            String s=input.nextLine();
            if(Arrays.asList(StId).contains(s)){
                for(int i=0; i<StId.length; i++){
                    if(s.equals(StId[i])){
                        ind=i;
                    }
                }
                for(int j=0; j<ind; j++){
                    f1[j]=StId[j];
                    f2[j]=StName[j];
                    f3[j]=PLF[j];
                    f4[j]=DMS[j];
                }
                for(int k=ind; k<StId.length-1; k++){
                    f1[k]=StId[k+1];
                    f2[k]=StName[k+1];
                    f3[k]=PLF[k+1];
                    f4[k]=DMS[k+1];
                }
                StId=f1;
                StName=f2;
                PLF=f3;
                DMS=f4;
                System.out.println("\nStudent has been deleted successfully.\n");
                System.out.print("Do you want to delete another student (Y/N) ");
                String nav=input.nextLine();
                switch(nav){
                    case "N" : return;
                    case "n" : return;
                }
            }else{
                System.out.print("\nInvalid ID. Do you want to search again (Y/N) ");
                String sch=input.nextLine();
                switch(sch){
                    case "N" : return;
                    case "n" : return;
                }
                System.out.println();
            }
        }while(true);
    }

    public static void printStDetails(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\t   PRINT STUDENT DETAILS\n");
        int ind=0;
        do{
            System.out.print("Enter student ID : ");
            String s=input.nextLine();
            if(Arrays.asList(StId).contains(s)){
                for(int i=0; i<StId.length; i++){
                    if(s.equals(StId[i])){
                        ind=i;
                    }
                }
                System.out.println("Student name : " + StName[ind]);
                if(PLF[ind]==-1 | DMS[ind]==-1){
                    System.out.println("Marks yet be added.\n");
                    System.out.print("Do you want to search another student details (Y/N) ");
                    String sch=input.nextLine();
                    switch(sch){
                        case "N" : return;
                        case "n" : return;
                    }
                    System.out.println();
                }
                int[] Tot=new int[StId.length];
                int[] Avg=new int[StId.length];
                int[] sort=new int[StId.length];
                for(int j=0; j<StId.length; j++){
                    Tot[j]=(PLF[j]+DMS[j]);
                    sort[j]=Tot[j];
                    Avg[j]=(Tot[j]/2);
                }
                int rank=Tot[ind];
                for(int k=StId.length-1; k>0; k--){
                    int temp=0;
                    for(int l=0; l<k; l++){
                        if(sort[l]>sort[l+1]){
                            temp=sort[l];
                            sort[l]=sort[l+1];
                            sort[l+1]=temp;
                        }
                    }
                }
                int elm=0;
                for(int m=0; m<StId.length; m++){
                    if(rank==sort[m]){
                        elm=(StId.length-m);
                    }
                }
                String[] s1={"Programming fundamentals marks","Database management system marks","Total marks","Avg. marks","Rank"};
                System.out.println("\n");
                System.out.printf("%-35s%6d\n",s1[0],PLF[ind]);
                System.out.printf("%-35s%6d\n",s1[1],DMS[ind]);
                System.out.printf("%-35s%6d\n",s1[2],Tot[ind]);
                System.out.printf("%-35s%6d\n",s1[3],Avg[ind]);
                System.out.printf("%-35s%6d\n",s1[4],elm);
                System.out.print("\nDo you want to search another student details (Y/N) ");
                String nav=input.nextLine();
                System.out.println("\n");
                switch(nav){
                    case "N" : return;
                    case "n" : return;
                }
            }else{
                System.out.print("Invalid ID. Do you want to try again (Y/N) ");
                String sch1=input.nextLine();
                switch(sch1){
                    case "N" : return;
                    case "n" : return;
                }
                System.out.println("\n");
            }
        }while(true);
    }

    public static void printStRanks(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\t   PRINT STUDENTS' RANKS\n\n\n");
        int ind=0;
        do{
            int[] Tot=new int[StId.length];
            int[] Avg=new int[StId.length];
            int[] sort=new int[StId.length];
            int[] num=new int[StId.length];
            String[] IDn=new String[StId.length];
            String[] Namen=new String[StId.length];
            for(int i=0; i<StId.length; i++){
                Tot[i]=(PLF[i]+DMS[i]);
                Avg[i]=(Tot[i]/2);
                sort[i]=Tot[i];
            }
            for(int j=StId.length-1; j>-1; j--){
                int temp=0;
                int temp1=0;
                for(int k=0; k<j; k++){
                    if(sort[k]>sort[k+1]){
                        temp=sort[k];
                        sort[k]=sort[k+1];
                        sort[k+1]=temp;
                    }
                    if(Avg[k]>Avg[k+1]){
                        temp1=Avg[k];
                        Avg[k]=Avg[k+1];
                        Avg[k+1]=temp1;
                    }
                }
            }
            int num1=0;
            for(int a=StId.length-1; a>-1; a--){
                for(int b=0; b<StId.length; b++){
                    if(sort[a]==Tot[b]){
                        num1=b;
                    }
                }
                IDn[a]=StId[num1];
                Namen[a]=StName[num1];
            }
            StId=IDn;
            StName=Namen;
            Tot=sort;
            System.out.printf("%-5s","Rank");
            System.out.printf("%-7s","ID");
            System.out.printf("%-25s","Name");
            System.out.printf("%12s","Total marks");
            System.out.printf("%12s","Avg marks");
            System.out.println("\n");
            for(int i=StId.length-1; i>=0; i--){
                num[i]=(StId.length-i);
                if(Tot[i]<0 | Avg[i]<0){
                    continue;
                }
                System.out.printf("%-5d%-7s%-25s%12d%12d\n",num[i],StId[i],StName[i],Tot[i],Avg[i]);
            }
            System.out.print("\n\n\nDo you want to go back to main manu (Y/N) ");
            String nav=input.nextLine();
            switch(nav){
                case "Y" : return;
                case "y" : return;
            }
            System.out.println("\n");
        }while(true);
    }

    public static void bestinPLF(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\n\n");
        int ind=0;
        do{
            String[] IDn1=new String[StId.length];
            String[] Namen1=new String[StId.length];
            int[] PLFn=new int[StId.length];
            int[] sort1=new int[StId.length];
            for(int i=0; i<StId.length; i++){
                sort1[i]=PLF[i];
            }
            for(int j=StId.length-1; j>0; j--){
                int temp=0;
                for(int k=0; k<j; k++){
                    if(sort1[k]>sort1[k+1]){
                        temp=sort1[k];
                        sort1[k]=sort1[k+1];
                        sort1[k+1]=temp;
                    }
                }
            }
            for(int a=StId.length-1; a>-1; a--){
                for(int b=0; b<StId.length; b++){
                    if(sort1[a]==PLF[b]){
                        ind=b;
                    }
                }
                IDn1[a]=StId[ind];
                Namen1[a]=StName[ind];
                PLFn[a]=PLF[ind];
            }
            StId=IDn1;
            StName=Namen1;
            PLF=PLFn;
            System.out.printf("%-7s","ID");
            System.out.printf("%-25s","Name");
            System.out.printf("%-12s","PF marks");
            System.out.printf("%-12s","BDMS marks");
            System.out.println("\n");
            for(int i=StId.length-1; i>=0; i--){
                if(PLF[i]==-1){
                    continue;
                }
                System.out.printf("%-7s%-25s%-12d%-12d\n",StId[i],StName[i],PLF[i],DMS[i]);
            }
            System.out.print("\n\n\nDo you want to go back to main manu (Y/N) ");
            String nav=input.nextLine();
            switch(nav){
                case "Y" : return;
                case "y" : return;
            }
            System.out.println("\n");
        }while(true);
    }

    public static void bestinDMS(){
        Scanner input=new Scanner(System.in);
        System.out.println("\n\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\n\n");
        int ind=0;
        do{
            String[] IDn1=new String[StId.length];
            String[] Namen1=new String[StId.length];
            int[] DMSn=new int[StId.length];
            int[] sort1=new int[StId.length];
            for(int i=0; i<StId.length; i++){
                sort1[i]=DMS[i];
            }
            for(int j=StId.length-1; j>0; j--){
                int temp=0;
                for(int k=0; k<j; k++){
                    if(sort1[k]>sort1[k+1]){
                        temp=sort1[k];
                        sort1[k]=sort1[k+1];
                        sort1[k+1]=temp;
                    }
                }
            }
            for(int a=StId.length-1; a>-1; a--){
                for(int b=0; b<StId.length; b++){
                    if(sort1[a]==DMS[b]){
                        ind=b;
                    }
                }
                IDn1[a]=StId[ind];
                Namen1[a]=StName[ind];
                DMSn[a]=DMS[ind];
            }
            StId=IDn1;
            StName=Namen1;
            DMS=DMSn;
            System.out.printf("%-7s","ID");
            System.out.printf("%-25s","Name");
            System.out.printf("%-12s","DBMS marks");
            System.out.printf("%-12s","PLF marks");
            System.out.println("\n");
            for(int i=StId.length-1; i>=0; i--){
                if(DMS[i]==-1){
                    continue;
                }
                System.out.printf("%-7s%-25s%-12d%-12d\n",StId[i],StName[i],DMS[i],PLF[i]);
            }
            System.out.print("\n\n\nDo you want to go back to main manu (Y/N) ");
            String nav=input.nextLine();
            switch(nav){
                case "Y" : return;
                case "y" : return;
            }
            System.out.println("\n");
        }while(true);
    }

    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        do{
            clearConsole();
            mainMenu();
            int x=input.nextInt();
            switch(x){
                case 1 : clearConsole(); addStudent(); break;
                case 2 : clearConsole(); addStwithMarks(); break;
                case 3 : clearConsole(); addMarks(); break;
                case 4 : clearConsole(); updateStDetails(); break;
                case 5 : clearConsole(); updateMarks(); break;
                case 6 : clearConsole(); deleteSt(); break;
                case 7 : clearConsole(); printStDetails(); break;
                case 8 : clearConsole(); printStRanks(); break;
                case 9 : clearConsole(); bestinPLF(); break;
                case 10: clearConsole(); bestinDMS(); break;
            }
        }while(true);
    }
}
