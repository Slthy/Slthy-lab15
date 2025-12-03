public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){         // public constructor

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));   // inner rotor
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));   // middle rotor
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));   // outer rotor
        
    }

    public String encrypt(String message) {
        String output = "";

        for (char c : message.toCharArray()) {                      // for every char in the string
            int step_one = rotors[0].indexOf(c);                    // get the index in the inner rotor
            char step_two = rotors[2].charAt(step_one);             // inner -> outer
            int step_three = rotors[1].indexOf(step_two);           // get the index in the middle rotor
            char step_four = rotors[2].charAt(step_three);          // middle -> outer
            output += step_four;                                    // update output string

            rotate();                                               // rotate
        }
        return output;
    }

    public String decrypt(String message) {
        String output = "";

        for (char c : message.toCharArray()) {
            int step_one = rotors[2].indexOf(c);                    // get the index in the outer rotor
            char step_two = rotors[1].charAt(step_one);             // outer -> middle
            int step_three = rotors[2].indexOf(step_two);           // get the outer in the outer rotor
            char step_four = rotors[0].charAt(step_three);          // outer -> inner
            output += step_four;

            rotate();
        }
        return output.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
}