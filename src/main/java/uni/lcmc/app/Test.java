package uni.lcmc.app;

import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Test {
    final String file = "test.txt";

    public void main(String[] args) {
        log("Avvio del programma di test");
        try {
            CharStream chars = CharStreams.fromFileName(file);
            uni.lcmc.app.SimpleExpLexer lexer = new uni.lcmc.app.SimpleExpLexer(chars);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            uni.lcmc.app.SimpleExpParser parser = new uni.lcmc.app.SimpleExpParser(tokens);
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
