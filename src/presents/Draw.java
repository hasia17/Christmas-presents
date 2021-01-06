package presents;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Draw {

    public Draw() {
    }

    private Mysql mysql = new Mysql();
    ArrayList people = mysql.selectEverything();
    MailSender mail = new MailSender();

    public void makeDraw() {

        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> drawnNameList = new ArrayList<String>();
        ArrayList<String> drawingPeopleList = new ArrayList<String>();
        String[][] tableEnd = new String[people.size()][2];
        ArrayList<String> emailList = new ArrayList<String>();

        for (int i = 0; i < people.size(); i++) {
            Person person = (Person) people.get(i);
            String name = person.getName();
            String email = person.getEmail();
            emailList.add(email);
            nameList.add(name);
            drawnNameList.add(name);
            drawingPeopleList.add(name);
        }
        System.out.println(nameList);
        for (int i = 0; i < people.size(); i++) {
            String name = nameList.get(i);
            String email = emailList.get(i);
            tableEnd[i][0] = name;
            String name2 = null;
            name2 = chooseElement(drawingPeopleList, drawnNameList, name);
            tableEnd[i][1] = name2;
            mail.sendMail(email, name, name2);

        }
    }

    private String chooseElement(ArrayList<String> drawingPeopleList, ArrayList<String> drawnNameList, String name) {
        Random random = new Random();
        drawingPeopleList.remove(name);
        drawnNameList.remove(name);
        System.out.println(drawingPeopleList.size());
        String element;
        if (drawingPeopleList.size() == 0) {
            int number = random.nextInt(drawingPeopleList.size() + 1);
            element = drawnNameList.get(number);
        } else {
            int number = random.nextInt(drawingPeopleList.size());
            element = drawnNameList.get(number);
        }
        drawnNameList.add(name);
        drawnNameList.remove(element);
        return element;
    }

}
