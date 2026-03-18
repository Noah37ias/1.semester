package opg4;

public class NameTest {
    void main(){
        Name name1 = new Name("Margrethe", "Mosbæk", "Dybdahl");
        Name name2 = new Name("Piotr", "Suski");
        IO.println(name1.getFullName());
        IO.println(name2.getFullName());
        //OPG Username print
        IO.println(name1.createUsername());
        IO.println(name2.createUsername());
        //OPG Initials print
        IO.println(name1.getInitials());
        IO.println(name2.getInitials());

        IO.println(name1.getCryptoInitials(20));
        IO.println(name2.getCryptoInitials(2));

    }

}
