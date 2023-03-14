# Pruebas de software

Los desarrolladores "odioamos" las pruebas.
Lo cierto es que a los desarrolladores nos encantan las pruebas.

## Para que sirven las pruebas?

- Para verificar el cumplimiento de un requisito (funcionales/no funcionales)
- Identificar fallos
- Identificar errores < TESTERS
- Para conocer mejor nuestro producto
- Para extraer información que poder aplicar en futuros proyectos
- Para suministrar información al equipo técnico que facilite la identificación del DEFECTO que tenemos en el producto

# Vocabulario que empleamos en el mundo del testing

- ERROR     Es comedido por una persona
- DEFECTO   Al cometerlo introduce un defecto en un producto
- FALLO     Ese defecto puede dar la cara en algún momento(o no) en forma de FALLO. Manifestación de un defecto.

La responsabilidad en la identificación de fallos es compartida en un equipo por desarrolladores y testers.
Una vez identificado un fallo, es responsabilidad del desarrollador el identificar el DEFECTO que provoca ese fallo: DEBUGGING

## Tipos de pruebas

A la hora de clasificar las pruebas usamos diferentes criterios.

### Tipos de pruebas en función del NIVEL DE LA PRUEBA

- Pruebas unitarias         Es una prueba que comprueba **UNA** CARACTERISTICA DE UN COMPONENTE **AISLADO** DEL SISTEMA
- Pruebas de integración    Es una prueba que comprueba **LA COMUNICACION** entre 2 componentes.

                                - Componente A que funciona GUAY
                                - Componente B que funciona GUAY
                                - Y la prueba de integración entre A y B me falla. Dónde está el problema? 
                                EN LA COMUNICACION ENTRE ELLOS

- Pruebas End2End/Sistema   Probamos el **COMPORTAMIENTO** del sistema en **SU CONJUNTO**
- Pruebas de aceptación     Éstas son un subconjunto de las anteriores. 
                            Las que al final me pide el cliente para dar el OK al producto.

### Tipos de pruebas en base al objetivo / característica que comprueban.

- Pruebas estáticas                     NO requieren poner el sistema en FUNCIONAMIENTO para poder hacer la prueba.
    - Revisión de un modelo de datos
    - Revisión de un modelo UML
    - Revisión de calidad de código***  -> MANTENIBILIDAD -> SONARQUBE
        - COMPLEJIDAD CICLOMATICA:      Número de caminos que puede potencialmente tomar un software ~ Requisitos funcionales
- Pruebas dinámicas                     Requieren poner el sistema en FUNCIONAMIENTO para poder hacer la prueba.
    - Pruebas funcionales               Se centran en la FUNCIONALIDAD
    - Pruebas no funcionales            Se centran en otros aspectos
        - Pruebas de rendimiento        En el tiempo que tarda un proceso en llevarse a cabo bajo unas determinadas circustancias.
                                            
                                        El sistema, instalado en un entorno con ESTAS CARACTERISTICAS,
                                        y sometido a una carga de trabajo LA QUE SE DEFINA, 
                                        debe realizar TAL OPERACION con un percentil 95 inferior a 200ms. 
 
        - Pruebas de estres             Cómo se degrada el sistema ante un uso excesivo o el paso del tiempo
        - Pruebas de carga              Muchos datos dentro, ficheros muy gordos.
        - Pruebas de UX                 Cómo de sencillo es usar el sistema para un usuario final.

## Metodologías de gestión de un proyecto de software

¿Qué metodologías se usaban antiguamente? Metodologías EN CASCADA (WATERFALL)

¿Qué metodologías se usan hoy en día? Metodologías AGIL (SCRUM, EXTREME PROGRAMMING,...)

En qué consiste una metodología ágil?

En hacer entregas incrementales de mi producto.

A los 15 días de haber comenzado el proyecto, te monto una versión del sistema en un entorno de producción.
    Ojo! A lo mejor solo te doy el 5% de la funcionalidad del sistema. (solo la pantalla de login), pero una pantalla de login 100% funcional
    En esta entrega 1, voy a montar un 5% de la funcionalidad... pero en producción  -> PRUEBAS de PRODUCCION!     5%
                                                                                        INSTALACION EN PRODUCCION
A los 30 días te monto la versión 2, que añade un 5% de funcionalidad adicional
    En esta entrega 2, voy a montar un +5% de la funcionalidad... pero en producción -> PRUEBAS de PRODUCCION!     5% + 5%
A los 45 días del inicio del proyecto, te dy otro 10%                                                              ·-> Pruebas de regresión !
    En esta entrega 3, voy a montar un +10% de la funcionalidad... pero en producción -> PRUEBAS de PRODUCCION!    5% + 5% + 10%

Al hacer esas entregas incrementales, obtenemos retroalimientación muy rápida del cliente.

Pero estas metodologías han venido con sus propios problemas ! que antes NO TENIA !!!

Tengo que hacer CENTENARES DE VECES MAS PRUEBAS ! Y sobre todo: REPRETIR MUCHAS VECES LAS MISMAS PRUEBAS
Tenemos pasta para hacer eso? NO.
- O no hago pruebas ~> RUINA ASEGURADA !
- AUTOMATIZAR LAS PRUEBAS ->
    - Hacer un programa que pruebe mi programa !
- AUTOMATIZAR LAS INSTALACIONES, EN EL ENTORNO DE PRUEBAS y EN EL ENTORNO DE PRODUCCION


SPRINT 1: **Fecha de entrega** cerrada donde tengo que subir N requisitos implementados.
HITO 1:   Fecha de entrega (F1 -> F2) cerrada donde tengo que mostrar **N requisitos** implementados.

......

En un momento dado te habré dado el 100% o no.



# JUNIT? TESTNG, MSTEST, UNITTEST

Es un Framework de pruebas.

Desde el punto de vista de JUNIT, qué es una prueba? Un programa que puede acabar en uno de estos 3 estados:
- OK
- NOK
- ERROR

Esos son los estados que los TESTERS también usan a la hora de hacer una prueba:
- SUPERADA
- NO SUPERADA
- NO SE PUDO EJECUTAR DEBIDO A UN PROBLEMA



Una libreria es un conjunto de programas (funciones, clases...) a los que invoco cuando necesito realizar una operación.
Y me dan un resultado. Fácilmente puedo usar/integrar esa libreria en mi forma de trabajo.

Un framework usualmente incorpora 1 o varias librerias... pero para su uso, necesito adoptar una determinada forma de trabajo.

----

# MAVEN

Gestor de ciclo de vida de un proyecto de software y dependencias

Maven, cuando creamos una configuración válida en un proyecto, nos permite:
- Ayuda con la obtención de esas dependencias.... y las dependencias de las dependencias!
- Compilar el código y este trabajo antes también lo hacíamos a mano
- Ejecutar las pruebas del proyecto
- Generar el artefacto... compilado/ensamblado: .jar .war .ear
- Exportar ese artefacto a un repositorio de artefactos, para que otras personas puedan usarlo

Maven funciona mediante plugins, que puedo configurar. 
Por defecto vienen unos cuantos, que me permiten hacer unas cuantas tareas básicas (GOLES)

- clean
- compile
- test-compile
- test
- package
- install

Cuando trabajamos con MAVEN, MAVEN nos impone una estructura de carpetas para nuestro proyecto (es configurable):

proyecto
 |- src 
 |   |- main            MI PROYECTO
 |   |  |- java         El código de mi programa (paquetes, clases, interfaces...)
 |   |  |- resources    Otros archivos no JAVA que pueda necesitar mi proyecto (Archivos de configuración, parametros,...)
 |   |- test            Programas de pruebas automatizadas
 |      |- java         El código de mis programas de prueba (paquetes, clases, interfaces...)
 |      |- resources    Otros archivos no JAVA que pueda necesitar mis programas de prueba (Archivos de configuración, parametros,...)
 |- target
 |   |- classes             < Ahi se copian los fichero de main/resources y los compilados de main/java
 |   |- test-classes        < Ahi se copian los fichero de test/resources y los compilados de test/java
 |   |- surefire-reports
 |   |- miproyecto.jar o miproyecto.war
 |- pom.xml         Archivo de configuración de maven (XML) 
                        Configuramos los plugins
                        Enumeramos las dependencias de mi proyecto
                        Configuramos otras característcias básicas del proyecto, como son sus coordenadas:
                            - groupId               Es un nombre que agrupa varios proyectos relativos a un tema / funcionalidad
                                - artifactId        Es un nombre que identifica, dentro de un grupo a un proyecto concreto
                                    - version       Que podrá estar en varias versiones

mvn compile             Se compilan todos mis ficheros .java del proyecto -> .class que se guardan en la carpeta target/classes
mvn test-compile        Se compilan todos mis ficheros .java de las pruebas -> .class que se guardan en la carpeta target/test-classes
mvn test                Ejecuta el compilado de mis pruebas.
                        Generar un informe de resultado de pruebas -> target/surefire-reports
mvn package             Genera el .jar o .war. Empaqueta la app... El resultando lo deja en target
mvn install             Copia el artefacto del proyecto (.jar o .war .ear ) en mi carpeta .m2
mvn clean               Borra la carpeta target

Maven descarga todas las dependencias que le hacen falta para los proyectos que 
gestiona en una carpeta que se crea dentro de la carpeta del usuario:
- c:\users\miUsuario\.m2
- /home/miUsuario/.m2

Las carpetas que comienzan con un PUNTO ? Son carpetas ocultas

A la hora de crear un proyecto con maven partimos de un "arquetipo"(básicamente una plantilla)


mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DarchetypeVersion=1.4

En nuestro proyecto:
- groupId: com.curso
- artifactId: prueba1
- version: 1.0.0

CI: Integración Continua:
Quiero la última versión de los desarrolladores
Lo ultimo que este en git CONTINUAMENTE 
en el entorno de de INTEGRACION estándo sometido
a pruebas automatizadas.

Configurar un pipeline de JENKINS

CD: Continuous Deployment

---

El "software funcionando"
es la medida principal de progreso.

Quien dice que un software funciona? el desarrollador?
NOOOOO. De ese no me fio, que miente mucho !!!sin querer 
LAS PRUEBAS !

