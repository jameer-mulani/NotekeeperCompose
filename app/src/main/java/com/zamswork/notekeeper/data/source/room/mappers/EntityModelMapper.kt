package com.zamswork.notekeeper.data.source.room.mappers

interface EntityModelMapper<Entity, Model> {

    fun convertEntityToModel(entity: Entity) : Model

    fun convertModelToEntity(model: Model) : Entity

}