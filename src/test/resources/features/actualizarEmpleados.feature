#language: es

Característica: Actualizar Empleado

  Antecedentes:
    Dado  como "administrador" quiero usar la pagina Dummy

  Escenario: Actualizar Empleado
    Dado que quiero actualizar la informacion del empleado
    Cuando haga un llamado a la api de actualizar
    Entonces recibo la informacion actualizada