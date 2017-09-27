public class Main {
    public static void main(String[] args) {
        String a = "123 222 dsfjsdf asdf";
        String[] b = a.split("[ \n]");
        for (String c : b){
            System.out.println(c);
        }
    }
}