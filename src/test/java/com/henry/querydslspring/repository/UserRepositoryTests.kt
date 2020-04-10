package com.henry.querydslspring.repository

import com.henry.querydslspring.entity.User
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
class UserRepositoryTests {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userRepositorySupport: UserRepositorySupport

    @After
    fun clear() = userRepository.deleteAllInBatch()

    @Test
    fun querydsl_basic_test() {
        // given
        val name = "henry"
        val age = 20
        userRepository.save(User(name = name, age = age))

        // when
        val result = userRepositorySupport.findAllByName(name)

        // then
        assertEquals(result.last().age, 20)
    }

    @Test
    fun querydsl_custom_test() {
        // given
        val name = "henry"
        val age = 20
        userRepository.save(User(name = name, age = age))

        // when
        // 기본 userRepository로 조회
        // userRepository에서 JPA Repository, QueryDSL Repository 둘다 상속받고 있기 때문에 가능.
        val result = userRepository.findAllByName(name)

        // then
        assertEquals(result.last().age, 20)
    }
}