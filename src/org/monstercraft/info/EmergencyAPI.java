package org.monstercraft.info;

import org.monstercraft.info.plugin.api.Carrier;

public class EmergencyAPI {

    public static boolean sendMail(final String subject, final String body) {
        return EmergencyAPI.sendMail(subject, body, MonsterEmergency.TO);
    }

    public static boolean sendMail(final String subject, final String body,
            final String to) {
        return MonsterEmergency.getEmailer().sendEmail(to, subject, body,
                MonsterEmergency.STMP_PORT, MonsterEmergency.STMP_HOST,
                MonsterEmergency.STMP_USERNAME, MonsterEmergency.STMP_PASSWORD);
    }

    public static boolean sendTextMessage(final String message) {
        return EmergencyAPI.sendTextMessage("", message);
    }

    public static boolean sendTextMessage(final String subject,
            final String message) {
        return EmergencyAPI.sendTextMessage(subject, message,
                MonsterEmergency.NUMBER, MonsterEmergency.CARRIER);
    }

    public static boolean sendTextMessage(final String subject,
            final String message, final String number, final Carrier carrier) {
        return EmergencyAPI.sendMail(subject, message,
                number + carrier.getSMTP());
    }

}
