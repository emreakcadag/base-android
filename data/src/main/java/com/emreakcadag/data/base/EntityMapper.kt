package com.emreakcadag.data.base

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
interface EntityMapper<Response, DbEntity, ViewEntity> {

    fun responseToDbEntity(response: Response?): DbEntity?

    fun dbEntityToViewEntity(entity: DbEntity?): ViewEntity?
}