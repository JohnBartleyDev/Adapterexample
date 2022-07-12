
public class HDMIaudioinput{
    private File audioinput;
    public AVinput(File audioinput){
        this.audioinput =audioinput;
    }
    public AudioInputStream getaudio(File audioinput){
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(audioinput);
        return audiostream;
    }
}

public class AVaudioinput{
    private File leftaudioinput;
    private File rightaudioinput;
    public AVinput(File leftaudioinput,File rightaudioinput){
        this.leftaudioinput =leftaudioinput;
        this.rightaudioinput =rightaudioinput;
    }
    public AudioInputStream getaudio1(){
        AudioInputStream audio1 =AudioSystem.getAudioInputStream(this.leftaudioinput);
        return audio1;
    }
    public AudioInputStream getaudio2(){
        AudioInputStream audio2 =AudioSystem.getAudioInputStream(this.rightaudioinput);
        return audio2;
    }
}

public class AVadapter extends HDMIaudioinput{
    private AVinput avin;

    public AVadapter(AVinput avin){
        this.avin = avin;
    }
    @Override
    public AudioInputStream getaudio(){
        File audiofile;
        AudioSystem.write(avin.getaudio1(), "LCPM", audiofile); 
        AudioSystem.write(avin.getaudio2(), "LCPM", audiofile);
        AudioInputStream audio =AudioSystem.getAudioInputStream(audiofile);
        return audio;
    }
}

public class TelevisionHDMIPort {
    public Television(){} 
    public static boolen displays(HDMIaudioinput input){
        boolean displays;
        audio = input.AudioInputStream(input.getaudio);
        if(audio.getFormat() !="LCPM"){
            System.out.println("Incorrect Audio");
            displays = false;
            return displays;
        }
    }
}

public class TelevisionAudioOutput{
    public static void main(String[] args){
        File hdmiaudio = new File(args[0]);
        File avaudio1 = new File(args[1]);
        File avaudio2 = new File(args[2]);
        TelevisionHDMIPort hdmi1 = new TelevisionHDMIPort();
        HDMIinput hdmiin = new HDMIaudioinput(hdmiaudio);
        AVinput avin = new AVaudioinput(avaudio1, avaudio2);
        AVadapter avadapted = new AVadapter(avin);
        if(TelevisionHDMIPort.displays(hdmiin) == true){
            System.out.println("Audio outputs corretly");
        }
    }
}