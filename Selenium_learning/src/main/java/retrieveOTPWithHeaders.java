import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class retrieveOTPWithHeaders {
    private final String apiUrl;
    private final String authorizationHeader;
    private final String extractOTPFromJson ;

    public retrieveOTPWithHeaders(String apiUrl, String authorizationHeader) {
        this.apiUrl = apiUrl;
        this.authorizationHeader = authorizationHeader;
    }

    public String getOTP() {
        Response response = given()
                .headers("Accept", "*/*", "Authorization", authorizationHeader,
                        "Host", "jenkins.bigbasket.com", "cache-control", "no-cache")
                .get(apiUrl);

        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        } else {
            System.out.println("Failed to get OTP. Response code: " + response.getStatusCode());
            return null;
        }
    }


    public static void main(String[] args) {
        String apiUrl = "http://jenkins.bigbasket.com/utils/otp/admin?server=https//:hqa2.bigbasket.com&username=arunuk";
        String authorizationHeader = "Basic YmJxYWJvdDpxYWJvdHBhc3N3b3Jk";

        retrieveOTPWithHeaders otpAPI = new retrieveOTPWithHeaders(apiUrl, authorizationHeader);
        String otpResponse = otpAPI.getOTP();

        if (otpResponse != null) {
            System.out.println("Retrieved OTP: " + otpResponse);
            private static String extractOTPFromJson(String jsonResponse) {
                int index = jsonResponse.indexOf("\"otp\":");
                if (index != -1) {
                    int startIndex = index + "\"otp\":".length() + 1; // Start index of the OTP value
                    int endIndex = jsonResponse.indexOf("\"", startIndex); // End index of the OTP value

                    if (startIndex != -1 && endIndex != -1) {
                        return jsonResponse.substring(startIndex, endIndex);
                    }
                }
                return null; // Return null if "otp" key is not found or unable to extract OTP
            }


            // Use the retrieved OTP as needed
        }
    }
}
