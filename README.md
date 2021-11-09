# Examen_Minim1
Examen Mínim 1 DSA 09/11/2021
La EETAC está interesada en construir un juego virtual que permita promocionar la escuela. Por este motivo, propone a sus alumnos de DSA la construcción de una prueba piloto con las siguientes operaciones:
- Añadir un usuario
- Listado de usuarios ordenado alfabéticamente
- Consultar información de un usuario
- Informar que un usuario pasa por un punto de interés (puerta, casilla X, puente, casilla Y, etc..)
- Consultar los puntos de interés por los que un usuario pasa (orden en que se notifica)
- Listado de usuarios que han pasado por un punto de interés
- Listado de alumnos ordenado descendentemente por puntos de interés por los que han pasado.
SE PIDE:
PARTE I: 5 puntos
1.-Identificar las entidades de información y sus propiedades. Podéis hacer una propuesta de atributos básica.
2.- Especificación del componente que implementará las operaciones descritas anteriormente: interfaz Java
3.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz definido previamente.
2.1 Elección de las estructuras de datos
2.3 La fachada deberá implementarse como un Singleton.
2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J que muestre el valor de los parámetros al inicio de los métodos y al final. También debe contemplarse trazas de otros niveles (ERROR o FATAL)
4.- Implementación de un test (JUNIT) sobre el componente desarrollado
PARTE II: 5 puntos
1.- Definir (servicio, operaciones, rutas, métodos HTTP, peticiones, respuestas, códigos de respuesta) e implementar un servicio REST que permita realizar las operaciones especificadas en la primera parte del ejercicio. Se recomienda que todas las operaciones deben retornar “objetos de transferencia” y evitar ciclos/relaciones. Si estos objetos de transferencia son complejos se complica la serialización/deserialización
NOTA: El servicio debe utilizar el componente construido en el punto anterior
NOTA:
- No se permite el uso de System.out.println
- La gestión de dependencias (librerías) debe realizarse ÚNICAMENTE con Maven: junit, log4j, etc
- No se permite el uso de System.out.println
- La entrega debe realizarse sobre un repositorio de GITHUB. En dicho repositorio debe existir un fichero README.md que describa el proyecto. NO SE DEBE REALIZAR NINGÚN PUSH hasta finalizar el ejercicio para evitar compartir el código entre compañeros. Si se comprueba un porcentaje
de similitudes del código alto se presentará el caso al jefe de estudios con la propuesta de suspenso global de la asignatura.
El fichero REAME.md debe explicar brevemente el desarrollo del ejercicio y el alcance del mismo (qué partes están desarrolladas y están funcionando y cuáles no).
La entrega consistirá en un fichero de texto con el enlace de Github
