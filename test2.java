public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 사용자 정보를 로그로 출력하는 메서드
    public void logUserInformation() {
        System.out.println("Username: " + username + ", Password: " + password);
    }

    // getter 메서드를 통해 username을 외부로 노출시키는 취약점
    public String getUsername() {
        return username;
    }

    // setter 메서드를 통해 password를 외부에서 변경할 수 있는 취약점
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    // 메인 메서드에서 테스트
    public static void main(String[] args) {
        User user = new User("john.doe", "secretpassword");

        // 외부에서 사용자 정보에 접근하여 출력하는 취약점
        user.logUserInformation();

        // 외부에서 username을 변경하는 취약점
        user.setUsername("jane.doe");

        // 외부에서 password를 변경하는 취약점
        user.setPassword("newpassword");
    }
}
