package sum_text;

import java.util.Scanner;

public class he {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int stu_num = sc.nextInt();
        int score = sc.nextInt();
        Student student=new Student(stu_num,score);
        Manger_stu manger_stu1 = new Manger_stu(student);
        for (int i=1;i<x;i++){
            int stu_num1 = sc.nextInt();
            int score1 = sc.nextInt();
            Student student_text=new Student(stu_num1,score1);
            manger_stu1.add_(student_text);
        }
        int stu_num2 = sc.nextInt();
        int score2 = sc.nextInt();
        Student student2=new Student(stu_num2,score2);
        Manger_stu manger_stu2 = new Manger_stu(student2);
        for (int i=1;i<y;i++){
            int stu_num_2 = sc.nextInt();
            int score_2 = sc.nextInt();
            Student student_text2=new Student(stu_num_2,score_2);
            manger_stu2.add_(student_text2);
        }
        manger_stu1.add_he(manger_stu2);
        manger_stu1.List();
    }
}

class Student {
    int stu_num;
    int score;
    Student next;

    public Student(int stu_num, int score) {
        this.stu_num = stu_num;
        this.score = score;
    }
}

class Manger_stu {
    private Student head=new Student(0,0);

    public Manger_stu(Student student) {
        head.next = student;

    }

    public void add_(Student student) {//按顺序增加
        if (head.next == null || head.next.stu_num > student.stu_num) {
            student.next = head.next;
            head.next = student;
            return;
        } else if (head.next.next==null){
            head.next.next=student;
            return;
        }
        Student temp = head.next;
        while (true) {
            if (temp.stu_num < student.stu_num && temp.next.stu_num > student.stu_num) {
                student.next = temp.next;
                temp.next = student;
                return;
            }
            if (temp.next == null) {
                temp.next = student;
                return;
            }
            temp = temp.next;
        }
    }

    public void add_he(Manger_stu manger) {
        if (head==null||manger.getHead()==null){
            return;
        }
        Student temp1 = head;
        Student temp2 = manger.getHead().next;
        Student temp3 = temp2.next;
        while (true){
            if (temp1.next.stu_num>temp2.stu_num){
                temp2.next=temp1.next;
                temp1.next=temp2;
                temp2=temp3;

                if (temp3.next!=null) {
                    temp3 = temp3.next;
                }
                if (temp2==temp3){
                    add_(temp2);
                    return;
                }
            } else if (temp1.next==null){
                temp1.next=temp2;
                return;
            }
            temp1=temp1.next;
        }
    }
    public void List(){
        Student temp = head.next;
        while (true) {
            System.out.println(temp.stu_num+" "+temp.score);
            if (temp.next==null){
                return;
            }
            temp = temp.next;
        }
    }

    public Student getHead() {
        return head;
    }
}
