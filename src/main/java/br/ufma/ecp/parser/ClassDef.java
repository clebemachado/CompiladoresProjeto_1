package br.ufma.ecp.parser;

import br.ufma.ecp.Parser;
import br.ufma.ecp.parser.facade.FacadeSyntaxy;

import static br.ufma.ecp.token.TokenType.*;
import static br.ufma.ecp.token.TokenType.RBRACKET;

public class ClassDef extends SyntaxyParser{

    public ClassDef(Parser parser, StringBuilder xmlOutput) {
        super(parser, xmlOutput);
    }

    public void parseClass(FacadeSyntaxy facadeSyntaxy) {
        printNonTerminal("class");
        expectPeek(CLASS);
        expectPeek(IDENTIFIER);
        expectPeek(LBRACKET);
        while (getPeekTokenType()==STATIC || getPeekTokenType() == FIELD){
            facadeSyntaxy.parseClassVarDec();
        }

        while(getPeekTokenType()==FUNCTION || getPeekTokenType()==CONSTRUCTOR ||getPeekTokenType()==METHOD){
            facadeSyntaxy.parseSubroutine();
        }
        expectPeek(RBRACKET);
        printNonTerminal("/class");
    }

}
