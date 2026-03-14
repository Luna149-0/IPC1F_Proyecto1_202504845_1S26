# Proyecto 1 – Sistema de Gestión de Inventario y Ventas

## Descripción del Programa

Este programa fue desarrollado en **Java** y permite gestionar un inventario de productos mediante una interfaz gráfica.

El sistema cuenta con un **menú interactivo** que permite realizar diferentes operaciones como:

- Agregar productos
- Eliminar productos
- Buscar productos
- Registrar ventas
- Generar reportes en formato HTML
- Ver datos del estudiante

El objetivo del programa es **simular un sistema básico de control de inventario**, donde se puedan administrar productos y registrar las ventas realizadas.

---

# Funcionalidades Principales

El sistema incluye las siguientes funciones:

## Gestión de productos
- Agregar productos al inventario.
- Buscar productos por:
  - Nombre
  - Categoría
  - ID
- Eliminar productos del inventario.

## Registro de ventas
- Registrar ventas de productos.
- Actualizar automáticamente el stock disponible.

## Generación de reportes
- Generar reporte **HTML del inventario**.
- Generar reporte **HTML de las ventas realizadas**.

## Información del estudiante
- Mostrar una ventana con los datos del estudiante desarrollador del programa.

Los reportes se generan automáticamente y **se abren en el navegador**.

---

# Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

## models
Contiene las clases que representan los datos del sistema.

Ejemplo:
- `ProductoModel`

Esta clase almacena la información de cada producto, como:
- ID
- Nombre
- Cantidad
- Categoría
- Precio

---

## controllers
Contiene la **lógica del sistema**, incluyendo:

- Manejo de productos
- Registro de ventas
- Generación de reportes

Ejemplo:
- `ProductoController`

---

## views
Contiene las **interfaces gráficas del programa**, desarrolladas con **Java Swing**.

Estas vistas permiten al usuario interactuar con el sistema mediante ventanas y botones.

---

# Instrucciones para Ejecutar el Programa

1. Abrir el proyecto en **NetBeans**.
2. Compilar el proyecto.
3. Ejecutar la **clase principal del programa**.
4. Utilizar el **menú principal** para acceder a las diferentes funciones:

- Gestión de productos
- Registro de ventas
- Generación de reportes

Cuando se genera un reporte, el sistema crea automáticamente un **archivo HTML** que se abre en el navegador.

---

# Generación de Reportes

El sistema genera dos tipos de reportes:

## Reporte de Stock

Muestra todos los productos registrados en el inventario, incluyendo:

- ID
- Nombre
- Cantidad
- Categoría
- Precio

---

## Reporte de Ventas

Muestra las ventas registradas durante la ejecución del programa, incluyendo:

- Código del producto
- Cantidad vendida
- Total de la venta
- Fecha y hora

Cada reporte se genera con **un nombre único basado en la fecha y hora**, para evitar sobrescribir archivos anteriores.

---

# Problemas Encontrados

Durante el desarrollo del proyecto se presentaron algunos problemas, como:

- Errores al generar reportes HTML.
- Manejo incorrecto de archivos de texto para almacenar ventas.
- Problemas con importaciones de librerías en Java.

Estos problemas se resolvieron **ajustando la lógica del programa y reorganizando el manejo de datos en memoria**.

---

# Mejoras Posibles

Algunas mejoras que se podrían implementar en el futuro son:

- Guardar los productos y ventas en una **base de datos**.
- Mejorar la **interfaz gráfica** del programa.
- Implementar **edición de productos**.
- Agregar **filtros más avanzados en los reportes**.
- Generar reportes en **formato PDF**.

---

# Autor

**Ixchel Panjoj García**  
Proyecto académico desarrollado para el curso **Introducción a la Programación y Computación 1**.
