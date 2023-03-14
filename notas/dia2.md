> La simplicidad, o el arte de maximizar la cantidad de trabajo no realizado, es esencial.

Esto tiene que ver con algo que antes haciamos mucho... por si acaso! y de hecho, antiguamente las considerabamos una BUENA PRACTICA!
Voy a dejar esta función creada ... por si acaso mañana me la piden....
Voy a dejar esta otra columna en la BBDD ... por sia caso mañana me dicen...

Usuarios en una BBDD ... y tengo que guardar un teléfono.... 
Bueno... me cuesta muy poco ahora que estoy desarrollando... crear 2 campos para el telefono en la BBDD

Hoy en día LO CONSIDERAMOS UNA PRACTICA HORRIBLE !!!!
No quiero escribir ni una sola linea más de código de las que necesito para superar las pruebas.

Porque además, NO SOY ADIVINO!!!


# Qué gano al aplicar una metodología TDD?

- Dejar claramente establecidos los requisitos
- A entender el programa que debo montar antes de montarlo
- Me ayuda a validar el API
- Descartar lo que no se necesita


---

Orden de complejidad de un algoritmo O(n) O(log(n)) O(n·log(n))                 Se refiere a cómo crece el nñumero de operaciones que hace una computadora
                                                                                Si crece el conjunto de datos sobre el que opera.
                                                                                
                                                                                A no ser que vaya a montar una BBDD... esto me vale para poco

Complejidad Ciclomática             Se refiere al número de caminos que puede tomar un código al ejecutarse ~ REQUERIMIENTOS FUNCIONALES
                                                                                -> El número mínimo de pruebas que he de realizar

Complejidad Cognitiva               Cómo de complejo es para un ser humano entender un código


    if CONDICION 1:
        // Tarea 1
        if CONDICION 2:
            // Tarea 2
        else:
            // TAREA 3
    else if CONDICION 4:
        // Tarea 4
    else
        // TAREA 5
        
    Complejidad ciclomática: 4
        CONDICION 1 && CONDICION 2 -> 1 , 2
        CONDICION 1 && ! CONDICION 2 -> 1, 3
        CONDICION 4 -> 4
        ! CONDICION 1 && ! CONDICION 4 -> 5
        
    Complejidad cognitiva: MAS COMPLEJO 
    
    

    switch(VARIABLE1):
        case 1:
            //TAREA 1
        case 2:
            //TAREA 2
        case 3:
            //TAREA 3
        case 4:
            //TAREA 4
        case 5:
            //TAREA 5
        case default:
            //TAREA 6

    Complejidad ciclomática: 6
    Complejidad cognitiva:   SENCILLO

---

API

Application Programming Interfaz

API: Es el conjunto de funciones/métodos/procedimientos, interfaces que tiene mi código


---

TDD
Test Driven Development
Qué tipos de pruenas estamos metiendo aquí?  UNITARIAS

---

BDD
Behaviour Driven Development
Desarrollo dirigido por EL COMPORTAMIENTO
Qué tipos de pruenas esamos metiendo aquí?  SISTEMA / END2END
    Estas pruebas, ni quiera las defino YO.. las define un TESTER
    
---

ATDD

---

Imaginad que quiero fabricar un coche

NORMATIVA ! REQUERIMIENTOS
Seguridad. Test EURONCAP

Tornillo: DIN ISO