#language: es

Característica: Obtener informacion  Empleado

  Antecedentes:
    Dado  como "administrador" quiero usar la pagina Dummy

  Escenario: Obtener informacion Empleado
    Dado que quiero obtener informacion del empleado
    Cuando haga un llamado a la api de obtener
    Entonces recibo la informacion del empleado