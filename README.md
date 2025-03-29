# Automatas
# Proyecto de Autómatas Finito Determinista

### Descripción

Este proyecto implementa un Autómata Finito Determinista (AFD) en Java. El sistema permite evaluar cadenas de entrada, determinar si son aceptadas por el autómata y visualizar su representación gráfica utilizando Graphviz.

# Autores

Sebastián López Osorno

Andrea Coronado Hoyos

# Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y archivos:

## 1. Paquete Bean

Node.java: Representa los estados del autómata. Cada estado tiene:

Un nombre (name).

Indicadores de si es un estado inicial o final.

Enlaces a otros nodos (linkA y linkB) según los símbolos de entrada.

## 2. Paquete Logic

Automaton.java: Implementa el autómata y sus funciones principales:

Evaluación de cadenas de entrada.

Generación de la representación gráfica del autómata.

Función Show() para visualizar los estados y transiciones.

## 3. Paquete Utility

GraphvizController.java: Controlador para generar gráficos de Graphviz.

Crea archivos de configuración de Graphviz.

Genera imágenes de los autómatas.

Abre automáticamente la imagen generada.

## 4. Paquete View

Menu.java: Implementa la interfaz de usuario con un menú de opciones.

Permite evaluar recorridos.

Muestra la representación gráfica del autómata.

## 5. Archivo Principal

Main.java: Inicializa los estados y transiciones del autómata, creando un autómata con los siguientes estados:

Q0 (inicial)

Q1, Q2, Q3, Q4, Q5, Q6, Q7 (finales o intermedios)

Configura las transiciones entre los estados.

Ejecuta el menú de opciones.

Requisitos

Java 8 o superior

Graphviz instalado y configurado

Ejecución

Compila y ejecuta el proyecto desde un IDE como IntelliJ IDEA o Eclipse.

Asegúrate de que Graphviz está instalado y su ejecutable (dot.exe) está en la ruta correcta.

Corre Main.java y usa el menú para evaluar cadenas o visualizar el autómata.
