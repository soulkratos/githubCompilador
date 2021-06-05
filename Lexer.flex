package codigo;

import static codigo.Tokens.*;

%%
%class Lexer
%type Tokens

L       = [a-z_A-Z]
D       = [0-9]*
ND      = {D}*"."{D}*
AF      = {L}*{D}*
CORREO  = "\""{AF}*"@"{L}+"."{L}+"."{L}+"\""
LINK    = (("\""){L}*"."{L}*"."{L}*"&"{L}*";" | ("\""){L}*"."{L}*"."{L}*"/"{L}*"."{L}*"&"{L}*";")*
TEXTO   = ("\""{L}*" "{L}*"\"" | "\""{L}*"\"" | {L}*)
LISTA   = ({L}*","{espacio}{L}*","{espacio}{L}*{espacio}{L}*","{espacio}{L}*{espacio}{L}*)*

espacio = [ ,\t,\r,\n]

%{
    public String lexeme;
%}
%%

  
{espacio}   {/*Ignore*/}
"//".*      {/*Ignore*/}

"INI_HTML"          {lexeme=yytext(); return HTML_INICIO;}
"FIN_HTML"          {lexeme=yytext(); return HTML_FIN;}
"ENCABEZADO_INI"    {lexeme=yytext(); return HEADER_INICIO;}
"ENCABEZADO_FIN"    {lexeme=yytext(); return HEADER_FIN;}
"TIT"               {lexeme=yytext(); return TITLE;}
"FILA"              {lexeme=yytext(); return ROW_INICIO;}
"FILA_FIN"          {lexeme=yytext(); return ROW_FIN;}
"CUERPO_IN"         {lexeme=yytext(); return BODY_INICIO;}
"CUERPO_FIN"        {lexeme=yytext(); return BODY_FIN;}
"TABLA_IN"          {lexeme=yytext(); return TABLE_INICIO;}
"TABLA_FIN"         {lexeme=yytext(); return TABLE_FIN;}
"LISTA_IN"          {lexeme=yytext(); return LIST_INICIO;}
"LISTA_FIN"         {lexeme=yytext(); return LIST_FIN;}
"IMAGEN_IN"         {lexeme=yytext(); return IMAGE_INICIO;}
"IMAGEN_FIN"        {lexeme=yytext(); return IMAGE_FIN;}
"COLUMNA"           {lexeme=yytext(); return ETIQUETA_COLUMNA;}
"ALTURA"            {lexeme=yytext(); return ETIQUETA_ALTURA;}    
"ANCHO"             {lexeme=yytext(); return ETIQUETA_ANCHO;}
"PRUEBA"            {lexeme=yytext(); return ETIQUETA_PRUEBA;}
"NEGRITA"           {lexeme=yytext(); return ETIQUETA_NEGRITA;}
"IMPRIMIR"          {lexeme=yytext(); return ETIQUETA_IMPRIMIR;}
"BORDE"             {lexeme=yytext(); return ETIQUETA_BORDE;}         
"NOMBRE"            {lexeme=yytext(); return NOMBRE;} 
"XXX"               {lexeme=yytext(); return IMAGEN_FOTO;} 
"ENLACE"            {lexeme=yytext(); return ETIQUETA_ENLACE;}
"Integer"            {lexeme=yytext(); return INTEGER;}
"String"            {lexeme=yytext(); return STRING;}
"Float"            {lexeme=yytext(); return FLOAT;} 

"+"                 {lexeme=yytext(); return SIGNO_SUMA;}
"-"                 {lexeme=yytext(); return SIGNO_RESTA;}
"*"                 {lexeme=yytext(); return SIGNO_MULTIPLICACION;}
"="                 {lexeme=yytext(); return Signo_Igual;}
"("                 {lexeme=yytext(); return AbreParentesis;} 
")"                 {lexeme=yytext(); return CierraParentesis;} 
"\""                {lexeme=yytext(); return COMILLA;}
":"                 {lexeme=yytext(); return DOS_PUNTOS;}
";"                 {lexeme=yytext(); return PUNTO_COMA;}
","                 {lexeme=yytext(); return COMA;}
"&quot;"             {lexeme=yytext(); return QUOT;}
"/"                  {lexeme=yytext(); return SIGNO_DIVISION;}

{CORREO}            {lexeme=yytext(); return Email;}
{LINK}              {lexeme=yytext(); return Link;}
{D}+                {lexeme=yytext(); return Numero;}
{ND}+               {lexeme=yytext(); return Numero_Decimal;}
{TEXTO}             {lexeme=yytext(); return TEXTO;} 
{LISTA}             {lexeme=yytext(); return LISTA;}       

 . {return error;}
