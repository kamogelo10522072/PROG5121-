package progpoe.part1;

public class Login {
    private String firstName;
    private String lastName;
    private String userName;
    private String pwd;
    private String cellNum;
    private boolean isUserValid;
    private boolean isPwdValid;
    private boolean isCellValid;

    public void storeNames(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public boolean checkUserName(String user) {
        userName = user;
        isUserValid = user != null && user.length() <= 5 && user.contains("_");
        return isUserValid;
    }

    public boolean checkPassword(String pass) {
        pwd = pass;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";
        isPwdValid = pass != null && pass.matches(regex);
        return isPwdValid;
    }

    public boolean checkCellPhoneNumber(String num) {
        cellNum = num;
        String regex = "^\\+27\\d{9}$";
        isCellValid = num != null && num.matches(regex);
        return isCellValid;
    }

    public String registerUser() {
        if(!isUserValid) {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        } else {
            System.out.println("Username successfully captured.");
        }
        if(!isPwdValid) {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        } else {
            System.out.println("Password successfully captured.");
        }
        if(isUserValid && isPwdValid) {
            return "You have successfully registered.";
        }
        return "Username/Password is invalid.";
    }

    public String returnLoginStatus(String loginUser, String loginPass) {
        if(loginUser.equals(userName) && loginPass.equals(pwd) && isUserValid && isPwdValid && isCellValid) {
            return "Welcome " + firstName + ", " + lastName + "  it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}