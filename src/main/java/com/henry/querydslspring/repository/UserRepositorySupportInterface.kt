package com.henry.querydslspring.repository

import com.henry.querydslspring.entity.User

interface UserRepositorySupportInterface {
    fun findAllByName(name: String): List<User>
}