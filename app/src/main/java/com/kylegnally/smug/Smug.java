package com.kylegnally.smug;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Smug {

    private static final String TAG = "Smug";
    private static final String SOUNDS_FOLDER = "raw";
    private static final int MAX_SOUNDS = 1;

    private int soundCount;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public Smug(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds(){
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            soundCount = mAssets.list(SOUNDS_FOLDER).length;
        } catch (IOException e) {
            Log.e(TAG, "Couldn't load assets.", e);
            return;
        }

        for (String fileName : soundNames) {
            try {
                String assetPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + fileName, ioe);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        // set an AssetFileDescriptor instance using the getAssetPath method of
        // the AssetManager instance
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());

        // load the sound file and set an integer to its Id
        int soundId = mSoundPool.load(afd, 1);

        // set the Id of the sound using the integer we just set
        sound.setSoundId(soundId);
    }

    public void play(Smug smug) {
        Integer count = smug.soundCount;
        int min = 1;
        int max = count;
        //Integer soundId = sound.getSoundId(soundCount);
        if (count == null) {
            return;
        }
        Random rand = new Random();
        int soundId = rand.nextInt(max - min + 1) + min;

        // Play the sound!
        // Params:
        // soundId - Id number of the sound that we set in load()
        // leftVolume - the left speaker volume
        // rightVolume - the right speaker volume
        // priority - ignored
        // loop - whether the sound plays over again indefinitely (-1 to loop forever)
        // rate - the playback rate of the sound
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void release() {

        // This unloads the sounds
        mSoundPool.release();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

}
