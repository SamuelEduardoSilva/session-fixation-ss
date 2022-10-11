import com.ssdemo.auth.Role
import com.ssdemo.auth.User
import com.ssdemo.auth.UserRole

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def user = User.findOrSaveWhere(username: "samuel.silva@asaas.com", password: "senha")

        if (!user.authorities.contains(adminRole)) {
            UserRole.create(user, adminRole, true)
        }
    }
    def destroy = {
    }
}
