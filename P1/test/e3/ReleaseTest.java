package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ReleaseTest {

    /* Releases. */
    private static Release beatlesSFFPennyLane; // Original double A-Side.
    private static Release beatlesPennyLanePromo; // Promotional release.
    private static Release beatlesSFFDigital; // One-track digital version.

    private static Release madonnaAngelUKSingle;
    private static Release madonnaAngelUKMaxiSingle;
    private static Release madonnaAngelUSMaxiSingle;
    private static Release madonnaIntoTheGrooveUSMaxiSingle;
    private static Release prueba;

    @BeforeAll
    static void setUp() {
        /* Recordings. */
        String recBeatlesSFF = "6f5f27e2-fe6d-4c98-be0b-1e58d569909c";
        String recBeatlesPennyLane = "5a6becfb-07e3-4286-8de0-5b4fa826f3f2";

        // Angel (short radio version).
        String recMadonnaAngelSingleEdit = "99f49645-1811-42f7-8a14-0df8578ccf09";
        // Angel (extended dance version), different recording.
        String recMadonnaAngelExtendedMix = "74e2ab8f-56f2-4b9c-ad35-336c73cd73e0";
        String recMadonnaBurningUp = "ed102d77-146c-4941-85c6-07f3b9df7117";
        String recMadonnaIntoTheGroove = "986645ce-32d0-42ba-999a-7faf2603aa7e";

        /* Releases. */

        prueba = new Release("0");
        // https://musicbrainz.org/release/eadb40cc-9394-3787-80c3-644ed4a167c0
        beatlesSFFPennyLane = new Release("eadb40cc-9394-3787-80c3-644ed4a167c0");
        beatlesSFFPennyLane.setArtist("Beatles");
        beatlesSFFPennyLane.setTitle("Strawberry Fields Forever / Penny Lane");
        beatlesSFFPennyLane.addTrack(new Track("A", recBeatlesSFF, "The Beatles", "Strawberry Fields Forever", 251));
        beatlesSFFPennyLane.addTrack(new Track("AA", recBeatlesPennyLane,"The Beatles", "Penny Lane", 178));

        // https://musicbrainz.org/release/0173d355-016f-4d28-8c57-cdb0b6fd30a0
        beatlesPennyLanePromo = new Release("0173d355-016f-4d28-8c57-cdb0b6fd30a0");
        beatlesPennyLanePromo.setArtist("The Beatles");
        beatlesPennyLanePromo.setTitle("Penny Lane / Strawberry Fields Forever (Promo)");
        beatlesPennyLanePromo.addTrack(new Track("A", recBeatlesPennyLane,"Beatles", "Penny Lane", 180));
        beatlesPennyLanePromo.addTrack(new Track("B", recBeatlesSFF,"Beatles","Strawberry Fields Forever", 245));

        // https://musicbrainz.org/release/af20e7d5-8ab2-4967-8608-c508213b821d
        beatlesSFFDigital = new Release("af20e7d5-8ab2-4967-8608-c508213b821d");
        beatlesSFFDigital.setArtist("The Beatles");
        beatlesSFFDigital.setTitle("Strawberry Fields Forever (Single)");
        beatlesSFFDigital.addTrack(new Track("1", recBeatlesSFF,"The Beatles","Strawberry Fields Forever (Remastered 2009)", 238));

        // https://musicbrainz.org/release/fcd7fed3-4523-49bc-a310-129a1f3b6bcc
        madonnaAngelUKSingle = new Release("fcd7fed3-4523-49bc-a310-129a1f3b6bcc");
        madonnaAngelUKSingle.setArtist("Madonna");
        madonnaAngelUKSingle.setTitle("Angel (UK 7\" Single)");
        madonnaAngelUKSingle.addTrack(new Track("A1", recMadonnaAngelSingleEdit,"Madonna","Angel (Edit)", 222));
        madonnaAngelUKSingle.addTrack(new Track("B1", recMadonnaBurningUp,"Madonna", "Burning Up", 288));

        // https://musicbrainz.org/release/56f72e41-1060-4926-b77d-58d7b2a4df86
        madonnaAngelUKMaxiSingle = new Release("56f72e41-1060-4926-b77d-58d7b2a4df86");
        madonnaAngelUKMaxiSingle.setArtist("Madonna");
        madonnaAngelUKMaxiSingle.setTitle("Angel (UK 12\" Single)");
        madonnaAngelUKMaxiSingle.addTrack(new Track("A1", recMadonnaAngelExtendedMix, "Madonna","Angel (Extended Dance Mix)", 375));
        madonnaAngelUKMaxiSingle.addTrack(new Track("B1", recMadonnaBurningUp, "Madonna", "Burning Up", 288));

        // https://musicbrainz.org/release/8b53c32c-ee79-42b1-a7a9-bd7c63322c31
        madonnaAngelUSMaxiSingle = new Release("8b53c32c-ee79-42b1-a7a9-bd7c63322c31");
        madonnaAngelUSMaxiSingle.setArtist("Madonna");
        madonnaAngelUSMaxiSingle.setTitle("Angel (US 12\" Single)");
        madonnaAngelUSMaxiSingle.addTrack(new Track("A1", recMadonnaAngelExtendedMix, "Madonna", "Angel (Extended Dance Mix)", 375));
        madonnaAngelUSMaxiSingle.addTrack(new Track("B1", recMadonnaIntoTheGroove,"Madonna", "Into The Groove", 280));

        // https://musicbrainz.org/release/d0e62810-fcab-443e-b3ef-398db6cec5eb
        madonnaIntoTheGrooveUSMaxiSingle = new Release("d0e62810-fcab-443e-b3ef-398db6cec5eb");
        madonnaIntoTheGrooveUSMaxiSingle.setArtist("Madonna");
        madonnaIntoTheGrooveUSMaxiSingle.setTitle("Into the Groove (US 12\" Single)");
        madonnaIntoTheGrooveUSMaxiSingle.addTrack(new Track("A1", recMadonnaIntoTheGroove, "Madonna", "Into the Groove", 280));
        madonnaIntoTheGrooveUSMaxiSingle.addTrack(new Track("B1", recMadonnaAngelExtendedMix, "Madonna", "Angel (12\" Dance Mix)", 375));
    }

    @Test
    void testEquals() {
        assertEquals(beatlesSFFPennyLane, beatlesPennyLanePromo); // Same but with flipped sides.
        assertEquals(madonnaAngelUSMaxiSingle, madonnaIntoTheGrooveUSMaxiSingle); // Same but with flipped sides.
        assertEquals(madonnaAngelUSMaxiSingle, madonnaAngelUSMaxiSingle); // comprobamos asi para ver q funciona con elmismo objetof
    }

    @Test
    void testNotEquals() {
        assertNotEquals(beatlesSFFPennyLane, beatlesSFFDigital); // Different number of songs.
        assertNotEquals(madonnaAngelUKMaxiSingle, madonnaAngelUSMaxiSingle); // Different songs.
        assertNotEquals(madonnaAngelUKSingle, madonnaAngelUSMaxiSingle); // Same songs but different versions.
        assertNotEquals(madonnaAngelUKSingle, null); // Same songs but different versions.
    }

    @Test
    void testHashCode() {
        assertEquals(beatlesSFFPennyLane.hashCode(), beatlesPennyLanePromo.hashCode()); // Same but with flipped sides.
        assertEquals(madonnaAngelUSMaxiSingle.hashCode(), madonnaIntoTheGrooveUSMaxiSingle.hashCode()); // Same but with flipped sides.
    }


//añadidios
    @Test
    void testRelease(){
        assertThrows(IllegalArgumentException.class , ()->new Release(""));
    }

    @Test
    void testToString(){
        assertEquals("ID Lanzamiento: eadb40cc-9394-3787-80c3-644ed4a167c0\nTítulo: Strawberry Fields Forever / Penny Lane\nArtista principal: Beatles\nTracklist:\nPosicion: A\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: The Beatles\nTítulo: Strawberry Fields Forever\nDuracion: 251\n\nPosicion: AA\nID Grabación: 5a6becfb-07e3-4286-8de0-5b4fa826f3f2\nArtista: The Beatles\nTítulo: Penny Lane\nDuracion: 178\n\n" , beatlesSFFPennyLane.toString());
        assertEquals("ID Lanzamiento: 0173d355-016f-4d28-8c57-cdb0b6fd30a0\nTítulo: Penny Lane / Strawberry Fields Forever (Promo)\nArtista principal: The Beatles\nTracklist:\nPosicion: A\nID Grabación: 5a6becfb-07e3-4286-8de0-5b4fa826f3f2\nArtista: Beatles\nTítulo: Penny Lane\nDuracion: 180\n\nPosicion: B\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: Beatles\nTítulo: Strawberry Fields Forever\nDuracion: 245\n\n" , beatlesPennyLanePromo.toString());
        assertEquals("ID Lanzamiento: af20e7d5-8ab2-4967-8608-c508213b821d\nTítulo: Strawberry Fields Forever (Single)\nArtista principal: The Beatles\nTracklist:\nPosicion: 1\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: The Beatles\nTítulo: Strawberry Fields Forever (Remastered 2009)\nDuracion: 238\n\n" , beatlesSFFDigital.toString());
        assertEquals("ID Lanzamiento: fcd7fed3-4523-49bc-a310-129a1f3b6bcc\nTítulo: Angel (UK 7\" Single)\nArtista principal: Madonna\nTracklist:\nPosicion: A1\nID Grabación: 99f49645-1811-42f7-8a14-0df8578ccf09\nArtista: Madonna\nTítulo: Angel (Edit)\nDuracion: 222\n\nPosicion: B1\nID Grabación: ed102d77-146c-4941-85c6-07f3b9df7117\nArtista: Madonna\nTítulo: Burning Up\nDuracion: 288\n\n" , madonnaAngelUKSingle.toString());
        assertEquals("ID Lanzamiento: 56f72e41-1060-4926-b77d-58d7b2a4df86\nTítulo: Angel (UK 12\" Single)\nArtista principal: Madonna\nTracklist:\nPosicion: A1\nID Grabación: 74e2ab8f-56f2-4b9c-ad35-336c73cd73e0\nArtista: Madonna\nTítulo: Angel (Extended Dance Mix)\nDuracion: 375\n\nPosicion: B1\nID Grabación: ed102d77-146c-4941-85c6-07f3b9df7117\nArtista: Madonna\nTítulo: Burning Up\nDuracion: 288\n\n" , madonnaAngelUKMaxiSingle.toString());
        assertEquals("ID Lanzamiento: 8b53c32c-ee79-42b1-a7a9-bd7c63322c31\nTítulo: Angel (US 12\" Single)\nArtista principal: Madonna\nTracklist:\nPosicion: A1\nID Grabación: 74e2ab8f-56f2-4b9c-ad35-336c73cd73e0\nArtista: Madonna\nTítulo: Angel (Extended Dance Mix)\nDuracion: 375\n\nPosicion: B1\nID Grabación: 986645ce-32d0-42ba-999a-7faf2603aa7e\nArtista: Madonna\nTítulo: Into The Groove\nDuracion: 280\n\n" , madonnaAngelUSMaxiSingle.toString());
        assertEquals("ID Lanzamiento: d0e62810-fcab-443e-b3ef-398db6cec5eb\nTítulo: Into the Groove (US 12\" Single)\nArtista principal: Madonna\nTracklist:\nPosicion: A1\nID Grabación: 986645ce-32d0-42ba-999a-7faf2603aa7e\nArtista: Madonna\nTítulo: Into the Groove\nDuracion: 280\n\nPosicion: B1\nID Grabación: 74e2ab8f-56f2-4b9c-ad35-336c73cd73e0\nArtista: Madonna\nTítulo: Angel (12\" Dance Mix)\nDuracion: 375\n\n" , madonnaIntoTheGrooveUSMaxiSingle.toString());
    }

    @Test
    void testWhatArtist(){
        assertEquals("Beatles" , beatlesSFFPennyLane.whatArtist());
        assertEquals("The Beatles" , beatlesPennyLanePromo.whatArtist());
        assertEquals("The Beatles" , beatlesSFFDigital.whatArtist());
        assertEquals("Madonna" , madonnaAngelUKSingle.whatArtist());
        assertEquals("Madonna" , madonnaAngelUKMaxiSingle.whatArtist());
        assertEquals("Madonna" , madonnaAngelUSMaxiSingle.whatArtist());
        assertEquals("Madonna" , madonnaIntoTheGrooveUSMaxiSingle.whatArtist());

    }
    @Test
    void testWhatTitle(){
        assertEquals("Strawberry Fields Forever / Penny Lane" , beatlesSFFPennyLane.whatTitle());
        assertEquals("Penny Lane / Strawberry Fields Forever (Promo)" , beatlesPennyLanePromo.whatTitle());
        assertEquals("Strawberry Fields Forever (Single)" , beatlesSFFDigital.whatTitle());
        assertEquals("Angel (UK 7\" Single)" , madonnaAngelUKSingle.whatTitle());
        assertEquals("Angel (UK 12\" Single)" , madonnaAngelUKMaxiSingle.whatTitle());
        assertEquals("Angel (US 12\" Single)" , madonnaAngelUSMaxiSingle.whatTitle());
        assertEquals("Into the Groove (US 12\" Single)" , madonnaIntoTheGrooveUSMaxiSingle.whatTitle());

    }
    @Test
    void testSetArtist(){
        assertThrows(IllegalArgumentException.class , ()->prueba.setArtist(""));
    }
    @Test
    void testSetTitle(){
        assertThrows(IllegalArgumentException.class , ()->prueba.setTitle(""));
    }
    @Test
    void testAddTrack(){
        assertThrows(IllegalArgumentException.class , ()->prueba.addTrack(null));
    }
    @Test
    void testWhatTrack(){
        List<Track> track = prueba.whatTrack();
        assertEquals(track , prueba.whatTrack());
        prueba.addTrack(new Track("1", "NIP", "Ye", "Niggas in Paris", 243));
        assertEquals(track , prueba.whatTrack());
        //Comprobamos que se actualiza
    }
}
