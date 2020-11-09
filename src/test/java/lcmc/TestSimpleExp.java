package lcmc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestSimpleExp {

    @Test
    public void testSimpleExpLexer() {
        CharStream chars = null;
        try {
            String strings = "strings.txt";
            chars = CharStreams.fromFileName(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lcmc.SimpleExpLexer lexer = new lcmc.SimpleExpLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        lcmc.SimpleExpParser parser = new lcmc.SimpleExpParser(tokens);
        parser.prog();

        log("Prog");
        log("Lexical errors: " + lexer.lexicalErrors);
        log("Syntax errors: " + parser.getNumberOfSyntaxErrors());
        assertEquals(0, lexer.lexicalErrors);
        assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
