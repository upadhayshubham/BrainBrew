package in.binarybeasts.StringAsPasswords;

public class StringAsPassword {
    public static void main(String[] args) {
        StringAsPassword passwordInString = new StringAsPassword();
        passwordInString.test();
    }

    public void test() {
        String s = "String pass";

        char[] charPass1 = "InMemoryCharPass".toCharArray();
        String[] arr = new String[] {"ArrayPassword"};

        char[] charPass2 = new char[] {'a', 'r', 'e', 'a', 'l','c','h','a','r','p','a', 's','s','w','o','r','d'};

        System.out.print("---------Starting---------");

        try{
            Thread.sleep(500000);
        }catch (InterruptedException e) {
            System.out.print("Interrupted Thread");
        }

        System.out.print("-------Exit--------");
    }
}
