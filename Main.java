
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.---...............
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Capacity of Library");
        System.out.print("Enter carefully")

        int capacity = 0;
        boolean invalidInput = false;

        while (!invalidInput) {
            try {
                capacity = scanner.nextInt();
                invalidInput = true;
            } catch (Exception e) {
                System.out.println("Invalid Input please enter only numbers ");
                System.out.println("Enter Capacity of Library");
                scanner.nextLine();
            }
        }
        Library library = new Library(capacity);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book");
            System.out.println("3. Display inventory");
            System.out.println("4. Search by letter");
            System.out.println("5. Remove a book");
            System.out.println("6. Sort by author name and display inventory");
            System.out.println("7. Sort by book name and display inventory");
            System.out.println("8. Sort by id name and display inventory");
            System.out.println("9. set rating for a book");
            System.out.println("10. calculate rent for a book");
            System.out.println("11. Borrow a book");
            System.out.println("12. Display all borrowed books");
            System.out.println("13. submit the borrowed book");
            System.out.println("14. Exit");

            System.out.println("-------------------");

//                    System.out.println("#########/#############");
//                scanner.nextLine();
//                    System.out.println("######################");

            String choice = scanner.next();
//                 scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.println("Enter book ID:");
                        int id = 0;

                        invalidInput = false;

                        while (!invalidInput) {
                            try {
                                id = scanner.nextInt();
                                if(library.isIdUnique(id))
                                {
                                    invalidInput=true;
                                }
                                else {
                                    System.out.println("Id is already declared, enter different id from the inventory");
                                    library.displayInventory();
                                    System.out.println("Enter book id");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid Input please enter only numbers ");
                                System.out.println("Enter book id");
                                scanner.nextLine();
                            }
                        }
                        scanner.nextLine();

                        System.out.println("To choose type of book enter your choice :");
                        System.out.println("1. computer science department books");
                        System.out.println("2. mechancial department books");
                        System.out.println("3. electrical department books");
                        System.out.println("4. electronics  department books");
                        System.out.println("5. civil department books");
                        String booktype = "";
                        int input= scanner.nextInt();


                        switch (input)
                        {
                            case 1:
                                booktype="CSE";
                                break;
                            case 2:
                                booktype="MECHANICAL";
                                break;
                            case 3:
                                booktype="ELECTRICAL";
                                break;
                            case 4:
                                booktype="ELECTRONICS";
                                break;
                            case 5:
                                booktype="CIVIL";
                                break;
                            default:
                                System.out.println("invalid inputs try again");
                                break;

                        }
                        scanner.nextLine();

                        System.out.println("Enter book title:");
                        String title = scanner.nextLine();

                        System.out.println("Enter book author:");
                        String author = scanner.nextLine();

                        System.out.println("Enter rent per day:");
                        System.out.println("rent for CSE books :        15 ruppes");
                        System.out.println("rent for MECHANICAL books : 25 ruppes");
                        System.out.println("rent for ECE books :        35 ruppes");
                        System.out.println("rent for CSE books :        10 ruppes");
                        double rentperday=0;
                        boolean example2=false;
                        while(!example2) {
                            try {
                                rentperday = scanner.nextDouble();
                                example2 = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Enter valid rent");
                                System.out.println("Enter rent per day:");
                                scanner.nextLine();
                            }
                        }

                        library.addBook(new Book(id,booktype,title,author,rentperday));
                    } catch (LibraryfullException e) {
                        System.out.println("Library is full cannot add any books");
                        System.out.println("if you want to increase the capacity of Library, press 1 or press any number");
                        String choice1 = scanner.next();
                        switch (choice1) {
                            case "1":
                                System.out.println("How much capacity of library, do you want to increase ?");
                                int newcapacity = scanner.nextInt();
                                library.increaseCapacity(newcapacity);
                            case "2":
                                break;
                        }
                    }
                    break;
                case "2":
                    boolean examp=false;
                        while (!examp) {
//                        System.out.println("1. search by id");
//                        System.out.println("2. search by Author name");
//                        System.out.println("3.search by Book name");
                        int option = 0;
                        boolean k = false;
                        while (!k) {
                            System.out.println("1. search by id");
                            System.out.println("2. search by Author name");
                            System.out.println("3. search by Book name");
                            System.out.println("4. search by Book rating");
                            System.out.println("5. search by Book type");
                            try {
                                option = scanner.nextInt();
                                k = true;
                            } catch (InputMismatchException e) {
                                System.out.println("please give valid input, enter only numbers");
                                scanner.nextLine();
                            }
                        }
                        switch (option) {
                            case 1:
                                System.out.println("Enter id to search a book");
                                scanner.nextLine();
                                    String searchid = scanner.nextLine();
                                   library.search(searchid);
                                break;

                            case 2:
                                ///search by author
                                System.out.println("Enter Author Name of the book to search:");
                                scanner.nextLine();

                                    String searchAuthor = scanner.nextLine();
                                   library.search(searchAuthor);
                              examp=true;
                                break;

                            case 3:
                                //search by book title
                                System.out.println("Enter the title of the book to search:");
                                scanner.nextLine();
                                String searchTitle = scanner.nextLine();
                              library.search(searchTitle);
                              examp=true;
                                break;
                            case 4:
                                System.out.println("Enter rating of book  to search");
                                scanner.nextLine();
                                String searchbyrating = scanner.nextLine();
                                try {
                                    if(Double.parseDouble(searchbyrating) < 1 && Double.parseDouble(searchbyrating) > 5)
                                    {
                                        throw new Illegalratingexception("rating should be between 1 and 5");
                                    }
                                    library.search(searchbyrating);
                                } catch (IllegalStateException e) {
                                    System.out.println(e.getMessage());
                                    examp=true;
                                }
                                catch (Illegalratingexception e)
                                {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                System.out.println("Enter book type to search");
                                scanner.nextLine();
                                String searchbybooktype= scanner.next();
                                library.search((searchbybooktype));
                                examp=true;
                                break;

                            default:
                                System.out.println("Invalid input, please enter valid input");
                                break;
                        }
                            System.out.println("Enter any key to enter console");
                            scanner.nextLine();

                            examp=true;
                    }
                    break;
                case "3":
                    library.displayInventory();
                    break;
                case "4":

                    System.out.println("Enter partial or full book title to search book");
                    String letter = scanner.next();
                    library.sortingByBookName();
                    library.searchByLetter(letter);
                    break;

                case "5":
                    System.out.println("Enter the book title");
                    String title = scanner.next();
                    library.removeBook(title);
                    break;
                case "6":
                    library.sortingByAuthor();
                    library.displayInventory();
                    break;
                case "7":
                    library.sortingByBookName();
                    library.displayInventory();
                    break;
                case "8":
                    library.sortingById();
                    library.displayInventory();
                    break;

                case "9":
                    int id=0;
                    double rating=0;
                    boolean invalid=false;
                    while(!invalid) {
                        try {
                            System.out.println("Enter id");
                            id = scanner.nextInt();
                            System.out.println("Enter rating out of 5");
                            rating = scanner.nextDouble();
                            if (rating < 1 || rating > 5) {
                                throw new Illegalratingexception("rating should be between 1 and 5");
                            }
                            invalid = true;
                        } catch (InputMismatchException e) {
                            System.out.println("invalid id enter valid id");
                            System.out.println("Enter id");
                            scanner.nextLine();
                        } catch (Illegalratingexception e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    scanner.nextLine();
                    library.setRating(rating,id);
                    break;
                case "10":
                    boolean example=false;
                    while(!example) {

                        int bookid = 0;
                        int numberOfDays=0;
                        try {
                            System.out.println("Enter Book id to calculate rent");
                            bookid = scanner.nextInt();
                            System.out.println("Enter the number of days to rent:");
                            numberOfDays = scanner.nextInt();
                            example = true;
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Enter valid input");
                            scanner.nextLine();
                        }
                        scanner.nextLine();
                        Book book=library.findById(bookid);
                        if (book != null) {
                            double rent = book.calculateRent(numberOfDays);
                            System.out.println("The rent for the book is: " + rent+" rupees");
                        } else {
                            System.out.println("Book not found.");
                        }
                    }
                    break;
                case "11":
                    boolean example1=false;
                    while(!example1) {

                        int bookid = 0;

                        try {
                            System.out.println("Enter Book id to borrow the book");
                            bookid = scanner.nextInt();
                            example1 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Enter valid input");
                            scanner.nextLine();
                        }
                        scanner.nextLine();
                        library.borrowBook(bookid);
                    }
                    break;
                case "12":
//                    System.out.println("Display all borrowed books");
                    String query="Book borrowed";
                    library.search(query);
                    break;
                case "13":
                    System.out.println("Enter id of the book to be submitted");
                    boolean example3=false;
                    while(!example3) {

                        int submitbookid = 0;
                        double setrating=0;

                        try {
                            System.out.println("Enter Book id to submit the book");
                            submitbookid = scanner.nextInt();
                            System.out.println("Enter your rating for the book out of 5");
                            setrating=scanner.nextDouble();
                            example3 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Enter valid input");
                            scanner.nextLine();
                        }
                        scanner.nextLine();
                        library.submitBook(submitbookid,setrating);

                    }
                    break;
                case "14":
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

}



