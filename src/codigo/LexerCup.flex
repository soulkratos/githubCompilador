package codigo;

import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

L       = [a-z_A-Z]
D       = [0-9]*
ND      = {D}*"."{D}*
AF      = {L}*{D}*
CORREO  = "\""{AF}*"@"{L}+"."{L}+"."{L}+"\""
LINK    = (("\""){L}*"."{L}*"."{L}*"&"{L}*";" | ("\""){L}*"."{L}*"."{L}*"/"{L}*"."{L}*"&"{L}*";")*
TEXTO   = ("\""{L}*" "{L}*"\"" | "\""{L}*"\"" | {L}*)
LISTA   = ({L}*","{espacio}{L}*","{espacio}{L}*{espacio}{L}*","{espacio}{L}*{espacio}{L}*)*

espacio = [ ,\t,\r,\n]+

%{
     private Symbol symbol(int type,Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

%}
%%

  
{espacio}   {/*Ignore*/}
"//".*      {/*Ignore*/}

"INI_HTML"          {return new Symbol(sym.HTML_INICIO, yychar, yyline, yytext());}
"FIN_HTML"          {return new Symbol(sym.HTML_FIN, yychar, yyline, yytext());}
"ENCABEZADO_INI"    {return new Symbol(sym.HEADER_INICIO, yychar, yyline, yytext());}
"ENCABEZADO_FIN"    {return new Symbol(sym.HEADER_FIN, yychar, yyline, yytext());}
"TIT"               {return new Symbol(sym.TITLE, yychar, yyline, yytext());}
"FILA"              {return new Symbol(sym.ROW_INICIO, yychar, yyline, yytext());}
"FILA_FIN"          {return new Symbol(sym.ROW_FIN, yychar, yyline, yytext());}
"CUERPO_IN"         {return new Symbol(sym.BODY_INICIO, yychar, yyline, yytext());}
"CUERPO_FIN"        {return new Symbol(sym.BODY_FIN, yychar, yyline, yytext());}
"TABLA_IN"          {return new Symbol(sym.TABLE_INICIO, yychar, yyline, yytext());}
"TABLA_FIN"         {return new Symbol(sym.TABLE_FIN, yychar, yyline, yytext());}
"LISTA_IN"          {return new Symbol(sym.LIST_INICIO, yychar, yyline, yytext());}
"LISTA_FIN"         {return new Symbol(sym.LIST_FIN, yychar, yyline, yytext());}
"IMAGEN_IN"         {return new Symbol(sym.IMAGE_INICIO, yychar, yyline, yytext());}
"IMAGEN_FIN"        {return new Symbol(sym.IMAGE_FIN, yychar, yyline, yytext());}
"COLUMNA"           {return new Symbol(sym.ETIQUETA_COLUMNA, yychar, yyline, yytext());}
"ALTURA"            {return new Symbol(sym.ETIQUETA_ALTURA, yychar, yyline, yytext());}
"ANCHO"             {return new Symbol(sym.ETIQUETA_ANCHO, yychar, yyline, yytext());}
"PRUEBA"            {return new Symbol(sym.ETIQUETA_PRUEBA, yychar, yyline, yytext());}
"NEGRITA"           {return new Symbol(sym.ETIQUETA_NEGRITA, yychar, yyline, yytext());}
"IMPRIMIR"          {return new Symbol(sym.ETIQUETA_IMPRIMIR, yychar, yyline, yytext());}
"BORDE"             {return new Symbol(sym.ETIQUETA_BORDE, yychar, yyline, yytext());}      
"NOMBRE"            {return new Symbol(sym.NOMBRE, yychar, yyline, yytext());}
"XXX"               {return new Symbol(sym.IMAGEN_FOTO, yychar, yyline, yytext());}
"ENLACE"            {return new Symbol(sym.ETIQUETA_ENLACE, yychar, yyline, yytext());}
"Integer"            {return new Symbol(sym.INTEGER, yychar, yyline, yytext());}
"String"            {return new Symbol(sym.STRING, yychar, yyline, yytext());}
"Float"            {return new Symbol(sym.FLOAT, yychar, yyline, yytext());}

"+"                 {return new Symbol(sym.SIGNO_SUMA, yychar, yyline, yytext());}
"-"                 {return new Symbol(sym.SIGNO_RESTA, yychar, yyline, yytext());}
"*"                 {return new Symbol(sym.SIGNO_MULTIPLICACION, yychar, yyline, yytext());}
"="                 {return new Symbol(sym.Signo_Igual, yychar, yyline, yytext());}
"("                 {return new Symbol(sym.AbreParentesis, yychar, yyline, yytext());}
")"                 {return new Symbol(sym.CierraParentesis, yychar, yyline, yytext());}
"\""                {return new Symbol(sym.COMILLA, yychar, yyline, yytext());}
":"                 {return new Symbol(sym.DOS_PUNTOS, yychar, yyline, yytext());}
";"                 {return new Symbol(sym.PUNTO_COMA, yychar, yyline, yytext());}
","                  {return new Symbol(sym.COMA, yychar, yyline, yytext());}
"&quot;"             {return new Symbol(sym.QUOT, yychar, yyline, yytext());}
"/"             {return new Symbol(sym.SIGNO_DIVISION, yychar, yyline, yytext());}

{CORREO}            {return new Symbol(sym.Email, yychar, yyline, yytext());}
{LINK}              {return new Symbol(sym.Link, yychar, yyline, yytext());}
{D}+                {return new Symbol(sym.Numero, yychar, yyline, yytext());}
{ND}+                {return new Symbol(sym.Numero_Decimal, yychar, yyline, yytext());}
{TEXTO}             {return new Symbol(sym.TEXTO, yychar, yyline, yytext());}
{LISTA}             {return new Symbol(sym.LISTA, yychar, yyline, yytext());} 

 . {return new Symbol(sym.error,yychar,yyline,yytext());}
