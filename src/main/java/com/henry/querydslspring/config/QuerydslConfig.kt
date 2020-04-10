package com.henry.querydslspring.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfig {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Bean(name = ["jpaQueryFactory"])
    fun jpaQueryFactory() = JPAQueryFactory(entityManager)
}