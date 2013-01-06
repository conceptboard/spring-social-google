package org.springframework.social.google.api.token;

import java.net.URI;
import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * represents the response to a user info call according to https://developers.google.com/accounts/docs/OAuth2Login
 * 
 * be aware that the response may change without notice
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private String id;
    private String email;
    private Boolean verified_email;
    private String name;
    private String given_name;
    private String family_name;
    private URI picture;
    private Locale locale;
    private TimeZone timezone;
    private String gender;
    private String link;

    /**
     * The value of this field is an immutable identifier for the logged-in user, and may be used when creating and managing user sessions in your application. This identifier is
     * the same regardless of the client_id. This provides the ability to correlate profile information across multiple applications in the same organization. The value of this
     * field is the same as the value of the userid field returned by the TokenInfo endpoint.
     */
    public String getId(){
        return id;
    }

    /** The email address of the logged in user */
    public String getEmail(){
        return email;
    }

    /** A flag that indicates whether or not Google has been able to verify the email address. */
    public Boolean getVerified_email(){
        return verified_email;
    }

    /** The full name of the logged in user */
    public String getName(){
        return name;
    }

    /** The first name of the logged in user */
    public String getGiven_name(){
        return given_name;
    }

    /** The last name of the logged in user */
    public String getFamily_name(){
        return family_name;
    }

    /** The URL to the user's profile picture. If the user has no public profile, this field is not included. */
    public URI getPicture(){
        return picture;
    }

    /** The user's registered locale. If the user has no public profile, this field is not included. */
    public Locale getLocale(){
        return locale;
    }

    /** the default timezone of the logged in user */
    public TimeZone getTimezone(){
        return timezone;
    }

    /** the gender of the logged in user (other|female|male) */
    public String getGender(){
        return gender;
    }

    public String getLink(){
        return link;
    }
}
