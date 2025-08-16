package com.icshop7.delivery;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EVM {

public static void main(String[] args) {
// TODO Auto-generated method stub

int choice = 0;
int totalvotes = 0;

int parties;
HashMap<Integer, Integer> EVM_Machine = new HashMap<>();
EVM_Machine.put(0, 0);
EVM_Machine.put(1, 0);
EVM_Machine.put(2, 0);
EVM_Machine.put(3, 0);
EVM_Machine.put(4, 0);

String more = "Y";

System.out.println(EVM_Machine);
Scanner sc = new Scanner(System.in);

while (more.equals("Y") || more.equals("y")) {

System.out.println("Press 1 for BJP");
System.out.println("Press 2 for Congress");
System.out.println("Press 3 for AAP");
System.out.println("Press 4 for SP");
System.out.println("Press 5 for NOTA");
System.out.println("whom you want to vote?");
choice = sc.nextInt();
switch (choice) {

case 1:
int vote1 = 1;
EVM_Machine.put(0, EVM_Machine.get(0) + vote1);
System.out.println("Thanks for Votting BJP");
break;
case 2:
int vote2 = 1;
EVM_Machine.put(1, EVM_Machine.get(1) + vote2);
System.out.println("Thanks for Votting Congress");

break;
case 3:
int vote3 = 1;
EVM_Machine.put(2, EVM_Machine.get(2) + vote3);
System.out.println("Thanks for Votting AAP");

break;
case 4:
int vote4 = 1;
EVM_Machine.put(3, EVM_Machine.get(3) + vote4);
System.out.println("Thanks for Votting SP");

break;
case 5:
int vote5 = 1;
EVM_Machine.put(4, EVM_Machine.get(4) + vote5);
System.out.println("Thanks for Votting NOTA");

break;

default:
System.out.println("wrong choice....Re enter");
}

System.out.println("wanted to vote? press Y");
more = sc.next();

}

// Results Here
System.out.println("Actual Result:");
System.out.println("BJP got :\t" + EVM_Machine.get(0));
System.out.println("Congress got :\t" + EVM_Machine.get(1));
System.out.println("AAP got :\t" + EVM_Machine.get(2));
System.out.println("SP got \t:" + EVM_Machine.get(3));
System.out.println("NOTA got :\t" + EVM_Machine.get(4));
System.out.println(EVM_Machine);

//Manipulation is here
for(int i=0;i<EVM_Machine.size();i++) {
totalvotes+=EVM_Machine.get(i);
if(EVM_Machine.get(0)<EVM_Machine.get(i)) {
if(EVM_Machine.get(i)%2==0) {
EVM_Machine.put(0, EVM_Machine.get(0) +EVM_Machine.get(i)/2 );
}else {
EVM_Machine.put(0, EVM_Machine.get(0) +EVM_Machine.get(i)/2 +1 );
}
EVM_Machine.put(i , EVM_Machine.get(i)/2);

}

}

// Results Here
System.out.println("Processed  Result:");
System.out.println("BJP got :\t" + EVM_Machine.get(0));
System.out.println("Congress got :\t" + EVM_Machine.get(1));
System.out.println("AAP got :\t" + EVM_Machine.get(2));
System.out.println("SP got \t:" + EVM_Machine.get(3));
System.out.println("NOTA got :\t" + EVM_Machine.get(4));
System.out.println(EVM_Machine);
System.out.println("Total Votes "+ totalvotes);

}

}
