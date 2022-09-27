package test.java;

import main.polls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static main.polls.createPoll;
import static org.junit.jupiter.api.Assertions.*;

class pollsTest {
    @Test
    @DisplayName("parameter Validation")
    @Order(1)
    void test_1() {
        String[] l_options = {};
        assertThrows(Exception.class, () -> {
            polls.parameterValidation(l_options);
        });
        String[] l_options_2 = {"", "", "", "", "","",""};
        assertThrows(Exception.class, () -> {
            polls.parameterValidation(l_options_2);
        });

    }

    @Test
    @DisplayName("Question Mark Test")
    @Order(2)
    void test_2() {
        try {
            String result = createPoll(new String[]{"Hier", "Hier"}, "Was ist die Frage");
            String s = result.split("\n")[0];
            assertEquals(s.charAt(s.length()-1), '?');
        } catch (Exception e) {
            fail("Reason: " + e);
        }
        try {
            String result = createPoll(new String[]{"Hier", "Hier"}, "Was ist die Frage?");
            String s = result.split("\n")[0];
            assertEquals(s.charAt(s.length()-1), '?');
            assertNotEquals(s.charAt(s.length()-3), '?');
        } catch (Exception e) {
            fail("Reason: " + e);
        }
    }

    @Test
    @DisplayName("Create Poll Test")
    @Order(3)
    void test_3() throws Exception {
        String l_quetion = "Welches Tier magst du am meisten";
        String[] l_options = {"Elefant","Affe", "Pferd", "Maus", "Giraffe"};
        String l_excpected_result = "Welches Tier magst du am meisten ?\n" +
                "\n" +
                "\uD83D\uDC4D:  Elefant\n" +
                "\uD83D\uDE02:  Affe\n" +
                "\uD83D\uDE2E:  Pferd\n" +
                "\uD83D\uDE22:  Maus\n" +
                "\uD83D\uDE4F:  Giraffe";

        assertNotEquals(createPoll(l_options, l_quetion),l_excpected_result);
    }


}