public class SecurityTest {

    // 약한 암호화 사용 예시
    public String encryptPassword(String password) {
        // 임시로 암호화에 약한 알고리즘을 사용합니다.
        String encryptedPassword = MD5(password);
        return encryptedPassword;
    }

    // SQL 삽입 취약점 예시
    public void getUserData(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        // 데이터베이스에 쿼리를 전송하는 코드...
    }

    // XSS(Cross-Site Scripting) 취약점 예시
    public String getUserProfile(String username) {
        // 사용자 프로필을 데이터베이스에서 가져옵니다.
        String profile = getProfileFromDB(username);

        // 프로필 데이터를 HTML로 렌더링할 때 적절한 이스케이프를 수행하지 않습니다.
        return "<h1>Welcome, " + profile + "!</h1>";
    }

    // 메인 메소드에서 테스트
    public static void main(String[] args) {
        SecurityTest test = new SecurityTest();
        String encryptedPassword = test.encryptPassword("myPassword");
        System.out.println("Encrypted Password: " + encryptedPassword);

        test.getUserData("admin");
        String userProfile = test.getUserProfile("<script>alert('XSS!');</script>");
        System.out.println("User Profile: " + userProfile);
    }
}
