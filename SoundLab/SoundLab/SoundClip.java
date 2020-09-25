import java.util.*; 
import java.io.*;
public class SoundClip 
{

    private double[] clip;
    public SoundClip()
    {
        clip=null;
    }

    public SoundClip(double[] a)
    {
        clip=a;
    }

    public void adjustVolume(double factor) 
    {
        for (int i=0;i<clip.length;i++){
            clip[i]*=factor;
        }
    }

    public static double[] adjustVolume(double[] clip, double factor)
    {
        double[] j=clip;
        for (int i=0;i<clip.length;i++){
            j[i]*=factor;
        }

        return j;
    }

    public double[] getClip()
    {
        return clip;
    }

    public void mix(double[] clip1, double[] clip2)
    {
        clip=new double[clip1.length];
        for (int i=0; i<clip.length;i++)
        {
            clip[i]=clip1[i]+clip2[i];
        }
    }

    public void mix1(double[] clip1, double[] clip2, double[] clip3,double[] clip4,double[] clip5)
    {
        clip=new double[clip1.length];
        for (int i=0; i<clip.length;i++)
        {
            clip[i]=clip1[i]+clip2[i]+clip3[i]+clip4[i]+clip5[i];
        }
    }

    public void join(double[] clip1, double[] clip2)
    {
        clip=new double[clip1.length+clip2.length];
        int i;
        for(i=0; i<clip1.length; i++)
            clip[i] = clip1[i];

        for(int j=0; j<clip2.length; j++)
            clip[i++]=clip2[j];

    }

    public void fadeIn(double seconds)
    {
        double i = Sound.toNumSamples(seconds);
        for (int j=0; j< i; j++)
        {
            clip[j]=clip[j]*(j/i);
        }

    }

    public void fadeOut(double seconds)
    {
        int i = Sound.toNumSamples(seconds);
        i*=2;
        int b = 3*Sound.toNumSamples(seconds);
        double a= Sound.toNumSamples(seconds);
        int h=Sound.toNumSamples(seconds);
        for (int j=i; j< b; j++)
        {
            clip[j]=clip[j]*(a/h);
            a--;
        }

    }

    public void harmonicTone(double frequency, double seconds, String amplitudesFile) throws IOException 
    {
        File file = new File("amplitudes.txt");
        Scanner in = new Scanner(file);
        clip = new double[Sound.toNumSamples(seconds)];
        for (int i=0; in.hasNext();i++)
        {
            
            double harmonic[]=Sound.pureTone(frequency*i,seconds);
            adjustVolume(clip,in.nextDouble());
            mix(clip,harmonic);
        }
        

    }
}