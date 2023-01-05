class LoginHandler {
  /**
   * The field SIGN_IN_ATTEMPTS has now been deprecated,
   * and replaced by more appropriate name.
   * @deprecated Use ACCOUNT_LOCKOUT_THRESHOLD instead.
   */
  @Deprecated(since = "10", forRemoval = false)         // Ordinarily deprecated
  public static final int SIGN_IN_ATTEMPTS = 4;         // static field.
  public static final int ACCOUNT_LOCKOUT_THRESHOLD = 4;

  /**
   * The following method has now been deprecated.
   * @deprecated Use initTwoFactorAuthentication() instead
   */
  @Deprecated(since = "10", forRemoval = true)          // Terminally deprecated
  public void initAuthentication() { /* ...*/ }         // instance method.

  public void initTwoFactorAuthentication() { /* ... */ }
}

public class UserLogin {
  public static void main(String[] args) {
    LoginHandler lh = new LoginHandler();
    lh.initAuthentication();                            // Removal warning
    System.out.println(LoginHandler.SIGN_IN_ATTEMPTS);  // Deprecation warning
  }
}