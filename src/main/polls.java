package main;

public class polls {
    public static int[] option_emojis = {0x1F44D,0x2764,0x1F602,0x1F62E,0x1F622,0x1F64F};

    public static String createPoll(String[] p_options, String p_question) throws Exception {
        parameterValidation(p_options);
        if (p_question.charAt(p_question.length()-1) != '?'){
            p_question += " ?";
        }

        String poll_string = p_question + "\n\n";
        for (int i=0; i<p_options.length; i++){
            poll_string += ((new String(Character.toChars(option_emojis[i])) + ":  " + p_options[i] + "\n"));
        }
        return poll_string;
    }
    public static void parameterValidation(String[] p_options) throws Exception {
        if (p_options.length > 6 || p_options.length == 0){
            throw new Exception("1-6 options are allowed");
        }
        for (String s : p_options) {
            if(s.toCharArray()[0] == '\0') {throw new Exception("Empty option");}
        }
    }

    public static void main(String[] args) throws Exception {
        String l_quetion = "Which is your favorite animal";
        String[] l_options = {"elephant","monkey", "horse", "mouse", "hippo"};

        int l_number_items = l_options.length;
        System.out.println(createPoll(l_options, l_quetion));
    }
}
