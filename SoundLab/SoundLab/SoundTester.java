import java.io.IOException;

public class SoundTester
{
    public static void main(String[] args) throws IOException
    {
        //adjustVolumeTest();
        //
        //joinTest();
        //
        //mixTest();
        //
        //     fadeInTest();
        //
        //fadeOutTest();
        //
              harmonicToneTest(); //didnt understand
    }

    public static void adjustVolumeTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 1));

        Sound.show(s.getClip());
        Sound.play(s.getClip());
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.adjustVolume(1.5);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.adjustVolume(0.25);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
    }


    public static void joinTest()
    {
        SoundClip s = new SoundClip();

        double[] clip1 = Sound.pureTone(200, 1);
        double[] clip2 = Sound.pureTone(400, 1);

        s.join(clip1, clip2);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
    }

    public static void mixTest()
    {
        SoundClip s = new SoundClip();

        double[] clip1 = Sound.pureTone(200, 1);
        double[] clip2 = Sound.pureTone(400, 1);

        Sound.play(clip1);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        Sound.play(clip2);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.mix(clip1, clip2);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
    }

    public static void fadeInTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));

        s.fadeIn(1);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
    }

    public static void fadeOutTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));

        s.fadeOut(1);

        Sound.show(s.getClip());
        Sound.play(s.getClip());
    }
    

    public static void harmonicToneTest() throws IOException
    {
    SoundClip s = new SoundClip(Sound.pureTone(200, 3));
    s.adjustVolume(1.5);

    Sound.show(s.getClip());
    Sound.play(s.getClip()); //play basic pure tone
    try { Thread.sleep(1000); } catch (InterruptedException e) {}

    s.harmonicTone(200, 3, "amplitudes.txt");

    Sound.show(s.getClip());
    Sound.play(s.getClip()); //play harmonic version of tone
    }
    
}
