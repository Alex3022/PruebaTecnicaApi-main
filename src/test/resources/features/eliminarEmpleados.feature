#language: es

Característica: Eliminar Empleado

  Antecedentes:
    Dado  como "administrador" quiero usar la pagina Dummy

  Escenario: Eliminar Empleado
    Dado que quiero eliminar a un empleado
    Cuando haga un llamado a la api de eliminar
    Entonces recibo la informacion ha sido eliminada