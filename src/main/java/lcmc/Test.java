package lcmc;

import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Test {
    final String file = "test.txt";

    public void main(String[] args) {
        log("Avvio del programma di test");
        try {
            CharStream chars = CharStreams.fromFileName(file);
            lcmc.SimpleExpLexer lexer = new lcmc.SimpleExpLexer(chars);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            lcmc.SimpleExpParser parser = new lcmc.SimpleExpParser(tokens);
            parser.prog();

            log("Prog");
            log("Lexical errors: " + lexer.lexicalErrors);
            log("Syntax errors: " + parser.getNumberOfSyntaxErrors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
