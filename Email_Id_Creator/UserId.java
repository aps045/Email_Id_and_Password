package Email_Id_Creator;

public class UserId {
    private String name;            //variable to store Name
    private String companyName;     //variable to store Company Name
    private int yearOfJoining;      //variable to store Year of Joining
    private String email;           //variable to store Email Id
    private String password;        //variable to store password to that correspond Email Id

    public UserId(String name, String companyName, int yearOfJoining) {       //definition of constructor
        this.name = name;
        this.companyName = companyName;
        this.yearOfJoining = yearOfJoining;
        this.email = createUserEmail();
        this.password = createUserPassword();
    }
    private static int generateRandomIntegerFromLimit(int limit) {
                            //method to produce random integer from a given limit for password
        return (int) (Math.random() * (limit));
    }
    private String createUserPassword() {           //method to create password for the user
        StringBuilder sb = new StringBuilder();         //object initialization of String Builder type
        sb.append(generateRandomCharacter());               //append a random character in the string
        for (int i = 0; i < 4; i++) {                           //loop to get 4 digit random integer password
            sb.append(generateRandomIntegerFromLimit(10));      //append a random integer as a character in the string
        }
        sb.append(getFirst5CharactersFromUserName());       //append first 5 characters from the user name in string object
        sb.append(generateRandomSpecialSymbol());           //append a random symbol as a character in String object
        return sb.toString();
    }
    private String createUserEmail() {                  //method to create user email
        return String.format("%s_%d@%s.com",
                getName().toLowerCase(), getYearOfJoining(), getCompanyName().toLowerCase());
    }
    public String getName() {               //getter method for name
        return name;
    }
    public String getCompanyName() {        //getter method for company name
        return companyName;
    }
    public int getYearOfJoining() {         //getter method for year of joining
        return yearOfJoining;
    }
    public String getEmail() {              //getter method for email
        return email;
    }
    public String getPassword() {           //getter method for password
        return password;
    }
    public void setName(String name) {      //setter method for name
        this.name = name;
    }
    public void setCompanyName(String companyName) {        //setter method for company name
        this.companyName = companyName;
    }
    public void setYearOfJoining(int yearOfJoining) {       //setter method for year of joining
        this.yearOfJoining = yearOfJoining;
    }
    public void setEmail(String email) {            //setter method for email
        this.email = email;
    }
    public void setPassword(String password) {              //setter method for password
        this.password = password;
    }
    private String getFirst5CharactersFromUserName() {      //method for getting 5 characters from user name
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            return (getName() + "0".repeat(Math.max(0, difference))).toLowerCase();
        } else {
            return getName().substring(0, 5);
        }
    }
    private char generateRandomSpecialSymbol() {            //method to generate a random symbol
        char[] specialSymbols =
                {
                        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
                        '{', '}', '[', ']', '|', '\\', ';', ':', '\'', '\"',
                        '<', '>', ',', '.', '?', '/'
                };
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }
    private char generateRandomCharacter() {                            //method to generate a random character for passwords
        int randomNumberUpto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }
}
