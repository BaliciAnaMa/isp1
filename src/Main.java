//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  ArrayList<Student> listaStudenti = new ArrayList<>();

  listaStudenti.add(new Student("Balici","Ana","xd987089","ism21/1"));
    listaStudenti.add(new Student("Popi","Maria","xd907009","ism21/1"));
  listaStudenti.add(new Student("Popa", "Maria", "120", "TI21/1"));
  listaStudenti.add(new Student("Popa", "Alis", "120", "TI21/2"));
  for(Student student : listaStudenti){
    System.out.println(student);
  }

  System.out.println(Student.existaStudent(listaStudenti,
          new Student("Popa", "Alis", "120", "TI21/2")));
  System.out.println(Student.existaStudent(listaStudenti,
          new Student("Popa", "Maria", "112", "TI21/1")));

  List<Integer> x = new ArrayList();
    x.add(1);
  x.add(8);
  x.add(9);
  x.add(5);
  x.add(2);

  List<Integer> y = new ArrayList();
  y.add(1);
  y.add(7);y.add(6);y.add(3);y.add(2);y.add(10);y.add(8);
  Collections.sort(x);
  Collections.sort(y);
  System.out.println("Lista x sortata:"+x);
  System.out.println("Lista y sortata:"+y);
  List<Integer> xPlusY = new ArrayList(); //a
  xPlusY.addAll(x);xPlusY.addAll(y);
  Collections.sort(xPlusY);
  System.out.println("toate elementele x+y"+ xPlusY);

  Set<Integer> zSet = new TreeSet(); //b
  zSet.addAll(x);zSet.retainAll(y);
  System.out.println("valorile comune luate o data"+zSet);

  List<Integer> xMinusY = new ArrayList();//c
  xMinusY.addAll(x);xMinusY.removeAll(y);
  System.out.println("valorile sir x, nu se afla in y"+ xMinusY);

  int p = 4;
  List<Integer> xPlusYLimitedByP = new ArrayList(); //d
  Set<Integer> tempSet=new TreeSet<>();
  tempSet.addAll(x);
  tempSet.addAll(y);
  for(Integer num:tempSet)
  {
    if(num<=p)
      xPlusYLimitedByP.add(num);
  }
  System.out.println("este mulţimea elementelor din x şi y ce nu depăşesc valoarea p."+xPlusYLimitedByP);



}
