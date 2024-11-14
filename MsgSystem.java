package OOPAssignment;

import java.util.Scanner;

public class MsgSystem {

    Scanner sc = new Scanner(System.in);

    String[] recNo = {"Umair", "Safi", "Uzair", "Qasim"};

    static int[] count = {0, 0, 0, 0};

    Message[][] myMsg = new Message[4][500];

    // Send Message Method
    public void sendMsg(String recNo, String content, boolean status) {

        int index = getReceiverIndex(recNo);

        if (index != -1) {
            myMsg[index][count[index]] = new Message(recNo, content, status);
            count[index]++;
            System.out.println("Message sent Successfully .. ");
        } else {
            System.out.println("Incorrect Receiver Name, Message not sent ! ");
        }

    }

    // Get Receiver Index
    public int getReceiverIndex(String recNo) {

        for (int i = 0; i < this.recNo.length; i++) {

            if (this.recNo[i].equalsIgnoreCase(recNo)) {
                return i;
            }

        }

        return -1;

    }

    // Print Contact List
    public void contactList() {

        for (String elem : recNo) {
            System.out.println(elem);
        }

    }

    // Display Messages
    public void displayMessages(Message[] tempMessages, int index, boolean status) {

        for (int j = 0; j < tempMessages.length - 1; j++) {

            for (int k = 0; k < tempMessages.length - 1 - j; k++) {

                if (Integer.parseInt(tempMessages[k].getMessageId()) < Integer.parseInt(tempMessages[k + 1].getMessageId())) {

                    Message temp = tempMessages[k];
                    tempMessages[k] = tempMessages[k + 1];
                    tempMessages[k + 1] = temp;

                }

            }

        }

        for (Message message : tempMessages) {
            System.out.println(message);

            if (status) {
                message.setStatus(true);
            }

        }

        if (status)
            System.out.println(recNo[index] + "'s" + " Messages" + " seen");

    }

    // Receive Messages
    public void receiverMessages() {

        boolean update = false;

        while (true) {

            if (update) {
                break;
            }

            System.out.print("\n\nView Options:-\nEnter 1 to display all the Receiver Messages : \nEnter 2 to view the specific receiver Messages : \nEnter 3 to exit from it: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    for (int i = 0; i < recNo.length; i++) {

                        System.out.println("\nReceiver: " + recNo[i] + " Messages");

                        Message[] tempMessages = new Message[count[i]];

                        for (int j = 0; j < count[i]; j++) {
                            tempMessages[j] = myMsg[i][j];
                        }

                        displayMessages(tempMessages, i, true);

                    }

                    break;

                case 2:
                    contactList();
                    System.out.print("\nEnter the name from the list given above: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    for (int i = 0; i < recNo.length; i++) {

                        if (name.equalsIgnoreCase(recNo[i])) {

                            Message[] temp = new Message[count[i]];

                            for (int j = 0; j < count[i]; j++) {
                                temp[j] = myMsg[i][j];
                            }

                            displayMessages(temp, i, true);

                        }

                    }

                    break;

                case 3:

                    update = true;
                    break;

                default:
                    break;
            }

        }

    }

    public void statusHistory() {

        boolean update = false;

        while (true) {

            if (update) {
                break;
            }

            String name;
            int index;
            System.out.print("\nEnter 1 to view all the seen messages : \nEnter 2 to view the all unseen messages\nEnter 3 to view the the specific person's seen messages\nEnter 4 to view the specific person's unseen messages\nEnter 5 to exit: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    for (int i = 0; i < recNo.length; i++) {

                        int statusCount = 0;
                        int p = 0;

                        System.out.println("\nReceiver: " + recNo[i] + " Messages");

                        for (int y = 0; y < count[i]; y++) {

                            if (myMsg[i][y].getStatus()) {
                                statusCount++;
                            }

                        }

                        Message[] tempMessages = new Message[statusCount];

                        for (int j = 0; j < count[i]; j++) {

                            if (myMsg[i][j].getStatus()) {
                                tempMessages[p] = myMsg[i][j];
                                p++;
                            }

                        }

                        displayMessages(tempMessages, i, false);

                    }

                    break;

                case 2:

                    for (int i = 0; i < recNo.length; i++) {

                        int statusCount = 0;
                        int p = 0;

                        System.out.println("\nReceiver: " + recNo[i] + " Messages");

                        for (int y = 0; y < count[i]; y++) {

                            if (!myMsg[i][y].getStatus()) {
                                statusCount++;
                            }

                        }

                        Message[] tempMessages = new Message[statusCount];

                        for (int j = 0; j < count[i]; j++) {

                            if (!myMsg[i][j].getStatus()) {
                                tempMessages[p] = myMsg[i][j];
                                p++;
                            }

                        }

                        displayMessages(tempMessages, i, false);

                    }

                    break;

                case 3:

                    contactList();
                    System.out.print("\nEnter the name : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    index = getReceiverIndex(name);

                    if (index != -1) {

                        int statusCount = 0;
                        int p = 0;

                        System.out.println("\nReceiver: " + recNo[index] + " Messages");

                        for (int y = 0; y < count[index]; y++) {

                            if (myMsg[index][y].getStatus()) {
                                statusCount++;
                            }

                        }

                        Message[] tempMessages = new Message[statusCount];

                        for (int j = 0; j < count[index]; j++) {

                            if (myMsg[index][j].getStatus()) {
                                tempMessages[p] = myMsg[index][j];
                                p++;
                            }

                        }

                        displayMessages(tempMessages, index, false);

                    } else {
                        System.out.println("You have Entered Incorrect Name ");
                    }

                    break;

                case 4:

                    contactList();
                    System.out.print("\nEnter the name : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    index = getReceiverIndex(name);

                    if (index != -1) {

                        int statusCount = 0;
                        int p = 0;

                        System.out.println("\nReceiver: " + recNo[index] + " Messages");

                        for (int y = 0; y < count[index]; y++) {

                            if (!myMsg[index][y].getStatus()) {
                                statusCount++;
                            }

                        }

                        Message[] tempMessages = new Message[statusCount];

                        for (int j = 0; j < count[index]; j++) {

                            if (!myMsg[index][j].getStatus()) {
                                tempMessages[p] = myMsg[index][j];
                                p++;
                            }

                        }

                        displayMessages(tempMessages, index, false);


                    } else {
                        System.out.println("You have Entered Incorrect Name ");
                    }
                    break;

                case 5:
                    update = true;
                    break;
                default:
                    break;

            }

        }

    }

    // Add Contact
    public void addContact() {

        System.out.print("Enter the new contact name: ");
        String name = sc.nextLine();

        String[] newRecNo = new String[recNo.length + 1];
        int[] newCount = new int[count.length + 1];
        Message[][] newMyMsg = new Message[recNo.length + 1][500];

        for (int i = 0; i < recNo.length; i++) {

            newRecNo[i] = recNo[i];
            newCount[i] = count[i];
            newMyMsg[i] = myMsg[i];

        }

        newRecNo[newRecNo.length - 1] = name;
        newCount[newCount.length - 1] = 0;

        recNo = newRecNo;
        count = newCount;
        myMsg = newMyMsg;

        System.out.println("Your Contact Added Successfully .. ");

    }

    // Delete Contact
    public void deleteContact() {

        contactList();
        System.out.print("Enter the contact name: ");
        String name = sc.nextLine();
        int index = getReceiverIndex(name);
        int j = 0;

        if (index != -1) {

            String[] newRecNo = new String[recNo.length - 1];
            int[] newCount = new int[count.length - 1];
            Message[][] newMyMsg = new Message[recNo.length - 1][500];

            for (int i = 0; i < recNo.length; i++) {

                if (i != index) {

                    newRecNo[j] = recNo[i];
                    newCount[j] = count[i];
                    newMyMsg[j] = myMsg[i];
                    j++;

                }


            }

            recNo = newRecNo;
            count = newCount;
            myMsg = newMyMsg;

            System.out.println("Contact deleted Successfully .. ");

        } else {
            System.out.println("You have Entered Incorrect Name ");
        }

    }

}