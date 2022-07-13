package com.project.sudamericano.service

import com.google.gson.Gson
import com.project.sudamericano.model.User
import com.project.sudamericano.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class UserServiceTest {

//    @Autowired
//    lateinit var userService: UserService

    @InjectMocks
    lateinit var userService: UserService

    @Mock
    lateinit var userRepository: UserRepository

    val jsonString = File("./src/test/resources/user.json").readText(Charsets.UTF_8)
    val userMock = Gson().fromJson(jsonString, User::class.java)

    @Test
    fun saveProduct(){
        // PAra actualizar
        // LLAVES  FORENEAS
        // Mockito.`when`(userRepository.findById(productMock.id)).thenReturn(productMock)
        Mockito.`when`(userRepository.save(Mockito.any(User::class.java))).thenReturn(userMock)
        val response = userService.save(userMock)
        Assertions.assertEquals(response?.id, userMock.id)
    }

    @Test
    fun saveProductFailed(){
        Assertions.assertThrows(Exception::class.java) {
            userMock.apply { name = " " }
            Mockito.`when`(userRepository.save(Mockito.any(User::class.java))).thenReturn(userMock)
            userService.save(userMock)
        }
    }

//    @Test
//    fun validateSerialIsValid() {
//        val response = userService.validateSerialNumber("7866513")
//        Assertions.assertEquals(true, response)
//    }
//
//    @Test
//    fun validateSerialIsInvalid() {
//        val response = userService.validateSerialNumber("6486513")
//        Assertions.assertEquals(false, response)
//    }
//
//    @Test
//    fun validateSerialIsBlank() {
//        Assertions.assertThrows(Exception::class.java) {
//            val response = userService.validateSerialNumber("")
//        }
//    }
//
//    @Test
//    fun validateSerialIsIncomplete() {
//        Assertions.assertThrows(Exception::class.java) {
//            val response = userService.validateSerialNumber("1")
//        }
//    }
//
//    @Test
//    fun productWhentLessThanTen() {
//        val response = userService.product(1, 7)
//        Assertions.assertEquals(7, response)
//    }
//
//    @Test
//    fun productWhentMajorThanTen() {
//        val response = userService.product(2, 7)
//        Assertions.assertEquals(5, response)
//    }
//
//    @Test
//    fun validarSumaNui(){
//        val response = userService.sumaValores("140106154")
//        Assertions.assertEquals(28, response)
//    }
//
//    @Test
//    fun validarDecenaSuperiorCuandoNoEsCero(){
//        val response = userService.findLastDig(25)
//        Assertions.assertEquals(5, response)
//    }
//
//    @Test
//    fun validarDecenaSuperiorCuandoEsCero(){
//        val response = userService.findLastDig(10)
//        Assertions.assertEquals(0, response)
//    }
//
//    @Test
//    fun validarCedulaIsValida(){
//        val response = userService.validarCedula("0107466152")
//        Assertions.assertEquals(false, response)
//    }
}
