package com.project.sudamericano.model

import javax.persistence.*

@Entity
@Table(name = "farmacy")

class Farmacy {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var phone: String? = null
    var address: String? = null
    var status: String? = null
    @Column(name = "id_user")
    var idUser: Long? = null
    @Column(name = "id_company")
    var idCompany: Long? = null
    @Column(name = "id_sector")
    var idSector: Long? = null

}