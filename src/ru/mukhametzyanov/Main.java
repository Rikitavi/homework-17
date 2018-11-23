package ru.mukhametzyanov;

import java.io.*;
import java.util.Objects;

public class Main {
    /**
     * Добавление книги в библиотеку
     *
     * @param book
     * @param dir
     */
    public static void addBook(Book book, File dir) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(dir, book.getNameBook() + ".txt")))) {
            dos.writeUTF(book.getNameBook());
            dos.writeUTF(book.getAuthor());
            dos.writeInt(book.getYear());
            dos.writeUTF(book.getContentsOfTheBook());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Распечатка содержимого библиотеки
     *
     * @param dir
     */
    public static void printAllBooks(File dir) {
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            Book currentBook = getBook(file);
            System.out.println(currentBook);
        }

    }

    /**
     * Получение книги из библиотеки
     *
     * @param fileName
     * @return
     */
    public static Book getBook(File fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            String name = dis.readUTF();
            String author = dis.readUTF();
            int year = dis.readInt();
            String countersOfTheBook = dis.readUTF();

            Book book = new Book();
            book.setNameBook(name);
            book.setAuthor(author);
            book.setYear(year);
            book.setContentsOfTheBook(countersOfTheBook);
            return book;
        } catch (FileNotFoundException e) {
            System.out.println("Книга не найдена!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        File dir = new File("library");
        dir.mkdir();

        Main.addBook(new Book("Война и мир", "Л. Н. Толстой", 1873, "Something"), dir);
        Main.addBook(new Book("Капитаниская дочка", "А. С. Пушкмин", 11293, "Something"), dir);
        Main.addBook(new Book("Мцыри", "Н. Ю. Лермонтов", 18273, "Something"), dir);

        Main.printAllBooks(dir);
    }
}