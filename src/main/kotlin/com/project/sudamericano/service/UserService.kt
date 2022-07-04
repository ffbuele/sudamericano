package com.project.sudamericano.service

import com.project.sudamericano.model.User
import com.project.sudamericano.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun list (): List<User>{
        return userRepository.findAll()
    }

    fun getById (id:Long?): User?{
        return userRepository.findById(id)
    }

    fun getByStatus (status: String?):List<User>?{
        return userRepository.getListStatus (status)
    }

    fun save(user: User): User{
        try {
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.username?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El username no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            return userRepository.save(user)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(user: User): User{
        try {
            userRepository.findById(user.id)
                ?: throw Exception("El id ${user.id} en user no existe")
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.username?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("El username no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
//            userRepository.findById(user.id)
//                ?: throw Exception("El id ${user.id} en user no existe");
            return userRepository.save(user)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateOne(user: User): User {
        try {
            userRepository.findById(user.id)
                ?: throw Exception("El id ${user.id} no existe en user")
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.username?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El username no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            return userRepository.save(user)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete(id: Long): Boolean{
        try {
            userRepository.findById(id)
                ?: throw Exception("El id ${id} no existe en user")
            userRepository.deleteById(id)

            return true
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun validateSerialNumber (serial: String?): Boolean? {
        serial.takeIf { !it?.trim().isNullOrEmpty() }
            ?: throw Exception()
        if (serial?.substring(0, 3).equals("786"))
            return true
        return false
    }

    // VALIDACION DE CEDULA

    fun product (iq: Int, dig: Int): Int {
        val response = iq * dig
        if (response >= 10)
            return response - 9
        return response
    }

    fun sumaValores (nui: String): Int {
        var sum: Int = 0
        for ( i in 0..8 ) {
            val iq = if( i%2 ==0 ) 2 else 1
            sum  += product( iq, Integer.parseInt( nui[i].toString() ))
        }
        return sum
    }

    fun findLastDig (sum: Int): Int {            //21
        val div: Int = sum /10                          //0
        val decenaSuperior: Int = ( div + 1 ) * 10      //1 * 10 = 10
        var response: Int = decenaSuperior - sum        //10 - 0 = 10
        if (response == 10)
            response = 0                                // si es 10 sera 0
        return response
    }

    fun validarCedula (cedula: String): Boolean {   //1401061542
        val sum = sumaValores( cedula )   // valor de la suma del string
        val lastDig = findLastDig(sum)    // calculo de ultimo dig

        val lastDigCedString = cedula.last()   //ultimo digito
        val lastDigCedInt = Integer.parseInt(lastDigCedString.toString())    //cambiado a int

        if(lastDigCedInt == lastDig)
            return true
        return false
    }
}