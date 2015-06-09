INSTITUTO TECNOLOGICO DE COSTA RICA SEDE REGIONAL SAN CARLOS
Primera tarea programada
Compiladores e Interpretes
Prof. Oscar Viquez Acuña

Analisis Sintactico - Compilador miniJava

Descripción:

> Este primer proyecto programado tendrá como finalidad completar exitosamente la primera fase de desarrollo de un compilador denominada Análisis Sintáctico. Nuestro enemigo va a ser la forma en que se escribe un programa y sus diferentes construcciones por parte del usuario. Es decir, con esta fase terminada, nuestro compilador será capaz de decir si un código cualquiera se encuentra sintácticamente correcto ie. cumple con la especificación de la gramática.

> El compilador a desarrollar será un subconjunto reducido del lenguaje de programación Java. La gramática que define las reglas sintácticas es anexada al final del documento y será la que definirá las reglas sintácticas del lenguaje. El lenguaje de implementación de nuestro compilador será Java.

> Los grupos de trabajo deberán construir en primera instancia un editor en donde el usuario pueda escribir código y guardar y abrir archivos con extensión ".java". El editor deberá ser de buena apariencia y en un ambiente integrado capaz de permitir las operaciones básicas de archivos y los comandos del compilador que se requieran. Se permite el uso de algún editor de texto previamente contruido.

> Deberán implementar un scanner o rastreador de texto del código fuente y “desarmar” todo el texto en tokens o palabras reservadas del lenguaje. Este Scanner debe realizarse utilizando la herramienta JFlex o afín al lenguaje de su escogencia para la implementación de esta tarea.  Dicho Scanner deberá devolver para cada token la información necesaria tanto para identificar el tipo de token, para mostrar la fila y la columna del token en el archivo de texto y para mostrar el valor asociado al token en aquellos casos que se requieran (números, identificadores, constantes STRING, operadores, valores booleanos, tipos de datos y cualquier otro que hiciera falta).  Como último punto, este scanner debe reportar cualquier error léxico que ocurriese en esta sub-etapa.

> Con estos tokens se alimentará la siguiente sub-fase relacionada con la creación de los parser de la forma Parser\_XXXX por ejemplo: "Parser\_Identificador". Las XXX se refieren a cada una de las reglas de la gramática. En otras palabras, estos procedimientos "parser" son los que verifican cada una de las construcciones gramaticales.

> Recordemos que al igual que el scanner, los parser pueden implementarse cualquier lenguaje de programación con la implicación inmediata que debe tomarse en cuenta, de que estamos desarrollando un compilador para un segmento de Java, por lo que al momento de las etapas finales (generación de código por ejemplo) será clave el uso de la máquina virtual.

> Al mismo tiempo cada parser debe ir construyendo el Árbol Abstracto de Sintáxis o AST que se utilizará en las fases posteriores de nuestro compilador. Este árbol deberá estar bien formando con sus respectivas etiquetas en cada subárbol y deberá haber una opción para imprimir ese árbol de manera eficiente. Lo anterior con la finalidad de que los estudiantes puedan chequear el avance de su proyecto y que el profesor pueda revisar con más detalle la correcta construcción de la estructura.

> El programa será capaz de reportar errores de compilación tanto en la subfase de verificación de tokens como en la construcción de los verificadores gramaticales (parsers). Dichos errores deben mostrarse al final de la ejecución de esta fase; el despliegue del error debe ser lo suficientemente descriptivo (descripción simple pero concisa y fase en la que ocurrió el error) y debe contener la información referente al lugar donde ocurrió dicho error mostrando en detalle la línea y columna correspondiente en el texto fuente. Estos errores van ser capturados por medio de excepciones por lo que DEBEN crear sus propias excepciones (ScannerException y ParserException).

> El editor contará con las opciones que el programador crea convenientes e incorporará una única opción de compilación llamada “compilar”. Esta opción será única para el resto del desarrollo del programa. Adicionalmente se deberá agregar una opción para el despliegue del árbol de sintaxis (AST). El despliegue del árbol debe realizarse utilizando GUI.


Documentación:

> La documentación deberá incluir las siguientes partes:

Portada formal.

Análisis del lenguaje: En donde se describa con SUS PALABRAS el lenguaje de programación que se está implementando. Qué características tienen los programas que se pueden implementar en el lenguaje.

Soluciones e implementación: En donde se especifiquen las estructuras y los algoritmos principales, realizados para solucionar el problema.

Resultados obtenidos: donde se define el porcentaje de éxito o fracaso en la ejecución del proyecto.

Conclusiones del trabajo.

Bibliografía: Según formato APA. Solo referencias a documentos con autor establecido. Ayuda: http://www.intec.edu.do/pdf/APA/guiaAPA-Importante%5B2%5D.pdf

Aspectos Administrativos:

La tarea se desarrollará en grupos de máximo dos personas.

La fecha de entrega será el Viernes 9 de Abril de 2011 con hora límite hasta las 12:00 media noche.

Cualquier intento de plagio, copias totales o parciales de otras personas o de Internet, serán castigados con nota de 0 con las debidas repercusiones administrativas que esto conlleva.




ANEXOS

Gramática de MiniJava

Program 	→ 	ImportDecl**MainClass ClassDecl**

ImportDecl	→	import TypeName (.**| );**

TypeName	→ 	id (. id)

MainClass 	→ 	class id { public static void main ( String[.md](.md) id )
> { Statement }}

ClassDecl 	→ 	class id ((extends | implements) id | ) { BodyDecl }

BodyDecl	→	(VarDecl | ConstrDecl | MethodDecl | ClassDecl)

VarDecl 	→ 	Type id ;

ConstrDecl	→	public id ( FormalList )
> { VarDecl**Statement** }
MethodDecl 	→ 	public (Type | void) id ( FormalList )
> > { VarDecl**Statement** (return Exp ; | ) }

FormalList 	→ 	Type id (, Type id)**| **

Type 		→ 	int [.md](.md)

> → 	boolean
> → 	int
> → 	id

Statement 	→ 	{ Statement**}
> → 	if ( Exp ) Statement else Statement
> > → 	while ( Exp ) Statement
> > > → 	System.out.println( Exp );

> →	( Type ) System.in.read();
> →	System.exit(0);
> > → 	id ([Exp ](.md) | ) = Exp ;**

Exp	 	→ 	Exp op Exp

> → 	Exp [Exp ](.md)
> → 	Exp . length
> → 	Exp . id ( ExpList )
> → 	INTEGER\_LITERAL
> → 	true
> → 	false
> → 	id
> → 	this
> → 	new int [Exp ](.md)
> → 	new id (ExpList)
> → 	! Exp
> → 	( Exp )
> →	STRING\_CONSTANT

ExpList 	→ 	Exp (, Exp)**| **

Op		→	+ | - | 