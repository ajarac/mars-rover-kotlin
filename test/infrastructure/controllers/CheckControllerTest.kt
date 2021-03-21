package infrastructure.controllers

import com.wallapop.main
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class CheckControllerTest {

    @Test
    fun `should return a check api`(): Unit = withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/check")) {
                response.status()  `should be equal to` HttpStatusCode.OK
                response.content `should be equal to` "Hello mars rover!"
            }
        }

}
