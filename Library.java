public class Library {
        public Book books[];

        private int capacity;

        private int bookcount;

        private int s=20;



    public Library(int capacity) {
        this.capacity = capacity;
        books = new Book[capacity];
        bookcount = 0;
    }

        public void addBook(Book book) throws LibraryfullException {
        if (bookcount >= capacity) {
            throw new LibraryfullException("Library is Full cannot add any Books");
        } else {
            books[bookcount] = book;
            bookcount++;
            System.out.println("Book has been added successfully");
            System.out.println("-------------------------");

        }
    }
    public void setRating(double rating,int id)
    {
        Book book=findById(id);
        if(book !=null)
        {
            book.set(rating);
            System.out.println("rating has been set succefully");
        }
        else {
            System.out.println("Book not found select id from following inventory");
            displayInventory();
        }
    }

    public  Book findById(int id)
    {
        for (int i=0;i<bookcount;i++)
        {
            if(books[i]!=null && books[i].getId()==(id))
            {
                return books[i];
            }
        }
        return null;
    }
        public boolean  isIdUnique(int id)
        {
            for(Book book : books) {
                if ( book!=null && book.getId()==id)
                {
                    return false;
                }
            }
            return true;
        }


        public void search(String query) {
        int c = 0;
        if (bookcount != 0) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null && (books[i].getTitle().contains(query) || String.valueOf(books[i].getId()).equals(query) || String.valueOf(books[i].getRating()).equals(query) || books[i].getAuthor().contains(query) || books[i].getBooktype().contains(query) || books[i].getStatus().equals(query))) {
                    c++;
                    System.out.println("ID: " + books[i].getId());
                    System.out.println("Book name: " + books[i].getTitle());
                    System.out.println("Author name: " + books[i].getAuthor());
                    System.out.println("Book rating: "+books[i].getRating());
                    System.out.println("Book type: "+books[i].getBooktype());
                    System.out.println("-------------------------");
                }
            }
            if (c == 0) {
                System.out.println("Book not found. Enter a valid query.");
            }
        } else {
            System.out.println("Inventory is empty. Add a book and try again.");
        }
    }
        public void displayInventory() {
        if (bookcount != 0) {
            for (int i = 0; i < bookcount; i++) {
                if (books[i] != null) {
                    System.out.println("Book Id : " + books[i].getId() + "\nAuthor Name :" + books[i].getAuthor() + " " + "\nBook Name :" + books[i].getTitle()+"\nBook Rating :" + books[i].getRating()+"\nBook status :" + books[i].getStatus());
                    System.out.println("----------------------");
                } else {
                    System.out.println("Inventory is Empty add a book and try again ");
                }
            }
        } else {
            System.out.println("Inventory is Empty ");
            System.out.println("----------------------");
        }

    }

        public void searchByLetter(String letter) {
        int c=0;
        if (bookcount != 0) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null && books[i].getTitle().contains(letter)) {
                    c++;
                    System.out.println("Book name : "+books[i].getTitle()+"\n"+"Author name : "+books[i].getAuthor()+"\n"+"Id : "+books[i].getId());
                }
            }
            if(c==0)
            {
                System.out.println("Book not found enter valid input");
            }
        }
        else {
            System.out.println("Inventory is Empty add a book and try again");
        }
    }
    public void borrowBook(int id)
    {
        int c=0;
        if(bookcount!=0)
        {
            for(int i=0;i<books.length;i++)
            {
                if(books[i]!=null && books[i].getId()==(id) )
                {
                    if(books[i].getStatus()!="Book borrowed") {
                        c++;
                        books[i].setStatus("Book borrowed");
                        System.out.println("Book status has been changed to borrowed");
                        break;
                    }
                    else {
                        System.out.println("Book has already been borrowed");
                    }

                }
            }
            if(c==0)
            {
                System.out.println("Book not found");
            }
        }
        else {
            System.out.println("Inventory is empty try again");
        }
    }
    public void submitBook(int submitid,double setrating)
    {
        int c=0;
        if(bookcount!=0)
        {
            for(int i=0;i<books.length;i++)
            {
                if(books[i]!=null && books[i].getId()==(submitid) )
                {
                    c++;
                    books[i].setStatus("exists");
                    books[i].set(setrating);
                    System.out.println("Book status has been updated succesfully");
                    break;
                }
            }
            if(c==0)
            {
                System.out.println("Book not found");
            }
        }
        else {
            System.out.println("Inventory is empty try again");
        }
    }

        public void removeBook(String title) {
        int c = 0;
        if (bookcount != 0) {

            for (int i = 0; i < books.length; i++) {
                c++;

                if (books[i] != null && books[i].getTitle().equals(title)) {
                    books[i] = null;
                    break;
                }
            }
            if (c == 0) {
                System.out.println("Book not found ");
            } else {
                System.out.println("Book has been Removed succesfully");
                System.out.println("-------------------");
                c = 0;
            }
        } else {
            System.out.println("Inventory is Empty book cannot br removed");
        }
    }

        public void increaseCapacity(int newcapacity) {
        newcapacity=bookcount+newcapacity;
        if (capacity >= newcapacity) {
            System.out.println("new value should be more than given value");
        } else {

            Book newbooks[] = new Book[newcapacity];
            System.arraycopy(books, 0, newbooks, 0, bookcount);
            books = newbooks;
            capacity = newcapacity;
            System.out.println("Library capacity has been incresed");

        }
    }

        public void sortingByAuthor() {

        for (int i = 0; i < bookcount; i++) {
            for (int j = 0; j < bookcount - i - 1; j++) {
                if (books[i]!=null && books[j].getAuthor().compareTo(books[j + 1].getAuthor()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

    }
        public void sortingByBookName() {

        for (int i = 0; i < bookcount; i++) {
            for (int j = 0; j < bookcount - i - 1; j++) {
                if (books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

    }

        public void sortingById() {

        for (int i = 0; i < bookcount; i++) {
            for (int j = 0; j < bookcount - i - 1; j++) {
                if (books[j].getId() > (books[j + 1].getId())) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

    }

    }
