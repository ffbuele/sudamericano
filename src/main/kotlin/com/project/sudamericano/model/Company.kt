package com.project.sudamericano.model

import javax.persistence.*

@Entity
@Table(name = "company")

class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var status: String? = null
    var id_user: Long? = null

}