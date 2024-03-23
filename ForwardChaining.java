import java.util.HashMap;
import java.util.Map;

public class ForwardChaining {
    public static void main(String[] args) {
        Map<String, Boolean> facts = new HashMap<>();
        
        System.out.println("Variabel\t: A, B, C, D, E, F, G, H, I, J, K");
        System.out.println("Rules:\n"+
                        "\t- R1: If A and B then C \n"+
                        "\t- R2: If C then D \n"+
                        "\t- R3: If A and E then F \n"+
                        "\t- R4: If A then G \n"+
                        "\t- R5: If F and G then D \n"+
                        "\t- R6: If G and E then H \n"+
                        "\t- R7: If C and H then I \n"+ 
                        "\t- R8: If I and A then J \n"+
                        "\t- R9: If G then J \n"+
                        "\t- R10: If J then K \n");
        System.out.println("Fakta awal diberikan A dan E bernilai benar. Tentukan apakah K bernilai benar?\n");

        facts.put("A", true);
        facts.put("E", true);

        while (true) {
            boolean updated = false;
            if (facts.containsKey("A") && facts.containsKey("B") && !facts.containsKey("C")) {
                facts.put("C", true);
                updated = true;
            }
            if (facts.containsKey("C") && !facts.containsKey("D")) {
                facts.put("D", true);
                updated = true;
            }
            if (facts.containsKey("A") && facts.containsKey("E") && !facts.containsKey("F")) {
                facts.put("F", true);
                updated = true;
            }
            if (facts.containsKey("A") && !facts.containsKey("G")) {
                facts.put("G", true);
                updated = true;
            }
            if (facts.containsKey("F") && facts.containsKey("G") && !facts.containsKey("D")) {
                facts.put("D", true);
                updated = true;
            }
            if (facts.containsKey("G") && facts.containsKey("E") && !facts.containsKey("H")) {
                facts.put("H", true);
                updated = true;
            }
            if (facts.containsKey("C") && facts.containsKey("H") && !facts.containsKey("I")) {
                facts.put("I", true);
                updated = true;
            }
            if (facts.containsKey("I") && facts.containsKey("A") && !facts.containsKey("J")) {
                facts.put("J", true);
                updated = true;
            }
            if (facts.containsKey("G") && !facts.containsKey("J")) {
                facts.put("J", true);
                updated = true;
            }
            if (facts.containsKey("J") && !facts.containsKey("K")) {
                facts.put("K", true);
                updated = true;
            }

            if (!updated) {
                break;
            }
        }

        System.out.println("Nilai K: " + facts.getOrDefault("K", false));
    }
}
