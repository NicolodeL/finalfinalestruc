https://github.com/NicolodeL/finalfinalestruc.git
# Nicolás Lodeiros López
## Análisis y descripción de la aplicación:
### Paquete Clases 
#### Bacteria
##### En esta clase se crea el constructor de bacteria, sus getters y setters, una funcion que da los detalles de la bacteria y  la funcion "fromInformacionDetallada" que convierte texto en una clase bacteria.
#### Experimento
##### En esta clase se define experimento, sus clases sus getter y sus setters.
#### Listado
##### Aqui se crean los arrays que crean las listas de bacterias y experimentos.
### Experimentos
#### Almacenamiento
##### En esta clase se definen los metodos guardarExperimento y cargarExperimento que se usan para guardar y cargar los experimentos.
### Org.example
#### Main
##### Ejecuta la interfaz y le da dimensiones a la ventana emergente
### VisualizacionGrafica
#### Interfaz
##### Esta clase crea la interfaz, los botones, sus ubicaciones y en cada boton agrega su funcion basandose en las clases creadas previamente y tomadnolas de apoyo
## Diseño
### En cuanto al diseño opté por hacer la interfaz lo mas intuitiva posible, y visual, para que no haya dudas en su uso ni compliciones a la hora de utlizarse.
## Comprobaciones de integridad y excepciones
### El manejo de expeciones y las comprobaciones estan muy presente en el proyecto, al cargar los archivos  en la creacion de experimentos y poblaciones mediante la comprobacion de si el formato es correcto o no, mandado excepciones si es que no se cumple el formato especificado.
## Técnicas de ordenación y búsqueda
### Decidí ordenar los archivos en una carpeta en los recursos, y dejar la busqueda para el usuario tras dejar que el programa se encargase de cargar los archivos mediante un boton.
## Diagrama de clases UML
