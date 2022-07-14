grammar Calc;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: '-'?[0-9]+;
WS: [ \t\r\n] -> skip;

start: expression;

expression:
    NUMBER #Number
    | '(' innerExpression = expression ')' #Parenthese
    | left=expression operator=(MUL|DIV) right=expression #MulOrDiv
    | left=expression operator=(ADD|SUB) right=expression #AddOrSub
    ;