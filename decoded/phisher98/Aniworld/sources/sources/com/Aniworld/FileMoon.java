package com.Aniworld;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Aniworld.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Aniworld/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/Aniworld/FileMoon;", "Lcom/Aniworld/AniworldPlugin$ByseSX;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FileMoon extends AniworldPlugin.ByseSX {

    @NotNull
    private String mainUrl = "https://filemoon.to";

    @NotNull
    private String name = "FileMoon";

    @Override // com.Aniworld.AniworldPlugin.ByseSX
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Aniworld.AniworldPlugin.ByseSX
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Aniworld.AniworldPlugin.ByseSX
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Aniworld.AniworldPlugin.ByseSX
    public void setName(@NotNull String str) {
        this.name = str;
    }
}
