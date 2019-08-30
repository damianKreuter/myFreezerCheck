package kreutcom.myfreezercheck.BaseDeDatos.Utilidades

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.Producto

object Utilidades {

    private val crear = " CREATE TABLE "
    private val actualizar = " UPDATE "
    private val eliminar = " DELETE "
    private val drop = " DROP "
    private val select = " SELECT "

    private val string = " TEXT "
    private val integer = " INTEGER "
    private val unique = " UNIQUE "
    private val autoIncrement = " AUTOINCREMENT "
    private val campoNotNull = " NOT NULL "

    private val PK = "$integer PRIMARY KEY $autoIncrement"
    private val FK = " FOREING KEY "
    private val referenciaA = " REFERENCES "

    private val campoDateTime = " DATETIME "


    private val en = " ON "
    private val fechaDeHoy = " CURRENT_DATE"
    private val donde = " WHERE "
    private val join = " JOIN "
    private val leftJoin = " LEFT JOIN "
    private val distinct = " DISTINCT "
    private val rollback = " ROLLBACK"

    private val set = " SET "
    private val notIn = " NOT IN "
    private val between = " BETWEEN "

    private val ordernarPor = " ORDER BY "
    private val having = " HAVING "
    private val ascendente = " ASC "
    private val descendente = " DESC "

    private val and = " AND "
    private val union = " UNION "
    private val like = " LIKE "
    private val notLike = " NOT LIKE "

    private val esNULL = " IS NULL "
    private val noEsNULL = " IS NOT NULL "
    private val from = " FROM "
    private val todo = "*"

    private val check = " CHECK "

    private val cerrarLlave = ")"
    private val abrirLlave = "("

    private val coma = ","
    private val espacio = " "

    //Constantes campos tabla usuario
    val TABLA_USER = "usuario"
    val USER_ID = " id_user "
    val USER_NOMBRE = " nombre_user "

    val CREAR_TABLA_USER = crear + TABLA_USER + abrirLlave + USER_ID + PK +
            coma + USER_NOMBRE + " " + string + cerrarLlave

    //Constantes campos tabla mascota
    val TABLA_GRUPO = "grupo"
    val GRUPO_ID = " id_GRUPO "
    val GRUPO_NOMBRE = " nombre_grupo "

    val CREAR_TABLA_GRUPO = crear + TABLA_GRUPO + abrirLlave + GRUPO_ID + PK + coma +
            GRUPO_NOMBRE + string + cerrarLlave

    val TABLA_GRUPO_X_USER = "grupo_x_user"
    val GRUPO_X_USER_USUARIO = " grupo_x_user_usuario "
    val GRUPO_X_USER_GRUPO = " gripo_x_user_grupo "

    val CREAR_TABLA_GRUPO_X_USER = crear + TABLA_GRUPO_X_USER + abrirLlave + GRUPO_X_USER_USUARIO  + integer + campoNotNull + coma +
            GRUPO_X_USER_GRUPO + integer + campoNotNull + cerrarLlave

    val TABLA_TIPO_ALMACEN = "tipo_almacen"
    val TIPO_ALMACEN_DESCRIPCION = " tipo_almacen_descripcion "
    val TIPO_ALMACEN_ID = " tipo_almacen_id "

    val CREAR_TABLA_TIPO_ALMACEN = (
            crear + TABLA_TIPO_ALMACEN + abrirLlave + TIPO_ALMACEN_ID + PK + coma
                    + TIPO_ALMACEN_DESCRIPCION + string + cerrarLlave)

    val TABLA_ALMACEN = "almacen"
    val ALMACEN_GRUPO = " grupo_almacen "
    val ALMACEN_ID = " id_almacen "
    val ALMACEN_TIPO = " tipo_almacen "

    val CREAR_TABLA_ALMACEN = (
            crear + TABLA_ALMACEN + abrirLlave + ALMACEN_ID + PK + coma
                    + ALMACEN_GRUPO + integer + campoNotNull + coma
                    + ALMACEN_TIPO + integer + campoNotNull +
                    FK +
                    abrirLlave +
                    ALMACEN_GRUPO
                    + cerrarLlave +
                    referenciaA + TABLA_GRUPO + abrirLlave + GRUPO_ID +
                    cerrarLlave +
                    coma + FK + abrirLlave + ALMACEN_TIPO + cerrarLlave + referenciaA + TABLA_TIPO_ALMACEN +
                    abrirLlave + TIPO_ALMACEN_ID + cerrarLlave +
                    cerrarLlave)

    val TABLA_LISTA = "lista"
    val LISTA_ID = " lista_id "
    val LISTA_ULTIMA_ACTUALIZACION = " lista_ultima_Actualizacion "
    val LISTA_ESTADO = " lista_estado "

    val CREAR_TABLA_LISTA = crear + TABLA_LISTA + abrirLlave + LISTA_ID + PK + coma +
            LISTA_ULTIMA_ACTUALIZACION + string + coma +
            LISTA_ESTADO + string + cerrarLlave

    val TABLA_ESTADO_LISTA = "estado_lista"
    val ESTADO_LISTA_ID = " estado_lista_id "
    val ESTADO_LISTA_DESCRIPCION = " estado_lista_descripcion "

    val CREAR_TABLA_ESTADO_LISTA = (
            crear + TABLA_ESTADO_LISTA + abrirLlave + ESTADO_LISTA_ID + PK + coma + ESTADO_LISTA_DESCRIPCION + string + cerrarLlave)

    val TABLA_TIPO_UNIDADES = "tipo_unidades"
    val TIPO_UNIDADES_ID = " tipo_unit_id "
    val TIPO_UNIDADES_DESCRIPCION = " tipo_unit_descripcion "

    val CREAR_TABLA_TIPO_UNIDADES = (
            crear + TABLA_TIPO_UNIDADES + abrirLlave + TIPO_UNIDADES_ID + PK+ coma+ TIPO_UNIDADES_DESCRIPCION+ string + cerrarLlave
            )

    val TABLA_TIPO_PRODUCTO = "tipo_producto"
    val TIPO_PRODUCTO_ID = " tipo_prod_id"
    val TIPO_PRODUCTO_DESCRIPCION = " tipo_prod_descr"

    val CREAR_TABLA_TIPO_PRODUCTO = (
            crear + TABLA_TIPO_PRODUCTO + abrirLlave + TIPO_PRODUCTO_ID + PK+ coma+ TIPO_PRODUCTO_DESCRIPCION+ string + cerrarLlave
            )

    val TABLA_PRODUCTO = "producto"
    val PRODUCTO_ID = " prod_id"
    val PRODUCTO_NOMBRE = " prod_nombre "
    val PRODUCTO_TIPO = " prod_tipo_prod "

    val CREAR_TABLA_PRODUCTO = (
            crear + TABLA_PRODUCTO + abrirLlave + PRODUCTO_ID + PK+ coma+
                    PRODUCTO_NOMBRE+ string + coma +
                    PRODUCTO_TIPO + integer + coma +
                    FK +
                        abrirLlave + PRODUCTO_TIPO + cerrarLlave
                    + referenciaA + TABLA_TIPO_PRODUCTO + abrirLlave + TIPO_PRODUCTO_ID + cerrarLlave
                    + cerrarLlave
            )

    val TABLA_PRODUCTO_X_ALMACEN = "producto_x_almacen"
    val PRODUCTO_X_ALMACEN_FECHA = " prod_x_almacen_fecha "
    val PRODUCTO_X_ALMACEN_ALMACEN = " prod_x_almacen_almacenID "
    val PRODUCTO_X_ALMACEN_PRODUCTO = " prod_x_almacen_productoID "
    val PRODUCTO_X_ALMACEN_CANTIDAD = " prod_x_almacen_cantidad "
    val PRODUCTO_X_ALMACEN_VENCIMIENTO_MAS_CERCANO = " prod_x_almacen_prox_vencimiento "
    val PRODUCTO_X_ALMACEN_PRECIO_TOTAL = " prod_x_almacen_precio_total "

    val CREAR_TABLA_PRODUCTO_X_ALMACEN = (
            crear + TABLA_PRODUCTO_X_ALMACEN + abrirLlave +
                    PRODUCTO_X_ALMACEN_FECHA + PK + coma +
                    PRODUCTO_X_ALMACEN_ALMACEN + integer + campoNotNull+ coma+
                    PRODUCTO_X_ALMACEN_PRODUCTO+ integer + campoNotNull + coma +
                    PRODUCTO_X_ALMACEN_CANTIDAD + integer + coma +
                    PRODUCTO_X_ALMACEN_VENCIMIENTO_MAS_CERCANO + campoDateTime +
                        check + abrirLlave + PRODUCTO_X_ALMACEN_VENCIMIENTO_MAS_CERCANO + " > " + fechaDeHoy + cerrarLlave +    coma +
                    PRODUCTO_X_ALMACEN_PRECIO_TOTAL + integer +
                        check + abrirLlave + PRODUCTO_X_ALMACEN_PRECIO_TOTAL + " > 0 " + cerrarLlave + coma +
                    FK +
                    abrirLlave + PRODUCTO_X_ALMACEN_PRODUCTO + cerrarLlave
                    + referenciaA + TABLA_ALMACEN + abrirLlave + ALMACEN_ID + cerrarLlave +
                    FK +
                        abrirLlave + PRODUCTO_X_ALMACEN_PRODUCTO + cerrarLlave
                        + referenciaA + TABLA_PRODUCTO + abrirLlave + PRODUCTO_ID + cerrarLlave
                    + cerrarLlave
            )

    val TABLA_LISTA_DE_COMPRAS_X_GRUPO = "lista_de_compras_x_grupo"
    val LISTA_DE_COMPRAS_X_GRUPO_GRUPO = " lista_de_compras_x_grupo_grupoID "
    val LISTA_DE_COMPRAS_x_GRUPO_LISTA = " lista_de_compras_x_grupo_listaID "

    val CREAR_TABLA_LISTA_DE_COMPRAS_x_GRUPO_LISTA =(
            crear + TABLA_LISTA_DE_COMPRAS_X_GRUPO + abrirLlave +
                    LISTA_DE_COMPRAS_X_GRUPO_GRUPO + integer + coma +
                    LISTA_DE_COMPRAS_x_GRUPO_LISTA + integer + coma +
                    FK +
                    abrirLlave + LISTA_DE_COMPRAS_X_GRUPO_GRUPO + cerrarLlave +
                        referenciaA + TABLA_GRUPO + abrirLlave + GRUPO_ID + cerrarLlave +
                    FK + abrirLlave + LISTA_DE_COMPRAS_x_GRUPO_LISTA + cerrarLlave +
                        referenciaA + TABLA_LISTA + abrirLlave + LISTA_ID + cerrarLlave +
                    cerrarLlave
            )

    val TABLA_PRODUCTO_X_LISTA = "producto_x_lista"
    val PRODUCTO_X_LISTA_LISTA = " prod_x_list_listaID "
    val PRODUCTO_X_LISTA_PRODUCTO = " prod_x_list_productoID "
    val PRODUCTO_X_LISTA_CANTIDAD = "prod_x_list_cantidad "
    val PRODUCTO_X_LISTA_TIPO_UNIDAD = " prod_x_list_tipo_unidad "
    val PRODUCTO_X_LISTA_DESCRIPCION = " prod_x_list_descripcion "

    val CREAR_TABLA_PRODUCTO_X_LISTA =(
            crear + TABLA_PRODUCTO_X_LISTA + abrirLlave +
                    PRODUCTO_X_LISTA_LISTA + integer + coma +
                    PRODUCTO_X_LISTA_PRODUCTO + integer + coma +
                    PRODUCTO_X_LISTA_CANTIDAD + integer + check + abrirLlave + PRODUCTO_X_LISTA_CANTIDAD + " > 0" + cerrarLlave + coma +
                    PRODUCTO_X_LISTA_TIPO_UNIDAD + integer + coma +
                    PRODUCTO_X_LISTA_DESCRIPCION + string + coma +
                    FK +
                    abrirLlave + PRODUCTO_X_LISTA_LISTA + cerrarLlave +
                    referenciaA + TABLA_LISTA + abrirLlave + LISTA_ID + cerrarLlave +
                    FK + abrirLlave + PRODUCTO_X_LISTA_PRODUCTO + cerrarLlave +
                    referenciaA + TABLA_PRODUCTO + abrirLlave + PRODUCTO_ID + cerrarLlave +
                    FK + abrirLlave + PRODUCTO_X_LISTA_TIPO_UNIDAD + cerrarLlave +
                    referenciaA + TABLA_TIPO_UNIDADES + abrirLlave + TIPO_UNIDADES_ID + cerrarLlave +
                    cerrarLlave
            )
}
