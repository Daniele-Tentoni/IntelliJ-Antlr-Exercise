package uni.lcmc.app;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;

public class TestSimpleExp {
    private final String file = "strings.txt";

    @Test
    public void testSimpleExpLexer() {
        CharStream chars = null;
        try {
            chars = CharStreams.fromFileName(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        uni.lcmc.app.SimpleExpLexer lexer = new uni.lcmc.app.SimpleExpLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        uni.lcmc.app.SimpleExpParser parser = new uni.lcmc.app.SimpleExpParser(tokens);
        parser.prog();

        log("Prog");
        log("Lexical errors: " + lexer.lexicalErrors);
        log("Syntax errors: " + parser.getNumberOfSyntaxErrors());
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
