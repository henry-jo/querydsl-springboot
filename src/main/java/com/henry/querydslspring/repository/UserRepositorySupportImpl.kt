package com.henry.querydslspring.repository

import com.henry.querydslspring.entity.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositorySupportImpl : UserRepositorySupportInterface {
    @Autowired
    private lateinit var jpqQueryFactory: JPAQueryFactory

    override fun findAllByName(name: String) =
        jpqQueryFactory
            .select(user)
            .where(user.name.eq(name))
            .fetch()
}