package unisex;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnisexBathroom {
    private final Lock lock = new ReentrantLock();
    private int menCount = 0;
    private int womenCount = 0;

    private static final String MALE = "M";
    private static final String FEMALE = "F";

    public void enterBathroom(String gender) {
        lock.lock();
        try {
            if (MALE.equalsIgnoreCase(gender)) {
                enterMale();
            } else if (FEMALE.equalsIgnoreCase(gender)) {
                enterFemale();
            } else {
                System.out.println("Invalid gender specified.");
            }
        } finally {
            lock.unlock();
        }
    }

    private void enterMale() {
        if (menCount < 3 && womenCount == 0) {
            menCount++;
            System.out.println("Male entered the bathroom. Total Men: " + menCount);
        } else {
            System.out.println("Male is in the queue or bathroom is occupied by females.");
        }
    }

    private void enterFemale() {
        if (womenCount < 2 && menCount == 0) {
            womenCount++;
            System.out.println("Female entered the bathroom. Total Women: " + womenCount);
        } else {
            System.out.println("Female is in the queue or bathroom is occupied by males.");
        }
    }

    public void exitBathroom(String gender) {
        lock.lock();
        try {
            if (MALE.equalsIgnoreCase(gender)) {
                exitMale();
            } else if (FEMALE.equalsIgnoreCase(gender)) {
                exitFemale();
            } else {
                System.out.println("Invalid gender specified.");
            }
        } finally {
            lock.unlock();
        }
    }

    private void exitMale() {
        if (menCount > 0) {
            menCount--;
            System.out.println("Male exited the bathroom. Total Men: " + menCount);
        } else {
            System.out.println("No males currently in the bathroom.");
        }
    }

    private void exitFemale() {
        if (womenCount > 0) {
            womenCount--;
            System.out.println("Female exited the bathroom. Total Women: " + womenCount);
        } else {
            System.out.println("No females currently in the bathroom.");
        }
    }
}


