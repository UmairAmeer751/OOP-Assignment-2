package OOPAssignment;
import java.util.Random;

public class DefaultMsgs {

    public void originalMessages(MsgSystem original) {

        Random rand = new Random();

        for (int i = 0; i < original.recNo.length; i++)
        {

            for (int j = 0; j < 10; j++) {

                if (original.count[i] < original.myMsg[i].length) {
                    original.myMsg[i][j] = new Message(original.recNo[i], "Message Sample", rand.nextBoolean());
                    original.count[i]++;
                }

            }

        }

    }

}