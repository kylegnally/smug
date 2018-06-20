package com.kylegnally.smug;

import java.util.Random;

public class Sound {

    public String mAssetPath;
    public String mName;

    private Integer mSoundId;
    private Random rand;

    public Sound(String assetPath){
        mAssetPath = assetPath;

        String[] components = assetPath.split("/");
        String fileName = components[components.length - 1];
        mName = fileName.replace(".mp3", "");
    }

    public Integer getSoundId(int soundCount) {
        rand = new Random();
        mSoundId = rand.nextInt(soundCount + 1);
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

}
