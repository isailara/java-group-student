package com.company;

class Student{

    private String name; //Variable de instancia
    private String lastName; //Variable de instancia
    private String code; //Variable de instancia

    //Constructor, se llama cuando se crea el objeto
    Student(String name,String lastName,String code){
        this.name=name;
        this.lastName=lastName;
        this.code=code;
    }

    //Setters
    public void setName(String name){
        this.name=name;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setCode(String code){
        this.code=code;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }
}

class Group{
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejeted;

    public Group(String code, int capacity) {
        this.code = code;
        students=new Student[capacity];
    }

    /*
    public void setCode(String code){
        this.code=code;
    }*/

    public String getCode(){
        return code;
    }

    /*
    public void setCapacity(int capacity){
        students=new Student[capacity];
    }*/

    public boolean addStudent(Student student){
        if(enrolled< students.length){
            students[enrolled++]=student;
            return true;
        }
        rejeted++;
        return  false;
    }

    public void removeStudent(String code){
        for(int i=0;i< enrolled;i++){
            if(students[i].getCode().equals(code))
            {
                System.out.println("------------------------------------------------------------------");
                System.out.println("El alumno "+students[i].getName()+" "+students[i].getLastName()+" con código "+students[i].getCode()+" será eliminado.");
                delete(i);
            }
        }
    }

    public void delete(int x){
        for(int i=x;i<enrolled-1;i++){
            students[i]=students[i+1];
        }
        enrolled--;
    }

    public int getEnrolled(){
        return enrolled;
    }

    public int getRejeted(){
        return rejeted;
    }

    public Student getStudent(int index){
        return students[index];
    }
}

public class Main {

    public static void main(String[] args){
        // write your code here
        Student student1;
        Student student2=new Student("Ivan","Uresti","972196");

        student1=new Student("José","González","456789");

        //student1.setName("Ivan");
        //student2.setName("Jose");

        Group group=new Group("230401",8);
        Group group2=new Group("230402",6);

        /*if(group.equals(group2))
        {
            System.out.println("IGUALES");
        }
        else {
            System.out.println("NO SON IGUALES");
        }*/

        /*group.setCode("230401");
        group.setCapacity(8);*/

        //Para guardar en un grupo, en un ciclo for guardar en cada variable cada dato que ocupa el estudiante
        //Se pasan todos los datos al arreglo de estudiantes

        /*if(!group.addStudent(student1)){
            System.out.println("Estudiante no fue añadido: "+student1.getName()+" "+student1.getLastName()+" "+student1.getCode());
        }*/
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(new Student("Jorge","Acosta","1"));
        group.addStudent(new Student("Arturo","Aleman","2"));
        group.addStudent(new Student("Antonio","Angel","3"));
        group.addStudent(new Student("Francisco","Arreguín","4"));
        group2.addStudent(new Student("Misael","Cabrera","5"));
        group2.addStudent(new Student("Roberto","Cisneros","6"));
        group.addStudent(new Student("Juan","Coronado","7"));
        group.addStudent(new Student("José","González","8"));
        group.addStudent(new Student("Jesus","Lara","9"));
        group.addStudent(new Student("José","Limón","10"));

        System.out.println();
        System.out.println("Grupo: "+group.getCode()+" "+"Inscritos: " + group.getEnrolled()+" "+"Rechazados: "+group.getRejeted());
        System.out.printf("Grupo: %s Inscritos: %d Rechazados: %d%n",group2.getCode(),group2.getEnrolled(),group2.getRejeted());

        System.out.println();
        System.out.println("----------------Antes de eliminar----------------");
        System.out.println();
        System.out.println("Alumnos del grupo: "+group.getCode());
        System.out.println();
        for(int i=0;i< group.getEnrolled();i++){
            Student student=group.getStudent(i);
            System.out.println(student.getCode()+": "+student.getName()+" "+student.getLastName());
        }
        System.out.println();
        System.out.println("Alumnos del grupo: "+group2.getCode());
        System.out.println();

        for(int i=0;i< group2.getEnrolled();i++){
            Student student=group2.getStudent(i);
            System.out.println(student.getCode()+": "+student.getName()+" "+student.getLastName());
        }

        group.removeStudent("972196");
        group.removeStudent("4");
        group2.removeStudent("6");
        group.removeStudent("3");
        group2.removeStudent("12");

        //group.addStudent(new Student("José","Limón","10"));
        //group2.addStudent(new Student("Isai","Lara","11"));

        System.out.println("------------------------------------------------------------------");
        System.out.println("Grupo: "+group.getCode()+" "+"Inscritos: " + group.getEnrolled()+" "+"Rechazados: "+group.getRejeted());
        System.out.printf("Grupo: %s Inscritos: %d Rechazados: %d%n",group2.getCode(),group2.getEnrolled(),group2.getRejeted());

        System.out.println();
        System.out.println("----------------Despues de eliminar----------------");
        System.out.println();
        System.out.println("Alumnos del grupo: "+group.getCode());
        System.out.println();
        for(int i=0;i<group.getEnrolled();i++){
            Student student=group.getStudent(i);
            System.out.println(student.getCode()+": "+student.getName()+" "+student.getLastName());
        }
        System.out.println();
        System.out.println("Alumnos del grupo: "+group2.getCode());
        System.out.println();
        for(int i=0;i< group2.getEnrolled();i++){
            Student student=group2.getStudent(i);
            System.out.println(student.getCode()+": "+student.getName()+" "+student.getLastName());
        }
    }
}

