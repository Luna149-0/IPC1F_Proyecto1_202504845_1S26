# IPC1F_Proyecto1_202504845_1S26

Proyecto 1 – Sistema de Gestión de Inventario y Ventas
Descripción del programa

Este programa fue desarrollado en Java y permite gestionar un inventario de productos.
El sistema cuenta con un menu interactivo que permite Agregar productos, Eliminar productos, Buscar productos, registrar ventas, generar reportes en formato HTML y ver datos del estudiante.

El objetivo del programa es simular un sistema básico de control de inventario donde se puedan administrar productos y registrar ventas realizadas.

Funcionalidades principales

El sistema incluye las siguientes funciones:

Agregar productos al inventario.

Buscar productos por:

Nombre

Categoría

ID

Eliminar productos del inventario.

Registrar ventas de productos.

Generar reporte HTML del inventario.

Generar reporte HTML de las ventas realizadas.

Ver datos del estudiante

Los reportes se generan automáticamente y se abren en el navegador.

Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

models
Contiene las clases que representan los datos del sistema, como ProductoModel.

controllers
Contiene la lógica del sistema, como el manejo de productos, ventas y generación de reportes.

views
Contiene las interfaces gráficas del programa desarrolladas con Java Swing.

Instrucciones para ejecutar el programa

Abrir el proyecto en NetBeans.

Compilar el proyecto.

Ejecutar la clase principal del programa.

Utilizar el menú principal para acceder a las diferentes funciones:

Gestión de productos

Registro de ventas

Generación de reportes

Cuando se genera un reporte, se crea un archivo HTML que se abre automáticamente en el navegador.

Generación de reportes

El sistema genera dos tipos de reportes:

Reporte de Stock
Muestra todos los productos registrados en el inventario, incluyendo:

ID

Nombre

Cantidad

Categoría

Precio

Reporte de Ventas
Muestra las ventas registradas durante la ejecución del programa, incluyendo:

Código del producto

Cantidad vendida

Total de la venta

Fecha y hora

Cada reporte se genera con un nombre único basado en la fecha y hora para evitar sobrescribir archivos anteriores.

Problemas encontrados

Durante el desarrollo del proyecto se presentaron algunos problemas, como:

Errores al generar reportes HTML.

Manejo incorrecto de archivos de texto para almacenar ventas.

Problemas con importaciones de librerías en Java.

Estos problemas se resolvieron ajustando la lógica del programa y reorganizando el manejo de datos en memoria.

Mejoras posibles

Algunas mejoras que se podrían implementar en el futuro son:

Guardar los productos y ventas en una base de datos.

Mejorar la interfaz gráfica del programa.

Implementar edición de productos.

Agregar filtros más avanzados en los reportes.

Generar reportes en formato PDF.

Autor

Ixchel Panjoj García
