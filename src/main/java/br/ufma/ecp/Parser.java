package br.ufma.ecp;

import static br.ufma.ecp.token.TokenType.*;
import static br.ufma.ecp.token.TokenType.RBRACKET;

import br.ufma.ecp.parser.facade.FacadeSyntaxy;
import br.ufma.ecp.token.Token;
import br.ufma.ecp.token.TokenType;

public class Parser {

    private Scanner scan;
    private Token currentToken;
    private Token peekToken;
    private FacadeSyntaxy facadeSyntaxy;

    public Parser (byte[] input) {
        scan = new Scanner(input);
        nextToken();
        facadeSyntaxy = new FacadeSyntaxy(this);
    }

    public Token getPeekToken() {
        return peekToken;
    }

    public Token getCurrentToken() {
        return currentToken;
    }

    public void nextToken() {
        currentToken = peekToken;
        peekToken = scan.nextToken();
    }

    void parser () {
        facadeSyntaxy.parseClass();
    }

    public String XMLOutput() {
        return facadeSyntaxy.XMLOutput();
    }

    public String VMOutput(){
        return facadeSyntaxy.VMOutput();
    }

}
