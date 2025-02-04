import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

class BackgroundMusic(val audioPath: String) : Runnable {
    override fun run() {
        try {
            val audio = File(audioPath)
            val audioInput: AudioInputStream = AudioSystem.getAudioInputStream(audio)
            val clip: Clip = AudioSystem.getClip()
            clip.open(audioInput)

            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                val volume: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
                volume.value = volume.minimum + (0.99f * (volume.maximum - volume.minimum))
            }

            clip.loop(Clip.LOOP_CONTINUOUSLY)
            clip.start()


            Thread.sleep(clip.microsecondLength / 1000)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}
