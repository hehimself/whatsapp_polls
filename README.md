#  Whatsapp Poll Generator

This poll generator can build surveys on which others can react with the reaction Emojis.

The standard reaction Emojis are:
👍,
❤️,
😂,
😮,
😢,
🙏

### Usage:
```java
public static String createPoll(String[] p_options, String p_question)
``` 
<li>p_options: insert 1-6 options to choose from
</li>
<li>p_question: This String represents the Question. The question can be with or without a question-mark at the end, it will automatically add one.
</li>

### Example:
input:
```java
String l_quetion = "Which is your favorite animal";
String[] l_options = {"elephant","monkey", "horse", "mouse", "hippo"};
``` 
output:  
```
Which is your favorite animal ?

👍:  elephant
:heart:️:  monkey
😂:  horse
😮:  mouse
😢:  hippo
``` 