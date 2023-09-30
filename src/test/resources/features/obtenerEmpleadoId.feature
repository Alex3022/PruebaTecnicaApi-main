#language: es

Característica: Obtener informacion Empleado id

  Antecedentes:
    Dado  como "administrador" quiero usar la pagina Dummy

  Escenario: Obtener informacion Empleado id
    Dado que quiero obtener informacion del empleado por id
    Cuando haga un llamado a la api de obtener empleado con id
    Entonces recibo la informacion del empleado con id