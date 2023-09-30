#language: es

Característica: Crear Empleado

  Antecedentes:
    Dado  como "administrador" quiero usar la pagina Dummy

  Escenario: Crear Empleado
    Dado que quiero crear a un empleado
    Cuando haga un llamado a la api de crear
    Entonces recibo la informacion creada