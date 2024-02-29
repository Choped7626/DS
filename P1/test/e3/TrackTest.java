package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TrackTest {

    /* Tracks. */

    // SFF/PL original double A-Side.
    private static Track beatlesSFFPennyLane01;
    private static Track beatlesSFFPennyLane02;

    // PL promotional release.
    private static Track beatlesPennyLanePromo01;
    private static Track beatlesPennyLanePromo02;

    // SFF digital one-track version.
    private static Track beatlesSFFDigital01;
    private static Track trakParaQsaltenLosErrores1;
    private static Track trakParaQsaltenLosErrores2;

    @BeforeAll
    static void setUp() {
        /* Recordings. */
        String recBeatlesSFF = "6f5f27e2-fe6d-4c98-be0b-1e58d569909c";
        String recBeatlesPennyLane = "5a6becfb-07e3-4286-8de0-5b4fa826f3f2";

        /* Tracks.
         * Note that some are credited to "Beatles" and some to "The Beatles".
         * Lengths may also vary slightly. */

        // https://musicbrainz.org/release/eadb40cc-9394-3787-80c3-644ed4a167c0
        beatlesSFFPennyLane01 = new Track("A", recBeatlesSFF, "The Beatles","Strawberry Fields Forever", 251);
        beatlesSFFPennyLane02 = new Track("AA", recBeatlesPennyLane,"The Beatles","Penny Lane", 178);

        // https://musicbrainz.org/release/0173d355-016f-4d28-8c57-cdb0b6fd30a0
        beatlesPennyLanePromo01 = new Track("A", recBeatlesPennyLane, "Beatles", "Penny Lane", 180);
        beatlesPennyLanePromo02 = new Track("B", recBeatlesSFF, "Beatles","Strawberry Fields Forever", 245);

        // https://musicbrainz.org/release/af20e7d5-8ab2-4967-8608-c508213b821d
        beatlesSFFDigital01 = new Track("1", recBeatlesSFF,"The Beatles","Strawberry Fields Forever (Remastered 2009)", 238);
        //erores
        trakParaQsaltenLosErrores1 = new Track("" , "" ,"" ,"" ,0);
        trakParaQsaltenLosErrores2 = new Track(null , null , null ,null , -654);
    }

    @Test
    void testEquals() {
        assertEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo02);
        assertEquals(beatlesSFFPennyLane02, beatlesPennyLanePromo01);
        assertEquals(beatlesSFFPennyLane01, beatlesSFFDigital01);
        assertEquals(beatlesPennyLanePromo01 , beatlesPennyLanePromo01);//comprobamos asi para ver q funcione si es el mismo objeto
    }

    @Test
    void testNotEquals() {
        assertNotEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo01); // Completely different songs.
        assertNotEquals(beatlesSFFPennyLane01, null); // Completely different songs.
    }

    @Test
    void testHashCode() {
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFDigital01.hashCode());
    }

//añadidos
    @Test
    void testToString(){
        assertEquals("Posicion: A\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: The Beatles\nTítulo: Strawberry Fields Forever\nDuracion: 251\n" , beatlesSFFPennyLane01.toString());
        assertEquals("Posicion: AA\nID Grabación: 5a6becfb-07e3-4286-8de0-5b4fa826f3f2\nArtista: The Beatles\nTítulo: Penny Lane\nDuracion: 178\n" , beatlesSFFPennyLane02.toString());
        assertEquals("Posicion: A\nID Grabación: 5a6becfb-07e3-4286-8de0-5b4fa826f3f2\nArtista: Beatles\nTítulo: Penny Lane\nDuracion: 180\n" , beatlesPennyLanePromo01.toString());
        assertEquals("Posicion: B\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: Beatles\nTítulo: Strawberry Fields Forever\nDuracion: 245\n" , beatlesPennyLanePromo02.toString());
        assertEquals("Posicion: 1\nID Grabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\nArtista: The Beatles\nTítulo: Strawberry Fields Forever (Remastered 2009)\nDuracion: 238\n" , beatlesSFFDigital01.toString());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.toString());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.toString());
    }

    @Test
    void testWhatPosition(){
        assertEquals("A" , beatlesPennyLanePromo01.whatPosition());
        assertEquals("B" , beatlesPennyLanePromo02.whatPosition());
        assertEquals("A" , beatlesSFFPennyLane01.whatPosition());
        assertEquals("AA" , beatlesSFFPennyLane02.whatPosition());
        assertEquals("1" , beatlesSFFDigital01.whatPosition());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.whatPosition());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.whatPosition());

    }

    @Test
    void testWhatArtista(){
        assertEquals("Beatles" , beatlesPennyLanePromo01.whatArtista());
        assertEquals("Beatles" , beatlesPennyLanePromo02.whatArtista());
        assertEquals("The Beatles" , beatlesSFFPennyLane01.whatArtista());
        assertEquals("The Beatles" , beatlesSFFPennyLane02.whatArtista());
        assertEquals("The Beatles" , beatlesSFFDigital01.whatArtista());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.whatArtista());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.whatArtista());
    }

    @Test
    void testWhatSong(){
        assertEquals("Penny Lane" , beatlesPennyLanePromo01.whatSong());
        assertEquals("Strawberry Fields Forever" , beatlesPennyLanePromo02.whatSong());
        assertEquals("Strawberry Fields Forever" , beatlesSFFPennyLane01.whatSong());
        assertEquals("Penny Lane" , beatlesSFFPennyLane02.whatSong());
        assertEquals("Strawberry Fields Forever (Remastered 2009)" , beatlesSFFDigital01.whatSong());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.whatSong());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.whatSong());

    }

    @Test
    void testWhatDuration(){
        assertEquals(180 , beatlesPennyLanePromo01.whatDuration());
        assertEquals(245 , beatlesPennyLanePromo02.whatDuration());
        assertEquals(251 , beatlesSFFPennyLane01.whatDuration());
        assertEquals(178 , beatlesSFFPennyLane02.whatDuration());
        assertEquals(238 , beatlesSFFDigital01.whatDuration());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.whatDuration());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.whatDuration());
    }

    @Test
    void testWhatID(){
        assertEquals("5a6becfb-07e3-4286-8de0-5b4fa826f3f2" , beatlesPennyLanePromo01.whatId());
        assertEquals("6f5f27e2-fe6d-4c98-be0b-1e58d569909c" , beatlesPennyLanePromo02.whatId());
        assertEquals("6f5f27e2-fe6d-4c98-be0b-1e58d569909c" , beatlesSFFPennyLane01.whatId());
        assertEquals("5a6becfb-07e3-4286-8de0-5b4fa826f3f2" , beatlesSFFPennyLane02.whatId());
        assertEquals("6f5f27e2-fe6d-4c98-be0b-1e58d569909c" , beatlesSFFDigital01.whatId());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores1.whatId());
        assertThrows(IllegalArgumentException.class , ()->trakParaQsaltenLosErrores2.whatId());

    }

}
