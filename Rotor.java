public class Rotor {

    private String rotorValues;
    private final char startChar;           // remember with what char I started

    public Rotor(String v, char c) {        // public constructor

        this.rotorValues = v;
        this.startChar = c;

        //rotate till the rotor is properly configurated
        while (rotorValues.charAt(0) != startChar) rotate();
    }

    public boolean rotate() {
        char last = rotorValues.charAt(rotorValues.length() - 1);                   // "123456" -> "6"
        rotorValues = last + rotorValues.substring(0, rotorValues.length() - 1);    // "6" + "12345"
        return rotorValues.charAt(0) == startChar;
    }

    public int indexOf(char c) {
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx) {
        return rotorValues.charAt(idx);
    }
}
