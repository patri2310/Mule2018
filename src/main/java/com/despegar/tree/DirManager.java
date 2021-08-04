package com.despegar.tree;

import lombok.val;

import java.util.Collections;

import static java.util.Arrays.asList;

public class DirManager {

    private Dir allDir;

    public Dir getAllDir() {
        return allDir;
    }

    public void setAllDir(Dir allDir) {
        this.allDir = allDir;
    }

    public Dir getActualDir() {
        return actualDir;
    }

    public void setActualDir(Dir actualDir) {
        this.actualDir = actualDir;
    }

    private Dir actualDir;

    public DirManager() {
        this.allDir = this.factoryBase();
        this.setActualDir(this.allDir);
    }


    public Dir changeDir(Dir actualDir){
        return null;
    }

    public Dir removeDir(){
        return null;
    }

    public Dir addDir(){
        return null;
    }

    public Dir factoryBase() {

        val download = Dir.builder().name("downloads").parent_name("patricia").files(asList(
                FileMule.builder().name("download1").parent_name("downloads").size(1).build(),
                FileMule.builder().name("download2").parent_name("downloads").size(2).build(),
                FileMule.builder().name("download3").parent_name("downloads").size(3).build(),
                FileMule.builder().name("download4").parent_name("downloads").size(4).build(),
                FileMule.builder().name("download5").parent_name("downloads").size(5).build())).build();

        val images = Dir.builder().name("images").parent_name("patricia").files(asList(
                FileMule.builder().name("image-1").parent_name("images").size(1).build(),
                FileMule.builder().name("image-2").parent_name("images").size(2).build(),
                FileMule.builder().name("image-3").parent_name("images").size(3).build(),
                FileMule.builder().name("image-4").parent_name("images").size(4).build(),
                FileMule.builder().name("image-5").parent_name("images").size(5).build())).build();

        val patricia = Dir.builder().name("patricia").parent_name("/").dirs(asList(download, images)).build();

        val despegar = Dir.builder().name("despegar").parent_name("/").files(Collections.singletonList(FileMule.builder().name("sensitive.conf").parent_name("despegar").size(100).build())).build();

        return Dir.builder().name("/").files(asList(
                FileMule.builder().name("file-1").parent_name("/").size(1).build(),
                FileMule.builder().name("file-2").parent_name("/").size(1).build(),
                FileMule.builder().name("file-3").parent_name("/").size(1).build(),
                FileMule.builder().name("file-4").parent_name("/").size(1).build()))
                .dirs(asList(patricia, despegar))
                .build();
    }

}