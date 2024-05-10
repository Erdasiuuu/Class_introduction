import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main
{
    private static final int ADD_EMPTY_OBJECT = 1;
    private static final int ADD_OBJECT = 2;
    private static final int EDIT_OBJECT = 3;
    private static final int OUTPUT_LIST = 4;
    private static final int SORT_LIST = 5;
    private static final int EXIT = 6;
    
	public static void main(String[] args) {
        List<Book> book = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != EXIT) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case ADD_EMPTY_OBJECT:
                    book.add(new Book());
                    System.out.printf("\nДобавлена книга со значениями по умолчанию\n\n");
                    break;
                case ADD_OBJECT:
                    Book tmp = new Book();
                    tmp.modify();
                    book.add(tmp);
                    break;
                case EDIT_OBJECT:
                    prepareForEdit(book, scanner);
                    break;
                case OUTPUT_LIST:
                    output(book);
                    break;
                case SORT_LIST:
                    prepToSortList(book, scanner);
                    break;
                case EXIT:
                    break;
                default:
                    printErrorInput();
                    break;
            }
        }
	}
	
  public static void prepToSortList(List<Book> book, Scanner scanner) {
      int size = book.size();
        checkListSize(size);
        if (size != 0) {
            sortList(book, scanner);
        }

    }
    
  public static void sortList(List<Book> book, Scanner scanner) {
        int choice = 0;
      while (choice != 6) {
        Book.printAttributes();
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                book.sort(Comparator.comparing(Book::getTitle));
                break;
            case 2:
                book.sort(Comparator.comparing(Book::getGenre));
                break;
            case 3:
                book.sort(Comparator.comparingInt(Book::getPages));
                break;
            case 4:
                book.sort(Comparator.comparingDouble(Book::getWordPerPage));
                break;
            case 5:
                output(book);
                break;
            case 6:
                break;
            default:
                printErrorInput();
                break;
        }
      }
  }

  public static void output(List<Book> book){
      int size = book.size();
      checkListSize(size);
      for (int i = 0; i < size; i++) {
          System.out.printf("\n%d: %s\n", i + 1, book.get(i));
      }
      if (size != 0) {
        System.out.printf("\n");
      }
  }
  
  public static void prepareForEdit(List<Book> book, Scanner scanner) {
      int choice = 0;
      int size = book.size();
        checkListSize(size);
        if (size != 0) {
            choice = getBookIndex(size, scanner);
            book.get(choice - 1).modify();
        }
  }
  
  public static void printEditMenu() {
    System.out.printf("Введите один из вариантов меню.\n");
    System.out.printf("1. Добавить пустой объект к массиву \n");
    System.out.printf("2. Добавить объект к массиву, заполненный вручную\n");
    System.out.printf("3. Редактировать значения\n");
    System.out.printf("4. Вывод информации про все объекты\n");
    System.out.printf("5. Сортировка массива\n");
    System.out.printf("6. Завершение программы\n");
  }
  
  public static void checkListSize(int size) {
      if (size == 0) {
            System.out.printf("\nНет введенных данных\n\n");
      }
  }
  
  public static int getBookIndex(int size, Scanner scanner) {
      int choice = 0;
      while (choice <= 0 || choice > size) {
          printIndexFindMenu(size);
          choice = scanner.nextInt();
          scanner.nextLine();
          if (choice <= 0 || choice > size) {
              printErrorInput();
          }
      }
      return choice;
  }

  public static void printIndexFindMenu(int size) {
    System.out.printf("\nВведите номер книги. Общее количество книг: %d. Отсчет начинается с 1\n", size);
  }

  public static void printMenu() {
    System.out.printf("Введите один из вариантов меню.\n");
    System.out.printf("1. Добавить пустой объект к массиву \n");
    System.out.printf("2. Добавить объект к массиву, заполненный вручную\n");
    System.out.printf("3. Редактировать значения\n");
    System.out.printf("4. Вывод информации про все объекты\n");
    System.out.printf("5. Сортировка массива\n");
    System.out.printf("6. Завершение программы\n");
  }

  public static void printErrorInput() {
    System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  }
}
