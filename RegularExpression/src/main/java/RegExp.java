import lombok.Data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Data
public class RegExp {
    String[] alphabet = {"a", "b", "c", "(", ")", "*", "U"};
    String str;
    int len;

    public RegExp(int len){
        this.len = len;
        this.str = generation(len);
    }

    public String generation(int len){
        String str = "";
        String strtest = "";
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < len; i++){
            arrayList.add(alphabet[random.nextInt(0,7)]);
        }

        for(int i = 0; i < arrayList.size(); i++){
            strtest += arrayList.get(i);
        }
        System.out.println(strtest);


        ArrayList<String> scob = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == "(") {
                scob.add("(");
            }
            if (arrayList.get(i) == ")") {
                if (scob.size() == 0) {
                    arrayList.remove(i);
                } else {
                    scob.remove(scob.size()-1);
                }
            }
        }
        if (scob.size() != 0) {
            for (int i = arrayList.size() - 1; i > 0; i--) {
                if (arrayList.get(i) == "(") {
                    arrayList.remove(i);
                    break;
                }
            }
        }
        if (arrayList.get(arrayList.size()-1) == "(") {
            arrayList.remove(arrayList.size()-1);
        }

        int countscob = 0;
        String onescob = "";
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).equals(")")) {
                if (onescob.length() == 0) {
                    onescob += ")";
                }
            } else if (arrayList.get(i).equals("(")) {
                if (onescob.length() == 0) {
                    onescob += "(";
                }
            }
        }
        if (onescob == ")") {
            arrayList.add(0, "(");
        }
        if (arrayList.get(0) == ")") {
            while (arrayList.get(0) == ")") {
                arrayList.remove(0);
            }
        }
        if (countscob == 0 && onescob == ")") {
            arrayList.add(0, "(");
            arrayList.add(")");
        }
        for(int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).equals(")")) {
                countscob++;
                if (onescob.length() == 0) {
                }
            } else if (arrayList.get(i).equals("(")) {
                countscob--;
                if (onescob.length() == 0) {
                }
            }
        }
        //System.out.println(onescob);
        //System.out.println(countscob);
        while (countscob != 0){
            if (countscob > 0) {
                arrayList.add(0, "(");
                countscob--;
            } else if (countscob < 0) {
                arrayList.add(")");
                countscob++;
            }
        }



        if(arrayList.get(0) == "*") {
            while (arrayList.get(0) == "*") {
                arrayList.remove(0);
            }
        }
        String alphzv = "*U(";
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == "*") {
                if (alphzv.contains(arrayList.get(i-1))) {
                    arrayList.remove(i);
                    i--;
                }
            }
        }


        if(arrayList.get(0) == "U") {
            while (arrayList.get(0) == "U") {
                arrayList.remove(0);
            }
        }
        if (arrayList.get(arrayList.size()-1) == "U") {
            while (arrayList.get(arrayList.size()-1) == "U") {
                arrayList.remove(arrayList.size()-1);
            }
        }
        String minialph1 = "(U*";
        String minialph2 = ")U*";
        for (int i = 1; i < arrayList.size() - 1; i++) {
            if ((arrayList.get(i) == "U") && (minialph1.contains(arrayList.get(i-1)))) {
                arrayList.remove(i);
                i--;
            }
            if ((arrayList.get(i) == "U") && (minialph2.contains(arrayList.get(i+1)))) {
                arrayList.remove(i);
                i--;
            }
        }

















        for(int i = 0; i < arrayList.size(); i++){
            str += arrayList.get(i);
        }
        return str;
    }

    public String getStr() {
        return str;
    }
    public void fileWrite(BufferedWriter writer, String rw) throws IOException {
        writer.write(rw);
        writer.write("\n");
    }
}
