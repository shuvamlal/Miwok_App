package com.example.android.miwok;

public class Word {

    private static int NO_IMAGE_PROVIDED = -1;
    private static int NO_AUDIO_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResoucreId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResoucreId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourcesId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourcesId;
        mAudioResourceId = audioResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

}
