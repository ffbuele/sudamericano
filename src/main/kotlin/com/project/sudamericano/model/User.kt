package com.project.sudamericano.model

import javax.persistence.*

@Entity
@Table(name = "users")

class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var last_name: String? = null
    var phone: String? = null
    var email: String? = null
    var password: String? = null
    var status: String? = null
    var username: String? = null
}