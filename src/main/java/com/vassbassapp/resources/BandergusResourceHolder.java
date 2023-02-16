package com.vassbassapp.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BandergusResourceHolder implements ResourceHolder {
    private static volatile BandergusResourceHolder instance;
    private BandergusResourceHolder() {}
    public static BandergusResourceHolder getInstance() {
        if (instance == null) {
            synchronized (BandergusResourceHolder.class) {
                if (instance == null) {
                    instance = new BandergusResourceHolder();
                }
            }
        }
        return instance;
    }

    private static final String IMAGES_FOLDER = "image";

    private static final String LEVEL_1 = "level-1.gif";
    private static final String LEVEL_2 = "level-2.gif";
    private static final String LEVEL_3 = "level-3.gif";
    private static final String LEVEL_4 = "level-4.gif";
    private static final String FINAL = "final.gif";

    @Override
    public void readResources(){
        try {
            readImages();
        } catch (IOException ignored) {}
    }

    private void readImages() throws IOException {
        Files.createDirectory(Path.of(IMAGES_FOLDER));

        String packedPath = IMAGES_FOLDER + "/" + LEVEL_1;
        unpackFile(packedPath);
        packedPath = IMAGES_FOLDER + "/" + LEVEL_2;
        unpackFile(packedPath);
        packedPath = IMAGES_FOLDER + "/" + LEVEL_3;
        unpackFile(packedPath);
        packedPath = IMAGES_FOLDER + "/" + LEVEL_4;
        unpackFile(packedPath);
        packedPath = IMAGES_FOLDER + "/" + FINAL;
        unpackFile(packedPath);
    }

    private void unpackFile(String path) throws IOException {
        InputStream in = BandergusResourceHolder.class.getClassLoader().getResourceAsStream(path);
        if (in == null){
            System.err.printf("FileBrowser: file not found: %s%n", path);
        }else {
            Path unpackingPath = Paths.get(path);
            Files.copy(in, unpackingPath, REPLACE_EXISTING);
            in.close();
        }
    }

    public File imageLevel1() {
        return new File(IMAGES_FOLDER, LEVEL_1);
    }

    public File imageLevel2() {
        return new File(IMAGES_FOLDER, LEVEL_2);
    }

    public File imageLevel3() {
        return new File(IMAGES_FOLDER, LEVEL_3);
    }

    public File imageLevel4() {
        return new File(IMAGES_FOLDER, LEVEL_4);
    }

    public File imageLevelFinal() {
        return new File(IMAGES_FOLDER, FINAL);
    }
}
