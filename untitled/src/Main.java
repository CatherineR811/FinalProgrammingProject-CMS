//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Initializing of prior student data
            ArrayList<String> studentFirstNames = new ArrayList<>();
            studentFirstNames.add("Jeff"); studentFirstNames.add("John"); studentFirstNames.add("Rob"); studentFirstNames.add("Greg"); studentFirstNames.add("Tommy");
            ArrayList<String> studentLastNames = new ArrayList<>();
            studentLastNames.add("Jefferson"); studentLastNames.add("Johnson"); studentLastNames.add("Robertson"); studentLastNames.add("Greggerson"); studentLastNames.add("Thompson");
            ArrayList<Double> studentGrades = new ArrayList<>();
            studentGrades.add(65.00); studentGrades.add(70.00); studentGrades.add(99.00); studentGrades.add(51.0); studentGrades.add(23.0);
        //Greeting message
            System.out.println("\nWelcome to the course management system!");
        //Main menu
            System.out.println("\nPlease refer to the main menu:\n  1. Add a student\n  2. Average of class marks\n  3. Minimum and maximum mark in the class\n  4. Display the list of students\n  5. Display the mark distribution\n  6. Search a student\n  7. Display the top and bottom 20%\n  8. Exit the program");
        //User input
            System.out.println("Enter the number corresponding to the item you would like to check:"); int userMenuResponse = Integer.parseInt(sc.nextLine());
            while (userMenuResponse != 8) {
                int studentIDNum = -1;
                //Finding average of class marks (is needed for case 2 and 6)
                    double totalGradesAdded = 0;
                    for (int b = 0; b < studentGrades.size(); b++) {
                        totalGradesAdded += studentGrades.get(b);
                    }
                    double averageGrade = totalGradesAdded/studentGrades.size();
                switch (userMenuResponse) {
                    //Add a student
                        case 1:
                            String addAnotherStudentUserResponse = "yes";
                            int studentAddedCounter = 0;
                            while (addAnotherStudentUserResponse.equalsIgnoreCase("yes") && studentAddedCounter < 2) {
                                //Adding student information
                                    System.out.println("\nEnter the student's first name:"); studentFirstNames.add(sc.nextLine());
                                    System.out.println("Enter the student's last name:"); studentLastNames.add(sc.nextLine());
                                    System.out.println("Enter the student's mark:"); studentGrades.add(Double.parseDouble(sc.nextLine()));
                                studentAddedCounter++;
                                addAnotherStudentUserResponse = "";
                                //Adding another student, yes or no?
                                    while (studentAddedCounter < 2 && !addAnotherStudentUserResponse.equalsIgnoreCase("no") && !addAnotherStudentUserResponse.equalsIgnoreCase("yes")) {
                                        System.out.println("Would you like to add another student? Enter yes or no.");
                                        //Error checking for proper question input
                                            while (!addAnotherStudentUserResponse.equalsIgnoreCase("no") && !addAnotherStudentUserResponse.equalsIgnoreCase("yes")) {
                                                addAnotherStudentUserResponse = sc.nextLine();
                                                if (!addAnotherStudentUserResponse.equalsIgnoreCase("no") && !addAnotherStudentUserResponse.equalsIgnoreCase("yes")) {
                                                    System.out.println("Neither yes or no were entered. Please enter yes or no.");
                                                }
                                            }
                                    }
                            }
                            break;
                    //Print average of class marks
                        case 2:
                            System.out.println("\nAverage Grade of the Class: " + averageGrade);
                            break;
                    //Maximum and minimum grades in the class
                        case 3:
                            //Initializing max and min grades and student IDs
                                double maxGrade = studentGrades.get(0);
                                double minGrade = studentGrades.get(0);
                            //Finding max and min grades
                                for (int c = 0; c < studentGrades.size(); c++) {
                                    if (studentGrades.get(c) > maxGrade) {
                                        maxGrade = studentGrades.get(c);
                                    } else if (studentGrades.get(c) < minGrade) {
                                        minGrade = studentGrades.get(c);
                                    }
                                }
                            //Printing of max and min students
                                System.out.println("\n  Maximum Grade: " + maxGrade + "\n  Student's First Name: " + studentFirstNames.get(studentGrades.indexOf(maxGrade)) + "\n  Student's Last Name: " + studentLastNames.get(studentGrades.indexOf(maxGrade)) + "\n  Student's ID Number: " + studentGrades.indexOf(maxGrade));
                                System.out.println("\n  Minimum Grade: " + minGrade + "\n  Student's First Name: " + studentFirstNames.get(studentGrades.indexOf(minGrade)) + "\n  Student's Last Name " + studentLastNames.get(studentGrades.indexOf(minGrade)) + "\n  Student's ID Number: " + studentGrades.indexOf(minGrade));
                            break;
                    //Display the list of the students
                        case 4:
                            //Printing student information
                                for (int d = 0; d < studentLastNames.size(); d++) {
                                    System.out.println("\n  Student's ID Number: " + d + "\n  Student's First Name: " + studentFirstNames.get(d) + "\n  Student's Last Name: " + studentLastNames.get(d) + "\n  Student's Grade: " + studentGrades.get(d));
                                }
                            //Sub menu
                                System.out.println("\nPlease refer to the sub menu: \n  1) Edit a student \n  2) Remove a student \n  3) Return to the main menu");
                            //Sub menu user input
                                System.out.println("Enter the number corresponding to the item you would like to check:"); int userSubMenuResponse = Integer.parseInt(sc.nextLine());
                            while (userSubMenuResponse != 3) {
                                switch (userSubMenuResponse) {
                                    //Edit a student
                                        case 1:
                                            System.out.println("\nEnter the student's ID number: "); studentIDNum = Integer.parseInt(sc.nextLine());
                                            System.out.println("Enter the student's new first name:"); studentFirstNames.set(studentIDNum, sc.nextLine());
                                            System.out.println("Enter the student's new last name:"); studentLastNames.set(studentIDNum, sc.nextLine());
                                            System.out.println("Enter the student's new grade:"); studentGrades.set(studentIDNum, Double.parseDouble(sc.nextLine()));
                                            System.out.println("\nNew student information: \n  Student's ID Number: " + studentIDNum + "\n  Student's First Name: " + studentFirstNames.get(studentIDNum) + "\n  Student's Last Name: " + studentLastNames.get(studentIDNum) + "\n  Student's Grade: " + studentGrades.get(studentIDNum));
                                            break;
                                    //Remove a student
                                        case 2:
                                            //Removing student
                                                System.out.println("\nEnter the student's ID number: ");studentIDNum = Integer.parseInt(sc.nextLine());
                                                System.out.println("Student " + studentFirstNames.get(studentIDNum) + " " + studentLastNames.get(studentIDNum) + " was removed.");
                                                studentFirstNames.remove(studentIDNum); studentLastNames.remove(studentIDNum); studentGrades.remove(studentIDNum);
                                            //New list of students
                                                System.out.println("\nNew list of students:");
                                                for (int e = 0; e < studentLastNames.size(); e++) {
                                                    System.out.println("  Student's ID Number: " + e + "\n  Student's First Name: " + studentFirstNames.get(e) + "\n  Student's Last Name: " + studentLastNames.get(e) + "\n  Student's Grade: " + studentGrades.get(e));
                                                    if (e < studentLastNames.size() - 1)
                                                        System.out.print("\n");
                                                }
                                                break;
                                    //Error checking for proper sub menu input
                                        default:
                                            System.out.println("Invalid number entered. Please reread the instructions.");
                                            break;
                                }
                                //Sub menu
                                System.out.println("\nPlease refer to the sub menu: \n  1) Edit a student \n  2) Remove a student \n  3) Return to the main menu");
                                //Sub menu user input
                                System.out.println("Enter the number corresponding to the item you would like to check:");userSubMenuResponse = Integer.parseInt(sc.nextLine());
                            }
                            break;
                    //Display the mark distribution
                        case 5:
                            //Finding number of students with each grade (A, B, C, D, F)
                                int numOfAStudents = 0; int numOfBStudents = 0; int numOfCStudents = 0; int numOfDStudents = 0; int numOfFStudents = 0;
                                for (int f = 0; f < studentLastNames.size(); f++) {
                                    if (studentGrades.get(f) >= 80) {
                                        numOfAStudents++;
                                    } else if (studentGrades.get(f) >= 70) {
                                        numOfBStudents++;
                                    } else if (studentGrades.get(f) >= 60) {
                                        numOfCStudents++;
                                    } else if (studentGrades.get(f) >= 50) {
                                        numOfDStudents++;
                                    } else {
                                        numOfFStudents++;
                                    }
                                }
                            //Placing number of students with each grade (A, B, C, D, F) in an arraylist
                                ArrayList<Integer> numOfABCDFStudents = new ArrayList<>();
                                numOfABCDFStudents.add(numOfAStudents); numOfABCDFStudents.add(numOfBStudents); numOfABCDFStudents.add(numOfCStudents);numOfABCDFStudents.add(numOfDStudents);numOfABCDFStudents.add(numOfFStudents);
                            //Finding which grade has the greatest amounts of students
                                int maxNumOfStudents = 0;
                                for (int g = 0; g < numOfABCDFStudents.size(); g++) {
                                    if (maxNumOfStudents < numOfABCDFStudents.get(g))
                                        maxNumOfStudents = numOfABCDFStudents.get(g);
                                }
                            //Printing graph
                                System.out.println("\n A\tB\tC\tD\tF ");
                                System.out.println("------------------");
                                for (int h = 1; h <= maxNumOfStudents; h++) {
                                    if (numOfAStudents >= h) {
                                        System.out.print(" █\t");
                                    } else {
                                        System.out.print(" \t");
                                    }
                                    if (numOfBStudents >= h) {
                                        System.out.print("█\t");
                                    } else {
                                        System.out.print(" \t");
                                    }
                                    if (numOfCStudents >= h) {
                                        System.out.print("█\t");
                                    } else {
                                        System.out.print(" \t");
                                    }
                                    if (numOfDStudents >= h) {
                                        System.out.print("█\t");
                                    } else {
                                        System.out.print(" \t");
                                    }
                                    if (numOfFStudents >= h) {
                                        System.out.print("█");
                                    } else {
                                        System.out.print(" \t");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("\n█ = one student");
                             break;
                    //Search a student
                        case 6:
                            //Entering student name and finding student
                                System.out.println("\nEnter the student's first, last, or part of first or last name:"); String studentName = sc.nextLine().toLowerCase();
                                for (int i = 0; i < studentFirstNames.size(); i++) {
                                    if (studentFirstNames.get(i).toLowerCase().contains(studentName)) {
                                        studentIDNum = i;
                                    } else if (studentLastNames.get(i).toLowerCase().contains(studentName)) {
                                        studentIDNum = i;
                                    }
                                }
                            //Message is no student is found
                                if (studentIDNum == -1) {
                                    System.out.println("Student matching inputted name was not found.");
                            //Printing found student information
                                } else {
                                    System.out.println("\nStudent found:\n  Student's ID Number: " + studentIDNum + "\n  Student's First Name: " + studentFirstNames.get(studentIDNum) + "\n  Student's Last Name: " + studentLastNames.get(studentIDNum) + "\n  Student's Grade: " + studentGrades.get(studentIDNum));
                                    if (studentGrades.get(studentIDNum) > averageGrade) {
                                        System.out.println("  Student is above the class average.");
                                    } else if (studentGrades.get(studentIDNum) < averageGrade) {
                                        System.out.println("  Student is below the class average.");
                                    } else {
                                        System.out.println("  Student is equal to the class average.");
                                    }
                                }
                            break;
                    //Display the top and bottom 20%
                        case 7:
                            //Finding the number of 20% of students
                                int numOfStudentsAtTopAndBottom = (int)Math.ceil(studentLastNames.size()/5.00);
                            //Finding the top grade and student ID
                                System.out.println("\nTop 20%:");
                                double lastTopStudentGrade = studentGrades.get(0);
                                int topStudentIDNum = 0;
                                for (int j = 0; j < studentGrades.size(); j++) {
                                    if (lastTopStudentGrade < studentGrades.get(j)) {
                                        lastTopStudentGrade = studentGrades.get(j);
                                        topStudentIDNum = j;
                                    }
                                }
                            //Printing and finding other top 20%
                                for (int k = 1; k <= numOfStudentsAtTopAndBottom; k++) {
                                    System.out.println("  Student's ID Number: " + topStudentIDNum + "\n  Student's First Name: " + studentFirstNames.get(topStudentIDNum) + "\n  Student's Last Name: " + studentLastNames.get(topStudentIDNum) + "\n  Student's Grade: " + studentGrades.get(topStudentIDNum) + "\n");
                                    double newTopStudentGrade = studentGrades.get(0);
                                    for (int l = 0; l < studentGrades.size(); l++) {
                                        if (newTopStudentGrade < studentGrades.get(l) && studentGrades.get(l) < lastTopStudentGrade) {
                                            newTopStudentGrade = studentGrades.get(l);
                                            topStudentIDNum = l;
                                        }
                                    }
                                    lastTopStudentGrade = newTopStudentGrade;
                                }
                            //Finding the bottom grade and student ID
                                System.out.println("Bottom 20%:");
                                double lastBottomStudentGrade = studentGrades.get(0);
                                int bottomStudentIDNum = 0;
                                for (int m = 0; m < studentGrades.size(); m++) {
                                    if (lastBottomStudentGrade > studentGrades.get(m)) {
                                        lastBottomStudentGrade = studentGrades.get(m);
                                        bottomStudentIDNum = m;
                                    }
                                }
                            //Printing and finding other bottom 20%
                                for (int n = 1; n <= numOfStudentsAtTopAndBottom; n++) {
                                    System.out.println("  Student's ID Number: " + bottomStudentIDNum + "\n  Student's First Name: " + studentFirstNames.get(bottomStudentIDNum) + "\n  Student's Last Name: " + studentLastNames.get(bottomStudentIDNum) + "\n  Student's Grade: " + studentGrades.get(bottomStudentIDNum));
                                    double newBottomStudentGrade = studentGrades.get(0);
                                    for (int o = 0; o < studentGrades.size(); o++) {
                                        if (newBottomStudentGrade > studentGrades.get(o) && studentGrades.get(o) > lastBottomStudentGrade) {
                                            newBottomStudentGrade = studentGrades.get(o);
                                            bottomStudentIDNum = o;
                                        }
                                    }
                                    lastBottomStudentGrade = newBottomStudentGrade;
                                    //For spacing (i like good spacing)
                                        if (n < numOfStudentsAtTopAndBottom)
                                            System.out.print("\n");
                                }
                            break;
                    //Error checking for proper main menu input
                        default:
                            System.out.println("Invalid number entered. Please reread the instructions.");
                            break;
                }
                //Main menu
                    System.out.println("\nPlease refer to the main menu:\n  1. Add a student\n  2. Average of class marks\n  3. Minimum and maximum mark in the class\n  4. Display the list of students\n  5. Display the mark distribution\n  6. Search a student\n  7. Display the top and bottom 20%\n  8. Exit the program");
                //User input
                    System.out.println("Enter the number corresponding to the item you would like to check:"); userMenuResponse = Integer.parseInt(sc.nextLine());
            }
        //Parting message
            System.out.println("\nThank you for using the course management system!");
        sc.close();
    }
}