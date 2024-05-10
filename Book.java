import java.util.Scanner;

	public class Book {
	    private String title;
	    private String genre;
	    private int pages;
	    private double wordPerPage;
	    private Scanner scanner = new Scanner(System.in);
	    
	    public Book() {
	        title = "title";
	        genre = "genre";
	        pages = 100;
	        wordPerPage = 100;
	    }
	    
	    public Book(String title, String genre, int pages, double wordPerPage) {
	        this.title = title;
	        this.genre = genre;
	        this.pages = pages;
	        this.wordPerPage = wordPerPage;
	    }
	    
	 
	    
	    public String getTitle() {
	        return title;
	    }
	    
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String getGenre() {
	        return genre;
	    }
	    
	    public void setGenre(String genre) {
	        this.genre = genre;
	    }
	    
	    public int getPages() {
	        return pages;
	    }
	    
	    public void setPages(int pages) {
	        this.pages = pages;
	    }
	    
	    public double getWordPerPage() {
	        return wordPerPage;
	    }
	    
	    public void setWordPerPage(double wordPerPage) {
	        this.wordPerPage = wordPerPage;
	    }
	    
	    public void modify() {
	        int choice = 0;
	        while (choice != 6) {
	            printAttributes();
                choice = scanner.nextInt();
                scanner.nextLine();
	            switch (choice) {
	                case 1:
                        checkTitle();
	                    break;
	                case 2:
	                    checkGenre();
	                    break;
	                case 3:
	                    checkPages();
	                    break;
	                case 4:
	                    checkWordPerPage();
	                    break;
	                case 5:
	                    currentData();
	                    break;
	                case 6:
	                    break;
	                default:
	                    Main.printErrorInput();
	                    break;
	            }
	        }
	    }
	    
	    private void checkTitle() {
            String title = scanner.nextLine();
            if (title.length() == 0) {
                System.out.printf("%s %s", incorrectStr(), this.title);
            }
            else {
                setTitle(title);
            }
	    }
	    
	    public void currentData() {
	        System.out.printf("\n%s\n", this);
	    }
	    
	    private void checkGenre() {
            String genre = scanner.nextLine();
            if (genre.length() == 0) {
                System.out.printf("%s %s", incorrectStr(), this.genre);
            }
            else {
                setGenre(genre);
            }
	    }
	    
	    private String incorrectStr() {
	        return "Введена пустая строка, Оставлены предыдущие данные:";
	    }
	    
	    private void checkPages() {
	        int pages = scanner.nextInt();
            scanner.nextLine();
            if (pages <= 0) {
                System.out.printf("%s %d", incorrectNum(), this.pages);
            }
            else {
                setPages(pages);
            }
	    }
	    
	    private void checkWordPerPage() {
	        double wordPerPage = scanner.nextDouble();
            scanner.nextLine();
            if (wordPerPage <= 0) {
                System.out.printf("%s %f", incorrectNum(), this.wordPerPage);
            }
            else {
                setWordPerPage(wordPerPage);
            }	        
	    }
	    
	    private String incorrectNum() {
	        return "Введено число меньшее или равное нулю, Оставлены предыдущие данные:";
	    }
	    
	    public static void printAttributes() {
            System.out.printf("\n1. Название книги\n");
            System.out.printf("2. Жанр\n");
            System.out.printf("3. Количество страниц\n");
            System.out.printf("4. Количестов слов на страницу\n");
            System.out.printf("5. Вывести текущие данные\n");
            System.out.printf("6. Закончить ввод\n");
	    }
	    
	    private double wordCount(int pages, double wordPerPage) {
	        return pages * wordPerPage;
	    }
	    
	    @Override
	    public String toString() {
	        return "Title: " + title + " Genre: " + genre + " Pages: " + pages + " wordPerPage: " + wordPerPage + " wordCount " + wordCount(pages, wordPerPage);
	    }
	
}
