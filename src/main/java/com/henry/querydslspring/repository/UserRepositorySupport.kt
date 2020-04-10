package com.henry.querydslspring.repository

import com.henry.querydslspring.entity.QUser.user
import com.henry.querydslspring.entity.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class UserRepositorySupport(private val jpaQueryFactory: JPAQueryFactory) :
    QuerydslRepositorySupport(User::class.java) {

    fun findAllByName(name: String): List<User> =
        jpaQueryFactory.selectFrom(user)
            .where(user.name.eq(name))
            .fetch()!!
}