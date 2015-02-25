package org.monstercraft.info.plugin.api;

/**
 * Enum containing cell carriers and their stmp addresses. List of stmp addresses can be found here: http://en.wikipedia.org/wiki/List_of_SMS_gateways
 *
 * @author Fletch to 99 <fletchto99@hotmail.com>
 */
public enum Carrier {

    /**
     * All of the cell carriers along with their company name and stmp address.
     */
    TELUS("@msg.telus.com", "Telus"), KOODO("@mms.koodomobile.com", "Koodo"), BELLCANADA(
            "@txt.bell.ca", "BellCanada"), FIDO("@fido.ca", "Fido"), TMOBILEUSA(
            "@tmomail.net", "TMobile"), VERIZON("@vtext.com", "Verizon"), VIRGINMOBILECANADA(
            "@vmobile.ca", "VirginCanada"), VIRGINMOBILEUSA("@vmpix.com",
            "VirginUSA"), SPRINT("@messaging.sprintpcs.com", "Sprint");

    /**
     * The carrier's stmp address.
     */
    private String smtp;

    /**
     * The name of the carrier.
     */
    private String name;

    /**
     * Sets the name and stmp of the carrier.
     *
     * @param stmp
     *            The stmp of the carrier.
     * @param name
     *            The carrier's company name.
     */
    Carrier(final String smtp, final String name) {
        this.smtp = smtp;
        this.name = name;
    }

    /**
     * Fetches the company name.
     *
     * @return The carrier's company name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Fetches the stmp address.
     *
     * @return The stmp address of the carrier.
     */
    public final String getSMTP() {
        return smtp;
    }

}